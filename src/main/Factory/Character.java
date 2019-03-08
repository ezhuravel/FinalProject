package main.Factory;

public abstract class Character {
    private Sprite sprite;


    public Character(){
        sprite = new Sprite();
    }

    public Sprite getSprite(){
        return sprite;
    }

    public void setPostion(int x, int y){
        sprite.setPosition(x, y);
    }

    public abstract int getType();
}
