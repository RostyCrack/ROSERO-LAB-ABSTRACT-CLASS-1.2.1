package edu.sabana.poob.shapes;

public class Circle extends Shape {

    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    @Override
    double getArea() {
        return Math.PI*this.radius*this.radius;
    }

    @Override
    double getPerimeter() {
        return 2*Math.PI*this.radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getDiameter() {
        return this.radius*2;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + " and radius %s", this.radius);
    }
}
