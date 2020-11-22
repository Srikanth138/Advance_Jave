package ioStreame;
import java.io.*;
public class Basic implements Serializable{
	
	
		private String s1;
		private int s2;
		private char s3;
		Basic(String s1,int s2,char s3){
			  this.s1=s1;
			  this.s2=s2;
			  this.s3=s3;
			 }
		
		void basic(){
			 System.out.println(s1+" "+s2+" "+s3);	
		}
		
	public static void main(String[] args)  {
		/*int a=10;
		char ch='c';
		String s="Srikanth";
		OutputStream os,osd=null;
		InputStream is1,is2,isd1,isd2=null;
		try {
			os=new FileOutputStream("basic.txt"); //destination file create
			osd=new DataOutputStream(os); //filter the data
			
			osd.write(a);
			osd.write(ch);
			//osd.write(s); //String can't store
			System.out.println(" FILE CREATED DATA IS PUSHED DETAILS OR PUSHUD TO FILE");
			
			is1 =new FileInputStream("basic.txt");
			isd1=new DataInputStream(is1);
			int i=isd1.read();
			System.out.println(i+" Retrive the data :"+(char)isd1.read());
			
			
			is2=new FileInputStream("C:/Users/srika/Desktop/text.txt.txt"); 
			isd2=new DataInputStream(is2);
			System.out.println("external...");
			long l=is2.read();
			char c=(char) isd2.read();
			System.out.println(l+" "+c);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
			
			Basic b=new Basic("Sri",100,'c');	
			
			OutputStream os;
		    ObjectOutputStream oos;
		    
		    InputStream is;
		    ObjectInputStream ois;
		    
		try{
			os=new FileOutputStream("oos.txt");//creating and writing the data.
			oos=new ObjectOutputStream(os);
			System.out.println(oos);
			oos.writeObject(b);
			
			is=new FileInputStream("oos.txt"); //reading data.
			ois=new ObjectInputStream(is);
			Basic bb=(Basic)ois.readObject();
			System.out.println(bb);
			bb.basic();
			
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
