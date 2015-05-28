package pl.proacem.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.proacem.model.SingleOrder;

public class SingleOrderOwnerTableModel extends AbstractTableModel {

	private List<SingleOrder> singleOrderList = new ArrayList<SingleOrder>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SingleOrderOwnerTableModel(List<SingleOrder> singleOrderList) {
		this.singleOrderList = singleOrderList;
	}

	@Override
	public int getColumnCount() {
		
		return 18;
	}

	@Override
	public int getRowCount() {
		
		return singleOrderList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return singleOrderList.get(row).getId();
		case 1:
			return singleOrderList.get(row);
		case 2:
			return singleOrderList.get(row).getOfferNumber();
		case 3:
			return singleOrderList.get(row).getRequestDate();
		case 4:
			return singleOrderList.get(row).getExpectedDate();
		case 5:
			return singleOrderList.get(row).getSpecification();
		case 6:
			return singleOrderList.get(row).getQuantity();
		case 7:
			return singleOrderList.get(row).getValuePln();
		case 8:
			return singleOrderList.get(row).getValueEur();
		case 9:
			return singleOrderList.get(row).getOther();
		case 10:
			return singleOrderList.get(row).getSupplier();
		case 11:
			return singleOrderList.get(row).getContracting();
		case 12:
			return singleOrderList.get(row).getOwner();
		case 13:
			return singleOrderList.get(row).getStatus();
		case 14:
			return singleOrderList.get(row).getCreated();
		case 15:
			return singleOrderList.get(row).getUpdated();
		case 16:
			return singleOrderList.get(row).getCreatedPerson();
		case 17:
			return singleOrderList.get(row).getUpdatedPerson();
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
			return "Order Number";
		case 2:
			return "Offer Number";
		case 3:
			return "Request Date";
		case 4:
			return "Expected Date";
		case 5:
			return "Specification";
		case 6:
			return "Quanitity";
		case 7:
			return "Value PLN";
		case 8:
			return "Value EUR";
		case 9:
			return "Other";
		case 10:
			return "Supplier";
		case 11:
			return "Contracting";
		case 12:
			return "Owner";
		case 13:
			return "Status";
		case 14:
			return "Created";
		case 15:
			return "Updated";
		case 16:
			return "CreatedPerson";
		case 17:
			return "UpdatedPerson";
		default:
			return "Column " + key;
		}
		
	}

	public List<SingleOrder> getSingleOrderList() {
		return singleOrderList;
	}

	public void setSingleOrderList(List<SingleOrder> singleOrderList) {
		this.singleOrderList = singleOrderList;
	}

	
}
