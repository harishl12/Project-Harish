package geekforgeek.strings;

public class RemoveCharsFromString {
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		StringBuffer sb = new StringBuffer(str);
		String mask_str = "mask";
		for (int i = 0; i < mask_str.length(); i++) {
			str = str.replaceAll(String.valueOf(mask_str.charAt(i)), "");
		}
		System.out.println(str);
	}
}
