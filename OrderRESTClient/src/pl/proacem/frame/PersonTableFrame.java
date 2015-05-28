package pl.proacem.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.table.TableModel;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

import pl.proacem.frame.component.ItemAddFrameListener;
import pl.proacem.frame.component.ItemDeleteButtonAction;
import pl.proacem.frame.component.JTableUpdateListener;
import pl.proacem.frame.component.LoadingAnimation;
import pl.proacem.frame.component.PopulateList;
import pl.proacem.model.Person;
import pl.proacem.service.RESTClient.PersonService;
import pl.proacem.table.PersonTableModel;

public class PersonTableFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Frame frame = JOptionPane.getFrameForComponent(this);
	private Person selectedPerson;
	private ObservableList<Person> list = ObservableCollections.observableList(new ArrayList<Person>());
	private LoadingAnimation loading;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonTableFrame frame = new PersonTableFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonTableFrame() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 851, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		
		
		JLabel lblNewLabel = new JLabel("Persons Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 9;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		
		
		TableModel model = new PersonTableModel(list);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollpana = new JScrollPane(table);

		populateList();
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 13;
		gbc_table.gridwidth = 23;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		contentPane.add(scrollpana, gbc_table);
		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateList();
			}
		});

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectionModel().isSelectionEmpty() != true) {
					Person chosenPerson = (Person) table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 1);
					//Person chosenPerson = list.get(table.convertRowIndexToModel(table.getSelectedRow()));
					JDialog dialog = new AddEditPersonFrame(chosenPerson);
					dialog.setModal(true);
					dialog.addPropertyChangeListener(new ItemAddFrameListener<Person>(list, new PersonService()));
					dialog.setVisible(true);
				}

			}
		});

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog personFrame = new AddEditPersonFrame();
				personFrame.setModal(true);
				personFrame.addPropertyChangeListener(new ItemAddFrameListener<Person>(list, new PersonService()));
				personFrame.setVisible(true);
				
			}
		});
		
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.insets = new Insets(0, 0, 0, 5);
		gbc_btnNew.gridx = 1;
		gbc_btnNew.gridy = 14;
		contentPane.add(btnNew, gbc_btnNew);

		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 2;
		gbc_btnEdit.gridy = 14;
		contentPane.add(btnEdit, gbc_btnEdit);

		
		
		JButton btnDelete = new JButton("Delete");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 14;
		contentPane.add(btnDelete, gbc_btnDelete);
		btnDelete.addActionListener(new ItemDeleteButtonAction<Person>(table, list, new PersonService(), frame));
		
		
		GridBagConstraints gbc_btnRefresh = new GridBagConstraints();
		gbc_btnRefresh.insets = new Insets(0, 0, 0, 5);
		gbc_btnRefresh.gridx = 4;
		gbc_btnRefresh.gridy = 14;
		contentPane.add(btnRefresh, gbc_btnRefresh);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectionModel().isSelectionEmpty() != true){
					selectedPerson = list.get(table.convertRowIndexToModel(table.getSelectedRow()));
					fireOk();
				}
				
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Person per = new Person();
				per.setName("dupek");
				list.add(per);
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 5;
		gbc_btnAdd.gridy = 14;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 20;
		gbc_btnOk.gridy = 14;
		contentPane.add(btnOk, gbc_btnOk);

		JButton btnNewButton = new JButton("Close");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 21;
		gbc_btnNewButton.gridy = 14;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PersonTableFrame.this.dispose();
			}
		});
		
	}

	private void fireOk() {
		this.firePropertyChange("item", null, selectedPerson);
		this.dispose();
	}


	private void populateList(){
		loading = new LoadingAnimation(contentPane);
		new PopulateList<Person>(table, list, new PersonService());
		list.addObservableListListener(new JTableUpdateListener(table));
	}
	
}
