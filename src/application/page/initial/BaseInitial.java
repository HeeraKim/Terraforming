package application.page.initial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * Primitive initial page
 * @author Rin
 * @version 1.0.0
 */
public class BaseInitial extends Initial {
	
	@Override
	public Scene scene() {
		// Width for buttons
		final double buttonWidth = 100;
		
		// Button for new game
		final Button bNew = new Button("New");
		bNew.setPrefWidth(buttonWidth);
		
		// Button for continue
		final Button bContinue = new Button("Continue");
		bContinue.setPrefWidth(buttonWidth);
		
		// Button for setting
		final Button bSetting = new Button("Setting");
		bSetting.setPrefWidth(buttonWidth);
		
		// GridPane to store buttons
		final GridPane gridButtons = new GridPane();
		gridButtons.addColumn(0, bNew, bContinue, bSetting);
		gridButtons.setAlignment(Pos.CENTER);
		
		// Root container
		final StackPane pane = new StackPane();
		pane.getChildren().add(gridButtons);
		
		// Scene
		final Scene scene = new Scene(pane);
		
		return scene;
	}

}
