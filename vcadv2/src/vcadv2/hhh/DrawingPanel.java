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
	private boolean drawing;
	private MouseAdapter mouseListener;
	private MouseAdapter mouseMotionListener;
	public DrawingPanel() {
		this.setOpaque(false);
		drawing = false;
		this.configureLiteners();
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseMotionListener);
	}
	public void subscribe(AbstractDrawer ad) {
		this.drawer = ad;
	}
	

	
	public AbstractDrawer getDrawer() {
		return drawer;
	}



	public void setDrawer(AbstractDrawer drawer) {
		this.drawer = drawer;
	}
	
	public void removeDrawer() {
		this.drawer = null;
	}



	public boolean isDrawing() {
		return drawing;
	}



	public void setDrawing(boolean drawing) {
		this.drawing = drawing;
	}
	
	public void configureLiteners(){
		this.mouseListener =new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			drawer.update(e);
			repaint();
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			drawer.update(e);
			repaint();
		}
	};
	this.mouseMotionListener = new MouseAdapter() {
		@Override
		public void mouseMoved(MouseEvent e) {
			drawer.update(e);
			repaint();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			drawer.update(e);
			repaint();
		}
	};
	}



	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(isDrawing()) {			
			drawer.designMyself(g2d);
		}else {
			//this.drawing=false;
		}
		
	}
}
