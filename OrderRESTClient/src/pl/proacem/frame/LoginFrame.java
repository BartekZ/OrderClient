package pl.proacem.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pl.proacem.controler.LoginUser;
import pl.proacem.model.Person;
import pl.proacem.service.RESTClient.PersonService;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;
	private Person person;
	private JLabel errorLabel;
	private Person authPerson = null;
	private static int WIDTH = 280;
	private static int HEIGHT = 170;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_errorLabel.gridx = 2;
		gbc_errorLabel.gridy = 0;
		contentPane.add(errorLabel, gbc_errorLabel);
		
		JLabel lblPleaseLogIn = new JLabel("Please log in");
		lblPleaseLogIn.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblPleaseLogIn = new GridBagConstraints();
		gbc_lblPleaseLogIn.anchor = GridBagConstraints.WEST;
		gbc_lblPleaseLogIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblPleaseLogIn.gridx = 2;
		gbc_lblPleaseLogIn.gridy = 1;
		contentPane.add(lblPleaseLogIn, gbc_lblPleaseLogIn);
		
		JLabel LoginLabel = new JLabel("Login");
		GridBagConstraints gbc_LoginLabel = new GridBagConstraints();
		gbc_LoginLabel.insets = new Insets(0, 0, 5, 5);
		gbc_LoginLabel.anchor = GridBagConstraints.EAST;
		gbc_LoginLabel.gridx = 1;
		gbc_LoginLabel.gridy = 2;
		contentPane.add(LoginLabel, gbc_LoginLabel);
		
		loginField = new JTextField();
		GridBagConstraints gbc_loginField = new GridBagConstraints();
		gbc_loginField.insets = new Insets(0, 0, 5, 5);
		gbc_loginField.anchor = GridBagConstraints.WEST;
		gbc_loginField.gridx = 2;
		gbc_loginField.gridy = 2;
		contentPane.add(loginField, gbc_loginField);
		loginField.setColumns(15);
		
		JLabel PasswordLabel = new JLabel("Password");
		GridBagConstraints gbc_PasswordLabel = new GridBagConstraints();
		gbc_PasswordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PasswordLabel.anchor = GridBagConstraints.EAST;
		gbc_PasswordLabel.gridx = 1;
		gbc_PasswordLabel.gridy = 3;
		contentPane.add(PasswordLabel, gbc_PasswordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.anchor = GridBagConstraints.WEST;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		contentPane.add(passwordField, gbc_passwordField);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		JButton OkButton = new JButton("OK");
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				person = new Person();
				person.setName(loginField.getText());
				int error = -1;
				error = checkLogin();
				if (error == 0){
					LoginUser.setPerson(authPerson);
					LoginFrame.this.firePropertyChange("succesfullLogged", null, person);
				}
				else
				{
					errorLabel.setText("ERROR nr " + error);
					if (getHeight() == 170){
						setSize(getWidth(), getHeight()+ 15);
					}
					
				}
				
			}
		});
		buttons.add(OkButton);
		buttons.add(exitButton);
		
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(buttons, gbc_btnNewButton);
		setCenterLocation();
		
		loginField.setText("login4");
		passwordField.setText("pass4");
		
	}
	
	private int checkLogin(){
		Person candidate = new Person();
		candidate.setLogin(loginField.getText());
		candidate.setPass(String.valueOf(passwordField.getPassword()));
		PersonService personService = new PersonService();
		authPerson = null;
		authPerson = personService.getLogin(candidate);
		if (authPerson != null){
			return 0;	
		}
		return -1;
		
	}
	
	public void clear(){
		loginField.setText(null);
		passwordField.setText(null);
		loginField.requestFocus();
		errorLabel.setText(null);
		setSize(WIDTH , HEIGHT);
		setCenterLocation();
	}
	
	public void setCenterLocation(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
