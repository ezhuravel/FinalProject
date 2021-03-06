package main.Command;

import main.Factory.Character;
import main.Factory.Tank;

import java.awt.*;
import java.util.ArrayList;

public class CollisionDetector {
    private PlayerCommand enemyCollision;
    private PlayerCommand healthCollision;

    public void setEnemyCollision(PlayerCommand command){
        enemyCollision = command;
    }

    public void setHealthCollision(PlayerCommand command){
        healthCollision = command;
    }

    public void collide(ArrayList<Character> characters, Tank player){

        Rectangle tanksRect = player.getSprite().getBounds();
        Character removedCharacter = null;

        for(Character s : characters){
            if (s !=  player){
                Rectangle r2 = s.getSprite().getBounds();

                if (tanksRect.intersects(r2)) {
                    switch (s.getType()){
                        case 1:
                            healthCollision.execute();
                            break;
                        case 2:
                            enemyCollision.execute();
                            break;
                    }

                    removedCharacter = s;
                }
            }
        }

        if(removedCharacter != null){
            characters.remove(removedCharacter);
        }
    }
}
