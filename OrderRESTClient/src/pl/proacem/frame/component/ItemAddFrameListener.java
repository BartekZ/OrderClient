package pl.proacem.frame.component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTable;

import org.jdesktop.observablecollections.ObservableList;

import pl.proacem.model.ModelInterface;
import pl.proacem.service.RESTClient.ServiceInterface;
import pl.proacem.task.AddItemThread;
import pl.proacem.task.ThreadCompleteListener;

public class ItemAddFrameListener<T extends ModelInterface> implements
		PropertyChangeListener {
	private ServiceInterface<T> service;
	private ObservableList<T> list;

	public ItemAddFrameListener(ObservableList<T> alist,	ServiceInterface<T> aservice) {
		this.list = alist;
		this.service = aservice;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName() == "item") {
			T person = (T) evt.getNewValue();

			// NEW
			AddItemThread<T> addThread = new AddItemThread<T>(list, service,
					person);
			addThread.addListener(new ThreadCompleteListener() {

				@Override
				public void notifyOfThreadComplete(Thread thread) {
					
					

				}
			});
			addThread.start();

		}
	}

}
