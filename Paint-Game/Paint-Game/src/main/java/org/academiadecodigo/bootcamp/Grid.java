package org.academiadecodigo.bootcamp;

import graphics.Color;
import graphics.Rectangle;
import graphics.Text;


public class Grid {

    // Properties

    private int nrCols = 10;
    private int nrRows = 10;

    private String currentColor = "Black";
    private String[][] gridColor = new String[nrRows][nrCols];

    private int[] currentPos = new int[2];
    private boolean draw = false;

    private Rectangle background;
    private Rectangle backgroundWhite;
    private Rectangle[][] rectangles = new Rectangle[nrRows][nrCols];


    // Constructor

    public Grid() {
        currentPos[0] = 0;
        currentPos[1] = 0;
    }


    //Methods

    public void init() {
if (nrCols< 10) {
	backgroundWhite = new Rectangle(10, 10, 10*42 + 30, nrRows*42 + 100);
	
} else {
	
	backgroundWhite = new Rectangle(10, 10, nrCols*42 + 30, nrRows*42 + 100);
}
        backgroundWhite.setColor(Color.WHITE);
        backgroundWhite.fill();

        Text text = new Text(40, nrRows*42 + 50, "To move, press the Arrow Keys.     To paint, keep the space bar pressed.");
        text.draw();

        Text text2 = new Text(40, nrRows*42 + 100, "To change the color, press M.  To save, press S.  To load, press L.   To exit, press E.");
        text2.draw();

        background = new Rectangle(10, 10, nrCols*42+2, nrRows*42+2);
        background.setColor(Color.BLACK);
        background.fill();

        for (int i = 0; i < nrRows; i++) {
            for (int j = 0; j < nrCols; j++) {
                rectangles[i][j] = new Rectangle(12 + j * 42, 12 + i * 42, 40, 40);
                gridColor[i][j] = "White";
                rectangles[i][j].setColor(toColor(gridColor[i][j]));
                rectangles[i][j].fill();

            }

        }

        drawCursor();
    }

    public void drawCursor() {
        rectangles[currentPos[0]][currentPos[1]].setColor(toColor(currentColor));
        rectangles[currentPos[0]][currentPos[1]].fill();

    }

    public void redraw() {

        for (int i = 0; i < nrRows; i++) {
            for (int j = 0; j < nrCols; j++) {

                rectangles[i][j].setColor(toColor(gridColor[i][j]));
                rectangles[i][j].fill();

            }

        }
        drawCursor();
    }

    public void clear() {
        for (int i = 0; i < nrRows; i++) {
            for (int j = 0; j < nrCols; j++) {
                gridColor[i][j] = "White";
            }
        }
    }

    public Color toColor(String colorString) {
        Color chosen = Color.BLACK;

        switch (colorString) {

            case "Black":
                chosen = Color.BLACK;
                break;
            case "Blue":
                chosen = Color.BLUE;
                break;
            case "Green":
                chosen = Color.GREEN;
                break;
            case "Magenta":
                chosen = Color.MAGENTA;
                break;
            case "Orange":
                chosen = Color.ORANGE;
                break;
            case "White":
                chosen = Color.WHITE;
                break;
            case "Yellow":
                chosen = Color.YELLOW;
                break;
        }

        return chosen;
    }

    public void changeColor() {

        switch (currentColor) {

            case "Black":
                currentColor = "Magenta";
                break;
            case "Blue":
                currentColor = "Black";
                break;
            case "Green":
                currentColor = "Blue";
                break;
            case "Magenta":
                currentColor = "Orange";
                break;
            case "Orange":
                currentColor = "Yellow";
                break;
            case "Yellow":
                currentColor = "Green";
                break;

        }
        drawCursor();
    }

    public void drawIt() {
        if (draw) {
            if (!gridColor[currentPos[0]][currentPos[1]].equals(currentColor)) {
                gridColor[currentPos[0]][currentPos[1]] = currentColor;
            } else {
                gridColor[currentPos[0]][currentPos[1]] = "White";
            }
        }
        redraw();
    }

    //Getters and Setters

    public void soutGridColor(String[][] thisGridColor){
        for (int i = 0; i < nrCols; i++) {
            for (int j = 0; j <nrRows ; j++) {
                System.out.println(thisGridColor[i][j]);
            }
        }
    }

    public void setCurrentPos(int[] currentPos) {
        this.currentPos = currentPos;
    }

    public void setGridColor(String[][] gridColor) {
        this.gridColor = gridColor;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public int[] getCurrentPos() {
        return currentPos;
    }

    public int getNrRows() {
        return nrRows;
    }

    public int getNrCols() {
        return nrCols;
    }

    public String[][] getGridColor() {
        return gridColor;
    }
}
