
/**
 * General Utils
 * Performs util actions for test
 *
 * @author ASIH
 *
 */


package util.general_util;

import java.io.*;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;

public class GeneralUtils {

	private static final Logger logger = Logger.getLogger(GeneralUtils.class);

	private GeneralUtils(){

	}

	public  static <T extends  Throwable> String stacktraceToString(T t){
		StringWriter errors = new StringWriter();
		t.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}

	public static <T extends Throwable> void reportError(String error , T t)  throws AssertionError{
		Assert.assertFalse(error + GeneralUtils.stacktraceToString(t), true);
	}

	public static String getRandomEmail() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr + "@gmail.com" ;

	}

	public static String removeNoNumeric(String str){
		return str.replaceAll("[^\\d.]", "");

	}
}
