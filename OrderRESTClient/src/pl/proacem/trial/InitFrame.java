package pl.proacem.trial;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import pl.proacem.controler.Populate;
import pl.proacem.model.Person;
import pl.proacem.table.TestTable;

public class InitFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private StringBuilder text = new StringBuilder();
	private JComboBox<Integer> comboBox;
	private JTable table;
	TestTable model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitFrame frame = new InitFrame();
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
	public InitFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textArea = new JTextArea();
		textArea.setSize(258, 200);
		
		JScrollPane scrollpana = new JScrollPane(textArea);
		scrollpana.setBounds(95, 44, 258, 57);
		contentPane.add(scrollpana);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Person person = Populate.getPerson(comboBox.getSelectedItem().toString());
				
				text.append(person.toString());
				text.append("\n");
				textArea.setText(text.toString());
				
			}
		});
		btnNewButton.setBounds(264, 10, 89, 23);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox<Integer>();
		comboBox.setBounds(95, 11, 100, 20);
		comboBox.setEnabled(false);
		contentPane.add(comboBox);
		
		
		model = new TestTable();
		
		model.setPersonList(Populate.getAllPerson());
		table = new JTable(model);
		//table.setBounds(95, 115, 258, 135);
		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setBounds(95, 115, 258, 135);
		contentPane.add(tableScroll);
		
		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//model.setPersonList(Populate.getAllPerson());
				//model.fireTableDataChanged();
			}
		});
		btnRefresh.setBounds(95, 278, 89, 23);
		contentPane.add(btnRefresh);
		
		JButton btnRe = new JButton("RE");
		btnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pop();
			}
		});
		btnRe.setBounds(363, 10, 50, 23);
		contentPane.add(btnRe);
		
		
		pop();
	}
	
	private void pop(){
		comboBox.removeAllItems();
		List<Person> personsList = Populate.getAllPerson();
		for (Person  person: personsList) {
			comboBox.addItem(person.getId());
			
		}
		comboBox.setEnabled(true);
	}
}
