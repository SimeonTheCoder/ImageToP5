package keyboard;

import widnow.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private JFrame frame;

    public Keyboard(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int mx = MouseInfo.getPointerInfo().getLocation().x - frame.getX() - 10;
        int my = MouseInfo.getPointerInfo().getLocation().y - frame.getY() - 30;

        mx = mx / 10 * 10;
        my = my / 10 * 10;

        switch (e.getKeyChar()) {
            case '1':
                Window.pos1 = new Point(mx, my);

                break;

            case '2':
                Window.pos2 = new Point(mx, my);

                break;

            case '3':
                Window.pos3 = new Point(mx, my);

                break;

            case '4':
                Window.pos4 = new Point(mx, my);

                break;

            case 'f':
                Window.KEY_BUFFER = 1;

                break;

            case 'q':
                Window.KEY_BUFFER = 2;

                break;

            case 'e':
                Window.KEY_BUFFER = 3;

                break;

            case 'c':
                Window.KEY_BUFFER = 4;

                break;

            case 't':
                Window.KEY_BUFFER = 5;

                break;

            case 'l':
                Window.KEY_BUFFER = 6;

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
