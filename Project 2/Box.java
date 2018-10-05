public class Box  {
    private int length;
    private int width; 
    private int height;

    public Box() {
        length = 1;
        width = 1;
        height = 1;
    } //No parameter constructor

    public Box(int length, int width, int height) {
        if (length < 1) {
            length = 1;
        }
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        this.length = length;
        this.width = width;
        this.height = height;
    } //Constructor using given dimensions for box

    public int getLength() {
        return length;
    } //Returns value of length

    public void setLength(int length) {
        if (length < 1) {
            length = 1;
        }
        this.length = length;
    } //Sets value to 1 if invalid and assigns value of variable to field

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width < 1) {
            width = 1;
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 1) {
            height = 1;
        }
        this.height = height;
    }

    public int getVolume() {
        return length * width * height;
    } //Returns value of volume

    @Override //Overrides method from Object
    public boolean equals(Object o) {
        if (o instanceof Box) {
        	Box b = (Box) o;
            if (this.length == b.length && this.width == b.width && this.height == b.height) { 
            	return true;
            }
        }
        return false;
    } //Checks if two boxes have the same dimensions

    @Override
    public String toString() {
        return "L: " + getLength() + " W: " + getWidth() +" H: " + getHeight() + " (V: " + getVolume() + ")";
    } //Output for value display
}