package pl.proacem.frame.component;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingAnimation {
	private JPanel pan;
	private JPanel contentPane;

	public LoadingAnimation(JPanel panel){
		this.contentPane = panel;
		init();
	}
	
	private void init(){
		ImageIcon loading = new ImageIcon("ajax-loader.gif");
		JLabel lab = new JLabel("loading", loading, JLabel.RIGHT);
		pan = new JPanel();
		pan.add(lab);
		GridBagConstraints gbc_lblLab = new GridBagConstraints();
		gbc_lblLab.anchor = GridBagConstraints.EAST;
		gbc_lblLab.gridwidth = 9;
		gbc_lblLab.insets = new Insets(0, 0, 5, 5);
		gbc_lblLab.gridx = 1;
		gbc_lblLab.gridy = 0;
		contentPane.add(pan, gbc_lblLab);
	}
	
	public void setVisible(boolean test){
		if (test == true){
			pan.setVisible(true);
		
		}
		else {
			pan.setVisible(false);
		}
	}
	
}
