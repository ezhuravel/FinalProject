package main;

import javax.swing.ImageIcon;

public class Tank extends Sprite{

    public Tank() {
        ImageIcon ii = new ImageIcon("src/Resources/tankLeft.png");
        loadImage(ii);
    }

    public void turn(int x, int y){
       ImageIcon ii = new ImageIcon("src/Resources/tankLeft.png");;

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
