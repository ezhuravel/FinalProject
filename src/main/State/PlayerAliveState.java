package main.State;

import main.Factory.Tank;

public class PlayerAliveState implements PlayerState {
    private Tank player;

    public PlayerAliveState(Tank t){
        player = t;
    }

    @Override
    public String getGameStatus() {

       if(player.getHealth() <= 0) {
           player.setState(player.getPlayerDeadState());
       }

       return  "Health: " + player.getHealth();
    }

    public void moveSprite(){
        player.getSprite().move();
    }
}
