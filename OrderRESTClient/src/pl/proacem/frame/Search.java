package pl.proacem.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
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
import pl.proacem.service.RESTClient.InvestorService;
import pl.proacem.service.RESTClient.MainOrderService;
import pl.proacem.service.RESTClient.SingleOrderService;
import pl.proacem.service.RESTClient.SupplierService;
import pl.proacem.table.InvestorTableModel;
import pl.proacem.table.MainOrderTableModel;
import pl.proacem.table.SingleOrderOwnerTableModel;
import pl.proacem.table.SupplierTableModel;

public class Search extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSearch;
	private ObservableList<SingleOrder> singleOrderList = ObservableCollections.observableList(new ArrayList<SingleOrder>());
	private ObservableList<MainOrder> mainOrderList = ObservableCollections.observableList(new ArrayList<MainOrder>());
	private ObservableList<Supplier> supplierList = ObservableCollections.observableList(new ArrayList<Supplier>());
	private ObservableList<Investor> investorList = ObservableCollections.observableList(new ArrayList<Investor>());
	private JTable table;
	private JPanel panel;
	private JComboBox<String> mainComboBox;

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
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_top = new JPanel();
		contentPane.add(panel_top, BorderLayout.NORTH);
		panel_top.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_top.add(textField);
		textField.setColumns(20);
		
		btnSearch = new JButton("Search");
		panel_top.add(btnSearch);
		
		mainComboBox = new JComboBox<String>();
		mainComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Singleorders", "Mainorders", "Investors", "Suppliers"}));
		panel_top.add(mainComboBox);
		
		JComboBox<String> subComboBox = new JComboBox<String>();
		subComboBox.setVisible(false);
		panel_top.add(subComboBox);
		
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_bottom = new JPanel();
		contentPane.add(panel_bottom, BorderLayout.SOUTH);
		panel_bottom.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		panel_bottom.add(btnNewButton, BorderLayout.LINE_END);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				switch (mainComboBox.getSelectedIndex()) {
				case 0:
					searchSingleOrder();
					break;
				case 1:
					searchMainOrder();
					break;
				case 2:
					searchInvestor();
					break;
				case 3:
					searchSupplier();
					break;

				default:
					break;
				}
				panel.updateUI();
				table.updateUI();
				
			}
		});
		
	}
	private void close(){
		this.dispose();
	}
	
	private void searchSingleOrder(){
		SingleOrderService service = new SingleOrderService();
		singleOrderList.clear();
		singleOrderList.addAll(service.getFind(textField.getText()));
		System.out.println(service.getFind(textField.getText()));
		panel.removeAll();
		table = new JTable(new SingleOrderOwnerTableModel(singleOrderList));
		JScrollPane scrollPane= new JScrollPane(table);
		panel.add(scrollPane);
	}
	
	private void searchMainOrder(){
		MainOrderService service = new MainOrderService();
		mainOrderList.clear();
		mainOrderList.addAll(service.getFind(textField.getText()));
		panel.removeAll();
		table = new JTable(new MainOrderTableModel(mainOrderList));
		JScrollPane scrollPane= new JScrollPane(table);
		panel.add(scrollPane);
	}
	
	private void searchInvestor(){
		InvestorService service = new InvestorService();
		investorList.clear();
		investorList.addAll(service.getFind(textField.getText()));
		panel.removeAll();
		table = new JTable(new InvestorTableModel(investorList));
		JScrollPane scrollPane= new JScrollPane(table);
		panel.add(scrollPane);
	}
	
	private void searchSupplier(){
		SupplierService service = new SupplierService();
		supplierList.clear();
		supplierList.addAll(service.getFind(textField.getText()));
		panel.removeAll();
		table = new JTable(new SupplierTableModel(supplierList));
		JScrollPane scrollPane= new JScrollPane(table);
		panel.add(scrollPane);
	}

}
