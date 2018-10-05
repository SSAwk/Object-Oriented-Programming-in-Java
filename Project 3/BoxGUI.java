import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JTextArea;

public class BoxGUI extends JFrame {
	Box inBox;
	UnsortedBoxList boxList;
	public BoxGUI(SortedBoxList sortedBoxList, UnsortedBoxList unsortedBoxList) { // Constructor
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2, 10, 10)); // Sets layout for how values will be displayed
		
		JTextArea left = new JTextArea();
		String data = "Input Boxes\n\n"; // Left side header
		data += unsortedBoxList.toString() + "\n"; // Uses toString to add and display box values from unsorted List
		left.setText(data);
		add(left); // Prepares input list area
		boxList = unsortedBoxList;

		JTextArea right = new JTextArea();
		data = "Boxes by Volume\n\n"; // Right side header
		data += sortedBoxList.toString() + "\n"; // Uses toString to display box values from sorted list
		right.setText(data);
		add(right); // Prepares sorted list area
		setVisible(true); // Displays the window
		pack(); // Adjusting window size
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu"); // Creating and adding a menu
		menuBar.add(menu);
		JMenuItem item = new JMenuItem("Tools"); // Creates "Tools" section for menu
		item.addActionListener(new ActionListener() { // Registers certain actions to prepare response
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame j = new JFrame("Search"); //Setting up JFrame for inputs in "Search"
				j.setSize(500, 100);
				j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Search(j);
				j.setVisible(true);
			}
		});
		menu.add(item);
		setJMenuBar(menuBar);
	}

	public void Search(JFrame b) {
		JTextField length = new JTextField(5); //Size of text field
		JTextField width = new JTextField(5);
		JTextField height = new JTextField(5);
		JTextArea box = new JTextArea();
		b.setLayout(new FlowLayout());
		b.add(new JLabel("Length: ")); //Labels for input area
		b.add(length);
		b.add(new JLabel("Width: "));
		b.add(width);
		b.add(new JLabel("Height: "));
		b.add(height);
		JButton search = new JButton("Search");
		b.add(search);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Display dialogue box when prompted with button
				SortedBoxList checkList = new SortedBoxList();
				int l = Integer.parseInt(length.getText()); //Getting dimensions from input
				int w = Integer.parseInt(width.getText());
				int h = Integer.parseInt(height.getText());
				try {
					inBox = new Box(l, w, h);
					for (int i = 0; i < boxList.length(); i++) {
						if (boxList.get(i).getVolume() >= inBox.getVolume()) {
							checkList.add(boxList.get(i)); //If box can fit input, add to list
						}
					}
				} catch (IllegalBoxException e1) { //Throws exception when input is invalid
					e1.printStackTrace();
					b.setVisible(false);
				}				
				String data = "Boxes That Can Fit Input\n\n";
				data += checkList.toString();
				JFrame o = new JFrame("Output"); //Setting up output JFrame
				o.setSize(500, 500);
				o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				box.setText(data);
				o.setVisible(true);
				o.add(box);
				o.setVisible(true);
			}
		});	
	}
}