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
	private boolean drawing;
	public CircleDrawer(DrawingPanel hostpanel, DrawedPanel dpp) {
		super(hostpanel, dpp);
		this.drawing = false;
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
	@Override
	public void update(MouseEvent e) {
		if(e.getID()==MouseEvent.MOUSE_PRESSED) {
			this.drawing = true;
			this.startingPoint = e.getPoint();
			this.endingPoint = e.getPoint();
			this.getHostpanel().setDrawing(drawing);
		}else if(e.getID()==MouseEvent.MOUSE_RELEASED ) {
			this.drawing = false;
			this.endingPoint = e.getPoint();
			this.getDpp().add(this.returnMyself());
			this.getHostpanel().setDrawing(drawing);
		}
		if(e.getID()==MouseEvent.MOUSE_DRAGGED) {
			this.endingPoint = e.getPoint();
		}
		
	}
}
