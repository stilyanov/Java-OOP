package Polymorphism.P02_Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();
    }

    protected Double getHeight() {
        return height;
    }

    protected Double getWidth() {
        return width;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        double perimeter = 2 * (this.height + this.width);
        setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        double area = this.width * this.height;
        setArea(area);
    }
}
