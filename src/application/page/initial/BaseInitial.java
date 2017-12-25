package application.page.initial;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		final double buttonWidth = 200;
		
		// Height for buttons
		final double buttonHeight = 75;
		
		// Vertical gap between buttons
		final double vGapButtons = 30;
		
		// Button text size
		final double buttonTextSize = 32;
		
		// Label text size
		final double titleTextSize = 100;
		
		// Label to display main title
		final Label lTitle = new Label("Terraforming");
		lTitle.setStyle("-fx-font-size: "+titleTextSize);
		
		// Button for new game
		final Button bNew = new Button("New");
		bNew.setPrefWidth(buttonWidth);
		bNew.setPrefHeight(buttonHeight);
		bNew.setStyle("-fx-font-size: "+buttonTextSize);
		
		// Button for continue
		final Button bContinue = new Button("Continue");
		bContinue.setPrefWidth(buttonWidth);
		bContinue.setPrefHeight(buttonHeight);
		bContinue.setStyle("-fx-font-size: "+buttonTextSize);
		
		// Button for setting
		final Button bSetting = new Button("Setting");
		bSetting.setPrefWidth(buttonWidth);
		bSetting.setPrefHeight(buttonHeight);
		bSetting.setStyle("-fx-font-size: "+buttonTextSize);
		
		// GridPane to store buttons
		final GridPane gridButtons = new GridPane();
		gridButtons.addColumn(0, bNew, bContinue, bSetting);
		gridButtons.setAlignment(Pos.BOTTOM_CENTER);
		gridButtons.setVgap(vGapButtons);
		gridButtons.setPadding(new Insets(0, 0, 30, 0));
		
		// Root container
		final StackPane pane = new StackPane();
		pane.getChildren().add(gridButtons);
		pane.getChildren().add(lTitle);
		StackPane.setAlignment(lTitle, Pos.TOP_CENTER);
		
		// Scene
		final Scene scene = new Scene(pane);
		
		return scene;
	}

}
