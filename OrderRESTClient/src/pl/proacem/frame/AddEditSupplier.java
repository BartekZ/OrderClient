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

import pl.proacem.model.Supplier;

public class AddEditSupplier extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nameTextField;
	private JTextField descriptionTextField;
	private JTextField addressTextField;
	private JTextField phoneTextField;
	private Supplier supplier = null;
	private String label= "Add Supplier";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddEditSupplier dialog = new AddEditSupplier();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddEditSupplier(Supplier asupplier){
		this.supplier = asupplier;
		label = "Edit Supplier";
		init();
		fillTextFilds();
	}
	public AddEditSupplier(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		init();
	}
	
	public void init() {
		setBounds(100, 100, 330, 210);
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
			JLabel lblSupplier = new JLabel(label);
			lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
			GridBagConstraints gbc_lblSupplier = new GridBagConstraints();
			gbc_lblSupplier.anchor = GridBagConstraints.WEST;
			gbc_lblSupplier.gridwidth = 2;
			gbc_lblSupplier.insets = new Insets(0, 0, 5, 5);
			gbc_lblSupplier.gridx = 1;
			gbc_lblSupplier.gridy = 0;
			contentPanel.add(lblSupplier, gbc_lblSupplier);
		}
		{
			JLabel lblNewLabel = new JLabel("Name");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			nameTextField = new JTextField();
			GridBagConstraints gbc_nameTextField = new GridBagConstraints();
			gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
			gbc_nameTextField.anchor = GridBagConstraints.WEST;
			gbc_nameTextField.gridx = 2;
			gbc_nameTextField.gridy = 1;
			contentPanel.add(nameTextField, gbc_nameTextField);
			nameTextField.setColumns(20);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Description");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			descriptionTextField = new JTextField();
			GridBagConstraints gbc_descriptionTextField = new GridBagConstraints();
			gbc_descriptionTextField.anchor = GridBagConstraints.WEST;
			gbc_descriptionTextField.insets = new Insets(0, 0, 5, 0);
			gbc_descriptionTextField.gridx = 2;
			gbc_descriptionTextField.gridy = 2;
			contentPanel.add(descriptionTextField, gbc_descriptionTextField);
			descriptionTextField.setColumns(20);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Address");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			addressTextField = new JTextField();
			GridBagConstraints gbc_addressTextField = new GridBagConstraints();
			gbc_addressTextField.anchor = GridBagConstraints.WEST;
			gbc_addressTextField.insets = new Insets(0, 0, 5, 0);
			gbc_addressTextField.gridx = 2;
			gbc_addressTextField.gridy = 3;
			contentPanel.add(addressTextField, gbc_addressTextField);
			addressTextField.setColumns(20);
		}
		{
			JLabel lblPhone = new JLabel("Phone");
			GridBagConstraints gbc_lblPhone = new GridBagConstraints();
			gbc_lblPhone.insets = new Insets(0, 0, 0, 5);
			gbc_lblPhone.anchor = GridBagConstraints.EAST;
			gbc_lblPhone.gridx = 1;
			gbc_lblPhone.gridy = 4;
			contentPanel.add(lblPhone, gbc_lblPhone);
		}
		{
			phoneTextField = new JTextField();
			GridBagConstraints gbc_phoneTextField = new GridBagConstraints();
			gbc_phoneTextField.anchor = GridBagConstraints.WEST;
			gbc_phoneTextField.gridx = 2;
			gbc_phoneTextField.gridy = 4;
			contentPanel.add(phoneTextField, gbc_phoneTextField);
			phoneTextField.setColumns(20);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (supplier == null){
							supplier = new Supplier();
						}
						fillSupplier();
						fireSupplier();
						close();
					}
				});
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
	
	private void fireSupplier(){
		this.firePropertyChange("item", null, supplier);
	}
	
	private void fillSupplier(){
		supplier.setName(nameTextField.getText());
		supplier.setDescription(descriptionTextField.getText());
		supplier.setAddress(addressTextField.getText());
		supplier.setPhone(phoneTextField.getText());
	}
	
	private void fillTextFilds(){
		nameTextField.setText(supplier.getName());
		descriptionTextField.setText(supplier.getDescription());
		addressTextField.setText(supplier.getAddress());
		phoneTextField.setText(supplier.getPhone());
		
	}

}
