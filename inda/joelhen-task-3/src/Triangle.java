import java.text.DecimalFormat;

public class Triangle {

    
    private int sideA;
    private int sideB;
    private int sideC; 
    
    public Triangle(int sideA, int sideB, int sideC) {
        if (validTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
        else {
            throw new IllegalArgumentException("Invalid side lengths for a triangle");
        }
    }

    public void setSideA(int sideA) {
        if (validTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
        }
        else {
            throw new IllegalArgumentException("Invalid side lengths for a triangle");
        }
    }
    public int getSideA() {
        return sideA;
    }

    public void setSideB(int sideB) {
        if (validTriangle(sideA, sideB, sideC)) {
            this.sideB = sideB;
        }
        else {
            throw new IllegalArgumentException("Invalid side lengths for a triangle");
        }
    }
    public int getSideB() {
        return sideB;
    }

    public void setSideC(int sideC) {
        if (validTriangle(sideA, sideB, sideC)) {
            this.sideC = sideC;
        }
        else {
            throw new IllegalArgumentException("Invalid side lengths for a triangle");
        }
    }
    public int getSideC() {
        return sideC;
    }

    private boolean validTriangle(int a, int b, int c) {
        return (a + b > c && a + c > b && b + c > a);
    }

    public String getTriangleType() {
        if (getSideA() == getSideB() && getSideB() == getSideC()) {
            return "Equilateral";
        }
        else if (getSideA() == getSideB() || getSideA() == getSideC() || getSideB() == getSideC()) {
            return "Isosceles";
        }
        else {
            return "Scalene";
        }
    }

    public double getSemiPerimeter() {
        return ( (double) getSideA() + getSideB() + getSideC()) / 2;
    }

    public double getArea() {
        return Math.sqrt(getSemiPerimeter() * (getSemiPerimeter() - getSideA()) * (getSemiPerimeter() - getSideB()) * (getSemiPerimeter() - getSideC()));
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Your triangle is of type: " + triangle.getTriangleType() + ", and has an area of: " + df.format(triangle.getArea()));
    }
}