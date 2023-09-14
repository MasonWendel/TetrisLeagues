import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class TetrisBlock {
    private int x,y; 
    private int[][] shape; 
    private Color color;
    
    

    public TetrisBlock(int[][] shape, Color color, int x, int y) {
        this.shape = shape;
        this.color = color;

        this.x=x; 
        this.y=y;
    }

    public ArrayList<Integer> getBottomEdges(){
        ArrayList<Integer> arr = new ArrayList<Integer>(getWidth());
        for(int i = 0; i<getWidth(); i++){
            arr.add(0);
        }
        for(int i = getHeight()-1; i>=0; i--){
            for(int j = 0; j<getWidth(); j++){
                if(shape[i][j]==1&&arr.get(j)==0){
                    arr.set(j,getY()+(getHeight()-i)); 
                }
            }
        }
        return arr; 
    }
    public ArrayList<Integer> getTopEdges(){
        ArrayList<Integer> arr = new ArrayList<Integer>(getWidth());
        for(int i = 0; i<getWidth(); i++){
            arr.add(0);
        }
        for(int i = 0; i<getHeight(); i++){
            for(int j = 0; j<getWidth(); j++){
                if(shape[i][j]==1&&arr.get(j)==0){
                    arr.set(j,getY()+i); 
                }
            }
        }
        return arr; 
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getWidth(){
        return shape[0].length;
    }

    public int getHeight(){
        return shape.length; 
    }

    public int[][] getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public int getBottomEdge(){
        return shape.length + getY(); 
    }
    public int getTopEdge(){
        return getY(); 
    }

    public void moveDown(){
        y++;
    }

    public void moveRight(){
        x++;
    }

    public void moveLeft(){
        x--;
    }
    
}
