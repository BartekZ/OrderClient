package pl.proacem.service.RESTClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jdesktop.observablecollections.ObservableList;
import org.springframework.web.client.RestTemplate;

import pl.proacem.model.MainOrder;
import pl.proacem.model.Person;
import pl.proacem.model.SingleOrder;

public class SingleOrderService implements ServiceInterface<SingleOrder> {

	private RestTemplate template = new RestTemplate();
	private SingleOrder singleOrder;
	private static List<SingleOrder> singleOrders = new ArrayList<SingleOrder>();
	
	@Override
	public SingleOrder getById(long id) {
		singleOrder = template.getForObject(
				"http://localhost:8080/orderRest/singleorder/" + id, SingleOrder.class);

		return singleOrder;
	}

	@Override
	public SingleOrder add(SingleOrder item) {
		Person person = new PersonService().getById(1);
		item.setUpdatedPerson(person);
		item.setCreatedPerson(person);
		singleOrder = template.postForObject(
				"http://localhost:8080/orderRest/singleorder", item, SingleOrder.class);

		return singleOrder;
	}

	@Override
	public void update(SingleOrder item) {
		template.put("http://localhost:8080/orderRest/singleorder", item);

	}

	@Override
	public void remove(SingleOrder item) {
		template.delete("http://localhost:8080/orderRest/singleorder", item);

	}

	@Override
	public void removeById(long id) {
		template.delete("http://localhost:8080/orderRest/singleorder/" + id);

	}

	@Override
	public List<SingleOrder> getList() {
		SingleOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/singleorder", SingleOrder[].class);
		singleOrders.clear();
		singleOrders.addAll(Arrays.asList(arr));
		
		return singleOrders;
	}
	
	
	public List<SingleOrder> getList(MainOrder amainOrder) {
		SingleOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/singleorder/mainorder/" + amainOrder.getId(), SingleOrder[].class);
		singleOrders.clear();
		singleOrders.addAll(Arrays.asList(arr));
		
		return singleOrders;
	}

	@Override
	public Integer getSize() {
		int size = template.getForObject(
				"http://localhost:8080/orderRest/singleorder/size", Integer.class);
		return size;
	}

	@Override
	public List<SingleOrder> getRange(long from, long to) {
		SingleOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/singleorder/from/" + from + "/to/"
						+ to, SingleOrder[].class);
		singleOrders.clear();
		singleOrders.addAll(Arrays.asList(arr));

		return singleOrders;
	}

	@Override
	public List<SingleOrder> getRangeTo(long to) {
		SingleOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/singleorder/to/" + to,
				SingleOrder[].class);
		singleOrders.clear();
		singleOrders.addAll(Arrays.asList(arr));

		return singleOrders;
	}

	@Override
	public List<SingleOrder> getRangeFrom(long from) {
		SingleOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/singleorder/from/" + from,
				SingleOrder[].class);
		singleOrders.clear();
		singleOrders.addAll(Arrays.asList(arr));

		return singleOrders;
	}
	
	

	public static List<SingleOrder> getSingleOrders() {
		return singleOrders;
	}

	public static void setSingleOrders(ObservableList<SingleOrder> asingleOrders) {
		singleOrders = asingleOrders;
	}

	@Override
	public SingleOrder getLastId() {
		singleOrder = template.getForObject(
				"http://localhost:8080/orderRest/singleorder/last", SingleOrder.class);
		return singleOrder;
	}

	@Override
	public List<SingleOrder> getByMainOrderId(int id) {
		SingleOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/singleorder/mainorder/" + id,
				SingleOrder[].class);
		singleOrders.clear();
		singleOrders.addAll(Arrays.asList(arr));

		return singleOrders;
	}
	
	public List<SingleOrder> getTest(String word){
		SingleOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/singleorder/search/" + word,
				SingleOrder[].class);
		singleOrders.clear();
		singleOrders.addAll(Arrays.asList(arr));

		return singleOrders;
		
	}

	


	
}
