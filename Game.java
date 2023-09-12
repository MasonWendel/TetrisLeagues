import javax.swing.JFrame;

public class Game extends JFrame{
    
    public Game(){
        super("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 600);
        this.add(new Panel());
    }
}
