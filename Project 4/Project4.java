
/**
 * Name: Steven Wang
 * Lab: 11G
 * Description: Reads a list of dimensions of boxes contained in a file, places it in maps, and sorts it based on volume.
 * Throws an illegal box exception error if values are invalid.
 * Displays boxes that can fit box values entered in tools menu.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Project4 {
	public static void main(String[] args) {
		TreeMap<Box, Integer> sortedBoxList = new TreeMap<Box, Integer>(); //Defines TreeMap sortedBoxList
		HashMap<Box, Integer> unsortedBoxList = new HashMap<Box, Integer>(); //Defines HashMap unsortedBoxList
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
					sortedBoxList.put(b, b.getVolume());
					unsortedBoxList.put(b, b.getVolume());
				}
				catch(IllegalBoxException e) {
					e.printStackTrace();
				}
			}//Reads file and inputs data into maps
		} catch(Exception e) {
			e.printStackTrace();
		}
		new BoxGUI(sortedBoxList, unsortedBoxList); //Lists maps as parameters for GUI
	}
}
