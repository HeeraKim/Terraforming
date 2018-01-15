package application.planet.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import application.event.StringNumberEvent;
import application.event.StringStringEvent;

/**
 * Realization of PlanetData. <br />
 * null values are handled.
 * @author Rin
 * @version 1.0.0
 */
public final class BasePlanetData extends PlanetData implements Serializable {

	@Override
	public Number number(String key) {
		// Throw exception if key is invalid.
		if (numberMap.get(key) == null) {
			throw new RuntimeException(key+" is invalid key. Available keys: "+numberMap.keySet().toString());
		}
		
		// Return value
		return numberMap.get(key);
	}

	@Override
	public void updateNumber(String key, Number value) {
		// Put data
		numberMap.put(key, value);
		
		// Handle events
		super.numberEvents.forEach(event -> {
			event.handle(key, value);
		});
	}
	
	@Override
	public void addNumberEvent(StringNumberEvent event) throws Exception {
		super.numberEvents.add(event);
	}
	
	@Override
	public String string(String key) throws Exception {
		// Throw exception if key is invalid.
		if (stringMap.get(key) == null) {
			throw new RuntimeException(key+" is invalid key. Available keys: "+stringMap.keySet().toString());
		}

		// Return value
		return stringMap.get(key);
	}

	@Override
	public void updateString(String key, String value) throws Exception {
		// Put data
		stringMap.put(key, value);

		// Handle events
		super.stringEvents.forEach(event -> {
			event.handle(key, value);
		});
	}
	
	@Override
	public void addStringEvent(StringStringEvent event) throws Exception {
		super.stringEvents.add(event);
	}
	
	@Override
	public void clear() throws Exception {
		numberMap.clear();
	}
	
	private final Map<String, Number> numberMap = new HashMap<>();
	private final Map<String, String> stringMap = new HashMap<>();
	
	private static final long serialVersionUID = 1L;
}
