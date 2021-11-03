package com.epam.preprod.sirenko.wrappers;

/**
 * String key wrapper, as HashCode uses sum of first four elements of string
 *
 * @author E.Sirenko
 **/
public class StringWrapperFourElementsSumAsHashCode {
	private String key;
	
	public StringWrapperFourElementsSumAsHashCode(String key) {
		this.key = key;
	}
	
	@Override
	public int hashCode() {
		int result = 0;
		char[] keyArray = key.toCharArray();
		for (int i = 0; i < keyArray.length; i++) {
			if (i < 4) {
				result += keyArray[i];
			}
		}
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof StringWrapperFourElementsSumAsHashCode)) {
			return false;
		}
		StringWrapperFourElementsSumAsHashCode stringWrapperFourElementsSumAsHashCode = (StringWrapperFourElementsSumAsHashCode) obj;
		return stringWrapperFourElementsSumAsHashCode.getKey().equals(this.key);
	}
	
	public String getKey() {
		return key;
	}
}
