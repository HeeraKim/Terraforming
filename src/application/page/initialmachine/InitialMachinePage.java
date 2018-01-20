package application.page.initialmachine;

import application.event.PlainEvent;
import javafx.stage.Stage;

/**
 * From initial page to this page. <br />
 * Page to define initial machines.
 * @author Rin
 * @version 1.0.0
 */
public abstract class InitialMachinePage {
	/**
	 * Display this page.
	 * @param stage
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void display(Stage stage) throws Exception;
	
	/**
	 * Add an event to be handled when back button is clicked.
	 * @param event
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void addBackEvent(PlainEvent event) throws Exception;
}
