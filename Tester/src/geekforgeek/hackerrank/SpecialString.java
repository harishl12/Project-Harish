package geekforgeek.hackerrank;

import java.util.ArrayList;
import java.util.Iterator;

public class SpecialString {

	static class Point {
		long count;
		char ch;

		Point(long count, char ch) {
			this.ch = ch;
			this.count = count;
		}
	}

	static long substrCount(String s, long n) {
		ArrayList<Point> l = new ArrayList<SpecialString.Point>();
		s = s + " ";
		long count = 1;

		char ch = s.charAt(0);

		for (int i = 1; i <= n; i++) {
			if (s.charAt(i) == ch) {
				count++;
			} else {
				l.add(new Point(count, ch));
				count = 1;
				ch = s.charAt(i);
			}
		}

		count = 0;
		if (l.size() >= 3) {
			Iterator<Point> itr = l.iterator();
			Point prev, curr, next;
			curr = (Point) itr.next();
			next = (Point) itr.next();
			count = (curr.count * (curr.count + 1)) / 2;
			for (int i = 1; i < l.size() - 1; i++) {
				prev = curr;
				curr = next;
				next = itr.next();
				count += (curr.count * (curr.count + 1)) / 2;
				if (prev.ch == next.ch && curr.count == 1)
					count += prev.count > next.count ? next.count : prev.count;
			}
			count += (next.count * (next.count + 1)) / 2;
		} else {
			for (Point curr : l) {
				count += (curr.count * (curr.count + 1)) / 2;
			}

		}
		return count;
	}

	public static void main(String[] args) {
		String str = "mnonopoo";
		long n = str.length();
		System.out.println(substrCount(str, n));
	}
}
