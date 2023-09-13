import java.awt.Color;

public class TetrisBlock {
    private int x,y; 
    private int[][] shape; 
    private Color color;
    
    

    public TetrisBlock(int[][] shape, Color color) {
        this.shape = shape;
        this.color = color;

        x=7; 
        y=-3;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public int getWidth(){
        return shape.length; 
    }

    public int getHeight(){
        return shape[0].length;
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
