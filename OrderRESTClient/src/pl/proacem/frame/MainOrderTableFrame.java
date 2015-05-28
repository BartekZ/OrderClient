package pl.proacem.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

import pl.proacem.frame.component.ItemAddFrameListener;
import pl.proacem.frame.component.ItemDeleteButtonAction;
import pl.proacem.frame.component.ItemEditFrameListener;
import pl.proacem.frame.component.JTableUpdateListener;
import pl.proacem.frame.component.LoadingAnimation;
import pl.proacem.frame.component.PopulateList;
import pl.proacem.model.MainOrder;
import pl.proacem.service.RESTClient.MainOrderService;
import pl.proacem.table.MainOrderTable;
import pl.proacem.table.MainOrderTableModel;

public class MainOrderTableFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private MainOrderTableModel model;
	private LoadingAnimation loading = new LoadingAnimation(contentPanel);
	private Frame frame = JOptionPane.getFrameForComponent(this);
	private ObservableList<MainOrder> list = ObservableCollections.observableList(new ArrayList<MainOrder>());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MainOrderTableFrame dialog = new MainOrderTableFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MainOrderTableFrame() {
		setBounds(100, 100, 800, 562);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		{
			JLabel lblNewLabel = new JLabel("Main Order Table");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
			model = new MainOrderTableModel(list);
			model.setMainOrderList(list);
			table = new MainOrderTable(model);
			
			table.getColumnModel().getColumn(0).setMinWidth(25);
			table.getColumnModel().getColumn(0).setMaxWidth(25);
			table.getColumnModel().getColumn(1).setMinWidth(70);
			table.getColumnModel().getColumn(1).setMaxWidth(70);
			table.getColumnModel().getColumn(2).setMinWidth(70);
			table.getColumnModel().getColumn(2).setMaxWidth(70);
			list.addObservableListListener(new JTableUpdateListener(table));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane  scrollpana= new JScrollPane(table);
			contentPanel.add(scrollpana, BorderLayout.CENTER);
			populateList();
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton openButton = new JButton("Open");
				openButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						MainOrder chosenMainOrder = (MainOrder) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1);
						JDialog dialog = new SingleOrderTableFrame(chosenMainOrder);
						dialog.setModal(true);
						dialog.setVisible(true);
					}
				});
				buttonPane.add(openButton);
			}
			{
				JButton refreshButton = new JButton("refresh");
				refreshButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						populateList();
						
					}
				});
				buttonPane.add(refreshButton);
			}
			{
				JButton newButton = new JButton("New");
				newButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JDialog itemFrame = new AddEditMainOrderFrame();
						itemFrame.setModal(true);
						itemFrame.addPropertyChangeListener(new ItemAddFrameListener<MainOrder>(list, new MainOrderService()));
						itemFrame.setVisible(true);
						
					}
				});
				buttonPane.add(newButton);
			}
			{
				JButton newButton = new JButton("Edit");
				newButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						MainOrder chosenInvestor = list.get(table.convertRowIndexToModel(table.getSelectedRow()));
						JDialog dialog = new AddEditMainOrderFrame(chosenInvestor);
						dialog.setModal(true);
						dialog.addPropertyChangeListener(new ItemEditFrameListener<MainOrder>(table, list, new MainOrderService()));
						dialog.setVisible(true);
					}
				});
				buttonPane.add(newButton);
			}
			{
				JButton newButton = new JButton("Delete");
				buttonPane.add(newButton);
				newButton.addActionListener(new ItemDeleteButtonAction<MainOrder>(table, list, new MainOrderService(), frame));
			}
			
		}
		setCenterLocation();
	}
	
	private void populateList(){
		//loading = new LoadingAnimation(contentPanel);
		new PopulateList<MainOrder>(table, list, new MainOrderService());
	}
	
	public void setCenterLocation(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
