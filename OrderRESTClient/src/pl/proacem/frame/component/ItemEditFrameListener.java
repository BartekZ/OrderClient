package pl.proacem.frame.component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JTable;

import pl.proacem.model.ModelInterface;
import pl.proacem.service.RESTClient.ServiceInterface;
import pl.proacem.task.EditItemThread;
import pl.proacem.task.ThreadCompleteListener;

public class ItemEditFrameListener<T extends ModelInterface> implements
		PropertyChangeListener {
	private JTable table;
	private ServiceInterface<T> service;
	private List<T> list;

	public ItemEditFrameListener(JTable atable, List<T> alist,
			ServiceInterface<T> aservice) {
		this.table = atable;
		this.list = alist;
		this.service = aservice;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (table.getSelectionModel().isSelectionEmpty() == true){
			return;
		}
		if (evt.getPropertyName() == "item") {
			T person = (T) evt.getNewValue();

			Integer row = table.convertRowIndexToModel(table.getSelectedRow());
			EditItemThread<T> editItemThread = new EditItemThread<T>(list,
					service, person, row);
			editItemThread.addListener(new ThreadCompleteListener() {

				@Override
				public void notifyOfThreadComplete(Thread thread) {
					table.updateUI();

				}
			});
			editItemThread.start();

		}
		table.updateUI();
	}
}
