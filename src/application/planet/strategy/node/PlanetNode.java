package application.planet.strategy.node;

import application.planet.data.PlanetData;
import javafx.scene.Node;

/**
 * Strategy to provide JavaFX node for Planet.
 * @author Rin
 * @version 1.0.0
 */
public abstract class PlanetNode {
	/**
	 * @param planetData
	 * @return JavaFX node
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract Node node(PlanetData planetData) throws Exception;
}
