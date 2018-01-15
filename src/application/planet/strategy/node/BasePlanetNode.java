package application.planet.strategy.node;

import application.planet.data.PlanetData;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * Realization of PlanetNode.
 * @author Rin
 * @version 1.0.0
 */
public final class BasePlanetNode extends PlanetNode {

	@Override
	public Node node(PlanetData planetData) throws Exception {
		// PhongMaterial
		final PhongMaterial material = new PhongMaterial();
		material.setDiffuseMap(new Image("File:" + planetData.string("diffuseMap")));
		material.setBumpMap(new Image("File:" + planetData.string("bumpMap")));
		material.setSpecularMap(new Image("File:" + planetData.string("specularMap")));
		material.setSelfIlluminationMap(new Image("File:" + planetData.string("selfIlluminationMap")));

		// JavaFX Sphere
		final Sphere sphere = new Sphere(planetData.number("radius").doubleValue());
		sphere.setMaterial(material);

		// Rotate
		final RotateTransition rotate = new RotateTransition(Duration.seconds(30), sphere);
		rotate.setCycleCount(RotateTransition.INDEFINITE);
		rotate.setAxis(Rotate.Y_AXIS);
		rotate.setFromAngle(360);
		rotate.setToAngle(0);
		rotate.setInterpolator(Interpolator.LINEAR);
		rotate.play();

		// Sync DiffuseMap
		planetData.addStringEvent((key, value) -> {
			if (key.equals("diffuseMap")) {
				material.setDiffuseMap(new Image("File:" + value));
			}
		});

		// Sync BumpMap
		planetData.addStringEvent((key, value) -> {
			if (key.equals("bumpMap")) {
				material.setBumpMap(new Image("File:" + value));
			}
		});

		// Sync SpecularMap
		planetData.addStringEvent((key, value) -> {
			if (key.equals("specularMap")) {
				material.setSpecularMap(new Image("File:" + value));
			}
		});

		// Sync SelfIlluminationMap
		planetData.addStringEvent((key, value) -> {
			if (key.equals("selfIlluminationMap")) {
				material.setSelfIlluminationMap(new Image("File:" + value));
			}
		});
		
		// Sync radius
		planetData.addNumberEvent((key, value) -> {
			if (key.equals("radius")) {
				sphere.setRadius(value.doubleValue());
			}
		});

		// Return sphere
		return sphere;
	}

}
