package main.Command;
import main.Tank;


public class TakeDamageCommand implements PlayerCommand {
    private Tank tank;

    public TakeDamageCommand(Tank t){
        tank = t;
    }

    @Override
    public void execute() {
        tank.setHealth(-10);
    }

    @Override
    public void undo() {
        tank.setHealth(10);
    }
}
