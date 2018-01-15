package application.planet.strategy.execution;

import application.planet.data.PlanetData;

/**
 * Reset planet data.
 * @author Rin
 * @version 1.0.0
 */
public final class PlanetReset extends PlanetExecution {

	@Override
	public void execute(PlanetData planetData) throws Exception {
		planetData.clear();
	}
	
}
