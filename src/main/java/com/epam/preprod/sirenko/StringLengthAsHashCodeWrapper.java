package com.epam.preprod.sirenko;

/**
 * String key wrapper, as HashCode uses string length
 *
 * @author E.Sirenko
 **/
public class StringLengthAsHashCodeWrapper {
	private String key;
	
	public StringLengthAsHashCodeWrapper() {
	}
	
	public StringLengthAsHashCodeWrapper(String key) {
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
		if (!(obj instanceof StringLengthAsHashCodeWrapper)) {
			return false;
		}
		StringLengthAsHashCodeWrapper stringLengthAsHashCodeWrapper = (StringLengthAsHashCodeWrapper) obj;
		return stringLengthAsHashCodeWrapper.getKey().equals(this.key);
	}
	
	public String getKey() {
		return key;
	}
}
