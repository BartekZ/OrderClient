package pl.proacem.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pl.proacem.model.MainOrder;
import pl.proacem.model.Person;

public class AddEditPersonFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField loginTextField;
	private JTextField passwordTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	private JTextField descriptionTextField;
	private JTextField notesTextField;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton button;
	private JLabel msgLabel;
	private Person person;
	private boolean edit;
	private String label="Add Person";
	private MainOrder mainOrder;

	/**
	 * Create the frame.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEditPersonFrame frame = new AddEditPersonFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddEditPersonFrame() {
		init();
	}

	public AddEditPersonFrame(Person person) {
		label="Edit Person";
		init();
		edit = true;
		this.person = person;
		fillFields();

	}
	
	public AddEditPersonFrame(MainOrder amainOrder) {
		label="Edit Person";
		init();
		edit = true;
		this.person = person;
		fillFields();
		this.mainOrder = amainOrder;

	}

	public void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		
		lblNewLabel_1 = new JLabel(label);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		nameTextField = new JTextField();
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.gridwidth = 3;
		gbc_nameTextField.anchor = GridBagConstraints.WEST;
		gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameTextField.gridx = 2;
		gbc_nameTextField.gridy = 1;
		contentPane.add(nameTextField, gbc_nameTextField);
		nameTextField.setColumns(20);

		JLabel lblLogin = new JLabel("Login");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 2;
		contentPane.add(lblLogin, gbc_lblLogin);

		loginTextField = new JTextField();
		GridBagConstraints gbc_loginTextField = new GridBagConstraints();
		gbc_loginTextField.gridwidth = 3;
		gbc_loginTextField.anchor = GridBagConstraints.WEST;
		gbc_loginTextField.insets = new Insets(0, 0, 5, 0);
		gbc_loginTextField.gridx = 2;
		gbc_loginTextField.gridy = 2;
		contentPane.add(loginTextField, gbc_loginTextField);
		loginTextField.setColumns(20);

		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		contentPane.add(lblPassword, gbc_lblPassword);

		passwordTextField = new JTextField();
		GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
		gbc_passwordTextField.gridwidth = 3;
		gbc_passwordTextField.anchor = GridBagConstraints.WEST;
		gbc_passwordTextField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordTextField.gridx = 2;
		gbc_passwordTextField.gridy = 3;
		contentPane.add(passwordTextField, gbc_passwordTextField);
		passwordTextField.setColumns(20);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		contentPane.add(lblEmail, gbc_lblEmail);

		emailTextField = new JTextField();
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.gridwidth = 3;
		gbc_emailTextField.anchor = GridBagConstraints.WEST;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 0);
		gbc_emailTextField.gridx = 2;
		gbc_emailTextField.gridy = 4;
		contentPane.add(emailTextField, gbc_emailTextField);
		emailTextField.setColumns(20);

		JLabel lblPhone = new JLabel("Phone");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.EAST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 1;
		gbc_lblPhone.gridy = 5;
		contentPane.add(lblPhone, gbc_lblPhone);

		phoneTextField = new JTextField();
		GridBagConstraints gbc_phoneTextField = new GridBagConstraints();
		gbc_phoneTextField.gridwidth = 3;
		gbc_phoneTextField.anchor = GridBagConstraints.WEST;
		gbc_phoneTextField.insets = new Insets(0, 0, 5, 0);
		gbc_phoneTextField.gridx = 2;
		gbc_phoneTextField.gridy = 5;
		contentPane.add(phoneTextField, gbc_phoneTextField);
		phoneTextField.setColumns(20);

		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 6;
		contentPane.add(lblDescription, gbc_lblDescription);

		descriptionTextField = new JTextField();
		GridBagConstraints gbc_descriptionTextField = new GridBagConstraints();
		gbc_descriptionTextField.gridwidth = 3;
		gbc_descriptionTextField.insets = new Insets(0, 0, 5, 0);
		gbc_descriptionTextField.anchor = GridBagConstraints.WEST;
		gbc_descriptionTextField.gridx = 2;
		gbc_descriptionTextField.gridy = 6;
		contentPane.add(descriptionTextField, gbc_descriptionTextField);
		descriptionTextField.setColumns(20);

		JLabel lblNotes = new JLabel("Notes");
		GridBagConstraints gbc_lblNotes = new GridBagConstraints();
		gbc_lblNotes.anchor = GridBagConstraints.EAST;
		gbc_lblNotes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotes.gridx = 1;
		gbc_lblNotes.gridy = 7;
		contentPane.add(lblNotes, gbc_lblNotes);

		notesTextField = new JTextField();
		GridBagConstraints gbc_notesTextField = new GridBagConstraints();
		gbc_notesTextField.gridwidth = 3;
		gbc_notesTextField.insets = new Insets(0, 0, 5, 0);
		gbc_notesTextField.anchor = GridBagConstraints.WEST;
		gbc_notesTextField.gridx = 2;
		gbc_notesTextField.gridy = 7;
		contentPane.add(notesTextField, gbc_notesTextField);
		notesTextField.setColumns(20);

		button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});

		msgLabel = new JLabel();
		msgLabel.setForeground(Color.RED);
		msgLabel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_msgLabel = new GridBagConstraints();
		gbc_msgLabel.anchor = GridBagConstraints.WEST;
		gbc_msgLabel.insets = new Insets(0, 0, 0, 5);
		gbc_msgLabel.gridx = 2;
		gbc_msgLabel.gridy = 8;
		contentPane.add(msgLabel, gbc_msgLabel);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 4;
		gbc_button.gridy = 8;
		contentPane.add(button, gbc_button);

		btnNewButton = new JButton("OK");

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (edit != true) {
					person = new Person();
				}
				fillPerson(person);
				firePerson(person);

				close();
			}

		});

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

	private void firePerson(Person person) {
		this.firePropertyChange("item", null, person);
	}

	private void close() {
		this.dispose();
	}

	private void fillFields() {

		nameTextField.setText(person.getName());
		loginTextField.setText(person.getLogin());
		emailTextField.setText(person.getEmail());
		passwordTextField.setText(person.getPass());
		phoneTextField.setText(person.getPhone());
		descriptionTextField.setText(person.getDescription());
		notesTextField.setText(person.getNotes());

	}
	
	private void fillPerson(Person person){
		person.setName(nameTextField.getText());
		person.setLogin(loginTextField.getText());
		person.setEmail(emailTextField.getText());
		person.setPass(passwordTextField.getText());
		person.setPhone(phoneTextField.getText());
		person.setDescription(descriptionTextField.getText());
		person.setNotes(notesTextField.getText());
	}

}
