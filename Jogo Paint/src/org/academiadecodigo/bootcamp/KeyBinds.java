package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class KeyBinds implements KeyboardHandler {

    private Save save = new Save();
    private Load load = new Load();
    private Grid grid;
    private String[][] gridColor;
    private int[] currentPos;
    private int gridSize;
    private boolean draw = false;
    private int nrCols;
    private int nrRows;
    private boolean isExitDefault = false;

    public KeyBinds(Grid grid) {
        this.grid = grid;
    }


    @Override
    public void keyPressed(KeyboardEvent e) {
        if (!isExitDefault) {
            try {
                JFrame frame = (JFrame) Window.getWindows()[0];
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                isExitDefault = true;
            } catch (Exception ex) {
            }
        }
        if (KeyboardEvent.KEY_LEFT == e.getKey()) {
            currentPos = grid.getCurrentPos();
            gridColor = grid.getGridColor();
            grid.drawIt();
            if (currentPos[1] != 0) {
                currentPos[1] = currentPos[1] - 1;
                grid.setCurrentPos(currentPos);
                // drawIt();

                grid.redraw();
            }


        }

        if (KeyboardEvent.KEY_RIGHT == e.getKey()) {
            currentPos = grid.getCurrentPos();
            gridColor = grid.getGridColor();
            grid.drawIt();
            if (currentPos[1] != (grid.getNrCols() - 1)) {
                currentPos[1] = currentPos[1] + 1;
                grid.setCurrentPos(currentPos);
                //drawIt();

                grid.redraw();
            }
        }

        if (KeyboardEvent.KEY_UP == e.getKey()) {
            currentPos = grid.getCurrentPos();
            gridColor = grid.getGridColor();
            grid.drawIt();
            if (currentPos[0] != 0) {
                currentPos[0] = currentPos[0] - 1;
                grid.setCurrentPos(currentPos);
                //drawIt();
                grid.redraw();
            }
        }

        if (KeyboardEvent.KEY_DOWN == e.getKey()) {
            currentPos = grid.getCurrentPos();
            gridColor = grid.getGridColor();
            grid.drawIt();
            if (currentPos[0] != (grid.getNrRows() - 1)) {
                currentPos[0] = currentPos[0] + 1;
                grid.setCurrentPos(currentPos);
                //  drawIt();
                grid.redraw();
            }
        }

        if (KeyboardEvent.KEY_S == e.getKey()) {
            gridColor = grid.getGridColor();
            nrCols = grid.getNrCols();
            nrRows = grid.getNrRows();
            try {
                save.save(gridColor, nrRows, nrCols);
            } catch (Exception ex) {
                System.out.println("Couldn't save");
                //  System.out.println(System.getProperty("user.dir"));
                //   System.out.println(File.separator);
            }
        }

        if (KeyboardEvent.KEY_L == e.getKey()) {
            nrCols = grid.getNrCols();
            nrRows = grid.getNrRows();
            try {
                gridColor = load.load(nrRows, nrCols);
                grid.setGridColor(gridColor);
                grid.redraw();
            } catch (Exception ex) {
                System.out.println("Couldn't load");
            }
        }

        if (KeyboardEvent.KEY_M == e.getKey()) {
            grid.changeColor();
        }
        if (KeyboardEvent.KEY_SPACE == e.getKey()) {
            draw = true;
            grid.setDraw(draw);
        }

        if (KeyboardEvent.KEY_C == e.getKey()) {
            grid.clear();
            grid.redraw();
        }

        if (KeyboardEvent.KEY_E == e.getKey()) {
            System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        if (KeyboardEvent.KEY_SPACE == e.getKey()) {
            draw = false;
            grid.setDraw(draw);
        }
    }
}
