package application.page.component.sphere;

/**
 * JavaFX custom sphere.
 * @author Rin
 * @version 1.0.0
 */
public abstract class Sphere {
	/**
	 * @return Predefined JavaFX sphere.
	 * @throws Exception 
	 * @since 1.0.0
	 */
	public abstract javafx.scene.shape.Sphere sphere() throws Exception;
	
	/**
	 * Change radius of sphere.
	 * @param size
	 * @throws Exception 
	 * @since 1.0.0
	 */
	public abstract void updateRadius(double radius) throws Exception;
}
