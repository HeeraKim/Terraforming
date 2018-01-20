package application.ui;

import java.util.ArrayList;
import java.util.List;

import application.event.DoubleEvent;
import javafx.scene.control.ProgressBar;

/**
 * Realization of CustomProgressBar. <br />
 * ProgressBar that has custom min, max range. <br />
 * Also, there is a 'normal range.' <br />
 * If the value is in the normal range, then the color of progress bar would be blue. <br />
 * Otherwise, the color of progress bar would be red. <br />
 * ProgressBar is cached.
 * @author Rin
 * @version 1.0.0
 */
public final class RangedProgressBar extends CustomProgressBar {

	/**
	 * @param minBar Minimum value to display on the progress bar.
	 * @param maxBar Maximum value to display on the progress bar.
	 * @param minNormal Minimum value of normal range.
	 * @param maxNormal Maximum value of normal range.
	 * @since 1.0.0
	 */
	public RangedProgressBar(double minBar, double maxBar, double minNormal, double maxNormal) {
		this.minBar = minBar;
		this.maxBar = maxBar;
		this.minNormal = minNormal;
		this.maxNormal = maxNormal;
	}

	@Override
	public ProgressBar ui() {
		// Return cached progress bar if exists.
		if (cache.isEmpty() == false) {
			return cache.get(0);
		}

		// Build progress bar:
		
		final ProgressBar progressBar = new ProgressBar();

		valueEvents.add(value -> {
			// Calculate progress
			final double range = maxBar - minBar;
			final double adjustedValue = value - minBar;
			final double percentage = adjustedValue / range;

			// set progress
			progressBar.setProgress(percentage);

			// Define color
			progressBar.setStyle("-fx-accent: red;");
			if (value >= minNormal && value <= maxNormal) {
				progressBar.setStyle("-fx-accent: blue;");
			}
		});
		
		// Cache the progress bar
		cache.add(progressBar);

		// Return cached progress bar
		return cache.get(0);
	}

	@Override
	public void updateValue(double value) {
		valueEvents.forEach(event -> {
			event.handle(value);
		});
	}

	private final double minBar;
	private final double maxBar;
	private final double minNormal;
	private final double maxNormal;

	private final List<DoubleEvent> valueEvents = new ArrayList<>();
	private final List<ProgressBar> cache = new ArrayList<>();
}
