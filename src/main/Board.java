package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private Tank tank;
    private final int DELAY = 10;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        setFocusable(true);
        addKeyListener(new TAdapter());
        setBackground(Color.black);

        tank = new Tank();

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
        g2d.drawImage(tank.getImage(), tank.getX(), tank.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }

    private void step() {
        tank.move();

        repaint(tank.getX() - 1, tank.getY() - 1, tank.getWidth() - 2, tank.getHeight() - 2);
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
               tank.turn(2, 0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                tank.setDx(2);
                tank.turn(-2, 0);
            }

            if (key == KeyEvent.VK_UP) {
                tank.setDy(-2);
                tank.turn(0, 2);
            }

            if (key == KeyEvent.VK_DOWN) {
                tank.setDy(2);
                tank.turn(0, -2);
            }
        }
    }
}
