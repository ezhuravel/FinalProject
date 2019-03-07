package main;

import javax.swing.ImageIcon;

public class Tank extends Sprite{

    private int power = 10;
    private int health = 100;

    public Tank() {
        ImageIcon ii = new ImageIcon("src/Resources/craft.png");
        loadImage(ii);
    }

    public void turn(int x, int y){
       ImageIcon ii = new ImageIcon("src/Resources/tankLeft.png");

        if(x > 0){
            ii = new ImageIcon("src/Resources/tankLeft.png");

        }
        else if(x < 0){
            ii = new ImageIcon("src/Resources/tankRight.png");
        }
        else if (y > 0){
            ii = new ImageIcon("src/Resources/tankUp.png");
        }
        else if (y < 0){
            ii = new ImageIcon("src/Resources/tankDown.png");
        }

        loadImage(ii);
    }
}
