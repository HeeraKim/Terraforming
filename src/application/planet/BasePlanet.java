package application.planet;

import application.planet.data.BasePlanetData;
import application.planet.data.PlanetData;
import application.planet.strategy.execution.PlanetExecution;
import application.planet.strategy.node.PlanetNode;
import javafx.scene.Node;

public final class BasePlanet extends Planet {

	@Override
	public Node node(PlanetNode planetNode) throws Exception {
		return planetNode.node(planetData);
	}
	
	@Override
	public void execute(PlanetExecution planetExecution) throws Exception {
		planetExecution.execute(planetData);
	}
	
	private final PlanetData planetData = new BasePlanetData();

}
