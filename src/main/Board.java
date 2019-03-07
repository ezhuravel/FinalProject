package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private Tank tank;
    private ArrayList<Sprite> sprites = new ArrayList<>();
    private final int DELAY = 10;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        setFocusable(true);
        addKeyListener(new TAdapter());
        setBackground(Color.black);

        tank = new Tank();
        HealthUp hu = new HealthUp();
        hu.setPostion(100,100);

        sprites.add(tank);
        sprites.add(hu);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for(Sprite s : sprites){
            g2d.drawImage(s.getImage(), s.getX(), s.getY(), this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
        Rectangle tanksRect = tank.getBounds();
        Sprite removedSprite = null;

        for(Sprite s : sprites){
            if (s !=  tank){
                Rectangle r2 = s.getBounds();

                if (tanksRect.intersects(r2)) {
                    removedSprite = s;
                }
            }
        }

        if(removedSprite != null){
            sprites.remove(removedSprite);
        }
    }

    private void step() {

        tank.move();
        for(Sprite s : sprites){

            repaint(s.getX() - 1, s.getY() - 1, s.getWidth() + 3, s.getHeight() + 3);
        }
        //repaint(tank.getX() - 1, tank.getY() - 1, tank.getWidth() + 3, tank.getHeight() + 3);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                tank.setDx(0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                tank.setDx(0);
            }

            if (key == KeyEvent.VK_UP) {
                tank.setDy(0);
            }

            if (key == KeyEvent.VK_DOWN) {
                tank.setDy(0);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
               tank.setDx(-2);
       //        tank.turn(2, 0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                tank.setDx(2);
         //       tank.turn(-2, 0);
            }

            if (key == KeyEvent.VK_UP) {
                tank.setDy(-2);
           //     tank.turn(0, 2);
            }

            if (key == KeyEvent.VK_DOWN) {
                tank.setDy(2);
             //   tank.turn(0, -2);
            }
        }
    }
}
