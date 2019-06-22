package stringManipulation;

/*input: the white tiger was bigger than the brown tiger
output: 
the 3
was 3

than 4

brown 5
tiger 5
white 5

bigger 6*/
public class Whitetiger {
	public static void main(String[] args) {
		String s = "the white tiger was bigger than the brown tiger";
		String[] arr = s.split("\\s+");
//		for (String s23 : arr)
//			System.out.println(s);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j].length() < arr[j - 1].length()) {
					String temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;

				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j].charAt(0) < arr[j - 1].charAt(0) && arr[j].length() == arr[j - 1].length()) {
					String temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;

				}
			}
		}
		for (String s23 : arr)
			System.out.println(s23);

		System.out.println("----------------------------------------------------------");
		for (int i = 0; i <= arr.length-1; i++) {
			if (i < arr.length) {
				if (!arr[i].equals(arr[i + 1]))
					System.out.println(arr[i] + " " + arr[i].length());
			}
			if (i == arr.length - 1)
				System.out.println(arr[i + 1] + " " + arr[i].length());

		}
	}
}
