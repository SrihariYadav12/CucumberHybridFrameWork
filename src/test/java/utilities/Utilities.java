package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utilities {

	public static String generatEmail() {

		String generatestring = RandomStringUtils.randomAlphanumeric(8);
		String email = generatestring + "gmail.com";

		return email;

	}

}
