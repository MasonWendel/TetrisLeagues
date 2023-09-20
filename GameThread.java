//import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

public class GameThread extends Thread {
    
    private Panel mainPanel; 

    public GameThread(Panel p){
        this.mainPanel = p;
    }

    MenuKeyListener listener = new MenuKeyListener() {
        public void menuKeyTyped(MenuKeyEvent e) {
            
         }
         public void menuKeyPressed(MenuKeyEvent e) {
            System.out.println(e.getKeyChar());
         }
         public void menuKeyReleased(MenuKeyEvent e) {
           
         }
    };

    public void run(){
        int count = 0; 
        while(true){

            boolean check = mainPanel.moveBlocks();
            
            check = mainPanel.getCurrBlock().isMoving();

            if(!check){
                mainPanel.spawnBlock(new int[][]{{1,0},{1,0},{1,1}}, Color.BLUE, 7,-3);
            }
            
            while(check){
                try {
                    Thread.sleep(500);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
