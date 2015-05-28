package pl.proacem.controler;

import org.springframework.web.client.RestTemplate;

import pl.proacem.model.Person;

public class LoginUser {
	public static Person person;

	public static Person getPerson() {
		return person;
	}

	public static void setPerson(Person person) {
		LoginUser.person = person;
	}
	
	public static Integer logout(){
		RestTemplate tamplate = new RestTemplate();
		Integer code = tamplate.getForObject("http://localhost:8080/orderRest/person/logout", Integer.class);
		if(code == 0){
			person = null;
			return 0;
		}
		return 1;
	}
}
