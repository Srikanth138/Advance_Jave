package collectionS.Map1;

import java.util.Map;


public class TreeMap {

	public static void main(String[] args) {
		java.util.TreeMap<Integer, String> map=new java.util.TreeMap<Integer, String>();    
	      map.put(100,"Amit");    
	      map.put(102,"Ravi");    
	      map.put(101,"Vijay");    
	      map.put(103,"Rahul");    
	        
	      for(Map.Entry m:map.entrySet()){    
	       System.out.println(m.getKey()+" "+m.getValue());    
	      } 
	      
//	      NavigableMap<Integer,String> nm=new java.util.TreeMap()<Integer,String>();   
//	      SortedMap<Integer,String> sm=new java.util.TreeMap()<Integer,String>();   
	      
	      //Maintains descending order  
	      System.out.println("descendingMap: "+map.descendingMap());  
	      //Returns key-value pairs whose keys are less than or equal to the specified key.  
	      System.out.println("headMap: "+map.headMap(102,true));  
	      //Returns key-value pairs whose keys are greater than or equal to the specified key.  
	      System.out.println("tailMap: "+map.tailMap(102,true));  
	      //Returns key-value pairs exists in between the specified key.  
	      System.out.println("subMap: "+map.subMap(100, false, 102, true));   

	}

}
