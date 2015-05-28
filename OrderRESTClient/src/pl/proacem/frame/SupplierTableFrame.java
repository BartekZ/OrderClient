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
import pl.proacem.model.Supplier;
import pl.proacem.service.RESTClient.SupplierService;
import pl.proacem.table.SupplierTableModel;

public class SupplierTableFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Frame frame = JOptionPane.getFrameForComponent(this);
	private Supplier selectedSupplier;
	private ObservableList<Supplier> list = ObservableCollections.observableList(new ArrayList<Supplier>());
	private LoadingAnimation loading;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SupplierTableFrame dialog = new SupplierTableFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SupplierTableFrame() {
		setBounds(100, 100, 841, 445);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		{
			JLabel lblNewLabel = new JLabel("Supplier Table");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			
			table = new JTable(new SupplierTableModel(list));
			table.setAutoCreateRowSorter(true);
			populateList();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane scrollpana = new JScrollPane(table);
			contentPanel.add(scrollpana, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton refreshButton = new JButton("Refresh");
				refreshButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						populateList();
					}
				});
				buttonPane.add(refreshButton);
				getRootPane().setDefaultButton(refreshButton);
			}
			{
				JButton newButton = new JButton("New");
				newButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JDialog dialog = new AddEditSupplier();
						dialog.setModal(true);
						dialog.addPropertyChangeListener(new ItemAddFrameListener<Supplier>(list, new SupplierService()));
						dialog.setVisible(true);
					}
				});
				buttonPane.add(newButton);
				getRootPane().setDefaultButton(newButton);
			}
			{
				JButton editButton = new JButton("Edit");
				editButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Supplier chosenSupplier = (Supplier) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1);
						JDialog dialog = new AddEditSupplier(chosenSupplier);
						dialog.setModal(true);
						dialog.addPropertyChangeListener(new ItemEditFrameListener<Supplier>(table, list, new SupplierService()));
						dialog.setVisible(true);
					}
				});
				buttonPane.add(editButton);
				getRootPane().setDefaultButton(editButton);
			}
			{
				JButton deleteButton = new JButton("Delete");
				deleteButton.addActionListener(new ItemDeleteButtonAction<Supplier>(table, list, new SupplierService(), frame));
				buttonPane.add(deleteButton);
				getRootPane().setDefaultButton(deleteButton);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						selectedSupplier = (Supplier) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1);
						fireOk();
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						SupplierTableFrame.this.dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void populateList(){
		//loading = new LoadingAnimation2(contentPanel);
		new PopulateList<Supplier>(table, list, new SupplierService());
		list.addObservableListListener(new JTableUpdateListener(table));
	}
	
	private void fireOk() {
		this.firePropertyChange("selectedSupplier", null, selectedSupplier);
	}

}
