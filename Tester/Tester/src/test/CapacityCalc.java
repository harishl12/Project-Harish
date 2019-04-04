package test;

import java.util.Scanner;

public class CapacityCalc {
public static void main(String[] args) {
//	Scanner in = new Scanner(System.in);
//	System.out.println("Enter capacity");
//	String cap = in.nextLine();
	double comp = 2;
	double cap = 100;
	double pack = (13.16357 * comp );
	double capVal = Math.ceil((cap) / pack)*pack;
	if(capVal%pack == 0 )
		System.out.println("Done");
	System.out.println(capVal);
}
}
