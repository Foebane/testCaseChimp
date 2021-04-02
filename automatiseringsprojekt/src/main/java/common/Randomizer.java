package common;

import java.util.concurrent.ThreadLocalRandom;


public class Randomizer {

	public String mail(String email) {
		
		int randomNumbers = ThreadLocalRandom.current().nextInt();
		
		
		if(email.equals("validEmail")) {
			email = ("Smirk"+String.valueOf(randomNumbers)+"@hotmail.com");
		
		}else if(email.equals("noEmail")) {
			email = "";
		}
		
		return email;
		
	}
	
}
