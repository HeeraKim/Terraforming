package application.string.base;

import application.string.CustomString;

/**
 * Convert camel cased String to normal one. <br />
 * Ex) camelCase -> Camel Case.
 * @author Rin
 * @version 1.0.0
 */
public final class DecamelString implements CustomString {

	public DecamelString(String camelString) {
		this.camelString = camelString;
	}
	
	@Override
	public String value() {
		// Split the String by capital letter.
		final String[] split = camelString.split("(?=\\p{Upper})");
		
		// String builder
		final StringBuilder stringBuilder = new StringBuilder();
		
		// Build string
		for (String word : split) {
			stringBuilder.append(word.substring(0, 1).toUpperCase() + word.substring(1) + " ");
		}
		
		// Return string without last space that is created accidently from above process.
		return stringBuilder.toString().substring(0, stringBuilder.length()-1);
	}
	
	private final String camelString;
}
