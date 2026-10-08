package main.java.oop_week7.assigment_problems;

abstract class Shape {
    private static int counter = 1001;
    private final String shapeId;
    protected double scaleX = 1.0;
    protected double scaleY = 1.0;

    public Shape() {
        this.shapeId = "SHP-" + (counter++);
    }

    public abstract double calculateArea();

    public void scale(double factor) {
        this.scaleX *= factor;
        this.scaleY *= factor;
    }

    public void scale(double xFactor, double yFactor) {
        this.scaleX *= xFactor;
        this.scaleY *= yFactor;
    }

    public String getShapeId() { return shapeId; }
}

class CircleShape extends Shape {
    private double radius;
    public CircleShape(double radius) { this.radius = radius; }
    
    @Override
    public double calculateArea() {
        return Math.PI * (radius * scaleX) * (radius * scaleY);
    }
}

class SquareShape extends Shape {
    private double side;
    public SquareShape(double side) { this.side = side; }
    
    @Override
    public double calculateArea() {
        return (side * scaleX) * (side * scaleY);
    }
}

public class BasicDrawingCanvas {
    public static void printArea(Shape s) {
        System.out.println(s.calculateArea());
    }
}