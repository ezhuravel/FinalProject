package main;
import javax.swing.ImageIcon;

public class Tank extends Character {
    private static Tank playerTank;
    private int health;



    private Tank() {
        setHealth(100);
        ImageIcon ii = new ImageIcon("src/Resources/craft.png");
        getSprite().loadImage(ii);
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

    public int getType(){
        return 0;
    }
}
