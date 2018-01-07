package application.event;

/**
 * An event with String and Number as parameters.
 * @author Rin
 * @version 1.0.0
 */
public interface StringNumEvent {
	/**
	 * Execute something with those parameters.
	 * @param str String
	 * @param num Number
	 * @since 1.0.0
	 */
	public void handle(String str, Number num);
}
