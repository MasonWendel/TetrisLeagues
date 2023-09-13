//import javax.swing.JPanel;

import java.awt.Color;

public class GameThread extends Thread {
    
    private Panel mainPanel; 

    public GameThread(Panel p){
        this.mainPanel = p;
    }

    public void run(){
        int count = 0; 
        while(true){
            if(count == 8){
                System.out.println("Works");
                mainPanel.spawnBlock(new int[][]{{1,0},{1,0},{1,1}}, Color.BLUE, 8,-3);
            }
            boolean check = mainPanel.moveBlocks();
            System.out.println(check);
            while(check){
                try {
                    Thread.sleep(1000);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
