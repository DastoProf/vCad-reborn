package vcadv2.hhh;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DottedGrid extends AbstractGrid{

	public DottedGrid(int xStep, int yStep, int width, int height) {
		super(xStep, yStep, width, height);
	}
	public DottedGrid(int width, int height) {
		super(25, 25, width, height);
	}
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g2d);
		g2d.setColor(Color.WHITE);
		for(int j=0; j<=this.getHeight(); j+=this.getyStep()) {
			for(int i=0; i<=this.getWidth(); i+=this.getxStep()) {
				g2d.fillOval(i-2, j-2, 4, 4);
			}
		}
		
	}

}
