package vcadv2.hhh;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class CircleDrawer extends AbstractDrawer{
	private Point startingPoint = null;
	private Point endingPoint = null;
	private MouseAdapter mouseListener;
	private MouseAdapter mouseMotionListener;
	private boolean drawing;
	public CircleDrawer(DrawingPanel hostpanel, DrawedPanel dpp) {
		super(hostpanel, dpp);
		this.drawing = false;
		this.configureLiteners();
		getHostpanel().addMouseListener(mouseListener);
	}
	@Override
	public void configureLiteners(){
		this.mouseListener =new MouseAdapter() {
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
				getHostpanel().setErase(true);
				getDpp().add(returnMyself());
			}
			//getHostpanel().repaint();
		}
	};
	this.mouseMotionListener = new MouseAdapter() {
		@Override
		public void mouseMoved(MouseEvent e) {
			if(drawing && startingPoint != null) {
				endingPoint = e.getPoint();
				getHostpanel().repaint();
			}
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			if(drawing && startingPoint != null) {
				endingPoint = e.getPoint();
				getHostpanel().repaint();
			}
		}
	};
	}
	@Override
	public void addMML() {
		getHostpanel().addMouseMotionListener(mouseMotionListener);
	}
	@Override
	public void removeMML() {
		getHostpanel().removeMouseMotionListener(mouseMotionListener);
	}
	@Override
	public void removeML() {
		getHostpanel().removeMouseListener(mouseListener);
	}
	@Override
	public void designMyself(Graphics2D g2d) {
		if(startingPoint != null && this.endingPoint != null) {
			g2d.setColor(Color.WHITE);
			g2d.setStroke(new BasicStroke(2));
			//g2d.drawLine(startingPoint.x, startingPoint.y, endingPoint.x, endingPoint.y);
			int dist = (int)Point.distance(startingPoint.x, startingPoint.y, endingPoint.x, endingPoint.y);
			g2d.drawOval(startingPoint.x, startingPoint.y, dist, dist);
		}
	}
	@Override
	public Shape returnMyself() {
		int dist = (int)Point.distance(startingPoint.x, startingPoint.y, endingPoint.x, endingPoint.y);
		Ellipse2D el = new Ellipse2D.Double(startingPoint.x, startingPoint.y, dist, dist);
		return el;
	}
}
