package SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape;

import SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Rengerer;
import SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {

    private final Rengerer renderer;

    public DrawingManagerImpl(Rengerer renderer) {
        this.renderer = renderer;
    }


    @Override
    public void draw(Shape shape) {
        renderer.render(shape);
    }
}
