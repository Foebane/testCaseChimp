package common;

import java.util.concurrent.ThreadLocalRandom;


public class Randomizer {

	
    //random nummers fr�n Threadlocal
	private int randomNumbers = ThreadLocalRandom.current().nextInt();
	//repetera abcde 30ggr
	private String itsOverOneHundred = "abcde".repeat(30);

	public String mail(String email) {
        //om v�r mail �r valid s� blir den random, annars tom
		if (email.equals("validEmail")) {
			email = ("Test" + String.valueOf(randomNumbers) + "@hotmail.com");

		} else if (email.equals("noEmail")) {
			email = "";
		}

		return email;

	}

	public String user(String username) {
        //Om username �r valid s� f�r vi ett random namn, annars �ver 100 bokst�ver
		if (username.equals("validUserName")) {
			username = ("Ouch" + String.valueOf(randomNumbers) + "@hotmail.com");
		} else if (username.equals("tooManyCharacters")) {
			username = (itsOverOneHundred);
		}

		return username;

	}

}
