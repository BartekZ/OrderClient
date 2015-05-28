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
import pl.proacem.model.Investor;
import pl.proacem.service.RESTClient.InvestorService;
import pl.proacem.table.InvestorTableModel;

public class InvestorTableFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Frame frame = JOptionPane.getFrameForComponent(this);;
	private Investor selectedInvestor;
	private ObservableList<Investor> list = ObservableCollections.observableList(new ArrayList<Investor>());
	private LoadingAnimation loading;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InvestorTableFrame dialog = new InvestorTableFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InvestorTableFrame() {
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		
		{
			JLabel lblNewLabel = new JLabel("Investor Table");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
			table = new JTable(new InvestorTableModel(list));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setAutoCreateRowSorter(true);
			populateList();
			JScrollPane  scrollpana= new JScrollPane(table);
			contentPanel.add(scrollpana, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton refreshButton = new JButton("Refresh");
				refreshButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						populateList();
						
					}
				});
				buttonPane.add(refreshButton);
				getRootPane().setDefaultButton(refreshButton);
			}
			{
				JButton newButton = new JButton("New");
				buttonPane.add(newButton);
				newButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JDialog dialog = new AddEditInvestorFrame();
						dialog.setModal(true);
						dialog.addPropertyChangeListener(new ItemAddFrameListener<Investor>(list, new InvestorService()));
						dialog.setVisible(true);
					}
				});
				getRootPane().setDefaultButton(newButton);
			}
			{
				JButton editButton = new JButton("Edit");
				editButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Investor chosenInvestor = (Investor) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1);
						JDialog dialog = new AddEditInvestorFrame(chosenInvestor);
						dialog.setModal(true);
						dialog.addPropertyChangeListener(new ItemEditFrameListener<Investor>(table, list, new InvestorService()));
						dialog.setVisible(true);
					}
				});
				
				buttonPane.add(editButton);
				getRootPane().setDefaultButton(editButton);
			}
			{
				frame = JOptionPane.getFrameForComponent(this);
				JButton deleteButton = new JButton("Delete");
				deleteButton.addActionListener(new ItemDeleteButtonAction<Investor>(table, list, new InvestorService(), frame));
				buttonPane.add(deleteButton);
				getRootPane().setDefaultButton(deleteButton);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selectedInvestor = (Investor) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1);
						fireInvestor();
						close();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						close();
						
					}
				});
			}
		}
	}

	private void populateList(){
		//loading = new LoadingAnimation(contentPane);
		new PopulateList<Investor>(table, list, new InvestorService());
		list.addObservableListListener(new JTableUpdateListener(table));
	}

	private void fireInvestor(){
		this.firePropertyChange("item", null, selectedInvestor);
		
	}
	
	private void close(){
		this.dispose();
	}
}
