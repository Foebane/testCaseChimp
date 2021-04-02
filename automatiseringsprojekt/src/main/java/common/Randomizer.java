package common;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

	private int randomNumbers = ThreadLocalRandom.current().nextInt();
	
	public String mail(String email) {

		

		if (email.equals("validEmail")) {
			email = ("Smirk" + String.valueOf(randomNumbers) + "@hotmail.com");

		} else if (email.equals("noEmail")) {
			email = "";
		}

		return email;

	}
     public String user(String username) {
		
    	 if(username.equals("validUserName")) {
    		 username = ("John" + String.valueOf(randomNumbers)+ "@Doe.com");
    	 }
    	 
    	 
    	 return username;
    	 
     }
}
