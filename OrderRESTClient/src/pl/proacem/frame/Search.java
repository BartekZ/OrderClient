package pl.proacem.frame;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

import pl.proacem.model.Investor;
import pl.proacem.model.MainOrder;
import pl.proacem.model.SingleOrder;
import pl.proacem.model.Supplier;
import pl.proacem.service.RESTClient.SingleOrderService;
import pl.proacem.table.InvestorTableModel;
import pl.proacem.table.MainOrderTableModel;
import pl.proacem.table.SingleOrderOwnerTableModel;
import pl.proacem.table.SupplierTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class Search extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton btnSearch;
	private ObservableList<SingleOrder> singleOrderList = ObservableCollections.observableList(new ArrayList<SingleOrder>());
	private ObservableList<MainOrder> mainOrderList = ObservableCollections.observableList(new ArrayList<MainOrder>());
	private ObservableList<Supplier> supplierList = ObservableCollections.observableList(new ArrayList<Supplier>());
	private ObservableList<Investor> investorList = ObservableCollections.observableList(new ArrayList<Investor>());
	private JTable table;
	private JPanel panel;
	JComboBox petList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Search dialog = new Search();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Search() {
		setModal(true);
		setBounds(100, 100, 602, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		{
			textField = new JTextField();
			contentPanel.add(textField, "6, 4, left, default");
			textField.setColumns(10);
		}
		{
			btnSearch = new JButton("Search");
			contentPanel.add(btnSearch, "6, 6, left, default");
			
		}
		{
			panel = new JPanel();
			contentPanel.add(panel, "6, 8, fill, fill");
		}
		{
			String[] items = {"singleorder", "mainorder", "investor", "supplier"};
			petList = new JComboBox<String>(items);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						close();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				buttonPane.add(petList);
			}
		}
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingleOrderService service = new SingleOrderService();
				singleOrderList.clear();
				singleOrderList.addAll(service.getTest(textField.getText()));
				System.out.println(service.getTest(textField.getText()));
				searchSingleOrder();
				table.updateUI();
				
				
				
			}
		});
		
	}
	private void close(){
		this.dispose();
	}
	
	private void searchSingleOrder(){
		panel.removeAll();
		table = new JTable(new SingleOrderOwnerTableModel(singleOrderList));
		JScrollPane scrollPane= new JScrollPane(table);
		panel.add(scrollPane);
	}
	
	private void searchMainOrder(){
		panel.removeAll();
		table = new JTable(new MainOrderTableModel(mainOrderList));
		JScrollPane scrollPane= new JScrollPane(table);
		panel.add(scrollPane);
	}
	
	private void searchInvestor(){
		panel.removeAll();
		table = new JTable(new InvestorTableModel(investorList));
		JScrollPane scrollPane= new JScrollPane(table);
		panel.add(scrollPane);
	}
	
	private void searchSupplier(){
		panel.removeAll();
		table = new JTable(new SupplierTableModel(supplierList));
		JScrollPane scrollPane= new JScrollPane(table);
		panel.add(scrollPane);
	}

}
