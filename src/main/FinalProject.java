package main;
import javax.swing.JFrame;


public class FinalProject extends JFrame{

    private static FinalProject uniqueInstance;

    public static FinalProject getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new FinalProject();
        }

        return uniqueInstance;
    }

    private FinalProject() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setTitle("Moving sprite");
        setSize(1000, 500);

        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        FinalProject ex = FinalProject.getInstance();
        ex.setVisible(true);
    }
}


