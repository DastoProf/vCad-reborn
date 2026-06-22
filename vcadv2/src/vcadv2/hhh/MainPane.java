package vcadv2.hhh;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class MainPane extends JPanel{
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.drawString("Hello", 10, 10);
		g2.drawLine(10, 10, 200, 200);
	}
}
