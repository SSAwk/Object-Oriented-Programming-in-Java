
public abstract class BoxList {
	protected BoxNode first;
	protected BoxNode last;
	protected int length;
	public BoxList() {
		first = null;
		last = null;
		length = 0;
	} //Constructor

	public void append(Box b) {
		BoxNode node = new BoxNode(b);
		if (first == null) {
			first = node;
			last = node;
		} 
		else {
			last.next = node;
			last = node;
		}
		length++;
	} //Appends a box
	
	@Override
	public String toString() {
		String data = "";
		BoxNode node = first;
		while (node != null) {
			data += node.data.toString() + "\n";
			node = node.next;
		}
		return data;
	} //Override for toString; returns a string
}