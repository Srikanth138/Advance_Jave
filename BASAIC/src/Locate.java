import java.util.Locale;

public class Locate {

	public static void main(String[] args) {
		Locale lcl[]=Locale.getAvailableLocales();
		
		//int a[]=new int[]{1,2,5,4};
		//for(int l:a){
		
		System.out.println("All langugaes are ::");
		for(Locale l:lcl){
			System.out.println(l.getDisplayLanguage());
		}
		
		System.out.println("All counstries are ::");
	 	      for(Locale l: lcl) {
	 	    	    System.out.println("<br><b>"+l.getDisplayCountry()+"</b>");
	 	      }
	 	    
	 	    	    System.out.println("<br><b>"+System.getProperties()+"</b>");
		
	}

}
