public class Box implements Comparable<Box>{
	private int length;
	private int width;
	private int height;

	public Box() {
		length = 1;
		width = 1;
		height = 1;
	} // No parameter constructor

	public Box(int length, int width, int height) throws IllegalBoxException {
		if (length < 1) {
			throw new IllegalBoxException("Invalid Length"); // Outputs error for exception
		}
		if (width < 1) {
			throw new IllegalBoxException("Invalid Width");
		}
		if (height < 1) {
			throw new IllegalBoxException("Invalid Height");
		}
		this.length = length;
		this.width = width;
		this.height = height;
	} // Constructor using given dimensions for box

	public int getLength() {
		return length;
	} // Returns value of length

	public void setLength(int length) throws IllegalBoxException {
		if (length < 1) {
			throw new IllegalBoxException("Invalid Length");
		}
		this.length = length;
	} // Outputs error if invalid and assigns value of variable to field

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) throws IllegalBoxException {
		if (width < 1) {
			throw new IllegalBoxException("Invalid Width");
		}
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) throws IllegalBoxException {
		if (height < 1) {
			throw new IllegalBoxException("Invalid Height");
		}
		this.height = height;
	}

	public int getVolume() {
		return length * width * height;
	} // Returns value of volume

	@Override // Overrides method from Object
	public boolean equals(Object o) {
		if (o instanceof Box) {
			Box b = (Box) o;
			if (this.length == b.length && this.width == b.width && this.height == b.height) {
				return true;
			}
		}
		return false;
	} // Checks if two boxes have the same dimensions

	@Override
	public String toString() {
		return "L: " + getLength() + " W: " + getWidth() + " H: " + getHeight() + " (V: " + getVolume() + ")";
	} // Output for value display

	@Override
	public int compareTo(Box b) {
		// TODO Auto-generated method stub
		if(this.getVolume() > b.getVolume())return 1;
        else if(this.getVolume() <b.getVolume())return -1;
        return 0;
	}
}