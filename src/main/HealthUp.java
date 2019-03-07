package main;

import javax.swing.*;

public class HealthUp extends Sprite {

    public HealthUp(){
        ImageIcon ii = new ImageIcon("src/Resources/healthUp.png");
        loadImage(ii);

        setPostion(100, 100);
    }
}
