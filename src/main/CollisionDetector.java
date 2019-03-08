package main;

import java.awt.*;
import java.util.ArrayList;

public class CollisionDetector {
    private PlayerCommand enemyCollision;
    private PlayerCommand healthCollision;

    public void setEnemyCollison(PlayerCommand command){
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

                    if(s.getType() == 1){
                        healthCollision.execute();
                    }
                    switch (s.getType()){
                        case 1:
                            healthCollision.execute();
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
