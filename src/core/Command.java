package core;

import java.awt.*;

public class Command {
    public Point pos1;
    public Point pos2;

    public Point pos3;
    public Point pos4;
    public int cmdIndex;

    public Command() {

    }

    public Command(Point pos1, Point pos2, int cmdIndex) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.cmdIndex = cmdIndex;
    }

    public Command(Point pos1, Point pos2, Point pos3, Point pos4, int cmdIndex) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.pos4 = pos4;
        this.cmdIndex = cmdIndex;
    }

    public static Command build() {
        return new Command();
    }

    public Command setPos1(Point pos1) {
        this.pos1 = pos1;

        return this;
    }

    public Command setPos2(Point pos2) {
        this.pos2 = pos2;

        return this;
    }

    public Command setPos3(Point pos3) {
        this.pos3 = pos3;

        return this;
    }

    public Command setPos4(Point pos4) {
        this.pos4 = pos4;

        return this;
    }

    public Command setCmdIndex(int cmdIndex) {
        this.cmdIndex = cmdIndex;

        return this;
    }
}
