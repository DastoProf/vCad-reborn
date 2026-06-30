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
		this.hostpanel.subscribe(this);
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
	public abstract void update(MouseEvent e);
}
