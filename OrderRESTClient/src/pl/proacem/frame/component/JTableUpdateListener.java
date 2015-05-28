package pl.proacem.frame.component;

import java.util.List;

import javax.swing.JTable;

import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.observablecollections.ObservableListListener;

public class JTableUpdateListener implements ObservableListListener {
	private JTable table;
	
	 public JTableUpdateListener(JTable atable) {
		this.table = atable;
	}
	
	@Override
	public void listElementPropertyChanged(ObservableList arg0, int arg1) {
		table.updateUI();
	}

	@Override
	public void listElementReplaced(ObservableList arg0, int arg1, Object arg2) {
		table.updateUI();
	}

	@Override
	public void listElementsAdded(ObservableList arg0, int arg1, int arg2) {
		table.updateUI();
	}

	@Override
	public void listElementsRemoved(ObservableList arg0, int arg1, List arg2) {
		table.updateUI();
	}

}
