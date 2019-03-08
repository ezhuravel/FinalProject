package main.Factory;

import main.State.PlayerAliveState;
import main.State.PlayerDeadState;
import main.State.PlayerState;

import javax.swing.ImageIcon;

public class Tank extends Character {
    private static Tank playerTank;
    private int health;
    private PlayerAliveState playerAliveState;
    private PlayerDeadState playerDeadState;
    private PlayerState currentState;


    private Tank() {
        setHealth(100);
        ImageIcon ii = new ImageIcon("src/Resources/craft.png");
        getSprite().loadImage(ii);

        //set states
        playerAliveState = new PlayerAliveState(this);
        playerDeadState = new PlayerDeadState(this);
        currentState = playerAliveState;
    }

    public static Tank getTankInstance(){
        if(playerTank == null){
            playerTank = new Tank();
        }

        return playerTank;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int amount){
        health += amount;
    }

    public void movePlayer(){
      currentState.moveSprite();
    }

    public int getType(){
        return 0;
    }

    public void setState(PlayerState state){
        currentState = state;
    }

    public PlayerState getPlayerAliveState(){
        return playerAliveState;
    }

    public PlayerState getPlayerDeadState(){
        return playerDeadState;
    }

    public String getGameStatus(){
        return currentState.getGameStatus();
    }
}
