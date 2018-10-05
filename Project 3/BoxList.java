
public abstract class BoxList {
	protected BoxNode first;
	protected BoxNode last;
	protected int length;

	public BoxList() {
		first = null;
		last = null;
		length = 0;
	} // Constructor

	public Box get(int x) { //Gets object from list
		if (x < 0 || x >= length) {
			return null;
		}
		if (x == length - 1) {
			return last.Data();
		}
		BoxNode n = first;
		for (int i = 1; i <= x; i++) n = n.Next();
		return n.Data();
	}

	public int length() { //Returns length of list
		return length;
	}

	public void append(Box b) {
		BoxNode node = new BoxNode(b);
		if (first == null) {
			first = node;
			last = node;
		} else {
			last.next = node;
			last = node;
		}
		length++;
	} // Appends a box

	@Override
	public String toString() {
		String data = "";
		BoxNode node = first;
		while (node != null) {
			data += node.data.toString() + "\n";
			node = node.next;
		}
		return data;
	} // Override for toString; returns a string
}