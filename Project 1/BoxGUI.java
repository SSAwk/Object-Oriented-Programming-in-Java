import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BoxGUI extends JFrame {
    public BoxGUI(Box[] a) { //Constructor
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2, 10, 10)); //Sets layout for how values will be displayed
        JTextArea left = new JTextArea();
        String data = "Input Boxes\n\n"; //Left side header
        for (Box b : a) {
        data += b.toString() + "\n";
        } //Uses toString to add and display box values
        left.setText(data);
        add(left); //Prepares input list area
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].getVolume() < a[index].getVolume()) { 
                    index = j;
                } //Find the smallest box in arrays
            }
            Box smallest = a[index];
            a[index] = a[i];
            a[i] = smallest;
        } //Moves smallest box to front
        JTextArea right = new JTextArea();
        data = "Boxes by Volume\n\n"; //Right side header
        for (Box b : a) {
            data += b.toString() + "\n";
        }
        right.setText(data);
        add(right); //Prepares sorted list area
        setVisible(true); //Displays the window
        pack(); // Adjusting window size
    }
}