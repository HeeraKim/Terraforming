package application.page.initialplanet;

import java.util.ArrayList;
import java.util.List;

import application.planet.Planet;
import application.planet.strategy.execution.PlanetRandomize;
import application.planet.strategy.execution.PlanetReset;
import application.planet.strategy.execution.PlanetSyncSlide;
import application.planet.strategy.node.BasePlanetNode;
import application.planet.strategy.node.InitialStatPlanetNode;
import application.ui.RangedProgressBar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Realization of InitialPlanetPage.  <br />
 * The scene is cached.
 * @author Rin
 * @version 1.0.0
 */
public final class BaseInitialPlanetPage extends InitialPlanetPage {
	
	public BaseInitialPlanetPage(Planet planet) {
		this.planet = planet;
	}

	@Override
	public void display(Stage stage) throws Exception {
		stage.setScene(this.scene());
	}

	private Scene scene() throws Exception {
		// Return cached scene
		if (cache.isEmpty() == false) {
			return cache.get(0);
		}
		
		// Reset planet
		planet.execute(new PlanetReset());

		// Randomize planet
		planet.execute(new PlanetRandomize());
		
		// Build scene and cache it:
		
		// StackPane for sphere
		final StackPane panePlanet = new StackPane();
		panePlanet.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		panePlanet.getChildren().add(planet.node(new BasePlanetNode()));

		// TextField to name the planet
		final TextField tfPlanetName = new TextField();
		tfPlanetName.setPromptText("Enter a planet name.");

		// Slider to configure size of the planet
		final Slider slider = new Slider();
		slider.setMin(30);
		slider.setMax(200);

		// Observable list for status
		final ObservableList<Node> obsStats = FXCollections.observableArrayList();
		obsStats.add(planet.node(new InitialStatPlanetNode("temperature", "c", 
				new RangedProgressBar(-100, 90, 0, 30)
				)));
		obsStats.add(planet.node(new InitialStatPlanetNode("pressure", "atm", 
				new RangedProgressBar(0, 10, 0.8, 1.2)
				)));
		obsStats.add(planet.node(new InitialStatPlanetNode("oxygenConcentration", "%", 
				new RangedProgressBar(0, 100, 20, 25)
				)));
		obsStats.add(planet.node(new InitialStatPlanetNode("gravity", "G", 
				new RangedProgressBar(0.1, 5, 0.9, 1.1)
				)));

		// ListView for status
		final ListView<Node> lvStats = new ListView<>();
		lvStats.setItems(obsStats);
		lvStats.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		// Button for random
		final Button bRandom = new Button("Random");
		bRandom.setMinWidth(100);

		// Button for next
		final Button bNext = new Button("Next");
		bNext.setMinWidth(100);

		// StackPane for next
		final StackPane paneNext = new StackPane();
		paneNext.getChildren().add(bNext);
		paneNext.setPrefWidth(Integer.MAX_VALUE);
		paneNext.setAlignment(Pos.CENTER_RIGHT);

		// GridPane for buttons at the bottom right
		final GridPane gridButtons = new GridPane();
		gridButtons.addRow(0, bRandom, paneNext);

		// GridPane for right side of the screen
		final GridPane gridRight = new GridPane();
		gridRight.addColumn(0, tfPlanetName, slider, lvStats, gridButtons);
		gridRight.setAlignment(Pos.CENTER);
		gridRight.setPadding(new Insets(10, 10, 10, 10));

		// Column constraint for sphere
		final ColumnConstraints colPlanet = new ColumnConstraints();
		colPlanet.setPercentWidth(50);

		// GrdiPane for left and right screen
		final GridPane grid = new GridPane();
		grid.addRow(0, panePlanet, gridRight);
		grid.getColumnConstraints().add(colPlanet);

		// Root container
		final StackPane pane = new StackPane();
		pane.getChildren().add(grid);

		// Scene
		final Scene scene = new Scene(pane);
		
		// Cache the scene
		this.cache.add(scene);
		
		// Synchronize slider and planet radius
		planet.execute(new PlanetSyncSlide(slider));
		
		// Handle event when random button is clicked.
		bRandom.setOnAction(e->{
			try {
				handleRandomEvent(planet, slider, panePlanet);
			} catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		});
		
		return this.cache.get(0);
	}
	
	private void handleRandomEvent(Planet planet, Slider slider, Pane panePlanet) throws Exception {
		// Reset planet
		planet.execute(new PlanetReset());
		
		// Randomize planet
		planet.execute(new PlanetRandomize());
		
		// Synchronize slider and planet radius
		planet.execute(new PlanetSyncSlide(slider));
	}

	private final Planet planet;
	
	private final List<Scene> cache = new ArrayList<>();
}
