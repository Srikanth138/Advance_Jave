package string;

public class StringArray {

	public static void main(String[] args) {
		String s="hello";
		char c[]=s.toCharArray();
		for(int i=0;i<5;i++){
			for(int j=i;j<5;j++){
				
				System.out.print(c[j]);
			}
			System.out.println(" ");
		}
	}

}
