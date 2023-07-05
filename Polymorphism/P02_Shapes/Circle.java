package Polymorphism.P02_Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculateArea();
        this.calculatePerimeter();
    }

    protected final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        double petimeter = 2 * Math.PI * this.radius;
        setPerimeter(petimeter);
    }

    @Override
    public void calculateArea() {
        double area = Math.PI * Math.pow(this.radius, 2);
        setArea(area);
    }
}
