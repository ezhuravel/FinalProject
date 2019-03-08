package main.Factory;

import java.util.Random;

public class CharacterFactory {

    private int MAX_X = 950;
    private int MIN_X = 50;

    private int MAX_Y = 950;
    private int MIN_Y = 50;

    public Character CreateCharacter(String type){
        Character createdCharacter = null;
        Random random = new Random();

        // get random position on the board
        int randX = random.nextInt(MAX_X + 1 - MIN_X) + MIN_X;
        int randY = random.nextInt(MAX_Y + 1 - MIN_Y) + MIN_Y;

        switch (type) {
            case "Player":
                createdCharacter = Tank.getTankInstance();
                createdCharacter.setPostion(randX,randY);
                break;
            case "Health":
                createdCharacter = new HealthUp();
                createdCharacter.setPostion(randX,randY);
                break;
            case "Enemy":
                createdCharacter = new Enemy();
                createdCharacter.setPostion(randX,randY);
                break;
        }
        return createdCharacter;
    }
}
