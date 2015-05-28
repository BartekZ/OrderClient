package pl.proacem.controler;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import pl.proacem.frame.LoginFrame;
import pl.proacem.frame.MainOrderTableFrame;
import pl.proacem.frame.component.MainMenu;

public class init {

	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				final LoginFrame loginFrame = new LoginFrame();
				final MainOrderTableFrame mainOrdersFrame = new MainOrderTableFrame();
				final JMenuBar menuBar = new MainMenu();
				
				mainOrdersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				loginFrame.addPropertyChangeListener(new PropertyChangeListener() {
					
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (evt.getPropertyName() == "succesfullLogged"){
							
							loginFrame.setVisible(false);
							mainOrdersFrame.setJMenuBar(menuBar);
							mainOrdersFrame.setVisible(true);
							mainOrdersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
						}
							
						
					}
				});
				
				menuBar.addPropertyChangeListener(new PropertyChangeListener() {
					
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (evt.getPropertyName() == "logout") {
							Integer code = LoginUser.logout();
							if (code == 0){
								mainOrdersFrame.setVisible(false);
								loginFrame.clear();
								loginFrame.setVisible(true);
							}
							
						}
						
					}
				});
				
				loginFrame.setVisible(true);
				
				
				
				
				
				
			}
		});
		
	}
	
	

}
