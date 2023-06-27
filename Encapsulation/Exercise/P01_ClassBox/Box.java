package Encapsulation.Exercise.P01_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * length * height) + (2 * width * height);
    }

    public double calculateSurfaceArea() {
        return (2 * length * width) + (2 * length * height) + (2 * width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }

    private void setLength(double length) {
        validateBoxSide(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateBoxSide(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateBoxSide(height, "Height");
        this.height = height;
    }
    private void validateBoxSide(double side, String messagePrefix) {
        if (side <= 0) {
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", messagePrefix));
        }
    }
}
