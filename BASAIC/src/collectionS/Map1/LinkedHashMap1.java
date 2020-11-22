package collectionS.Map1;

import java.util.*;

public class LinkedHashMap1 {
//public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V>  
	public static void main(String[] args) {
		LinkedHashMap<Integer,String> hm=new LinkedHashMap<Integer,String>();  
		hm.put(100,"Amit");  
		hm.put(101,"Vijay");  
		hm.put(102,"Rahul");  
		System.out.println("KEY: "+hm.keySet());
		System.out.println("values: "+hm.values());
		System.out.println("Key-Value pairs: "+hm.entrySet()); 
		
		for(Map.Entry m : hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
		
		hm.remove(101);
		System.out.println(hm);
	}
}
