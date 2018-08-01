import java.io.File;
import java.util.Scanner;

public class ReadFiles {
	
	public int[] readFileToArray(String file) {

		try {
			File fileToRead = new File(file);
			int[] numArray = new int[50000];
			
			Scanner number = new Scanner(fileToRead);
			
			for (int i = 0; i <numArray.length; i++) {
				numArray[i] = number.nextInt();
			}
			
			number.close();
			
			return numArray;
		}
		
		catch (Exception e) {
			System.out.println("There was an error");
			return null;
		}
	}
}
