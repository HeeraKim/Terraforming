package application.page.start;

import java.util.ArrayList;
import java.util.List;

import application.data.PlanetData;
import application.data.update.RandomDataUpdate;
import application.page.component.sphere.PlanetSphere;
import application.page.component.stat.BaseStat;
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
import javafx.scene.layout.StackPane;

/**
 * Realization of Start Page. <br />
 * The scene is cached.
 * @author Rin
 * @version 1.0.0
 */
public final class BaseStart extends Start {

	public BaseStart(PlanetData planetData) {
		this.planetData = planetData;
	}
	
	@Override
	public Scene scene() throws Exception {
		// Build cache if does not exist
		if (cache.isEmpty()) {
			buildCache();
		}
		
		// Return cached scene
		return cache.get(0);
	}

	private void buildCache() throws Exception {
		// Clear data
		planetData.clear();
		
		// Update data randomly.
		new RandomDataUpdate(planetData).apply();
		
		// Custom sphere
		planet[0] = new PlanetSphere();
		planet[0].updateRadius(planetData.num("radius").doubleValue());

		// StackPane for sphere
		final StackPane panePlanet = new StackPane();
		panePlanet.getChildren().add(planet[0].sphere());
		panePlanet.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		// TextField to name the planet
		final TextField tfPlanetName = new TextField();
		tfPlanetName.setPromptText("Enter a planet name.");

		// Slider to configure size of the planet
		final Slider slider = new Slider();
		slider.setMin(30);
		slider.setMax(200);
		slider.setValue(planetData.num("radius").doubleValue());
		slider.valueProperty().addListener(e->{
			try {
				planetData.updateNumber("radius", slider.getValue());
				planet[0].updateRadius(slider.getValue());
			} catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		});
		
		// Observable list for status
		final ObservableList<Node> obsStats = FXCollections.observableArrayList();
		// Populate random generated datas:
		// temperature
		obsStats.add(new BaseStat(-100, 90, planetData.num("temperature").doubleValue()).node());
		// Test
		obsStats.add(new BaseStat(-100, 90, -30).node());
		obsStats.add(new BaseStat(-100, 90, 80).node());

		// ListView for status
		final ListView<Node> lvStats = new ListView<>();
		lvStats.setItems(obsStats);
		lvStats.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		// Button for random
		final Button bRandom = new Button("Random");
		bRandom.setMinWidth(100);
		bRandom.setOnAction(e->{
			try {
				// Remove previous sphere
				panePlanet.getChildren().remove(planet[0].sphere());
				
				// Clear data
				planetData.clear();
				
				// Update data randomly.
				new RandomDataUpdate(planetData).apply();
				
				// Custom sphere
				planet[0] = new PlanetSphere();
				planet[0].updateRadius(planetData.num("radius").doubleValue());
				
				// Add new sphere to the pane
				panePlanet.getChildren().add(planet[0].sphere());
				
				// Update slider value
				slider.setValue(planetData.num("radius").doubleValue());
			} catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		});

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
		cache.add(scene);
	}
	
	private final PlanetData planetData;

	private final List<Scene> cache = new ArrayList<>(1);
	private final PlanetSphere[] planet = new PlanetSphere[1];

}
