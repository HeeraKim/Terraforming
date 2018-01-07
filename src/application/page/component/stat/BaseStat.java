package application.page.component.stat;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.ProgressBar;

/**
 * Realization of Stat. <br />
 * The node is cached.
 * @author Rin
 * @version 1.0.0
 */
public class BaseStat extends Stat {
	/**
	 * @param min
	 * @param max
	 * @param value
	 * @since 1.0.0
	 */
	public BaseStat(double min, double max, double value) {
		this.min = min;
		this.max = max;
		this.value = value;
	}
	
	@Override
	public Node node() {
		// Build cache if does not exist
		if (cache.isEmpty()) {
			buildCache();
		}
		
		// Return cached bar
		return cache.get(0);
	}
	
	private void buildCache() {
		// Calculate progress
		final double range = max - min;
		final double adjustedValue = value - min;
		final double percentage = adjustedValue / range;
		
		// Progress bar
		final ProgressBar bar = new ProgressBar();
		bar.setProgress(percentage);
		
		// Define color
		bar.setStyle("-fx-accent: red;");
		if (percentage >= 0.4 && percentage <= 0.6) {
			bar.setStyle("-fx-accent: blue;");
		}
		
		// Cache the bar
		cache.add(bar);
	}
	
	private final double min;
	private final double max;
	private final double value;
	
	private final List<ProgressBar> cache = new ArrayList<>();

}
