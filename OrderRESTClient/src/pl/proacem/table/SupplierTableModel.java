package pl.proacem.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.proacem.model.Supplier;

public class SupplierTableModel extends AbstractTableModel {

	private List<Supplier> supplierList = new ArrayList<Supplier>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SupplierTableModel(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}

	@Override
	public int getColumnCount() {
		
		return 10;
	}

	@Override
	public int getRowCount() {
		
		return supplierList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return supplierList.get(row).getId();
		case 1:
			return supplierList.get(row);
		case 2:
			return supplierList.get(row).getDescription();
		case 3:
			return supplierList.get(row).getAddress();
		case 4:
			return supplierList.get(row).getPhone();
		case 5:
			return supplierList.get(row).getStatus();
		case 6:
			return supplierList.get(row).getCreated();
		case 7:
			return supplierList.get(row).getUpdated();
		case 8:
			return supplierList.get(row).getCreatedPerson();
		case 9:
			return supplierList.get(row).getUpdatedPerson();
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
			return "Address";
		case 4:
			return "Phone";
		case 5:
			return "Status";
		case 6:
			return "Created";
		case 7:
			return "Updated";
		case 8:
			return "CreatedPerson";
		case 9:
			return "UpdatedPerson";
		default:
			return "Column " + key;
		}
		
	}

	public List<Supplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}

	
}
