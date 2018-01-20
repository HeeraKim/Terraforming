package application.page.initialmachine;

import java.util.ArrayList;
import java.util.List;

import application.event.PlainEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Realization of InitialMachinePage. <br />
 * Scene is cached.
 * @author Rin
 * @version 1.0.0
 */
public final class BaseInitialMachinePage extends InitialMachinePage {

	@Override
	public void display(Stage stage) throws Exception {
		stage.setScene(this.scene());
	}
	
	@Override
	public void addBackEvent(PlainEvent event) throws Exception {
		backEvents.add(event);
	}
	
	private Scene scene() {
		// Return cached scene if it exists
		if (cache.isEmpty() == false) {
			return cache.get(0);
		}
		
		// Build cache:
		
		// ObservableList
		final ObservableList<Node> obsMachine = FXCollections.observableArrayList();
		
		// ListView
		final ListView<Node> lvMachine = new ListView<>();
		lvMachine.setItems(obsMachine);
		lvMachine.setPrefHeight(Integer.MAX_VALUE);
		
		// Button to go back
		final Button bBack = new Button("Back");
		bBack.setMinWidth(100);
		bBack.setOnAction(e->{
			backEvents.forEach(event -> {
				event.handle();
			});
		});
		
		// Button to go next
		final Button bNext = new Button("Next");
		bNext.setMinWidth(100);
		
		// StackPane to store next button
		final StackPane paneNext = new StackPane();
		paneNext.getChildren().add(bNext);
		paneNext.setPrefWidth(Integer.MAX_VALUE);
		paneNext.setAlignment(Pos.CENTER_RIGHT);
		
		// GridPane to store buttons
		final GridPane gridButtons = new GridPane();
		gridButtons.addRow(0, bBack, paneNext);
		
		// GridPane for right side
		final GridPane gridRight = new GridPane();
		gridRight.addColumn(0, lvMachine, gridButtons);
		
		// StackPane for picture of machine
		final StackPane paneImage = new StackPane();
		paneImage.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		paneImage.setStyle("-fx-border-color: silver");
		
		// Label for explanation
		final Label lDetail = new Label();
		lDetail.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		lDetail.setAlignment(Pos.CENTER);
		lDetail.setWrapText(true);
		lDetail.setStyle("-fx-border-color: silver");
		
		// GridPane for left side
		final GridPane gridLeft = new GridPane();
		gridLeft.setVgap(10);
		gridLeft.addColumn(0, paneImage, lDetail);
		
		// ColumnConstraints
		ColumnConstraints col = new ColumnConstraints();
		col.setPercentWidth(50);
		
		// Root GridPane
		final GridPane grid = new GridPane();
		grid.getColumnConstraints().add(col);
		grid.setHgap(10);
		grid.addRow(0, gridLeft, gridRight);
		
		// Root Pane
		final StackPane pane = new StackPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().add(grid);
		
		// Scene
		final Scene scene = new Scene(pane);
		
		// Cache the scene
		cache.add(scene);
		
		// Return scene
		return cache.get(0);
	}
	
	private final List<Scene> cache = new ArrayList<>();
	private final List<PlainEvent> backEvents = new ArrayList<>();
}
