package pl.proacem.table;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class MainOrderTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainOrderTable(TableModel arg0) {
		super(arg0);
		getColumnModel().getColumn(0).setMaxWidth(30);
		getColumnModel().getColumn(0).setMinWidth(30);
		getColumnModel().getColumn(1).setMaxWidth(30);
		getColumnModel().getColumn(1).setMinWidth(30);
		getColumnModel().getColumn(2).setMaxWidth(30);
		getColumnModel().getColumn(2).setMinWidth(30);
		getColumnModel().getColumn(3).setMaxWidth(30);
		getColumnModel().getColumn(4).setMinWidth(30);
		getColumnModel().getColumn(4).setMaxWidth(30);
		getColumnModel().getColumn(5).setMinWidth(30);
		getColumnModel().getColumn(5).setMaxWidth(30);
		
	}

	
	
}
