package main.Factory;

import main.Factory.Character;

import javax.swing.*;

public class Enemy extends Character {
    public Enemy(){
        ImageIcon ii = new ImageIcon("src/Resources/powerUp.png");
        getSprite().loadImage(ii);
    }

    public int getType(){
        return 2;
    }
}
