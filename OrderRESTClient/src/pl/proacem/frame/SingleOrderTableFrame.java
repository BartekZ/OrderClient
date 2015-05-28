package pl.proacem.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

import pl.proacem.frame.component.ItemAddFrameListener;
import pl.proacem.frame.component.ItemDeleteButtonAction;
import pl.proacem.frame.component.ItemEditFrameListener;
import pl.proacem.frame.component.JTableUpdateListener;
import pl.proacem.frame.component.PopulateList;
import pl.proacem.model.MainOrder;
import pl.proacem.model.SingleOrder;
import pl.proacem.service.RESTClient.SingleOrderService;
import pl.proacem.table.SingleOrderOwnerTableModel;
import pl.proacem.table.SingleOrderTableModel;

public class SingleOrderTableFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ObservableList<SingleOrder> list = ObservableCollections.observableList(new ArrayList<SingleOrder>());
	//private LoadingAnimation loading;
	private Frame frame = JOptionPane.getFrameForComponent(this);
	private MainOrder editedMainOrder = null;
	private JDialog dialog;
	private TableModel model;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SingleOrderTableFrame dialog = new SingleOrderTableFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SingleOrderTableFrame() {
		init();
		populateList();
		//cancelButton.setVisible(false);
		
	}
	
	public SingleOrderTableFrame(MainOrder amainOrder) {
		this.editedMainOrder = amainOrder;
		init();
		populateList(editedMainOrder);
		
	}
	
	public void init() {
		setBounds(100, 100, 1250, 446);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblSingleOrderTable = new JLabel("Single Order Table");
			lblSingleOrderTable.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblSingleOrderTable, BorderLayout.NORTH);
		}
		{
			if (editedMainOrder != null){
				model = new SingleOrderTableModel(list);
			}
			else {
				model = new SingleOrderOwnerTableModel(list);
			}
			
			table = new JTable(model);
			JScrollPane scrollPane= new JScrollPane(table);
			table.setAutoCreateRowSorter(true);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Refresh");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (editedMainOrder != null){
							populateList(editedMainOrder);
						}
						else {
							populateList();
						}
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton okButton = new JButton("New");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (editedMainOrder != null){
							dialog = new AddEditSingleOrderFrame(editedMainOrder);
						}
						else {
							dialog = new AddEditSingleOrderFrame();
						}
						dialog.addPropertyChangeListener(new ItemAddFrameListener<SingleOrder>(list, new SingleOrderService()));
						dialog.setModal(true);
						dialog.setVisible(true);
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton okButton = new JButton("Edit");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SingleOrder selectedItem = (SingleOrder) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1);
						JDialog dialog = new AddEditSingleOrderFrame(selectedItem);
						dialog.addPropertyChangeListener(new ItemEditFrameListener<SingleOrder>(table, list, new SingleOrderService()));
						dialog.setModal(true);
						dialog.setVisible(true);
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton deleteButton = new JButton("Delete");
				deleteButton.addActionListener(new ItemDeleteButtonAction<SingleOrder>(table, list, new SingleOrderService(), frame));
				buttonPane.add(deleteButton);
				getRootPane().setDefaultButton(deleteButton);
			}
			{
				cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						SingleOrderTableFrame.this.dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	


	private void populateList(){
		//loading = new LoadingAnimation(contentPanel);
		new PopulateList<SingleOrder>(table, list, new SingleOrderService());
		list.addObservableListListener(new JTableUpdateListener(table));
	}
	
	private void populateList(MainOrder amainorder){
		//loading = new LoadingAnimation(contentPanel);
		new PopulateList<SingleOrder>(table, list, new SingleOrderService(), editedMainOrder);
		list.addObservableListListener(new JTableUpdateListener(table));
	}
	

}
