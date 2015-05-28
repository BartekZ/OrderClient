package pl.proacem.task;

import java.util.List;

import pl.proacem.model.ModelInterface;
import pl.proacem.service.RESTClient.ServiceInterface;

public class DeleteItemThread<T extends ModelInterface> extends NotifyingThread {
	private List<T> list;
	private ServiceInterface<T> service;
	private T item;
	
	public DeleteItemThread(List<T> alist, ServiceInterface<T> aservice, T aitem) {
		this.list = alist;
		this.service = aservice;
		this.item = aitem;
	}

	@Override
	public void doRun() {
		list.remove(item);
		service.removeById(item.getId());
	}

}
