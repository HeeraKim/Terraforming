package application.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import application.string.base.DecamelString;

class DecamelStringTest {

	@Test
	void test() {
		assertEquals("Camel Case", new DecamelString("camelCase").value());
		assertEquals("Camelcase", new DecamelString("camelcase").value());
		assertEquals("A B C", new DecamelString("aBC").value());
	}

}
