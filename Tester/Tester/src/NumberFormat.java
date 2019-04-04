
public class NumberFormat {
public static void main(String[] args) {
	String input_capacity = "1 TBu";
	String unit = "TBu";
	int input = Integer.parseInt(input_capacity.replace(unit, "").replaceAll(" ",""));
	System.out.println(input);
//	System.out.println(Integer.parseInt(input));
}
}
