package org.example.model;

import org.example.model.fill.FillBehavior;

import java.awt.Color;
import java.awt.geom.RectangularShape;

import java.awt.*;
import java.awt.geom.RectangularShape;

public class MyShapeFactory {
    private MyShapeFactory() {

    }
    public static MyShape createShape(RectangularShape shape) {
        return new MyShape(shape);
    }

    public static  MyShape createShape(
            Color color,
            RectangularShape shape,
            FillBehavior fillBehavior
    ) {
        return new MyShape(color, shape, fillBehavior);
    }
}
