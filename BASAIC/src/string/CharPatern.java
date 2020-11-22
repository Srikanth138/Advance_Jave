package string;

public class CharPatern {

	public static void main(String[] args) {
		/*for(char i='A';i<='E';i++){
			//for(char j='A';j<='E';j++)
				for(char j=i;j<='E';j++)
				{
				 System.out.print(j+" ");
			}
			System.out.println(" ");
		}*/
		
		for(int i=65;i<=69;i++){
			for(int j=65;j<=69;j++)
				//for(int j=i;j<=69;j++)
				{
				 System.out.print((char)j+" "); //explicite type casting LOSSING THE DATA.
			}
			System.out.println(" ");
		}

	}

}
