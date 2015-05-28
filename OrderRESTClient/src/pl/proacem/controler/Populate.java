package pl.proacem.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import pl.proacem.model.Person;

public class Populate {

	private List<Person> peopleList = new ArrayList<Person>();
	private RestTemplate template = new RestTemplate();

	public Populate() {
		// template.getMessageConverters().add(new
		// MappingJackson2HttpMessageConverter());
	}

	public void populateList(){

		Person[] persons = template.getForObject(
				"http://localhost:8080/orderRest/person", Person[].class);
		peopleList = Arrays.asList(persons);
	}

	public static Person getPerson(String num) {
		Person person = null;
		RestTemplate template2 = new RestTemplate();
		person = template2.getForObject(
				"http://localhost:8080/orderRest/person/{num}", Person.class,
				num);
		return person;
	}

	public static List<Person> getAllPerson() {
		List<Person> personsList = new ArrayList<Person>();
		RestTemplate template2 = new RestTemplate();
		Person[] persons = template2.getForObject("http://localhost:8080/orderRest/person", Person[].class);

		personsList = Arrays.asList(persons);

		return personsList;
	}



	public static void savePerson(Person newPerson) {
		RestTemplate template2 = new RestTemplate();
		template2.postForObject("http://localhost:8080/orderRest/person",
				newPerson, Person.class);

	}
}
