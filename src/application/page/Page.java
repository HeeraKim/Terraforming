package application.page;

import javafx.scene.Scene;

/**
 * Object represents predefined JavaFX scene.
 * @author Rin
 * @version 1.0.0
 */
public interface Page {
	/**
	 * @return JavaFX scene
	 * @throws Exception 
	 * @since 1.0.0
	 */
	public Scene scene() throws Exception;
}
