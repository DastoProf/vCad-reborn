package vcadv2.hhh;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.EventListener;

import javax.swing.JPanel;

public class LineDrawer extends AbstractDrawer{
	private Point startingPoint = null;
	private Point endingPoint = null;
	
	private boolean drawing;
	public LineDrawer(DrawingPanel hostpanel, DrawedPanel dpp) {
		super(hostpanel, dpp);
		this.drawing = false;
	}
	

	@Override
	public void designMyself(Graphics2D g2d) {
		if(startingPoint != null && this.endingPoint != null) {
			g2d.setColor(Color.WHITE);
			g2d.setStroke(new BasicStroke(2));
			g2d.drawLine(startingPoint.x, startingPoint.y, endingPoint.x, endingPoint.y);
		}
	}
	@Override
	public Shape returnMyself() {
		Line2D line = new Line2D.Double(startingPoint.x, startingPoint.y, endingPoint.x, endingPoint.y);
		return line;
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
