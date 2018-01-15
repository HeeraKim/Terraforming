package application.event;

/**
 * A functional interface to handle an event with parameters String and Number.
 * @author Rin
 * @version 1.0.0
 */
public interface StringStringEvent {
	/**
	 * Execute something with those parameters.
	 * @param string1
	 * @param string2
	 * @since 1.0.0
	 */
	public void handle(String string1, String string2);
}
