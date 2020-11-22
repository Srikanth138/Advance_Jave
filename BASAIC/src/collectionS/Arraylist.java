package collectionS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;


public class Arraylist {

	public static void main(String[] args) {
		try{
	/* It uses a dynamic array to STORE THE DUPLICATE ELEMENT OF DIFFERENT DATA TYPES.
	 * ArrayList class can be randomly accessed.*/
		ArrayList<Integer> al=new ArrayList<Integer>(10); //give the size
		ArrayList<String> als=new ArrayList<String>(20);
		System.out.println("Arraylist.main()");
		System.out.println(al);
		System.out.println(als);
		//al.add(indexNO,value);
		al.add(0,10);// al.add(1,10); ->give error
		al.add(0,20);
		al.add(0,30);
		al.set(1,180);
		al.add(40);
//		al.addAll(3, al);System.out.println(al);
		als.add(0,"sri");
		als.add(1,"a"); //als.add(3,"kanth");->give error
		als.add(0,"b");
		als.add(3,"kanth");
		als.set(1,"180");
		al.remove(2);
		System.out.println(al);
		System.out.println(al+""+als);
		als.clear();
		for (String a : als) { //java 5 introduces
			System.out.print(a+" "+"is");
		}
		al.forEach((n)->System.out.print(n+" ")); //java 8 introduces
		
		/*for(int i=0;i<al.size();i++){
			for(int j=0;j<=i;j++){
				System.out.print(al);
			}
			System.out.println(" ");
		}*/
		}
		catch(IndexOutOfBoundsException e){
			e.printStackTrace(); //it will show which line & which type of error is there
			//System.out.println(e.getMessage() );//it will tell what error is there
		}
		System.out.println("\n---------------------------------------------------------------");
		
/*		It uses a DOUBLY linked list internally to STORE THE ELEMENTS.
		It maintains the insertion order and is NOT SYNCHRONIZED. 
		In LinkedList, the MANIPULATION IS FAST BECAUSE NO SHIFTING IS REQUIRED.*/
		System.out.println("Arraylist.main()");
		LinkedList<Integer> ll=new LinkedList<Integer>();{
		ll.add(0,1); //index Zero
		ll.addFirst(10);
		ll.addLast(20);
		System.out.println(ll+"add");
		
		System.out.println(ll.clone()+"clone only object");
		
		System.out.println(ll.getFirst()+"->getfirst element");
		
		ll.addAll(ll);
		System.out.println(ll+"addAll");
		
		System.out.println(ll.descendingIterator()+"descendingIterator()->itraction()");
		
		System.out.println(ll.indexOf(ll)+"indexOf");
		ll.remove(5);
		System.out.println(ll+"remove()");
		
		Iterator<Integer> itr=ll.iterator();  
		while(itr.hasNext()){   //check next value is there are not 
			System.out.println(itr.next()+" : itr");  //print the values
			}  
		System.out.println(ll.offerFirst(20)+"\n"+ll+"offerFirst(20)->add this value first");
		
		System.out.println(ll.peek()+" peek->top element");
		ll.push(90);
		ll.set(1,180);
		System.out.println(ll);
		
		ll.clear();
		System.out.println(ll+"clear()");
		ll.push(90);
		System.out.println(ll);		
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		
/*  The stack is the subclass of Vector. 
 *	It implements the LAST-IN-FIRST-OUT data Structure, i.e., Stack. */		
		Stack<Integer> s=new Stack<Integer>();
		s.add(90); //add
		s.push(200); //add
		s.push(100); 
		s.set(1,180);
		s.push(300);//add
		System.out.println(s);
		s.pop(); //remove last element
		System.out.println(s);
		System.out.println(s.empty()); 
		System.out.println(s.peek());
		System.out.println(s.capacity()+"capacity");
		System.out.println("====================================================");
		
//		Vector uses a dynamic array to store the data elements. 
//		It is similar to ArrayList. 
		Vector<Integer> v=new Vector<Integer>();
		v.add(999);
		v.add(990); //v.push(990);
		System.out.println(v);
		System.out.println(v.capacity());
		System.out.println(v.size());
		
		System.out.println(v.contains(v));
		System.out.println(v.clone());
		v.set(1,180); //change the value in given index number
		System.out.println(v);
		System.out.println(v.toArray());
	}

}
