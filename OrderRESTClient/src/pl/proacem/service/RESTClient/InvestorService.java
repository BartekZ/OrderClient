package pl.proacem.service.RESTClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jdesktop.observablecollections.ObservableList;
import org.springframework.web.client.RestTemplate;

import pl.proacem.model.Investor;
import pl.proacem.model.Person;

public class InvestorService implements ServiceInterface<Investor> {

	private RestTemplate template = new RestTemplate();
	private Investor investor;
	private static List<Investor> investors = new ArrayList<Investor>();
	
	@Override
	public Investor getById(long id) {
		investor = template.getForObject(
				"http://localhost:8080/orderRest/investor/" + id, Investor.class);

		return investor;
	}

	@Override
	public Investor add(Investor item) {
		Person person = new PersonService().getById(1);
		item.setUpdatedPerson(person);
		item.setCreatedPerson(person);
		investor = template.postForObject(
				"http://localhost:8080/orderRest/investor", item, Investor.class);

		return investor;
	}

	@Override
	public void update(Investor item) {
		template.put("http://localhost:8080/orderRest/investor", item);

	}

	@Override
	public void remove(Investor item) {
		template.delete("http://localhost:8080/orderRest/investor", item);

	}

	@Override
	public void removeById(long id) {
		template.delete("http://localhost:8080/orderRest/investor/" + id);

	}

	@Override
	public List<Investor> getList() {
		Investor[] arr = template.getForObject(
				"http://localhost:8080/orderRest/investor", Investor[].class);
		investors.clear();
		investors.addAll(Arrays.asList(arr));
		
		return investors;
	}

	@Override
	public Integer getSize() {
		int size = template.getForObject(
				"http://localhost:8080/orderRest/investor/size", Integer.class);
		return size;
	}

	@Override
	public List<Investor> getRange(long from, long to) {
		Investor[] arr = template.getForObject(
				"http://localhost:8080/orderRest/investor/from/" + from + "/to/"
						+ to, Investor[].class);
		investors.clear();
		investors.addAll(Arrays.asList(arr));

		return investors;
	}

	@Override
	public List<Investor> getRangeTo(long to) {
		Investor[] arr = template.getForObject(
				"http://localhost:8080/orderRest/investor/to/" + to,
				Investor[].class);
		investors.clear();
		investors.addAll(Arrays.asList(arr));

		return investors;
	}

	@Override
	public List<Investor> getRangeFrom(long from) {
		Investor[] arr = template.getForObject(
				"http://localhost:8080/orderRest/investor/from/" + from,
				Investor[].class);
		investors.clear();
		investors.addAll(Arrays.asList(arr));

		return investors;
	}
	
	

	public static List<Investor> getInvestors() {
		return investors;
	}

	public static void setInvestors(ObservableList<Investor> ainvestors) {
		investors = ainvestors;
	}

	@Override
	public Investor getLastId() {
		investor = template.getForObject(
				"http://localhost:8080/orderRest/investor/last", Investor.class);
		return investor;
	}

	@Override
	public List<Investor> getByMainOrderId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Investor> getFind(String word) {
		Investor[] arr = template.getForObject(
				"http://localhost:8080/orderRest/search/investor/" + word,
				Investor[].class);
		investors.clear();
		investors.addAll(Arrays.asList(arr));

		return investors;
	}
	



	
}
