package pl.proacem.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pl.proacem.model.Investor;
import pl.proacem.model.MainOrder;
import pl.proacem.model.Person;

public class AddEditMainOrderFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField numberField;
	private JTextField topicField;
	private JTextField leaderField;
	private JTextField investorField;
	private MainOrder mainOrder = null;
	private String label = "Add Main Order";
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddEditMainOrderFrame dialog = new AddEditMainOrderFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddEditMainOrderFrame(MainOrder amainOrder) {
		this.mainOrder = amainOrder;
		label="Edit MainOrder";
		init();
		fillTextFilds();
	}
	public AddEditMainOrderFrame(){
		mainOrder = new MainOrder();
		init();
	}
	
	public void init() {
		setBounds(100, 100, 340, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblAddMainOrder = new JLabel(label);
			lblAddMainOrder.setFont(new Font("Tahoma", Font.BOLD, 15));
			GridBagConstraints gbc_lblAddMainOrder = new GridBagConstraints();
			gbc_lblAddMainOrder.anchor = GridBagConstraints.WEST;
			gbc_lblAddMainOrder.gridwidth = 2;
			gbc_lblAddMainOrder.insets = new Insets(0, 0, 5, 0);
			gbc_lblAddMainOrder.gridx = 1;
			gbc_lblAddMainOrder.gridy = 0;
			contentPanel.add(lblAddMainOrder, gbc_lblAddMainOrder);
		}
		{
			JLabel lblNumber = new JLabel("Number");
			GridBagConstraints gbc_lblNumber = new GridBagConstraints();
			gbc_lblNumber.insets = new Insets(0, 0, 5, 5);
			gbc_lblNumber.anchor = GridBagConstraints.EAST;
			gbc_lblNumber.gridx = 1;
			gbc_lblNumber.gridy = 1;
			contentPanel.add(lblNumber, gbc_lblNumber);
		}
		{
			numberField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.anchor = GridBagConstraints.WEST;
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			contentPanel.add(numberField, gbc_textField);
			numberField.setColumns(20);
		}
		{
			JLabel lblTopic = new JLabel("Topic");
			GridBagConstraints gbc_lblTopic = new GridBagConstraints();
			gbc_lblTopic.insets = new Insets(0, 0, 5, 5);
			gbc_lblTopic.anchor = GridBagConstraints.EAST;
			gbc_lblTopic.gridx = 1;
			gbc_lblTopic.gridy = 2;
			contentPanel.add(lblTopic, gbc_lblTopic);
		}
		{
			topicField = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.anchor = GridBagConstraints.WEST;
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.gridx = 2;
			gbc_textField_1.gridy = 2;
			contentPanel.add(topicField, gbc_textField_1);
			topicField.setColumns(20);
		}
		{
			JLabel lblLeader = new JLabel("Leader");
			GridBagConstraints gbc_lblLeader = new GridBagConstraints();
			gbc_lblLeader.insets = new Insets(0, 0, 5, 5);
			gbc_lblLeader.anchor = GridBagConstraints.EAST;
			gbc_lblLeader.gridx = 1;
			gbc_lblLeader.gridy = 3;
			contentPanel.add(lblLeader, gbc_lblLeader);
		}
		{
			leaderField = new JTextField();
			leaderField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					JDialog dialog = new PersonTableFrame();
					dialog.setModal(true);
					dialog.addPropertyChangeListener(new PropertyChangeListener() {
						
						@Override
						public void propertyChange(PropertyChangeEvent evt) {
							if (evt.getPropertyName() == "item"){
								Person person = (Person) evt.getNewValue();
								mainOrder.setLeader(person);
								leaderField.setText(person.toString());
							}
						}
					});
					dialog.setVisible(true);
				}
			});
			leaderField.setEditable(false);
			
			leaderField.setBackground(Color.ORANGE);
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.anchor = GridBagConstraints.WEST;
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.gridx = 2;
			gbc_textField_2.gridy = 3;
			contentPanel.add(leaderField, gbc_textField_2);
			leaderField.setColumns(20);
		}
		{
			JLabel lblInvestor = new JLabel("Investor");
			GridBagConstraints gbc_lblInvestor = new GridBagConstraints();
			gbc_lblInvestor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInvestor.anchor = GridBagConstraints.EAST;
			gbc_lblInvestor.gridx = 1;
			gbc_lblInvestor.gridy = 4;
			contentPanel.add(lblInvestor, gbc_lblInvestor);
		}
		{
			investorField = new JTextField();
			investorField.setEditable(false);
			investorField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					JDialog dialog = new InvestorTableFrame();
					dialog.setModal(true);
					dialog.addPropertyChangeListener(new PropertyChangeListener() {
						
						@Override
						public void propertyChange(PropertyChangeEvent evt) {
							if (evt.getPropertyName() == "item"){
								Investor item = (Investor) evt.getNewValue();
								mainOrder.setInvestor(item);
								investorField.setText(item.toString());
							}
							
							
						}
					});
										
					dialog.setVisible(true);
				}
			});
			
			investorField.setBackground(Color.ORANGE);
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.anchor = GridBagConstraints.WEST;
			gbc_textField_3.gridx = 2;
			gbc_textField_3.gridy = 4;
			contentPanel.add(investorField, gbc_textField_3);
			investorField.setColumns(20);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (mainOrder == null){
							mainOrder = new MainOrder();
						}
						fillMainOrder();
						fireMainOrder();
						close();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						close();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void close(){
		this.dispose();
	}
	
	private void fillMainOrder(){
		mainOrder.setMainNumber(numberField.getText());
		mainOrder.setTopic(topicField.getText());
	}
	
	private void fillTextFilds(){
		if (mainOrder.getMainNumber() != null){
			numberField.setText(mainOrder.getMainNumber());
		}
		if (mainOrder.getTopic() != null){
			topicField.setText(mainOrder.getTopic());
		}
		if (mainOrder.getLeader()!= null ){
			leaderField.setText(mainOrder.getLeader().toString());
		}
		if (mainOrder.getInvestor() != null){
			investorField.setText(mainOrder.getInvestor().toString());
		}
		
		
		
	}
	
	private void fireMainOrder(){
		this.firePropertyChange("item", null, mainOrder);
	}
}
