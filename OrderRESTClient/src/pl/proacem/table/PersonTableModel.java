package pl.proacem.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.proacem.model.Person;

public class PersonTableModel extends AbstractTableModel {

	private List<Person> personList = null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonTableModel(List<Person> personList) {
		this.personList = personList;
	}

	@Override
	public int getColumnCount() {
		
		return 12;
	}

	@Override
	public int getRowCount() {
		if (personList != null){
			return personList.size();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return personList.get(row).getId();
		case 1:
			return personList.get(row);
		case 2:
			return personList.get(row).getLogin();
		case 3:
			return personList.get(row).getPass();
		case 4:
			return personList.get(row).getEmail();
		case 5:
			return personList.get(row).getPhone();
		case 6:
			return personList.get(row).getDescription();
		case 7:
			return personList.get(row).getNotes();
		case 8:
			return personList.get(row).getAuthority();
		case 9:
			return personList.get(row).getStatus();
		case 10:
			return personList.get(row).getCreated();
		case 11:
			return personList.get(row).getUpdated();
		default:
			return null;
		}
		
	}

	@Override
	public String getColumnName(int key) {
		switch (key) {
		case 0:
			return "Id";
		case 1:
			return "Name";
		case 2:
			return "Login";
		case 3:
			return "Password";
		case 4:
			return "Email";
		case 5:
			return "Phone";
		case 6:
			return "Description";
		case 7:
			return "Notes";
		case 8:
			return "Authority";
		case 9:
			return "Status";
		case 10:
			return "Created";
		case 11:
			return "Updated";

		default:
			return "Column";
		}
		
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	
}
