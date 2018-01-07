package application.event;

/**
 * Functional interface to handle an event without any parameter.
 * @author Rin
 * @version 1.0.0
 */
public interface PlainEvent {
	/**
	 * Execute something when the event occurs.
	 * @since 1.0.0
	 */
	public void handle();
}
