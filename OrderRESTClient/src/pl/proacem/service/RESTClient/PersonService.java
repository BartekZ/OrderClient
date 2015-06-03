package pl.proacem.service.RESTClient;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import pl.proacem.model.Person;

public class PersonService implements ServiceInterface<Person> {

	private RestTemplate template = new RestTemplate();
	private Person person;
	//private static List<Person> persons = new ArrayList<Person>();
	
	@Override
	public Person getById(long id) {
		person = template.getForObject(
				"http://localhost:8080/orderRest/person/" + id, Person.class);

		return person;
	}

	@Override
	public Person add(Person item) {
		person = template.postForObject(
				"http://localhost:8080/orderRest/person", item, Person.class);
		

		return person;
	}
	

	@Override
	public void update(Person item) {
		template.put("http://localhost:8080/orderRest/person", item);

	}

	@Override
	public void remove(Person item) {
		template.delete("http://localhost:8080/orderRest/person/" + item.getId());

	}

	@Override
	public void removeById(long id) {
		template.delete("http://localhost:8080/orderRest/person/" + id);

	}

	@Override
	public List<Person> getList() {
		Person[] arr = template.getForObject(
				"http://localhost:8080/orderRest/person", Person[].class);
		
		return Arrays.asList(arr);
	}

	@Override
	public Integer getSize() {
		int size = template.getForObject(
				"http://localhost:8080/orderRest/person/size", Integer.class);
		return size;
	}

	@Override
	public List<Person> getRange(long from, long to) {
		Person[] arr = template.getForObject(
				"http://localhost:8080/orderRest/person/from/" + from + "/to/"
						+ to, Person[].class);
		return Arrays.asList(arr);
	}

	@Override
	public List<Person> getRangeTo(long to) {
		Person[] arr = template.getForObject(
				"http://localhost:8080/orderRest/person/to/" + to,
				Person[].class);
		
		return Arrays.asList(arr);
	}

	@Override
	public List<Person> getRangeFrom(long from) {
		Person[] arr = template.getForObject(
				"http://localhost:8080/orderRest/person/from/" + from,
				Person[].class);

		return Arrays.asList(arr);
	}
	

	@Override
	public Person getLastId() {
		person = template.getForObject(
				"http://localhost:8080/orderRest/person/last", Person.class);
		return person;
	}


	public Person getLogin(Person person){
		person.setCreated(new Date());
		person.setUpdated(new Date());
		
		Person person_ok = template.postForObject(
				"http://localhost:8080/orderRest/person/login", person, Person.class);
		return person_ok;
	}

	@Override
	public List<Person> getByMainOrderId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	



	
}
