public class Rectangle {


    private int height;
    private int width;
    
    public Rectangle(int height, int width) {
        if (height > 0 && width > 0) {
            this.height = height;
            this.width = width;
        }
        else {
            throw new IllegalArgumentException("Invalid side lengths for a rectangle");
        }
    }

    public Rectangle() {}

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        }
        else {
            throw new IllegalArgumentException("Invalid side lengths for a rectangle");
        }
    }
    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        }
        else {
            throw new IllegalArgumentException("Invalid side lengths for a rectangle");
        }
    }
    public int getWidth() {
        return width;
    }

    public boolean isSquare() {
        return (getHeight() == getWidth());
    }

    public int area() {
        return(getHeight() * getWidth());
    }

    public double diagonalLength() {
        return (double) Math.round(Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2)) * 100) / 100;
    }
}
