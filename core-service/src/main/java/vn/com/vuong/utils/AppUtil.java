package vn.com.vuong.utils;

import java.util.Collection;

public class AppUtil {

	public static boolean isCollectionNullOrEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	public static boolean isStringNullOrEmpty(String s) {
		return s == null || s.trim().isEmpty();
	}
	
	public static boolean isListObjectNullOrEmpty(Object...objects ) {
		boolean isNullOrEmpty = false;
		for (Object object : objects) {
			isNullOrEmpty = isObjectNullOrEmpty(object);
			if(isNullOrEmpty) {
				break;
			}
		}
		return isNullOrEmpty;
	}
	
	public static boolean isListObjectNullAll(Object...objects) {
		boolean isNullAll = true;
		for (Object object : objects) {
			if(object != null) {
				isNullAll = false;
				 break;
			}
		}
		return isNullAll;
	}

	public static boolean isObjectNullOrEmpty(Object object) {
		if (object == null) {
			return true;
		} else if (object instanceof String) {
			if (((String) object).trim().isEmpty()) {
				return true;
			}
		} else if (object instanceof Collection) {
			if (((Collection<?>) object).isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isNumberGreaterThanOrEqualsZero(Integer number) {
		return number != null && number >= 0;
	}
	
	public static boolean allNumberGreaterThanOrEqualsZero(Integer... numbers) {
		for (Integer number : numbers) {
			if(!isNumberGreaterThanOrEqualsZero(number)) {
				return false;
			}
		}
		return true;
	}
}
