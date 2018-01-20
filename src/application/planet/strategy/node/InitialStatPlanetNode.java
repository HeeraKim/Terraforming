package application.planet.strategy.node;

import application.planet.data.PlanetData;
import application.string.base.DecamelString;
import application.ui.CustomProgressBar;
import javafx.scene.Node;
import javafx.scene.control.Label;
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
	public InitialStatPlanetNode(String name, String unit, CustomProgressBar progressBar) {
		this.name = name;
		this.unit = unit;
		this.progressBar = progressBar;
	}

	@Override
	public Node node(PlanetData planetData) throws Exception {
		// Label
		final Label label = new Label();
		
		// GridPane as root
		final GridPane grid = new GridPane();
		grid.addRow(0, progressBar.ui(), label);
		grid.setHgap(10);
		
		// Sync progress bar and data
		planetData.addNumberEvent((key, value)->{
			if (key.equals(name)) {
				label.setText(new DecamelString(name).value()+": "+value.toString()+unit);
				progressBar.updateValue(value.doubleValue());
			}
		});
		
		// Initial display
		label.setText(new DecamelString(name).value()+": "+planetData.number(name).toString()+unit);
		progressBar.updateValue(planetData.number(name).doubleValue());
		
		// Return root GridPane
		return grid;
	}
	
	private final String name;
	private final String unit;
	private final CustomProgressBar progressBar;

}
