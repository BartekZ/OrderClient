package pl.proacem.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pl.proacem.model.Investor;

public class AddEditInvestorFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -51067751445047630L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nameTextField;
	private JTextField descriptionTextField;
	private JTextField NotesTextField;
	private String label = "New Investor";
	private Boolean edit = false;
	private Investor investor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddEditInvestorFrame dialog = new AddEditInvestorFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddEditInvestorFrame(Investor ainvestor){
		label = "Edit Investor";
		init();
		edit = true;
		this.investor = ainvestor;
		fillFields();
		
	}
	
	public AddEditInvestorFrame() {
		init();
	}
	
	public void init() {
		setBounds(100, 100, 331, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblAddInvestor = new JLabel(label);
			lblAddInvestor.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_lblAddInvestor = new GridBagConstraints();
			gbc_lblAddInvestor.anchor = GridBagConstraints.WEST;
			gbc_lblAddInvestor.gridwidth = 2;
			gbc_lblAddInvestor.insets = new Insets(0, 0, 5, 5);
			gbc_lblAddInvestor.gridx = 1;
			gbc_lblAddInvestor.gridy = 0;
			contentPanel.add(lblAddInvestor, gbc_lblAddInvestor);
		}
		{
			JLabel nameLabel = new JLabel("Name");
			GridBagConstraints gbc_nameLabel = new GridBagConstraints();
			gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_nameLabel.anchor = GridBagConstraints.EAST;
			gbc_nameLabel.gridx = 1;
			gbc_nameLabel.gridy = 1;
			contentPanel.add(nameLabel, gbc_nameLabel);
		}
		{
			nameTextField = new JTextField();
			GridBagConstraints gbc_nameTextField = new GridBagConstraints();
			gbc_nameTextField.anchor = GridBagConstraints.WEST;
			gbc_nameTextField.insets = new Insets(0, 0, 5, 5);
			gbc_nameTextField.gridx = 2;
			gbc_nameTextField.gridy = 1;
			contentPanel.add(nameTextField, gbc_nameTextField);
			nameTextField.setColumns(20);
		}
		{
			JLabel DescriptionLabel = new JLabel("Description");
			GridBagConstraints gbc_DescriptionLabel = new GridBagConstraints();
			gbc_DescriptionLabel.insets = new Insets(0, 0, 5, 5);
			gbc_DescriptionLabel.anchor = GridBagConstraints.EAST;
			gbc_DescriptionLabel.gridx = 1;
			gbc_DescriptionLabel.gridy = 2;
			contentPanel.add(DescriptionLabel, gbc_DescriptionLabel);
		}
		{
			descriptionTextField = new JTextField();
			GridBagConstraints gbc_DescriptionTextField = new GridBagConstraints();
			gbc_DescriptionTextField.insets = new Insets(0, 0, 5, 5);
			gbc_DescriptionTextField.anchor = GridBagConstraints.WEST;
			gbc_DescriptionTextField.gridx = 2;
			gbc_DescriptionTextField.gridy = 2;
			contentPanel.add(descriptionTextField, gbc_DescriptionTextField);
			descriptionTextField.setColumns(20);
		}
		{
			JLabel NotesLabel = new JLabel("Notes");
			GridBagConstraints gbc_NotesLabel = new GridBagConstraints();
			gbc_NotesLabel.insets = new Insets(0, 0, 0, 5);
			gbc_NotesLabel.anchor = GridBagConstraints.EAST;
			gbc_NotesLabel.gridx = 1;
			gbc_NotesLabel.gridy = 3;
			contentPanel.add(NotesLabel, gbc_NotesLabel);
		}
		{
			NotesTextField = new JTextField();
			GridBagConstraints gbc_NotesTextField = new GridBagConstraints();
			gbc_NotesTextField.insets = new Insets(0, 0, 0, 5);
			gbc_NotesTextField.anchor = GridBagConstraints.WEST;
			gbc_NotesTextField.gridx = 2;
			gbc_NotesTextField.gridy = 3;
			contentPanel.add(NotesTextField, gbc_NotesTextField);
			NotesTextField.setColumns(20);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (edit == false){
							investor = new Investor();
						}
						fillInvestor();
						fireInvestor();
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
	
	private void fillFields(){
		nameTextField.setText(investor.getName());
		descriptionTextField.setText(investor.getDescription());
		NotesTextField.setText(investor.getNote());
	}

	private void fireInvestor() {
		this.firePropertyChange("item", null, investor);
	}
	
	private void fillInvestor(){
		investor.setName(nameTextField.getText());
		investor.setDescription(descriptionTextField.getText());
		investor.setNote(NotesTextField.getText());
	}
}
