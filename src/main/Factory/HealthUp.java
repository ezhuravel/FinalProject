package main.Factory;

import main.Factory.Character;

import javax.swing.*;

public class HealthUp extends Character {

    public HealthUp(){
        ImageIcon ii = new ImageIcon("src/Resources/healthUp.png");
        getSprite().loadImage(ii);
    }

    public int getType(){
        return 1;
    }
}
