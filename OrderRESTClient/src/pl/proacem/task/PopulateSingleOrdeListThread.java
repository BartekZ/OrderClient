package pl.proacem.task;

import org.jdesktop.observablecollections.ObservableList;

import pl.proacem.model.MainOrder;
import pl.proacem.model.ModelInterface;
import pl.proacem.service.RESTClient.ServiceInterface;

public class PopulateSingleOrdeListThread<T extends ModelInterface> extends NotifyingThread {
	private ObservableList<T> list;
	private ServiceInterface<T> service;
	private MainOrder item;
	
	public PopulateSingleOrdeListThread(ObservableList<T> list, ServiceInterface<T> aservice, MainOrder aitem) {
		this.list = list;
		this.service = aservice;
		this.item = aitem;
		
	}

	@Override
	public void doRun() {
		list.clear();
		list.addAll(service.getByMainOrderId(item.getId()));
	}

}
