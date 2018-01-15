package application.planet.data;

import java.util.ArrayList;
import java.util.List;

import application.event.StringNumberEvent;
import application.event.StringStringEvent;

/**
 * Data for Planet.
 * @author Rin
 * @version 1.0.0
 */
public abstract class PlanetData {
	/**
	 * @param key of Map<String, Number>.
	 * @return value of Map<String, Number>.
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract Number number(String key) throws Exception;
	
	/**
	 * Put method of Map<String, Number>.
	 * @param key
	 * @param value
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void updateNumber(String key, Number value) throws Exception;
	
	/**
	 * Add an event to be executed when the number map is updated.
	 * @param event
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void addNumberEvent(StringNumberEvent event) throws Exception;
	
	/**
	 * @param key of Map<String, String>.
	 * @return value of Map<String, String>.
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract String string(String key) throws Exception;
	
	/**
	 * Put method of Map<String, String>.
	 * @param key
	 * @param value
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void updateString(String key, String value) throws Exception;
	
	/**
	 * Add an event to be executed when the string map is updated.
	 * @param event
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void addStringEvent(StringStringEvent event) throws Exception;
	
	/**
	 * Clear data.
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void clear() throws Exception;
	
	protected final List<StringNumberEvent> numberEvents = new ArrayList<>();
	protected final List<StringStringEvent> stringEvents = new ArrayList<>();
}
