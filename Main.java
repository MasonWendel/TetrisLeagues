//import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    private static Game game = new Game();
    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        game.setVisible(true);
      }
    });
  }
}
