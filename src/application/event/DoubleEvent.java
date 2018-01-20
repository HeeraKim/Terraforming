package application.event;

/**
 * A functional interface to handle an event with a Double type parameter.
 * @author Rin
 * @version 1.0.0
 */
public interface DoubleEvent {
	/**
	 * Execute something with the parameter.
	 * @param d Double
	 * @since 1.0.0
	 */
	public void handle(Double d);
}
