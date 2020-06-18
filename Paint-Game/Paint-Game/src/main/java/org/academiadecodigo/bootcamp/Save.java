package org.academiadecodigo.bootcamp;

import graphics.Color;

import java.io.*;
import java.net.URL;
import java.text.BreakIterator;

public class Save {

    public String[][] save(String[][] gridCol, int nrRows, int nrCols) {
        boolean isBlack = false;
        String[][] savedGridColor= new String[nrRows][nrCols];
        
        for(int i=0;i<nrRows;i++) {
        	for(int j=0; j<nrCols; j++) {
        		savedGridColor[i][j]= gridCol[i][j];
        	}
        }
        return savedGridColor;        
    }
}
