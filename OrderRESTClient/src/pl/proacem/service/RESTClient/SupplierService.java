package pl.proacem.service.RESTClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jdesktop.observablecollections.ObservableList;
import org.springframework.web.client.RestTemplate;

import pl.proacem.model.Person;
import pl.proacem.model.Supplier;

public class SupplierService implements ServiceInterface<Supplier> {

	private RestTemplate template = new RestTemplate();
	private Supplier supplier;
	private static List<Supplier> suppliers = new ArrayList<Supplier>();
	
	@Override
	public Supplier getById(long id) {
		supplier = template.getForObject(
				"http://localhost:8080/orderRest/supplier/" + id, Supplier.class);

		return supplier;
	}

	@Override
	public Supplier add(Supplier item) {
		Person person = new PersonService().getById(1);
		item.setCreatedPerson(person);
		item.setUpdatedPerson(person);
		supplier = template.postForObject(
				"http://localhost:8080/orderRest/supplier", item, Supplier.class);

		return supplier;
	}

	@Override
	public void update(Supplier item) {
		template.put("http://localhost:8080/orderRest/supplier", item);

	}

	@Override
	public void remove(Supplier item) {
		template.delete("http://localhost:8080/orderRest/supplier", item);

	}

	@Override
	public void removeById(long id) {
		template.delete("http://localhost:8080/orderRest/supplier/" + id);

	}

	@Override
	public List<Supplier> getList() {
		Supplier[] arr = template.getForObject(
				"http://localhost:8080/orderRest/supplier", Supplier[].class);
		suppliers.clear();
		suppliers.addAll(Arrays.asList(arr));
		
		return suppliers;
	}

	@Override
	public Integer getSize() {
		int size = template.getForObject(
				"http://localhost:8080/orderRest/supplier/size", Integer.class);
		return size;
	}

	@Override
	public List<Supplier> getRange(long from, long to) {
		Supplier[] arr = template.getForObject(
				"http://localhost:8080/orderRest/supplier/from/" + from + "/to/"
						+ to, Supplier[].class);
		suppliers.clear();
		suppliers.addAll(Arrays.asList(arr));

		return suppliers;
	}

	@Override
	public List<Supplier> getRangeTo(long to) {
		Supplier[] arr = template.getForObject(
				"http://localhost:8080/orderRest/supplier/to/" + to,
				Supplier[].class);
		suppliers.clear();
		suppliers.addAll(Arrays.asList(arr));

		return suppliers;
	}

	@Override
	public List<Supplier> getRangeFrom(long from) {
		Supplier[] arr = template.getForObject(
				"http://localhost:8080/orderRest/supplier/from/" + from,
				Supplier[].class);
		suppliers.clear();
		suppliers.addAll(Arrays.asList(arr));

		return suppliers;
	}
	
	

	public static List<Supplier> getSuppliers() {
		return suppliers;
	}

	public static void setSuppliers(ObservableList<Supplier> asuppliers) {
		suppliers = asuppliers;
	}

	@Override
	public Supplier getLastId() {
		supplier = template.getForObject(
				"http://localhost:8080/orderRest/supplier/last", Supplier.class);
		return supplier;
	}

	@Override
	public List<Supplier> getByMainOrderId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	



	
}
