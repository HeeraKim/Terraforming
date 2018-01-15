package application.number;

/**
 * Intended to use decorator pattern.
 * @author Rin
 * @version 1.0.0
 */
public interface CustomValue {
	/**
	 * @return custom generated double value.
	 * @throws Exception
	 * @since 1.0.0
	 */
	public double value() throws Exception;
}
