package collections;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ReturnRandomElement {
	NumberFormat formatter = new DecimalFormat("#0.00");

	public static void main(String[] args) {
		ReturnRandomElement re = new ReturnRandomElement();
		re.returnRandomElement(re.createList(1000, 40000, 3000));

	}

	ArrayList<String> createList(Double start, Double end, Double interval) {
		ArrayList<String> List = new ArrayList<String>();
		Double i = 0.0;
		while (i < end) {
			List.add(String.valueOf(formatter.format(i)));
			i = i + interval;

		}

		return List;
	}

	ArrayList<String> createList(int start, int end, int interval) {
		ArrayList<String> List = new ArrayList<String>();
		for (int i = start; i <= end; i = i + interval) {
			List.add(String.valueOf(i));
		}

		return List;
	}

	String returnRandomElement(ArrayList<String> list) {
		String element = list.get(((int) (Math.random() * list.size()) - 1));

		return element;
	}

}
