package CollectionsSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sorting {

	public static void main(String[] args) {

		List<String> ls = new ArrayList<String>();
		ls.add("third");
		ls.add("first");
		ls.add("second");
		ls.add("third");
		System.out.println("Collection Before Sorting ::" + ls);

		Collections.sort(ls); // Collections is a class in util package. sort(param) method in the Collections
								// class to sort the elements
		System.out.println("Collection After  Sorting ::" + ls);

		// Remove the duplicate in the List we can mention to the set

		Set<String> s1 = new HashSet<String>(ls);
		System.out.println("After Removing the duplicates in to the set object collection ::"+s1);

		Set<String> set = new HashSet<String>(); // set is not allowed duplicate values. and set is non-order collection
		set.add("Ravi");
		set.add("Vijay");
		set.add("Ravi");
		set.add("Ajay");

		System.out.println(set);

		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(250, "value");
		hm.put(255, "value5");
		hm.put(251, "value2");

		System.out.println(hm); // HashMap is order collection

		Set s = hm.entrySet();
		Iterator it = s.iterator();
		while (it.hasNext())
			System.out.println(it.next());

	}

}
