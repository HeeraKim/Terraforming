package application.nio.archive;

/**
 * Used to save and load object from the file system.
 * @author Rin
 * @version 1.0.0
 */
public abstract class ObjectArchive {
	/**
	 * Save an object.
	 * @param path that the object will be saved.
	 * @param object to be saved.
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract void save(String path, Object object) throws Exception;
	
	/**
	 * Load an object.
	 * @param path of the object to be loaded.
	 * @param defaultObject will be returned if the object does not exist.
	 * @return loaded object. Or default object if it does not exist.
	 * @throws Exception
	 * @since 1.0.0
	 */
	public abstract Object load(String path, Object defaultObject) throws Exception;
}
