package vcadv2.hhh;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public abstract class AbstractDrawer {
	private DrawingPanel hostpanel;
	private DrawedPanel dpp;
	
	public AbstractDrawer(DrawingPanel hostpanel, DrawedPanel dpp) {
		this.hostpanel = hostpanel;
		this.dpp = dpp;
		
	}
	
	public void configureLiteners(){
		/*this.mouseListener =new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				drawing = !drawing;
				if(drawing) {
					startingPoint = e.getPoint();	
					endingPoint = null;
					addMML();
				}else {
					endingPoint= e.getPoint();
					removeMML();
				}
				repaint();
			}
		};
		this.mouseMotionListener = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(drawing && startingPoint != null) {
					endingPoint = e.getPoint();
					repaint();
				}
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				if(drawing && startingPoint != null) {
					endingPoint = e.getPoint();
					repaint();
				}
			}
		};*/
	}
	public void addMML() {
		//this.addMouseMotionListener(mouseMotionListener);
	}
	public void removeMML() {
		//this.removeMouseMotionListener(mouseMotionListener);
	}
	


	public DrawingPanel getHostpanel() {
		return hostpanel;
	}

	public void setHostpanel(DrawingPanel hostpanel) {
		this.hostpanel = hostpanel;
	}
	

	public DrawedPanel getDpp() {
		return dpp;
	}

	public void setDpp(DrawedPanel dpp) {
		this.dpp = dpp;
	}

	public abstract void designMyself(Graphics2D g2d);
	public abstract Shape returnMyself();
}
