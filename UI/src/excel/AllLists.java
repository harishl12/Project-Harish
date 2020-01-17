package excel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class AllLists {

	NumberFormat formatter = new DecimalFormat("#0.00");

	ArrayList<String> createList(int start, int end, int interval) {
		ArrayList<String> List = new ArrayList<String>();
		for (int i = start; i <= end; i = i + interval) {
			List.add(String.valueOf(i));
		}

		return List;
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

	String returnRandomElement(ArrayList<String> list) {
		/*
		 * System.out.println(list.size()); System.out.println((int) (Math.random() *
		 * list.size()));
		 */
		String element = list.get((int) (Math.random() * list.size()));

		return element;
	}

	ArrayList<String> returnRandomList(ArrayList<ArrayList<String>> list) {
		ArrayList<String> element = list.get((int) (Math.random() * list.size()));

		return element;
	}

	public void addItemsToList(String item, ArrayList<String> list) {
//		ArrayList<String> list = new ArrayList<String>();
		String[] items = item.split("\\s+");
		for (String s : items)
			list.add(s);

	}

}
