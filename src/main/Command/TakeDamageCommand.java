package main.Command;
import main.Factory.Tank;


public class TakeDamageCommand implements PlayerCommand {
    private Tank tank;

    public TakeDamageCommand(Tank t){
        tank = t;
    }

    @Override
    public void execute() {
        tank.setHealth(-30);
    }

    @Override
    public void undo() {
        tank.setHealth(10);
    }
}
