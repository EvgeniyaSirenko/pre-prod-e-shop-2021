package com.epam.preprod.sirenko;

/**
 * String key wrapper, as HashCode uses sum of first four elements of string
 *
 * @author E.Sirenko
 **/
public class FourElementsOfStringSumAsHashCodeWrapper {
		private String key;
	
	public FourElementsOfStringSumAsHashCodeWrapper() {
	}
	
	public FourElementsOfStringSumAsHashCodeWrapper(String key) {
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
			if (!(obj instanceof FourElementsOfStringSumAsHashCodeWrapper)) {
				return false;
			}
			FourElementsOfStringSumAsHashCodeWrapper fourElementsOfStringSumAsHashCodeWrapper = (FourElementsOfStringSumAsHashCodeWrapper) obj;
			return fourElementsOfStringSumAsHashCodeWrapper.getKey().equals(this.key);
	}
	
	public String getKey() {
		return key;
	}
}
