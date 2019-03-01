package main;

import javax.swing.*;
import java.awt.*;

public abstract class  Sprite {
    private int dx;
    private int dy;
    private int x = 40;
    private int y = 60;
    private int w;
    private int h;
    protected Image image;

    public void move() {

        x += dx;
        y += dy;
    }

    public  void setDx(int dx){
        this.dx = dx;
    }

    public void setDy(int dy){
        this.dy = dy;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public int getWidth() {

        return w;
    }

    public int getHeight() {

        return h;
    }

    public Image getImage() {

        return image;
    }

    public void loadImage(ImageIcon imageIcon) {


        image = imageIcon.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }
}
