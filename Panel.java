import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class Panel extends JPanel {
	private static final Dimension PANEL_SIZE = new Dimension(200, 100);
	
	public Panel(){
		this.setSize(200,200);
		this.setBackground(Color.GREEN);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
		for(int i = 0; i<200 ; i++){
			g.fillOval(i, i, 30, 30);
		}
		
	}

}