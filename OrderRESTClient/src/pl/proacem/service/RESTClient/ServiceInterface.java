package pl.proacem.service.RESTClient;

import java.util.List;

public interface ServiceInterface<T> {

	public T getById(long id);
	public T add(T item);
	public void update(T item);
	public void remove(T item);
	public void removeById(long id);
	public List<T> getList();
	public Integer getSize();
	public List<T> getRange(long from, long to);
	public List<T> getRangeTo(long to);
	public List<T> getRangeFrom(long from);
	public T getLastId();
	public List<T> getByMainOrderId(int id);
	
}
