package application.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import application.data.PlanetData;

class PlanetDataTest {

	@Test
	void test() {
		// Create an object to be tested.
		final PlanetData planetData = new PlanetData();
		
		// Make sure it throws Exception when value does not exist.
		assertThrows(IllegalArgumentException.class, () -> planetData.num("invalid"));
		
		// Local Map to test.
		final Map<String, Number> testMap = new HashMap<>();
		
		// Define an update event.
		planetData.addNumberEvent((key, value) -> {
			testMap.put(key, value);
		});
		
		// Insert a number data.
		planetData.updateNumber("size", 1);
		
		// Make sure event is handled correctly.
		assertEquals(1, testMap.get("size"));
		
		// Make sure data is updated.
		assertEquals(1, planetData.num("size"));
	}

}
