package com.epam.preprod.sirenko.wrappers;

/**
 * String key wrapper, as HashCode uses string length
 *
 * @author E.Sirenko
 **/
public class StringWrapperLengthAsHashCode {
	private String key;
	
	public StringWrapperLengthAsHashCode(String key) {
		this.key = key;
	}
	
	@Override
	public int hashCode() {
		return key.length();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof StringWrapperLengthAsHashCode)) {
			return false;
		}
		StringWrapperLengthAsHashCode stringWrapperLengthAsHashCode = (StringWrapperLengthAsHashCode) obj;
		return stringWrapperLengthAsHashCode.getKey().equals(this.key);
	}
	
	public String getKey() {
		return key;
	}
}
