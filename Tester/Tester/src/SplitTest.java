
public class SplitTest {
public static void main(String[] args) {
	String str = "2.5\" 3.84TB Flash Drive Raid5-7+1";
	System.out.println(str.split("Raid")[0]);
}
}
