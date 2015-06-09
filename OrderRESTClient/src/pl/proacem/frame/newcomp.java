package pl.proacem.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newcomp extends JFrame {

	private JPanel contentPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newcomp frame = new newcomp();
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
	public newcomp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton button3 = new JButton("button3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.add(new JButton());
				panel.updateUI();
			}
		});
		GridBagConstraints gbc_btnNut = new GridBagConstraints();
		gbc_btnNut.anchor = GridBagConstraints.WEST;
		gbc_btnNut.insets = new Insets(0, 0, 5, 5);
		gbc_btnNut.gridx = 2;
		gbc_btnNut.gridy = 1;
		contentPane.add(button3, gbc_btnNut);
		
		JButton button2 = new JButton("New button");
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.anchor = GridBagConstraints.WEST;
		gbc_button2.insets = new Insets(0, 0, 5, 5);
		gbc_button2.gridx = 3;
		gbc_button2.gridy = 1;
		contentPane.add(button2, gbc_button2);
		
		JButton button1 = new JButton("button1");
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.anchor = GridBagConstraints.WEST;
		gbc_button1.insets = new Insets(0, 0, 5, 0);
		gbc_button1.gridx = 4;
		gbc_button1.gridy = 1;
		contentPane.add(button1, gbc_button1);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
	}

}
