//import javax.swing.JPanel;

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
                mainPanel.spawnBlock();
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
