package pl.proacem.frame.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pl.proacem.frame.AboutFrame;
import pl.proacem.frame.InvestorTableFrame;
import pl.proacem.frame.PersonTableFrame;
import pl.proacem.frame.Search;
import pl.proacem.frame.SingleOrderTableFrame;
import pl.proacem.frame.SupplierTableFrame;

public class MainMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5828659190994299331L;

	public MainMenu() {
		super();
		
		JMenu main = new JMenu("Main");
		JMenuItem logout = new JMenuItem("Logout");
		JMenuItem exit = new JMenuItem("Exit");
		main.add(logout);
		main.add(exit);
		
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				firePropertyChange("logout", null, true);
			}
		});
		
		JMenu about = new JMenu("About");
		
		
		JMenuItem loggedUser = new JMenuItem("Account");
		loggedUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog frame = new AboutFrame();
				frame.setVisible(true);
				
			}
		});
		JMenuItem search = new JMenuItem("Search");
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog searchDialog = new Search();
				searchDialog.setVisible(true);
				
			}
		});
		
		about.add(loggedUser);
		about.add(search);
		
		JMenu tables = new JMenu("Tables");
		JMenuItem personTableItem = new JMenuItem("Person");
		JMenuItem investorTableItem = new JMenuItem("Investor");
		JMenuItem singleOrderTableItem = new JMenuItem("Singleorder");
		JMenuItem supplierTableItem = new JMenuItem("Supplier");
		
		tables.add(personTableItem);
		tables.add(investorTableItem);
		tables.add(singleOrderTableItem);
		tables.add(supplierTableItem);
		
		
		personTableItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new PersonTableFrame();
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		
		investorTableItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new InvestorTableFrame();
				dialog.setModal(true);
				dialog.setVisible(true);
				
			}
		});
		
		singleOrderTableItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new SingleOrderTableFrame();
				dialog.setModal(true);
				dialog.setVisible(true);
				
			}
		});
		
		supplierTableItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new SupplierTableFrame();
				dialog.setModal(true);
				dialog.setVisible(true);
				
			}
		});
		
		add(main);
		add(tables);
		add(about);
		
		
	}
	
	

}
