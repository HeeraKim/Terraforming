package application.page.title;

import application.event.PlainEvent;
import javafx.stage.Stage;

/**
 * Very first screen of the game.
 * @author Rin
 * @version 1.0.0
 */
public abstract class TitlePage {
	/**
	 * Display page on the stage.
	 * @param stage
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void display(Stage stage) throws Exception;
	
	/**
	 * Execute something when new button is clicked.
	 * @param event
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void addNewEvent(PlainEvent event) throws Exception;
}
