//import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
//import javax.swing.JPanel;

public class Game extends JFrame{
    
    private Thread gameLoop;
    
    private Panel mainPanel; 

    public Game(){
        super("Game");
        this.getContentPane().setBackground(new Color(200, 200, 200));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 600);
        mainPanel = new Panel(15);
        this.add(mainPanel);

        gameLoop = new GameThread(mainPanel); 

        startGame();
    }

    public void startGame(){
        gameLoop.start();
    }
}
