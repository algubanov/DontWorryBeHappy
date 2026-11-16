package org.example.view;

import lombok.Setter;
import org.example.controller.Controller;
import org.example.model.factory.ShapeState;
import org.example.model.factory.ShapeType;

import javax.swing.*;
import java.awt.*;

public class MenuCreator {
    private static MenuCreator instanse;
    @Setter
    private ShapeState shapeState;
    @Setter
    private Controller controller;

    private MenuCreator() {

    }

    public static MenuCreator getInstanse() {
        synchronized (MenuCreator.class) {
            if (instanse == null) {
                instanse = new MenuCreator();
            }
            return instanse;
        }
    }

    public JMenuBar createMenu() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu shapeMenu = createShapeMenu();
        jMenuBar.add(shapeMenu);

        JMenu colorMenu = createColorMenu();
        jMenuBar.add(colorMenu);

        JMenu FillMenu = createFillMenu();
        jMenuBar.add(FillMenu);

        return jMenuBar;
    }
    private JMenu createActionMenu() {
        ButtonGroup group = new ButtonGroup();
        JMenu actionMenu = new JMenu("Действие");

        JRadioButtonMenuItem drawItem = new JRadioButtonMenuItem("Рисовать", true);
        drawItem.addActionListener(action -> controller.switchActionDraw());
        actionMenu.add(drawItem);
        group.add(drawItem);

        return actionMenu;
    }
    private JMenu createFillMenu() {
        ButtonGroup group = new ButtonGroup();
        JMenu fillMenu = new JMenu();

        JRadioButtonMenuItem fillItem = new JRadioButtonMenuItem("С заливкой", true);
        fillItem.addActionListener(action -> shapeState.setFill(true));
        fillMenu.add(fillItem);
        group.add(fillItem);

        JRadioButtonMenuItem noFillItem = new JRadioButtonMenuItem("Без заливки", false);
        noFillItem.addActionListener(action -> shapeState.setFill(true));
        fillMenu.add(noFillItem);
        group.add(noFillItem);

        return fillMenu;
    }

    private JMenu createColorMenu() {
        ButtonGroup group = new ButtonGroup();
        JMenu shapeMenu = new JMenu("Цвет");
        JRadioButtonMenuItem redItem = new JRadioButtonMenuItem("Красный", true);
        redItem.addActionListener(action -> shapeState.setColor(Color.RED));
        shapeMenu.add(redItem);
        group.add(redItem);

        JRadioButtonMenuItem blueItem = new JRadioButtonMenuItem("Синий", true);
        blueItem.addActionListener(action -> shapeState.setColor(Color.BLUE));
        shapeMenu.add(blueItem);
        group.add(blueItem);

        JRadioButtonMenuItem rgbItem = new JRadioButtonMenuItem("Выбор цвета");
        blueItem.addActionListener(action -> shapeState.setColor(JColorChooser.showDialog(null, "Выбор цвета", Color.BLACK)));
        shapeMenu.add(rgbItem);
        group.add(rgbItem);

        return shapeMenu;
    }

    private JMenu createShapeMenu() {
        ButtonGroup group = new ButtonGroup();
        JMenu shapeMenu = new JMenu("Фигура");
        JRadioButtonMenuItem squareItem = new JRadioButtonMenuItem("Прямоугольнык", true);
        squareItem.addActionListener(action -> shapeState.setShapeType(ShapeType.RECTANGULAR_SHAPE));
        shapeMenu.add(squareItem);
        group.add(squareItem);

        return shapeMenu;
    }
}
