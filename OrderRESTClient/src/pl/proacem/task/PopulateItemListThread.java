package pl.proacem.task;

import org.jdesktop.observablecollections.ObservableList;

import pl.proacem.model.ModelInterface;
import pl.proacem.service.RESTClient.ServiceInterface;

public class PopulateItemListThread<T extends ModelInterface> extends NotifyingThread {
	private ObservableList<T> list;
	private ServiceInterface<T> service;
	
	public PopulateItemListThread(ObservableList<T> list, ServiceInterface<T> aservice) {
		this.list = list;
		this.service = aservice;
	}

	@Override
	public void doRun() {
		list.clear();
		list.addAll(service.getList());
	}

}
