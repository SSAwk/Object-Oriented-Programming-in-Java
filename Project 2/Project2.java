/**
 * Name: Steven Wang
 * Lab: 11G
 * Description: Reads a list of dimensions of boxes contained in a file and sorts it based on volume
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 {
	public static void main(String[] args) {
		SortedBoxList sortedBoxList = new SortedBoxList(); //Defines SortedBoxList
		UnsortedBoxList unsortedBoxList = new UnsortedBoxList(); //Defines UnsortedBoxList
		File file = new File("Box.txt");
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String fields[] = line.split(",");
				int length = Integer.parseInt(fields[0].trim());
				int width = Integer.parseInt(fields[1].trim());
				int height = Integer.parseInt(fields[2].trim());
				Box b = new Box(length, width, height);
				sortedBoxList.add(b);
				unsortedBoxList.add(b);
			} //Reads file and inputs data into array
			new BoxGUI(sortedBoxList, unsortedBoxList); //Lists as parameters for GUI
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} //Output for missing file
		catch (Exception e) {
			System.out.println("Invalid file format!");
		} //Output for invalid file input
	}
}
