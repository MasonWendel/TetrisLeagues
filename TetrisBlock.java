import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class TetrisBlock {
    private int x,y; 
    private int[][] shape; 
    private Color color;
    private boolean isMoving; 
    
    

    public TetrisBlock(int[][] shape, Color color, int x, int y) {
        this.shape = shape;
        this.color = color;

        this.x=x; 
        this.y=y;

        isMoving = true; 

        if(color.equals(Color.BLUE)){
            rotateRight();
        }
        
    }

    public ArrayList<Integer> getBottomEdges(){
        ArrayList<Integer> arr = new ArrayList<Integer>(getWidth());
        for(int i = 0; i<getWidth(); i++){
            arr.add(0);
        }
        for(int i = getHeight()-1; i>=0; i--){
            for(int j = 0; j<getWidth(); j++){
                if(shape[i][j]==1&&arr.get(j)==0){
                    arr.set(j,(getY()+getHeight()+1)-(getHeight()-i)); 
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

    public int[][] transposeShape(int[][] shape){
        int[][] arr = new int[shape[0].length][shape.length];
        for(int c = 0; c<shape[0].length; c++){
            for(int r=0; r<shape.length; r++){
                arr[c][r] = shape[r][c];
            }
        }
        return arr;
    }

    public int[][] reverseRows(int[][] arr){
        for(int i = 0; i<arr.length/2; i++){
            int[] holder = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = holder; 
        }
        return arr;
    }

    public int[][] reverseCols(int[][] arr){
        for (int[] row : arr) {
            for(int i = 0; i<row.length/2; i++){
            int holder = row[i];
            row[i] = row[row.length-1-i];
            row[row.length-1-i] = holder; 
        }
        }
        return arr;
    }

    public void rotateRight(){
        shape = reverseCols(transposeShape(shape));
    }

    public void rotateLeft(){
        shape = reverseRows(transposeShape(shape));
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

    public void setMoving(boolean b){
        isMoving = b; 
    }
    
    public boolean isMoving(){
        return isMoving; 
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
