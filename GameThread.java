//import javax.swing.JPanel;

public class GameThread extends Thread {
    
    private Panel mainPanel; 

    public GameThread(Panel p){
        this.mainPanel = p;
    }

    public void run(){
        while(true){
            boolean check = mainPanel.moveBlock();
            System.out.println(check);
            while(check){
                try {
                    Thread.sleep(1000);
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
