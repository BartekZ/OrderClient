package pl.proacem.task;

import java.util.List;

import pl.proacem.service.RESTClient.ServiceInterface;

public class EditItemThread<T> extends NotifyingThread {
	private List<T> list;
	private ServiceInterface<T> service;
	private T item;
	private Integer row;
	
	public EditItemThread(List<T> alist, ServiceInterface<T> aservice, T aitem, Integer arow) {
		this.list = alist;
		this.service = aservice;
		this.item = aitem;
		this.row = arow;
	}

	@Override
	public void doRun() {
		list.set(row, item);
		service.update(item);
	}

}
