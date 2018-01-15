package application.planet.strategy.execution;

import application.planet.data.PlanetData;

/**
 * Strategy to execute something.
 * @author Rin
 * @version 1.0.0
 */
public abstract class PlanetExecution {
	/**
	 * Execute something.
	 * @param planetData
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void execute(PlanetData planetData) throws Exception;
}
