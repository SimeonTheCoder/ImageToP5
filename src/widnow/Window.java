package widnow;

import core.Command;
import core.CommandHandler;
import keyboard.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Window extends JPanel {
    private JFrame frame;

    public static Point pos1;
    public static Point pos2;
    public static Point pos3;
    public static Point pos4;

    public static int KEY_BUFFER = 0;

    public List<Command> commandList;

    public String cmdSequence;

    public Window() {
        frame = new JFrame();

        frame.setSize(500, 500);
        frame.setTitle("Paint 2");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(this);

        frame.setVisible(true);

        frame.addKeyListener(new Keyboard(frame));

        commandList = new ArrayList<Command>();
    }

    private void resetPos() {
        pos1 = null;
        pos2 = null;
        pos3 = null;
        pos4 = null;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int mx = MouseInfo.getPointerInfo().getLocation().x - frame.getX() - 10;
        int my = MouseInfo.getPointerInfo().getLocation().y - frame.getY() - 30;

        mx = mx / 10 * 10;
        my = my / 10 * 10;

        g.setColor(Color.DARK_GRAY);

        if (pos1 != null) {
            g.fillRect(pos1.x, pos1.y, 5, 5);
        }

        if (pos2 != null) {
            g.fillRect(pos2.x, pos2.y, 5, 5);
        }

        if (pos3 != null) {
            g.fillRect(pos3.x, pos3.y, 5, 5);
        }

        if (pos4 != null) {
            g.fillRect(pos4.x, pos4.y, 5, 5);
        }

        if (KEY_BUFFER != 0) {
            if (KEY_BUFFER == 1) {
                commandList.add(
                        Command.build().setPos1(pos1)
                                .setPos2(new Point(pos2.x - pos1.x, pos2.y - pos1.y))
                                .setCmdIndex(1));

                resetPos();
            } else if (KEY_BUFFER == 2) {
                commandList.add(
                        Command.build()
                                .setPos1(pos1)
                                .setPos2(pos2)
                                .setPos3(pos3)
                                .setPos4(pos4)
                                .setCmdIndex(2)
                );

                resetPos();
            } else if (KEY_BUFFER == 3) {
                commandList.add(
                        Command.build()
                                .setPos1(pos1)
                                .setPos2(new Point(pos2.x - pos1.x, pos2.y - pos1.y))
                                .setCmdIndex(3)
                );

                resetPos();
            } else if (KEY_BUFFER == 4) {
                System.out.println(cmdSequence);
            } else if (KEY_BUFFER == 5) {
                commandList.add(
                    Command.build()
                            .setPos1(pos1)
                            .setPos2(pos2)
                            .setPos3(pos3)
                            .setCmdIndex(4)
                );

                resetPos();
            } else if (KEY_BUFFER == 6) {
                commandList.add(
                        Command.build()
                                .setPos1(pos1)
                                .setPos2(pos2)
                                .setCmdIndex(5)
                );

                resetPos();
            }

            KEY_BUFFER = 0;
        }

        cmdSequence = CommandHandler.handle(g, commandList);

        try {
            TimeUnit.MILLISECONDS.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        g.setColor(new Color(0, 0, 255, 120));

        for (int i = 0; i < 500; i += 20) {
            g.drawLine(i, 0, i, 500);
            g.drawString(String.valueOf(i), 0, i);
            g.drawLine(0, i, 500, i);
            g.drawString(String.valueOf(i), i, 20);
        }

        g.setColor(Color.RED);

        g.drawString(String.format("%d, %d", mx, my), mx, my);

        g.setColor(Color.GREEN);

        g.fillRect(mx, my, 5, 5);

        repaint();
    }
}
