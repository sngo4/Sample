package util;

public class Validate {
	public static boolean checkNumberInput(String inPutString){
		try {
			Long.parseLong(inPutString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
