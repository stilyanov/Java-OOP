package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Rengerer;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class ConsoleRenderer implements Rengerer {
    @Override
    public void render(Shape shape) {
        System.out.printf("Shape with area %.2f%n", shape.getArea());
    }
}
