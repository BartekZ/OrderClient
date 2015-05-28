package pl.proacem.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.proacem.model.Person;

public class TestTable extends AbstractTableModel {

	private List<Person> personList = new ArrayList<Person>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		
		return 3;
	}

	@Override
	public int getRowCount() {
		
		return personList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return personList.get(row).getName();
		case 1:
			return personList.get(row).getLogin();

		default:
			return null;
		}
		
	}

	@Override
	public String getColumnName(int key) {
		switch (key) {
		case 0:
			return "Name";
		case 1:
			return "Login";

		default:
			return "Column ";
		}
		
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	
	

	
	
}
