package application.planet;

import application.planet.strategy.execution.PlanetExecution;
import application.planet.strategy.node.PlanetNode;
import javafx.scene.Node;

/**
 * Planet.
 * @author Rin
 * @version 1.0.0
 */
public abstract class Planet {
	/**
	 * @param planetNode
	 * @return JavaFX node to visually represent itself.
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract Node node(PlanetNode planetNode) throws Exception;
	
	/**
	 * Execute the strategy.
	 * @param planetExecution
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void execute(PlanetExecution planetExecution) throws Exception;
}
