package application.ui;

import javafx.scene.control.ProgressBar;

/**
 * JavaFX custom progress bar.
 * @author Rin
 * @version 1.0.0
 */
public abstract class CustomProgressBar {
	
	/**
	 * @return JavaFX ProgressBar
	 * @since 1.0.0
	 */
	public abstract ProgressBar ui();
	
	/**
	 * Change the value of progress bar.
	 * @param value
	 * @since 1.0.0
	 */
	public abstract void updateValue(double value);
}
