import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 *  Create a text file contains an unspecified number
 *   of scores separated by blanks. Now write a program 
 *   that prompts the user to enter the file (path/name), 
 *   reads the scores from the file, and displays their 
 *   total and average.
 *   
 *   This program should have exception handling. 
 * */

public class textReader {

	public static void main(String[] args) {
		System.out.println("Please enter the file path of the scores:");
		Scanner reader = new Scanner(System.in);
		String filePath = reader.nextLine();
		reader.close();
		
		
		ArrayList<Integer> scores = new ArrayList<Integer>();
		try {
			File myObj = new File(filePath);
			reader = new Scanner(myObj);
			
			
			while (reader.hasNextLine()) {
				scores.add(reader.nextInt());
			}
			reader.close();		
			
			
			int total = 0;
			int size = scores.size();
			
			for(int score : scores) {
				total += score;
			}
			
			int average = total/size;
			
			System.out.println("The total score is: " + total );
			System.out.println("The average score is: " + average);
			
		}catch (FileNotFoundException e) {
			System.out.println("file not found, oops");
			e.printStackTrace();	
		}
		catch (InputMismatchException e) {
			System.out.println("The file you have selected is not compatible.\n"
					+ "Plese use a file that only has scores in integer form, "
					+ "one score per line");
			
		}
		

	}
	
}
