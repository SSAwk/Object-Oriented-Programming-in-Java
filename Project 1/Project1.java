/**
 * Name: Steven Wang
 * Lab: 11G
 * Description: Reads a list of dimensions of boxes contained in a file and sorts it based on volume
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Project1 {
	public static void main(String[] args) {
        Box a[] = new Box[100]; //Creates arrays for box values
        int b = 0;
        File file = new File("Box.txt"); //File with input values
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String fields[] = line.split(",");
                int length = Integer.parseInt(fields[0].trim());
                int width = Integer.parseInt(fields[1].trim());
                int height = Integer.parseInt(fields[2].trim());
                Box box = new Box(length, width, height);
                a[b] = box;
                b++;
            } //Reads the text file and inputs values into array
            new BoxGUI(Arrays.copyOf(a, b));
        }
        catch (FileNotFoundException e) {
            System.out.println("File missing");
        } //Output for missing file
        catch (Exception e) {
            System.out.println("Invalid file data");
        } //Output for invalid inputs
    }
}