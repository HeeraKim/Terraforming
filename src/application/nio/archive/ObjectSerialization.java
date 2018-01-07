package application.nio.archive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ObjectArchive with serialization.
 * @author Rin
 * @version 1.0.0
 */
public final class ObjectSerialization extends ObjectArchive {

	@Override
	public void save(String path, Object object) throws Exception {
		// Stream
		final FileOutputStream fos = new FileOutputStream(path);
		final ObjectOutputStream oos = new ObjectOutputStream(fos);

		// Save an object
		oos.writeObject(object);
		oos.flush();

		// Close stream
		oos.close();
	}

	@Override
	public Object load(String path, Object defaultObject) throws Exception {
		// Object to be returned
		final Object[] object = new Object[1];
		
		// Stream
		try {
			final FileInputStream fis = new FileInputStream(path);
			final ObjectInputStream ois = new ObjectInputStream(fis);

			// Load an object
			object[0] = ois.readObject();

			// Close stream
			ois.close();
		} catch (FileNotFoundException fileNotFoundException){
			// Assign default object when the file is not found.
			object[0] = defaultObject;
		}
		
		// Return object
		return object[0];
	}

}
