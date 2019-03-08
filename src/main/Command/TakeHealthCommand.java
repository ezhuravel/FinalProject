package main.Command;

import main.Tank;

public class TakeHealthCommand implements PlayerCommand {
    private Tank tank;

    public TakeHealthCommand(Tank t){
        tank = t;
    }


    @Override
    public void execute() {
        tank.setHealth(10);
    }

    @Override
    public void undo() {
        tank.setHealth(-10);
    }
}
