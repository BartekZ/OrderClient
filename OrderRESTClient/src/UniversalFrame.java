import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class UniversalFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UniversalFrame dialog = new UniversalFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UniversalFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		for (int i = 0; i < 3; i++) {
			JPanel panel$i = new JPanel();
			panel$i.setLayout(new BorderLayout());
			JLabel aacc$i = new JLabel();
			aacc$i.setText(String.valueOf(i));
			panel$i.add(aacc$i);
			panel$i.setPreferredSize(new Dimension(450, 25));
			contentPanel.add(panel$i);
		}
		{
			
		}
		{
			JPanel panel2 = new JPanel();
			panel2.setBackground(Color.green);
			panel2.setPreferredSize(new Dimension(450, 25));
			contentPanel.add(panel2);
		}
		{
			JPanel panel3 = new JPanel();
			panel3.setBackground(Color.BLUE);
			panel3.setPreferredSize(new Dimension(450, 25));
			contentPanel.add(panel3);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
