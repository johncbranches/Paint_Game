package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.*;
import java.text.BreakIterator;

public class Save {

    public void save(String[][] gridCol, int nrRows, int nrCols) throws FileNotFoundException, IOException {
        boolean isBlack = false;
       /* String pathSpecial = this.getClass().getClassLoader().getResource("saved.txt").toExternalForm();
        System.out.println(pathSpecial);*/
        String path;
        String incPath = System.getProperty("user.dir");

        if(incPath.substring(incPath.length()-5).equals("build")) {
            path = incPath.substring(0, incPath.length() - 5);
        } else {
            path = incPath;
        }
        FileWriter fileWriter = new FileWriter(path + File.separator +"resources" + File.separator +"saved.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        for (int i = 0; i < nrRows; i++) {
            for (int j = 0; j < nrCols; j++) {

                    bufferedWriter.write(gridCol[i][j] + "\n");



            }
        }


        bufferedWriter.close();
    }
}
