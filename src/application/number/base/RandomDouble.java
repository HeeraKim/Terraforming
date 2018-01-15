package application.number.base;

import java.math.BigDecimal;
import java.util.Random;

import application.number.CustomValue;

/**
 * Randomly generated double.
 * @author Rin
 * @version 1.0.0
 */
public final class RandomDouble implements CustomValue {
	
	/**
	 * @param min range. Inclusive.
	 * @param max range. Exclusive.
	 * @param decimalPlace to show. Ex) decimalPlace = 2 -> 1.12;
	 * @since 1.0.0
	 */
	public RandomDouble(double min, double max, int decimalPlace) {
		this.min = min;
		this.max = max;
		this.decimalPlace = decimalPlace;
	}
	
	@Override
	public double value() throws Exception {
		// Make sure the decimal place is valid.
		if (decimalPlace < 0) {
			throw new RuntimeException("decimalPlace must be a positive integer or zero.");
		}
		
		// Make sure the range is valid.
		if (Double.valueOf(max-min).isInfinite()) {
			throw new RuntimeException("Double.MAX_VALUE should be avoided.");
		}
		
		// Generate random value
		final Random random = new Random();
		final double randomValue = min + (max - min) * random.nextDouble();
		
		// Round decimal
		final BigDecimal roundedValue = new BigDecimal(String.valueOf(randomValue)).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		
		// Return value
		return roundedValue.doubleValue();
	}
	
	private final double min;
	private final double max;
	private final int decimalPlace;
}
