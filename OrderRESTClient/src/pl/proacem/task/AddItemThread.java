package pl.proacem.task;

import org.jdesktop.observablecollections.ObservableList;

import pl.proacem.service.RESTClient.ServiceInterface;

public class AddItemThread<T> extends NotifyingThread {
	private ObservableList<T> list;
	private ServiceInterface<T> service;
	private T item;
	
	public AddItemThread(ObservableList<T> alist,ServiceInterface<T> aservice ,T aitem) {
		this.list = alist;
		this.service = aservice;
		this.item = aitem;
	}

	@Override
	public void doRun() {
		item = service.add(item);
		//item = service.getLastId();
		list.add(item);
	}

}
