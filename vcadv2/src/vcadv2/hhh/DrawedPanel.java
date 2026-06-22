package vcadv2.hhh;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class DrawedPanel extends JPanel{
	private List<Shape> shapes;
	public DrawedPanel() {
		this.shapes = new LinkedList<Shape>();
		this.setOpaque(false);
	}
	
	public void add(Shape s) {
		shapes.add(s);
		repaint();
	}
	public void remove(Shape s) {
		shapes.remove(s);
		repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for(Shape s: shapes) {
			g2d.setColor(Color.YELLOW);
			g2d.setStroke(new BasicStroke(2));
			g2d.draw(s);
		}
	}
}
