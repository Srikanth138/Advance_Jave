package collectionS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Lists {

	public static void main(String[] args) {
		List<Integer> a;
		a=new ArrayList<Integer>(10);
		a.add(10);
		a.add(20);
		a.add(30);
		System.out.println(a+" before "+a.getClass());
		a.remove(2);//index number remove
		a.remove(new Integer(10)); //object remove
		System.out.println(a+" after "+a.getClass());
		
		a=new LinkedList<Integer>();
		a.add(30); //addFirst(400); here not suppot.
		LinkedList<Integer> l=new LinkedList<Integer>();
		l.addFirst(400);
		System.out.println(a+" "+a.getClass()+" "+l+" "+l.getClass());
		
		a=new Vector<Integer>();
		a.add(10);
		System.out.println(a+" "+a.getClass());
		Vector<Integer> v=new Vector<Integer>();
		v.add(19);
		v.addElement(2);
		System.out.println(v+" "+v.getClass());
		
		a=new Stack<Integer>();
		a.add(150);//ss.push(20); can't use here 
		System.out.println(a+" "+a.getClass());
		
		Stack<Integer> ss=new Stack<Integer>();
		ss.push(20);
		System.out.println(ss+" "+ss.getClass());

	}
}
