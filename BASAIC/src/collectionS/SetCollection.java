package collectionS;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;
/* It represents the unordered set of elements which DOESN'T ALLOW US TO STORE THE DUPLICATE ITEMS/values. 
 * We can store at most ONE NULL VALUE in Set. 
 * Set is implemented by HashSet, LinkedHashSet, and TreeSet.
*/
public class SetCollection {

	public static void main(String[] args) {
//		Set<Integer> s1 = new HashSet<Integer>();  
//		Set<Integer> s2 = new LinkedHashSet<Integer>();  
//		Set<Integer> s3 = new TreeSet<Integer>();  
		
		HashSet<String> hs=new HashSet<String>(); //It represents the collection that uses a HASH TABLE FOR STORAGE. store the elements in the HashSet. It contains UNIQUE ITEMS.
		hs.add("Hello hai i am you");
		System.out.println(hs);
		hs.add("Ravi");  
		hs.add("Vijay");  
		hs.add("Ravi");  
		hs.add("Ajay");  
		//Traversing elements  
		Iterator<String> itr1=hs.iterator();  
		while(itr1.hasNext()){   //hashNext() chech next value is there are not 
		System.out.println(itr1.next()); //print the value  & go to the next value
		} 
		System.out.println(hs);
		System.out.println("--------------------------------------");
		
		/*It extends the HashSet class and implements Set interface. 
		 * Like HashSet, It also CONTAINS UNIQUE ELEMENTS. 
		 * It maintains the INSERTION ORDER AND PERMITS NULL ELEMENTS. */
		LinkedHashSet<String> set=new LinkedHashSet<String>();  
		set.add("Ravi");  
		set.add("Vijay");  
		set.add("Ravi");  
		set.add("Ajay");  
		Iterator<String> itr2=set.iterator();  
		while(itr2.hasNext()){  
		System.out.println(itr2.next()+" "+set.size());  
		} 
		System.out.println("--------------------------------------");
		
		/* SortedSet is the alternate of Set interface that provides a total ordering on its elements. 
		 * The elements of the SortedSet are arranged in the increasing (ascending) order. 
		 * The SortedSet provides the additional methods that inhibit the natural ordering of the elements. */
		TreeSet<String> tset=new TreeSet<String>();  
		tset.add("Ravi");  
		tset.add("Vijay");  
		tset.add("Ravi");  
		tset.add("Ajay");  
		//traversing elements  
		Iterator<String> itr3=tset.iterator();  
		while(itr3.hasNext()){  
		System.out.println(itr3.next()); 
		}  
	}
}

