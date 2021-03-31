package collections.maps;

import java.util.HashMap;

public class LambdaMaps {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "a!");
		map.put("2", "b$");
		map.put("3", "c#");
		map.put("4", "d&");
		System.out.println(isHashPresent(map));
	}

	private static boolean isHashPresent(HashMap<String, String> map) {
		map.forEach((String k, String v) -> {
			if (v.contains("#"))
				return true;
		});
		return false;
	}
}
