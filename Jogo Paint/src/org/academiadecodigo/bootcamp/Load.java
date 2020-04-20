package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class Load {


    public String[][] load(int nrRows, int nrCols) throws FileNotFoundException, IOException {
        String[][] gridCol = new String[nrRows][nrCols];


        String path;
        String incPath = System.getProperty("user.dir");

        if(incPath.substring(incPath.length()-5).equals("build")) {
            path = incPath.substring(0, incPath.length() - 5);
        } else {
            path = incPath;
        }
        FileReader fileReader = new FileReader(path + File.separator +"resources" + File.separator +"saved.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        for (int i = 0; i < nrRows; i++) {
            for (int j = 0; j < nrCols; j++) {
                gridCol[i][j] = bufferedReader.readLine();
            }

        }

        bufferedReader.close();
        return gridCol;
    }

}
