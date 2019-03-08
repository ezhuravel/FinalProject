package main.State;

import main.Factory.Tank;

public class PlayerDeadState implements PlayerState {
    private Tank player;

    public PlayerDeadState(Tank t){
        player = t;
    }

    @Override
    public String getGameStatus() {
        return "Game Over";
    }

    public void moveSprite(){

    }
}
