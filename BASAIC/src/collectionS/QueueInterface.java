package collectionS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.PriorityQueue;

public class QueueInterface {
	/*Queue interface maintains the FIRST-IN-FIRST-OUT order. 
	 * It can be defined as an ordered list that is used to hold the elements which are about to be processed. 
	 * There are various classes like PriorityQueue, Deque, and ArrayDeque which implements the Queue interface. */
	public static void main(String[] args) {
//		Queue<String> q1 = new PriorityQueue();  
//		Queue<String> q2 = new ArrayDeque();  
		
		PriorityQueue<String> pq=new PriorityQueue<String>(); 
		
/*		It holds the elements or objects which are to be processed by their priorities. 
		PriorityQueue DOESN'T ALLOW NULL VALUES to be stored in the queue. */	
		
		pq.add("Amit Sharma");  
		pq.add("Vijay Raj");  
		pq.add("JaiShankar");  
		pq.add("Raj");  
		System.out.println("head:"+pq.element());  
		System.out.println("head:"+pq.peek());  
		System.out.println("iterating the queue elements:");  
		Iterator<String> itr1=pq.iterator();  
		while(itr1.hasNext()){  
		System.out.println(itr1.next());  
		}  
		pq.remove();  
		pq.poll();  
		System.out.println("after removing two elements:");  
		Iterator<String> itr2=pq.iterator();  
		while(itr2.hasNext()){  
		System.out.println(itr2.next());  
		}  
		System.out.println("----------------------------");
		
		
		ArrayDeque<String> dd = new ArrayDeque<String>();  
		
		/*In Deque, we can remove and add the elements from BOTH THE SIDE. 
		 * Deque stands for a DOUBLE-ENDED QUEUE which enables us to perform the operations at BOTH THE ENDS.*/	
		
		dd.add("Gautam");  
		dd.add("Karan");  
		dd.add("Ajay");  
		//Traversing elements  
		for (String str : dd) {  
		System.out.println(str);  
		}  
		dd.remove();
		dd.pollFirst();
		dd.poll();
		dd.push("vish");
		System.out.println(dd);
		dd.pop();
		System.out.println(dd);
	}

}
