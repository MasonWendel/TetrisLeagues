//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.BorderFactory;
//import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.Border;

//import java.awt.Dimension;

public class Panel extends JPanel {
 
	private ArrayList<TetrisBlock> blocks = new ArrayList<TetrisBlock>();

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
		TetrisBlock block = new TetrisBlock(new int[][]{{1,0},{1,0},{1,1}}, Color.GREEN , 7,-3);
		blocks.add(block);
	}

	public void spawnBlock(int[][] shape, Color c, int x, int y){
		TetrisBlock block = new TetrisBlock(shape, c, x ,y);
		blocks.add(block);
	}

	public boolean moveBlocks(){
		for (TetrisBlock block : blocks) {
			if(checkBottom(block)){
				block.moveDown();
				repaint();
				//return true;
			} 
			
		}	
		return true; 
	}

	public boolean checkBottom(TetrisBlock block){
		System.out.println(overBlock(block));
		return block.getBottomEdge() != gridRows&&(block.getBottomEdge()!=overBlock(block));
	}
	public int overBlock(TetrisBlock block){
		for (TetrisBlock b: blocks) {
			if(!b.equals(block)){
				if(!(b.getX()<block.getX()-b.getWidth()||b.getX()>block.getX()+block.getWidth())){
					//return 	b.getTopEdge();
					for(int i =0; i<block.getWidth(); i++){
						if(block.getShape()[block.getHeight()][i] == 0){
							
						}
					}
				} 
			}
		}
		return -1; 
	}

	public void drawBlock(Graphics g){
		for (TetrisBlock block : blocks) {
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
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Graphics2D g2d = (Graphics2D) g;
		drawBlock(g);
	}

}