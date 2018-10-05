
public class SortedBoxList extends BoxList {
	public SortedBoxList() {
		super();
	}

	public void add(Box b) {
		if (first == null) {
			super.append(b);
		} // Appends a box to appropriate position
		else {
			BoxNode node = new BoxNode(b); // Defines a node
			BoxNode c = first, n = first.next; // Variables for head node and next node
			while (c != null) {
				if (n == null) {
					if ((b.getVolume() < first.data.getVolume())) {
						node.next = first;
						first = node;
						break;
					} // Compares to head node and replaces as necessary
					c.next = node;
					break;
				} 
				else if ((b.getVolume() >= c.data.getVolume()) && (b.getVolume() <= n.data.getVolume())) {
					node.next = n;
					c.next = node;
					break;
				} // Checks box volume relative to other boxes and places node in between as necessary
				c = n;
				n = c.next;
			}
		}
	}
}
