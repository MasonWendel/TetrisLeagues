//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;

import javax.swing.BorderFactory;
//import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.Border;

//import java.awt.Dimension;

public class Panel extends JPanel {
	private TetrisBlock block; 

	private int WIDTH = 300;
	private int HEIGHT = 460; 

	private int gridRows; 
	private int gridCols;
	private int gridCellSize;
	
	public Panel(int cols){
		this.setBounds(195, 50, WIDTH, HEIGHT);
		this.setBackground(new Color(228, 228, 228));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		gridCols = cols; 
		gridCellSize = WIDTH/gridCols; 
		gridRows = HEIGHT/gridCellSize; 

		spawnBlock();
	}

	public void spawnBlock(){
		block = new TetrisBlock(new int[][]{{1,0},{1,0},{1,1}}, Color.GREEN);
	}

	public boolean moveBlock(){
		if(checkBottom()){
			block.moveDown();
			repaint();
			return true;
		} 
		return false; 
	}

	public boolean checkBottom(){
		return block.getBottomEdge() != gridRows;
	}

	public void drawBlock(Graphics g){
		for(int r=0; r<block.getWidth(); r++){
			for(int c=0; c<block.getHeight(); c++){
				if(block.getShape()[r][c]==1){
					g.setColor(block.getColor());
					g.fillRect((block.getX()*gridCellSize)+(c*gridCellSize),(block.getY()*gridCellSize)+(r*gridCellSize), gridCellSize, gridCellSize);
					g.setColor(Color.BLACK);
					g.drawRect((block.getX()*gridCellSize)+(c*gridCellSize),(block.getY()*gridCellSize)+(r*gridCellSize), gridCellSize, gridCellSize);
				}
			}
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Graphics2D g2d = (Graphics2D) g;
		drawBlock(g);
	}

}