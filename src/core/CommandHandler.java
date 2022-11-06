package core;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class CommandHandler {
    public static String handle(Graphics g, List<Command> commandList) {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("ellipseMode(CORNER);%n"));

        for (Command command : commandList) {
            g.setColor(Color.DARK_GRAY);

            if (command.cmdIndex == 1) {
                g.fillRect(command.pos1.x, command.pos1.y, command.pos2.x, command.pos2.y);

                g.setColor(Color.RED);

                g.drawRect(command.pos1.x, command.pos1.y, command.pos2.x, command.pos2.y);

                builder.append(String.format("rect(%d, %d, %d, %d);%n", command.pos1.x, command.pos1.y,
                        command.pos2.x, command.pos2.y));
            } else if (command.cmdIndex == 2) {
                Polygon polygon = new Polygon(new int[]{command.pos1.x, command.pos2.x, command.pos3.x, command.pos4.x},
                        new int[]{command.pos1.y, command.pos2.y, command.pos3.y, command.pos4.y}, 4);

                g.fillPolygon(polygon);

                g.setColor(Color.RED);

                g.drawPolygon(polygon);

                builder.append(String.format("quad(%d, %d, %d, %d, %d, %d, %d, %d);%n", command.pos1.x, command.pos1.y,
                        command.pos2.x, command.pos2.y, command.pos3.x, command.pos3.y, command.pos4.x, command.pos4.y));
            } else if (command.cmdIndex == 3) {
                Graphics2D g2d = (Graphics2D) g;

                g2d.fill(new Ellipse2D.Double(command.pos1.x, command.pos1.y, command.pos2.x, command.pos2.y));

                g.setColor(Color.RED);
                g2d.draw(new Ellipse2D.Double(command.pos1.x, command.pos1.y, command.pos2.x, command.pos2.y));

                builder.append(String.format("ellipse(%d, %d, %d, %d);%n", command.pos1.x, command.pos1.y,
                        command.pos2.x, command.pos2.y));
            } else if (command.cmdIndex == 4) {
                Polygon polygon = new Polygon(new int[]{command.pos1.x, command.pos2.x, command.pos3.x},
                        new int[]{command.pos1.y, command.pos2.y, command.pos3.y}, 3);

                g.fillPolygon(polygon);

                g.setColor(Color.RED);
                g.drawPolygon(polygon);

                builder.append(String.format("triangle(%d, %d, %d, %d, %d, %d);%n", command.pos1.x,
                        command.pos1.y, command.pos2.x, command.pos2.y, command.pos3.x, command.pos3.y));
            }
        }

        if (commandList.size() > 0) {
            return builder.toString();
        }else{
            return "";
        }
    }
}
