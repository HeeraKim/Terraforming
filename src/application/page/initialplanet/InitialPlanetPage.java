package application.page.initialplanet;

import application.event.PlainEvent;
import javafx.stage.Stage;

/**
 * From title to this page. <br />
 * When user click new button, go to this page. <br />
 * This page shows initial planet.
 * @author Rin
 * @version 1.0.0
 */
public abstract class InitialPlanetPage {
	/**
	 * Display this page.
	 * @param stage
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void display(Stage stage) throws Exception;
	
	/**
	 * Add an event to be executed when next button is clicked.
	 * @param event
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void addNextEvent(PlainEvent event) throws Exception;
}
