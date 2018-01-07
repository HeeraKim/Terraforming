package application.page.component.sphere;

import java.util.ArrayList;
import java.util.List;

import application.nio.path.BaseRandomPath;
import application.nio.path.RandomPath;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * Planet. <br />
 * The sphere is cached. <br />
 * Default radius is 200.
 * @author Rin
 * @version 1.0.0
 */
public final class PlanetSphere extends Sphere {

	@Override
	public javafx.scene.shape.Sphere sphere() throws Exception {
		// Build cache if does not exist
		if (cache.isEmpty()) {
			buildCache();
		}
		
		// Return cached sphere
		return cache.get(0);
	}

	private void buildCache() throws Exception {
		// Random path
		final RandomPath randomPath = new BaseRandomPath("src/img/planet");

		// PhongMaterial
		final PhongMaterial material = new PhongMaterial();
		material.setDiffuseMap(new Image("File:"+randomPath.path().toString()));
		material.setBumpMap(new Image("File:"+randomPath.path().toString()));
		material.setSpecularMap(new Image("File:"+randomPath.path().toString()));
		material.setSelfIlluminationMap(new Image("File:"+randomPath.path().toString()));

		// JavaFX Sphere
		final javafx.scene.shape.Sphere sphere = new javafx.scene.shape.Sphere(200);
		sphere.setMaterial(material);

		// Rotate
		final RotateTransition rotate = new RotateTransition(
				Duration.seconds(30),
				sphere
				);
		rotate.setCycleCount(RotateTransition.INDEFINITE);
		rotate.setAxis(Rotate.Y_AXIS);
		rotate.setFromAngle(360);
		rotate.setToAngle(0);
		rotate.setInterpolator(Interpolator.LINEAR);
		rotate.play();
		
		// Cache the sphere
		cache.add(sphere);
	}
	
	@Override
	public void updateRadius(double radius) throws Exception {
		if (cache.isEmpty()) {
			buildCache();
		}
		
		cache.get(0).setRadius(radius);
	}

	private final List<javafx.scene.shape.Sphere> cache = new ArrayList<>();

}
