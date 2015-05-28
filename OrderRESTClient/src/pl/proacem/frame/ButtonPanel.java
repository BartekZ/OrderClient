package pl.proacem.frame;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import pl.proacem.frame.component.MainMenu;

public class ButtonPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextPane textPane;
	StringBuilder builder = new StringBuilder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonPanel frame = new ButtonPanel();
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
	public ButtonPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnPerson = new JButton("Person");
		btnPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new PersonTableFrame();
				dialog.setModal(true);
				dialog.addPropertyChangeListener(new PropertyChangeListener() {
					
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (evt.getPropertyName() == "selectedPerson"){
							builder.append(evt.getNewValue()+ "<br>");
							textPane.setText(builder.toString());
						}
						
					}
				});
				dialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnPerson = new GridBagConstraints();
		gbc_btnPerson.insets = new Insets(0, 0, 5, 5);
		gbc_btnPerson.gridx = 0;
		gbc_btnPerson.gridy = 0;
		contentPane.add(btnPerson, gbc_btnPerson);
		
		JButton btnInvestor = new JButton("Investor");
		btnInvestor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new InvestorTableFrame();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnInvestor = new GridBagConstraints();
		gbc_btnInvestor.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvestor.gridx = 1;
		gbc_btnInvestor.gridy = 0;
		contentPane.add(btnInvestor, gbc_btnInvestor);
		
		JButton btnSingleorder = new JButton("Singleorder");
		btnSingleorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new SingleOrderTableFrame();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnSingleorder = new GridBagConstraints();
		gbc_btnSingleorder.insets = new Insets(0, 0, 5, 5);
		gbc_btnSingleorder.gridx = 2;
		gbc_btnSingleorder.gridy = 0;
		contentPane.add(btnSingleorder, gbc_btnSingleorder);
		
		JButton btnMainorder = new JButton("Mainorder");
		btnMainorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame dialog = new MainOrderTableFrame();
				dialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnMainorder = new GridBagConstraints();
		gbc_btnMainorder.insets = new Insets(0, 0, 5, 5);
		gbc_btnMainorder.gridx = 3;
		gbc_btnMainorder.gridy = 0;
		contentPane.add(btnMainorder, gbc_btnMainorder);
		
		JButton btnSupplier = new JButton("Supplier");
		btnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new SupplierTableFrame();
				dialog.setVisible(true);
				
			}
		});
		GridBagConstraints gbc_btnSupplier = new GridBagConstraints();
		gbc_btnSupplier.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupplier.gridx = 4;
		gbc_btnSupplier.gridy = 0;
		contentPane.add(btnSupplier, gbc_btnSupplier);
		
		
		textPane = new JTextPane();
		textPane.setContentType("text/html");
		textPane.setEditable(false);
		JScrollPane scrollpana = new JScrollPane(textPane);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 5;
		gbc_textPane.insets = new Insets(0, 0, 0, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 2;
		contentPane.add(scrollpana, gbc_textPane);
		
		MainMenu menubar = new MainMenu();
		this.setJMenuBar(menubar);
	}

}
