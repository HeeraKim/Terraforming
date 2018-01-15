package application.event;

/**
 * A functional interface to handle an event with parameters String and Number.
 * @author Rin
 * @version 1.0.0
 */
public interface StringNumberEvent {
	/**
	 * Execute something with those parameters.
	 * @param string
	 * @param number
	 * @since 1.0.0
	 */
	public void handle(String string, Number number);
}
