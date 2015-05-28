package pl.proacem.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import pl.proacem.model.MainOrder;
import pl.proacem.model.SingleOrder;

public class AddEditSingleOrderFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField orderNumberField;
	private JTextField offertNumberField;
	private JTextField requestDateField;
	private JTextField expectedDateField;
	private JTextField SpecificationField;
	private JTextField QuantityField;
	private JTextField valuePlnField;
	private JTextField valueEurField;
	private JTextField otherField;
	private JTextField supplierField;
	private JTextField ContractingField;
	private SingleOrder singleOrder;
	private String label = "Add SingleOrder";
	private MainOrder mainOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddEditSingleOrderFrame dialog = new AddEditSingleOrderFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddEditSingleOrderFrame(SingleOrder asingleOrder) {
		this.singleOrder = asingleOrder;
		label = "Edit SingleOrder";
		init();
		fillTextFields();
	}

	public AddEditSingleOrderFrame() {
		init();
	}

	public AddEditSingleOrderFrame(MainOrder amainOrder) {
		init();
		this.mainOrder = amainOrder;
	}
	
	public void init() {
		setBounds(100, 100, 361, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblAddSingleOrder = new JLabel(label);
			GridBagConstraints gbc_lblAddSingleOrder = new GridBagConstraints();
			gbc_lblAddSingleOrder.anchor = GridBagConstraints.WEST;
			gbc_lblAddSingleOrder.gridwidth = 2;
			gbc_lblAddSingleOrder.insets = new Insets(0, 0, 5, 5);
			gbc_lblAddSingleOrder.gridx = 1;
			gbc_lblAddSingleOrder.gridy = 0;
			contentPanel.add(lblAddSingleOrder, gbc_lblAddSingleOrder);
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
			orderNumberField = new JTextField();
			GridBagConstraints gbc_orderNumberField = new GridBagConstraints();
			gbc_orderNumberField.anchor = GridBagConstraints.WEST;
			gbc_orderNumberField.insets = new Insets(0, 0, 5, 0);
			gbc_orderNumberField.gridx = 2;
			gbc_orderNumberField.gridy = 1;
			contentPanel.add(orderNumberField, gbc_orderNumberField);
			orderNumberField.setColumns(20);
		}
		{
			JLabel lblOffertNumber = new JLabel("Offert number");
			GridBagConstraints gbc_lblOffertNumber = new GridBagConstraints();
			gbc_lblOffertNumber.insets = new Insets(0, 0, 5, 5);
			gbc_lblOffertNumber.anchor = GridBagConstraints.EAST;
			gbc_lblOffertNumber.gridx = 1;
			gbc_lblOffertNumber.gridy = 2;
			contentPanel.add(lblOffertNumber, gbc_lblOffertNumber);
		}
		{
			offertNumberField = new JTextField();
			GridBagConstraints gbc_offertNumberField = new GridBagConstraints();
			gbc_offertNumberField.anchor = GridBagConstraints.WEST;
			gbc_offertNumberField.insets = new Insets(0, 0, 5, 0);
			gbc_offertNumberField.gridx = 2;
			gbc_offertNumberField.gridy = 2;
			contentPanel.add(offertNumberField, gbc_offertNumberField);
			offertNumberField.setColumns(20);
		}
		{
			JLabel lblRequestDate = new JLabel("Request Date");
			GridBagConstraints gbc_lblRequestDate = new GridBagConstraints();
			gbc_lblRequestDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblRequestDate.anchor = GridBagConstraints.EAST;
			gbc_lblRequestDate.gridx = 1;
			gbc_lblRequestDate.gridy = 3;
			contentPanel.add(lblRequestDate, gbc_lblRequestDate);
		}
		{
			requestDateField = new JTextField();
			GridBagConstraints gbc_requestDateField = new GridBagConstraints();
			gbc_requestDateField.anchor = GridBagConstraints.WEST;
			gbc_requestDateField.insets = new Insets(0, 0, 5, 0);
			gbc_requestDateField.gridx = 2;
			gbc_requestDateField.gridy = 3;
			contentPanel.add(requestDateField, gbc_requestDateField);
			requestDateField.setColumns(20);
		}
		{
			JLabel lblExpectedDate = new JLabel("Expected Date");
			GridBagConstraints gbc_lblExpectedDate = new GridBagConstraints();
			gbc_lblExpectedDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblExpectedDate.anchor = GridBagConstraints.EAST;
			gbc_lblExpectedDate.gridx = 1;
			gbc_lblExpectedDate.gridy = 4;
			contentPanel.add(lblExpectedDate, gbc_lblExpectedDate);
		}
		{
			expectedDateField = new JTextField();
			GridBagConstraints gbc_expectedDateField = new GridBagConstraints();
			gbc_expectedDateField.anchor = GridBagConstraints.WEST;
			gbc_expectedDateField.insets = new Insets(0, 0, 5, 0);
			gbc_expectedDateField.gridx = 2;
			gbc_expectedDateField.gridy = 4;
			contentPanel.add(expectedDateField, gbc_expectedDateField);
			expectedDateField.setColumns(20);
		}
		{
			JLabel lblSpecification = new JLabel("Specification");
			GridBagConstraints gbc_lblSpecification = new GridBagConstraints();
			gbc_lblSpecification.insets = new Insets(0, 0, 5, 5);
			gbc_lblSpecification.anchor = GridBagConstraints.EAST;
			gbc_lblSpecification.gridx = 1;
			gbc_lblSpecification.gridy = 5;
			contentPanel.add(lblSpecification, gbc_lblSpecification);
		}
		{
			SpecificationField = new JTextField();
			GridBagConstraints gbc_SpecificationField = new GridBagConstraints();
			gbc_SpecificationField.anchor = GridBagConstraints.WEST;
			gbc_SpecificationField.insets = new Insets(0, 0, 5, 0);
			gbc_SpecificationField.gridx = 2;
			gbc_SpecificationField.gridy = 5;
			contentPanel.add(SpecificationField, gbc_SpecificationField);
			SpecificationField.setColumns(20);
		}
		{
			JLabel lblQuanitity = new JLabel("Quanitity");
			GridBagConstraints gbc_lblQuanitity = new GridBagConstraints();
			gbc_lblQuanitity.insets = new Insets(0, 0, 5, 5);
			gbc_lblQuanitity.anchor = GridBagConstraints.EAST;
			gbc_lblQuanitity.gridx = 1;
			gbc_lblQuanitity.gridy = 6;
			contentPanel.add(lblQuanitity, gbc_lblQuanitity);
		}
		{
			QuantityField = new JTextField();
			GridBagConstraints gbc_QuantityField = new GridBagConstraints();
			gbc_QuantityField.anchor = GridBagConstraints.WEST;
			gbc_QuantityField.insets = new Insets(0, 0, 5, 0);
			gbc_QuantityField.gridx = 2;
			gbc_QuantityField.gridy = 6;
			contentPanel.add(QuantityField, gbc_QuantityField);
			QuantityField.setColumns(20);
		}
		{
			JLabel lblValuePln = new JLabel("Value PLN");
			GridBagConstraints gbc_lblValuePln = new GridBagConstraints();
			gbc_lblValuePln.insets = new Insets(0, 0, 5, 5);
			gbc_lblValuePln.anchor = GridBagConstraints.EAST;
			gbc_lblValuePln.gridx = 1;
			gbc_lblValuePln.gridy = 7;
			contentPanel.add(lblValuePln, gbc_lblValuePln);
		}
		{
			valuePlnField = new JTextField();
			GridBagConstraints gbc_ValuePlnField = new GridBagConstraints();
			gbc_ValuePlnField.anchor = GridBagConstraints.WEST;
			gbc_ValuePlnField.insets = new Insets(0, 0, 5, 0);
			gbc_ValuePlnField.gridx = 2;
			gbc_ValuePlnField.gridy = 7;
			contentPanel.add(valuePlnField, gbc_ValuePlnField);
			valuePlnField.setColumns(20);
		}
		{
			JLabel lblValueEur = new JLabel("Value EUR");
			GridBagConstraints gbc_lblValueEur = new GridBagConstraints();
			gbc_lblValueEur.insets = new Insets(0, 0, 5, 5);
			gbc_lblValueEur.anchor = GridBagConstraints.EAST;
			gbc_lblValueEur.gridx = 1;
			gbc_lblValueEur.gridy = 8;
			contentPanel.add(lblValueEur, gbc_lblValueEur);
		}
		{
			valueEurField = new JTextField();
			GridBagConstraints gbc_valueEurField = new GridBagConstraints();
			gbc_valueEurField.anchor = GridBagConstraints.WEST;
			gbc_valueEurField.insets = new Insets(0, 0, 5, 0);
			gbc_valueEurField.gridx = 2;
			gbc_valueEurField.gridy = 8;
			contentPanel.add(valueEurField, gbc_valueEurField);
			valueEurField.setColumns(20);
		}
		{
			JLabel lblOther = new JLabel("Other");
			GridBagConstraints gbc_lblOther = new GridBagConstraints();
			gbc_lblOther.insets = new Insets(0, 0, 5, 5);
			gbc_lblOther.anchor = GridBagConstraints.EAST;
			gbc_lblOther.gridx = 1;
			gbc_lblOther.gridy = 9;
			contentPanel.add(lblOther, gbc_lblOther);
		}
		{
			otherField = new JTextField();
			GridBagConstraints gbc_otherFiield = new GridBagConstraints();
			gbc_otherFiield.anchor = GridBagConstraints.WEST;
			gbc_otherFiield.insets = new Insets(0, 0, 5, 0);
			gbc_otherFiield.gridx = 2;
			gbc_otherFiield.gridy = 9;
			contentPanel.add(otherField, gbc_otherFiield);
			otherField.setColumns(20);
		}
		{
			JLabel lblSupplier = new JLabel("Supplier");
			GridBagConstraints gbc_lblSupplier = new GridBagConstraints();
			gbc_lblSupplier.insets = new Insets(0, 0, 5, 5);
			gbc_lblSupplier.anchor = GridBagConstraints.EAST;
			gbc_lblSupplier.gridx = 1;
			gbc_lblSupplier.gridy = 10;
			contentPanel.add(lblSupplier, gbc_lblSupplier);
		}
		{
			supplierField = new JTextField();
			GridBagConstraints gbc_supplierField = new GridBagConstraints();
			gbc_supplierField.anchor = GridBagConstraints.WEST;
			gbc_supplierField.insets = new Insets(0, 0, 5, 0);
			gbc_supplierField.gridx = 2;
			gbc_supplierField.gridy = 10;
			contentPanel.add(supplierField, gbc_supplierField);
			supplierField.setColumns(20);
		}
		{
			JLabel lblContracting = new JLabel("Contracting");
			GridBagConstraints gbc_lblContracting = new GridBagConstraints();
			gbc_lblContracting.insets = new Insets(0, 0, 0, 5);
			gbc_lblContracting.anchor = GridBagConstraints.EAST;
			gbc_lblContracting.gridx = 1;
			gbc_lblContracting.gridy = 11;
			contentPanel.add(lblContracting, gbc_lblContracting);
		}
		{
			ContractingField = new JTextField();
			GridBagConstraints gbc_ContractingField = new GridBagConstraints();
			gbc_ContractingField.anchor = GridBagConstraints.WEST;
			gbc_ContractingField.gridx = 2;
			gbc_ContractingField.gridy = 11;
			contentPanel.add(ContractingField, gbc_ContractingField);
			ContractingField.setColumns(20);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (singleOrder == null) {
							singleOrder = new SingleOrder();
						}
						if (mainOrder != null){
							singleOrder.setOwner(mainOrder);
						}
						
						fillSingleOrder();
						fireSingleOrder();
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

	private void close() {
		this.dispose();
	}

	private void fillSingleOrder() {
		singleOrder.setOrderNumber(orderNumberField.getText());
		singleOrder.setOfferNumber(offertNumberField.getText());
		singleOrder.setSpecification(SpecificationField.getText());
		singleOrder.setQuantity(QuantityField.getText());
		singleOrder.setValuePln(valuePlnField.getText());
		singleOrder.setValueEur(valueEurField.getText());
		singleOrder.setOther(otherField.getText());
	}

	private void fillTextFields(){
		orderNumberField.setText(singleOrder.getOrderNumber());
		offertNumberField.setText(singleOrder.getOfferNumber());
		if (singleOrder.getRequestDate() != null){
			requestDateField.setText(singleOrder.getRequestDate().toString());
		}
		if(singleOrder.getExpectedDate() != null){
			expectedDateField.setText(singleOrder.getExpectedDate().toString());
		}
		
		SpecificationField.setText(singleOrder.getSpecification());
		QuantityField.setText(singleOrder.getQuantity());
		valuePlnField.setText(singleOrder.getValuePln());
		valueEurField.setText(singleOrder.getValueEur());
		otherField.setText(singleOrder.getOther());
		if(singleOrder.getSupplier() != null){
			supplierField.setText(singleOrder.getSupplier().toString());
		}
		if(singleOrder.getContracting() != null){
			ContractingField.setText(singleOrder.getContracting().toString());
		}
		
		
	}

	private void fireSingleOrder() {
		this.firePropertyChange("item", null, singleOrder);
		;
	}

}
