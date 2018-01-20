package application.event;

/**
 * A functional interface to handle an event with a String type parameter.
 * @author Rin
 * @version 1.0.0
 */
public interface StringEvent {
	/**
	 * Execute something with the parameter.
	 * @param string
	 * @since 1.0.0
	 */
	public void handle(String string);
}
