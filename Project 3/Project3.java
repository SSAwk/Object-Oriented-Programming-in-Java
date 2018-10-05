
/**
 * Name: Steven Wang
 * Lab: 11G
 * Description: Reads a list of dimensions of boxes contained in a file and sorts it based on volume.
 * Throws an illegal box exception error if values are invalid.
 * Displays boxes that can fit box values entered in tools menu.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project3 {
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
				try {
					Box b = new Box(length, width, height);
					sortedBoxList.add(b);
					unsortedBoxList.add(b);
				}
				catch(IllegalBoxException e) {
					e.printStackTrace();
				}
			} //Reads file and inputs data into array
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		new BoxGUI(sortedBoxList, unsortedBoxList); //Lists as parameters for GUI
	}
}
