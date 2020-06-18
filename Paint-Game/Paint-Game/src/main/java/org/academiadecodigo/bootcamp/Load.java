package org.academiadecodigo.bootcamp;

import graphics.Color;

import java.io.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class Load {


    public String[][] load(String[][] savedGridColor, int nrRows, int nrCols) {
        String[][] gridCol = new String[nrRows][nrCols];

        for (int i = 0; i < nrRows; i++) {
            for (int j = 0; j < nrCols; j++) {
                gridCol[i][j] = savedGridColor[i][j];
            }
        }
        return gridCol;
    }

}
