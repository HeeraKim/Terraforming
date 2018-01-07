package application.data;

import java.util.ArrayList;
import java.util.List;

import application.event.StringNumEvent;

/**
 * Database for this game. <br />
 * Child class must use the event list from this class for Observer pattern because of serialization issue.
 * @author Rin
 * @version 1.0.0
 */
public abstract class BigData {
	
	/**
	 * Put a number value to the map.
	 * @param key
	 * @param value
	 * @since 1.0.0
	 */
	public abstract void updateNumber(String key, Number value);
	
	/**
	 * Add an event to be executed when the number map is updated.
	 * @param event
	 * @since 1.0.0
	 */
	public abstract void addNumberEvent(StringNumEvent event);
	
	/**
	 * @param key
	 * @return A number value from the map.
	 * @since 1.0.0
	 */
	public abstract Number num(String key);
	
	/**
	 * Clear data.
	 * @since 1.0.0
	 */
	public abstract void clear();
	
	protected final List<StringNumEvent> numberEvents = new ArrayList<>();
	
}
