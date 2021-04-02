package common;

import java.util.concurrent.ThreadLocalRandom;


public class Randomizer {

	public String mail(String email) {
		
		ThreadLocalRandom.current().ints(100);
		
		
		if(email.equals("validEmail")) {
			email = ThreadLocalRandom.current().ints().toString();
		}
		
		return email;
		
	}
	
}
