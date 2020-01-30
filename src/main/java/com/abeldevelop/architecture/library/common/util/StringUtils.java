package com.abeldevelop.architecture.library.common.util;

import java.text.Normalizer;

public class StringUtils {

	protected StringUtils() throws IllegalAccessException {
		throw new IllegalAccessException();
	}
	
	/**
	 * Normalize a String deleting the accents
	 * 
	 * @param string to rormalize
	 * @return the params string normalize
	 */
	public static String normalize(String string) {
		return Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("\\p{M}", "");
	}
	
	/**
	 * Generate string for use in url
	 * 
	 * @param string to generate url string
	 * @return the string for use in url
	 */
	public static String generateUrlName(String string) {
		return normalize(string.toLowerCase().replace(" ", "-"));
	}
	
	/**
	 * Check if string have then length (minSize and maxSize included)
	 * 
	 * @param str String to check size
	 * @param minSize min size of the string (included)
	 * @param maxSize max size of the string (included)
	 * @return <code>true</code> if the String size is between
	 */
	public static boolean isSizeBetween(String str, int minSize, int maxSize) {
		return (str.length() >= minSize && str.length() <= maxSize);
	}
	
	/**
     * <p>Checks if a String is empty ("") or null.</p>
     *
     * @param str  the String to check, may be null
     * @return <code>true</code> if the String is empty or null
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
