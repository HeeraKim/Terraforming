package application.planet.strategy.execution;

import application.nio.path.BaseRandomPath;
import application.nio.path.RandomPath;
import application.number.base.RandomDouble;
import application.planet.data.PlanetData;

/**
 * Put random data.
 * @author Rin
 * @version 1.0.0
 */
public final class PlanetRandomize extends PlanetExecution {

	@Override
	public void execute(PlanetData planetData) throws Exception {
		// PhongMaterials:
		final RandomPath randomPath = new BaseRandomPath("src/img/planet");
		planetData.updateString("diffuseMap", randomPath.path().toString());
		planetData.updateString("bumpMap", randomPath.path().toString());
		planetData.updateString("specularMap", randomPath.path().toString());
		planetData.updateString("selfIlluminationMap", randomPath.path().toString());
		
		// Radius
		planetData.updateNumber("radius", 200);
		
		// Temperature
		planetData.updateNumber("temperature", new RandomDouble(-100, 90, 1).value());
		
		// Pressure
		planetData.updateNumber("pressure", new RandomDouble(0, 10, 1).value());
		
		// Oxygen Concentration
		planetData.updateNumber("oxygenConcentration", new RandomDouble(0, 100, 1).value());
		
		// Gravity
		planetData.updateNumber("gravity", new RandomDouble(0.1, 5, 1).value());
	}

}
