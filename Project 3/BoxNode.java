
public class BoxNode {
	protected Box data;
	protected BoxNode next;
	
	public BoxNode(Box d) {
		this.data = d;
	} //One argument constructor with box parameter
	
	public Box Data() {
		return data;
	}
	
	public BoxNode Next() {
		return next;
	}
}
