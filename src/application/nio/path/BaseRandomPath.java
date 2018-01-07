package application.nio.path;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Realization of RandomPath. <br />
 * It is NOT cached.
 * @author Rin
 * @version 1.0.0
 */
public final class BaseRandomPath extends RandomPath {
	
	/**
	 * @param folder Path to the folder.
	 * @since 1.0.0
	 */
	public BaseRandomPath(String folder) {
		this.folder = folder;
	}
	
	@Override
	public Path path() throws Exception {
		// Store all paths in the list
		final Stream<Path> stream = Files.list(Paths.get(folder));
		final List<Path> list = new ArrayList<>();
		stream.forEach(path ->{
			list.add(path);
		});
		stream.close();
		
		// Random index
		final int randomIndex = new Random().nextInt(list.size());
		
		// Return
		return list.get(randomIndex);
	}
	
	private final String folder;
}
