package main;
import javax.swing.JFrame;


public class FinalProject extends JFrame{

    public FinalProject() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setTitle("Moving sprite");
        setSize(1000, 1000);

        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        FinalProject ex =  new FinalProject();
        ex.setVisible(true);
    }
}


