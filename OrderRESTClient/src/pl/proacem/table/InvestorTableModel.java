package pl.proacem.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.proacem.model.Investor;

public class InvestorTableModel extends AbstractTableModel {

	private List<Investor> investorList = new ArrayList<Investor>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvestorTableModel(List<Investor> investorList) {
		this.investorList = investorList;
	}

	@Override
	public int getColumnCount() {
		
		return 9;
	}

	@Override
	public int getRowCount() {
		
		return investorList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return investorList.get(row).getId();
		case 1:
			return investorList.get(row);
		case 2:
			return investorList.get(row).getDescription();
		case 3:
			return investorList.get(row).getStatus();
		case 4:
			return investorList.get(row).getNote();
		case 5:
			return investorList.get(row).getCreated();
		case 6:
			return investorList.get(row).getUpdated();
		case 7:
			return investorList.get(row).getCreatedPerson();
		case 8:
			return investorList.get(row).getUpdatedPerson();
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
			return "Description";
		case 3:
			return "Status";
		case 4:
			return "Notes";
		case 5:
			return "Created";
		case 6:
			return "Updated";
		case 7:
			return "CreatedPerson";
		case 8:
			return "UpdatedPerson";
		default:
			return "Column " + key;
		}
		
	}

	public List<Investor> getInvestorList() {
		return investorList;
	}

	public void setInvestorList(List<Investor> investorList) {
		this.investorList = investorList;
	}

	
}
