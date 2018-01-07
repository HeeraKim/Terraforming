package application.page.initial;

import application.event.PlainEvent;
import application.page.Page;

/**
 * Abstraction of initial page.
 * @author Rin
 * @version 1.0.0
 */
public abstract class Initial implements Page {
	public abstract void addNewEvent(PlainEvent event);
}
