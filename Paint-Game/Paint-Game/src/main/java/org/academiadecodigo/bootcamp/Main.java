package org.academiadecodigo.bootcamp;


import keyboard.Keyboard;
import keyboard.KeyboardEvent;
import keyboard.KeyboardEventType;
import keyboard.KeyboardHandler;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid();


        KeyboardHandler camelCase = new KeyBinds(grid);
/*JFrame frame = (JFrame) Window.getWindows()[0];
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

        Keyboard k = new Keyboard(camelCase);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent draw = new KeyboardEvent();
        draw.setKey(KeyboardEvent.KEY_SPACE);
        draw.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent undraw = new KeyboardEvent();
        undraw.setKey(KeyboardEvent.KEY_SPACE);
        undraw.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent exit = new KeyboardEvent();
        exit.setKey(KeyboardEvent.KEY_E);
        exit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent changeColor = new KeyboardEvent();
        changeColor.setKey(KeyboardEvent.KEY_M);
        changeColor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(moveLeft);
        k.addEventListener(moveRight);
        k.addEventListener(moveDown);
        k.addEventListener(moveUp);
        k.addEventListener(draw);
        k.addEventListener(undraw);
        k.addEventListener(exit);
        k.addEventListener(save);
        k.addEventListener(load);
        k.addEventListener(clear);
        k.addEventListener(changeColor);

        grid.init();
    }

}
