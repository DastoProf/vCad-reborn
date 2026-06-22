package vcadv2.hhh;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
	private AbstractDrawer drawer;
	private boolean erase;
	public DrawingPanel() {
		this.setOpaque(false);
		erase = false;
	}
	

	
	public AbstractDrawer getDrawer() {
		return drawer;
	}



	public void setDrawer(AbstractDrawer drawer) {
		this.drawer = drawer;
	}



	public boolean isErase() {
		return erase;
	}



	public void setErase(boolean erase) {
		this.erase = erase;
	}



	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(!isErase()) {			
			drawer.designMyself(g2d);
		}else {
			this.erase=false;
		}
		
	}
}
