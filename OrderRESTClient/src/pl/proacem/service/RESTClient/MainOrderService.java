package pl.proacem.service.RESTClient;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jdesktop.observablecollections.ObservableList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import pl.proacem.model.MainOrder;
import pl.proacem.model.Person;

public class MainOrderService implements ServiceInterface<MainOrder> {

	private RestTemplate template = new RestTemplate();
	private MainOrder mainOrder;
	private static List<MainOrder> mainOrders = new ArrayList<MainOrder>();
	
	@Override
	public MainOrder getById(long id) {
		mainOrder = template.getForObject(
				"http://localhost:8080/orderRest/mainorder/" + id, MainOrder.class);

		return mainOrder;
	}

	@Override
	public MainOrder add(MainOrder item) {
		Person person = new PersonService().getById(1);
		item.setUpdatedPerson(person);
		item.setCreatedPerson(person);
		mainOrder = template.postForObject(
				"http://localhost:8080/orderRest/mainorder", item, MainOrder.class);

		return mainOrder;
	}

	@Override
	public void update(MainOrder item) {
		template.put("http://localhost:8080/orderRest/mainorder", item);

	}

	@Override
	public void remove(MainOrder item) {
		template.delete("http://localhost:8080/orderRest/mainorder", item);

	}

	@Override
	public void removeById(long id) {
		template.delete("http://localhost:8080/orderRest/mainorder/" + id);

	}

	@Override
	public List<MainOrder> getList() {
		
		try {
			
			MainOrder[] arr = template.getForObject("http://localhost:8080/orderRest/mainorder", MainOrder[].class);
			mainOrders.clear();
			mainOrders.addAll(Arrays.asList(arr));
		} catch (HttpClientErrorException e) {
			MainOrder empty = new MainOrder();
			empty.setTopic("error");
			empty.setMainNumber(e.getStatusCode().toString());
			mainOrders.add(empty);
		} catch (ResourceAccessException e) {
			MainOrder empty = new MainOrder();
			empty.setTopic(e.getLocalizedMessage());
			mainOrders.add(empty);
		}
		
		
		return mainOrders;
	}

	@Override
	public Integer getSize() {
		int size = template.getForObject(
				"http://localhost:8080/orderRest/mainorder/size", Integer.class);
		return size;
	}

	@Override
	public List<MainOrder> getRange(long from, long to) {
		MainOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/mainorder/from/" + from + "/to/"
						+ to, MainOrder[].class);
		mainOrders.clear();
		mainOrders.addAll(Arrays.asList(arr));

		return mainOrders;
	}

	@Override
	public List<MainOrder> getRangeTo(long to) {
		MainOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/mainorder/to/" + to,
				MainOrder[].class);
		mainOrders.clear();
		mainOrders.addAll(Arrays.asList(arr));

		return mainOrders;
	}

	@Override
	public List<MainOrder> getRangeFrom(long from) {
		MainOrder[] arr = template.getForObject(
				"http://localhost:8080/orderRest/mainorder/from/" + from,
				MainOrder[].class);
		mainOrders.clear();
		mainOrders.addAll(Arrays.asList(arr));

		return mainOrders;
	}
	
	

	public static List<MainOrder> getMainOrders() {
		return mainOrders;
	}

	public static void setMainOrders(ObservableList<MainOrder> amainOrders) {
		mainOrders = amainOrders;
	}

	@Override
	public MainOrder getLastId() {
		mainOrder = template.getForObject(
				"http://localhost:8080/orderRest/mainorder/last", MainOrder.class);
		return mainOrder;
	}

	@Override
	public List<MainOrder> getByMainOrderId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	



	
}
