package application.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import application.event.StringNumEvent;

/**
 * Data of a planet.
 * @author Rin
 * @version 1.0.0
 */
public final class PlanetData extends BigData implements Serializable {
	
	@Override
	public void updateNumber(String key, Number value) {
		// Put data into map
		numberData.put(key, value);
		
		// Handle event
		super.numberEvents.forEach(event ->{
			event.handle(key, value);
		});
	}

	@Override
	public void addNumberEvent(StringNumEvent event) {
		super.numberEvents.add(event);
	}

	@Override
	public Number num(String key) {
		// Make sure data exists.
		if (numberData.containsKey(key) == false) {
			throw new IllegalArgumentException("Data does not exists. Make sure the key is valid.");
		}
		
		// Return
		return numberData.get(key);
	}
	
	@Override
	public void clear() {
		numberData.clear();
	}
	
	private final Map<String, Number> numberData = new HashMap<>();
	
	private static final long serialVersionUID = 1L;

}
