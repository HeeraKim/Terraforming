package application.nio.path;

import java.nio.file.Path;

/**
 * Randomly selected Path object.
 * @author Rin
 * @version 1.0.0
 */
public abstract class RandomPath {
	/**
	 * @return Randomly selected Path.
	 * @throws Exception 
	 * @since 1.0.0
	 */
	public abstract Path path() throws Exception;
}
