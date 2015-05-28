package pl.proacem.table;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import pl.proacem.model.MainOrder;

public class MainOrderTableModel extends AbstractTableModel {

	private List<MainOrder> mainOrderList = new ArrayList<MainOrder>();
	private DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainOrderTableModel(List<MainOrder> mainOrderList) {
		this.mainOrderList = mainOrderList;
	}

	@Override
	public int getColumnCount() {
		
		return 9;
	}

	@Override
	public int getRowCount() {
		
		return mainOrderList.size();
		
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return mainOrderList.get(row).getId();
		case 1:
			return mainOrderList.get(row);
		case 2:
			return mainOrderList.get(row).getTopic();
		case 3:
			return mainOrderList.get(row).getLeader();
		case 4:
			return mainOrderList.get(row).getInvestor();
		case 5:
			if (mainOrderList.get(row).getCreated() != null){
				return df.format(mainOrderList.get(row).getCreated());
			}
			return mainOrderList.get(row).getCreated();
		case 6:
			if (mainOrderList.get(row).getUpdated() != null){
				return df.format(mainOrderList.get(row).getUpdated());
			}
			return mainOrderList.get(row).getUpdated();
		case 7:
			return mainOrderList.get(row).getCreatedPerson();
		case 8:
			return mainOrderList.get(row).getUpdatedPerson();
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
			return "Number";
		case 2:
			return "Topic";
		case 3:
			return "Leader";
		case 4:
			return "Investor";
		case 5:
			return "Created";
		case 6:
			return "Updated";
		case 7:
			return "Created by";
		case 8:
			return "Updated by ";
		default:
			return "Column " + key;
		}
		
	}

	public List<MainOrder> getMainOrderList() {
		return mainOrderList;
	}

	public void setMainOrderList(List<MainOrder> mainOrderList) {
		this.mainOrderList = mainOrderList;
	}

	
}
