/**
 * Not In Page Exception
 * Validates flow correctnes
 * 
 * @extend exception         
 * @author asih
 */

package common.selenium_services.page;


public class NotInPageException extends Exception {

	public NotInPageException(String message) {
		super(message);
	}
}