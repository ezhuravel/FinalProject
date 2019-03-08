package main;

import main.Command.CollisionDetector;
import main.Command.TakeDamageCommand;
import main.Command.TakeHealthCommand;
import main.Factory.Character;
import main.Factory.CharacterFactory;
import main.Factory.Tank;

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
    private ArrayList<Character> characters = new ArrayList<>();
    private final int DELAY = 10;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        setFocusable(true);
        addKeyListener(new TAdapter());
        setBackground(Color.black);

        CharacterFactory characterFactory = new CharacterFactory();
        tank = (Tank)characterFactory.CreateCharacter("Player");


        characters.add(tank);

        // add 5 random power ups
        for(int i =0; i<= 5; i++){
            characters.add(characterFactory.CreateCharacter("Health"));
        }

        // add 15 random enemies
        for(int i =0; i<= 15; i++){
            characters.add(characterFactory.CreateCharacter("Enemy"));
        }


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

        for(Character s : characters){
            g2d.drawImage(s.getSprite().getImage(), s.getSprite().getX(), s.getSprite().getY(), this);
        }
        g.setColor(Color.WHITE);
        g.drawString(tank.getGameStatus(), 5, 15);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();

        CollisionDetector cd = new CollisionDetector();
        TakeHealthCommand healthCommand = new TakeHealthCommand(tank);
        TakeDamageCommand damageCommand = new TakeDamageCommand(tank);
        cd.setHealthCollision(healthCommand);
        cd.setEnemyCollision(damageCommand);

        cd.collide(characters, tank);

    }

    private void step() {
        tank.movePlayer();

        for(Character s : characters){
            repaint(s.getSprite().getX() - 1, s.getSprite().getY() - 1, s.getSprite().getWidth() + 3, s.getSprite().getHeight() + 3);
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                tank.getSprite().setDx(0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                tank.getSprite().setDx(0);
            }

            if (key == KeyEvent.VK_UP) {
                tank.getSprite().setDy(0);
            }

            if (key == KeyEvent.VK_DOWN) {
                tank.getSprite().setDy(0);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
               tank.getSprite().setDx(-2);
            }

            if (key == KeyEvent.VK_RIGHT) {
                tank.getSprite().setDx(2);
            }

            if (key == KeyEvent.VK_UP) {
                tank.getSprite().setDy(-2);
            }

            if (key == KeyEvent.VK_DOWN) {
                tank.getSprite().setDy(2);
            }
        }
    }
}
