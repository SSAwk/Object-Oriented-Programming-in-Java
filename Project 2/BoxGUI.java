import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BoxGUI extends JFrame {
	 public BoxGUI(SortedBoxList sortedBoxList, UnsortedBoxList unsortedBoxList) { //Constructor
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2, 10, 10)); //Sets layout for how values will be displayed
        
        JTextArea left = new JTextArea();
        String data = "Input Boxes\n\n"; //Left side header
        data += unsortedBoxList.toString() + "\n"; //Uses toString to add and display box values from unsorted List
        left.setText(data);
        add(left); //Prepares input list area
        
        JTextArea right = new JTextArea();
        data = "Boxes by Volume\n\n"; //Right side header
        data += sortedBoxList.toString() + "\n"; //Uses toString to display box values from sorted list
        right.setText(data);
        add(right); //Prepares sorted list area
        setVisible(true); //Displays the window
        pack(); // Adjusting window size
    }
}