package application.planet.strategy.node;

import application.planet.data.PlanetData;
import application.string.base.DecamelString;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

/**
 * Visual representation of status. <br />
 * It is intended to be used for InitialPlanetPage.
 * @author Rin
 * @version 1.0.0
 */
public final class InitialStatPlanetNode extends PlanetNode {
	
	/**
	 * @param status to show.
	 * @param min
	 * @param max
	 * @since 1.0.0
	 */
	public InitialStatPlanetNode(String status, String unit, double min, double max) {
		this.status = status;
		this.unit = unit;
		this.min = min;
		this.max = max;
	}

	@Override
	public Node node(PlanetData planetData) throws Exception {
		// Label to show what it is
		final Label lStatus = new Label();
		
		// Progress bar
		final ProgressBar progressBar = new ProgressBar();
		
		// GridPane as root
		final GridPane grid = new GridPane();
		grid.addRow(0, progressBar, lStatus);
		grid.setHgap(10);
		
		// Configure progress bar
		configureNodes(planetData.number(status).doubleValue(), progressBar, lStatus);
		
		// Sync progress bar and data
		planetData.addNumberEvent((key, value)->{
			if (key.equals(status)) {
				configureNodes(value.doubleValue(), progressBar, lStatus);
			}
		});
		
		return grid;
	}
	
	private void configureNodes(double rawData, ProgressBar progressBar, Label lStatus) {
		// Calculate progress
		final double range = max - min;
		final double adjustedValue = rawData - min;
		final double percentage = adjustedValue / range;
		
		// set progress
		progressBar.setProgress(percentage);
		
		// Define color
		progressBar.setStyle("-fx-accent: red;");
		if (percentage >= 0.4 && percentage <= 0.6) {
			progressBar.setStyle("-fx-accent: blue;");
		}
		
		// Update label
		lStatus.setText(new DecamelString(status).value()+": "+rawData+unit);
	}
	
	private final String status;
	private final String unit;
	private final double min;
	private final double max;

}
