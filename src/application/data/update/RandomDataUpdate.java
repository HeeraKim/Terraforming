package application.data.update;

import application.data.BigData;

/**
 * Update BigData randomly.
 * @author Rin
 * @version 1.0.0
 */
public final class RandomDataUpdate extends DataUpdate {
	
	public RandomDataUpdate(BigData bigData) {
		this.bigData = bigData;
	}
	
	@Override
	public void apply() {
		// Testing for now...
		bigData.updateNumber("radius", 200);
		bigData.updateNumber("temperature", 0);
	}
	
	private final BigData bigData;
}
