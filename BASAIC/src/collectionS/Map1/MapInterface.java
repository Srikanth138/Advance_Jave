package collectionS.Map1;
import java.util.Collection;
import java.util.Comparator;
/*A map contains values on the basis of key, i.e. key and value pair. Each key and value pair is known as an entry. A Map contains unique keys.
A Map is useful if you have to search, update or delete elements on the basis of a key.*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapInterface {

	public static void main(String[] args) {
		Map<Integer,String> m=new HashMap<>(); //<key,value> pair
		m.put(101,"first");
		m.put(102,"Sri");
		System.out.println(m);
		
		Set<Integer> i=m.keySet();
		Collection<String> s=m.values();
		i.forEach(System.out::println);
		s.forEach(System.out::println);
		
		System.out.println(m.get(101)); //print 101 value
		
		m.put(103,"");
		//Traversing Map  
	    Set set=m.entrySet();//Converting to Set so that we can traverse  
	    Iterator itr=set.iterator();  
		while(itr.hasNext()){	
		System.out.println(itr.next());
		}
		
		System.out.println("Iterating Hashmap...");  
		m.put(102, "s");
		for(Map.Entry mp:m.entrySet()){  
			   System.out.println(mp.getKey()+" "+mp.getValue());  
		}  
		
		//Returns a Set view of the mappings contained in this map        
		m.entrySet()  
	    //Returns a sequential Stream with this collection as its source  
	    .stream()  
	    //Sorted according to the provided Comparator  
	    .sorted(Map.Entry.comparingByKey())  //key base print 
	    //Performs an action for each element of this stream  
	    .forEach(System.out::println);  
		
		m.entrySet() 
		.stream()  
		.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) //key base reverseOrder
		.forEach(System.out::println);  
		
		
		m.entrySet() 
		.stream() 
		.sorted(Map.Entry.comparingByValue())   //value base
		.forEach(System.out::println); 
		
		m.entrySet() 
		.stream() 
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))   //value base
		.forEach(System.out::println); 
		
	}//main
}//class
