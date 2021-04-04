package common;

import java.util.concurrent.ThreadLocalRandom;


public class Randomizer {

	

	private int randomNumbers = ThreadLocalRandom.current().nextInt();
	private String itsOverOneHundred = "abcde".repeat(30);

	public String mail(String email) {

		if (email.equals("validEmail")) {
			email = ("Test" + String.valueOf(randomNumbers) + "@hotmail.com");

		} else if (email.equals("noEmail")) {
			email = "";
		}

		return email;

	}

	public String user(String username) {

		if (username.equals("validUserName")) {
			username = ("Ouch" + String.valueOf(randomNumbers) + "@hotmail.com");
		} else if (username.equals("tooManyCharacters")) {
			username = (itsOverOneHundred);
		}

		return username;

	}

}
