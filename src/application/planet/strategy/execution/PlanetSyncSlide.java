package application.planet.strategy.execution;

import application.planet.data.PlanetData;
import javafx.scene.control.Slider;

/**
 * Synchronize JavaFX slider and Planet radius.
 * @author Rin
 * @version 1.0.0
 */
public final class PlanetSyncSlide extends PlanetExecution {

	public PlanetSyncSlide(Slider slider) {
		this.slider = slider;
	}
	
	@Override
	public void execute(PlanetData planetData) throws Exception {
		// Initial sync
		slider.setValue(planetData.number("radius").doubleValue());
		
		// Sync continuously
		slider.valueProperty().addListener(e->{
			try {
				planetData.updateNumber("radius", slider.getValue());
			} catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		});
	}
	
	private final Slider slider;
}
