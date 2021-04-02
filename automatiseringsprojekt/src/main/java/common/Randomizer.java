package common;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Randomizer {

	Random num = new Random();

	private int randomNumbers = ThreadLocalRandom.current().nextInt();
	String onehundred = "abcde".repeat(30);

	public String mail(String email) {

		if (email.equals("validEmail")) {
			email = ("Greg" + String.valueOf(randomNumbers) + "@hotmail.com");

		} else if (email.equals("noEmail")) {
			email = "";
		}

		return email;

	}

	public String user(String username) {

		if (username.equals("validUserName")) {
			username = ("MrT" + String.valueOf(randomNumbers) + "@hotmail.com");
		} else if (username.equals("tooManyCharacters")) {
			username = (onehundred);
		}

		return username;

	}

}
