package test_arraylist;
import java.util.*;

public class sorted {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		list.add(50);
		list.add(28);
		list.add(32);
		Collections.sort(list);
		for (int n : list)
			System.out.println(n);
	}
}
