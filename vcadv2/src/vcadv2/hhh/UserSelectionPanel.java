package vcadv2.hhh;

import javax.swing.JButton;
import javax.swing.JPanel;

public class UserSelectionPanel extends JPanel{
	private JButton line;
	private JButton circle;
	private JButton square;
	private DrawingPanel dp;
	private DrawedPanel dpp;
	public UserSelectionPanel(DrawingPanel dp, DrawedPanel dpp) {
		line = new JButton("Line");
		circle = new JButton("Circle");
		square = new JButton("Square");
		this.add(line);
		this.add(circle);
		this.add(square);
		this.dp = dp;
		this.dpp = dpp;
		this.dp.setDrawer(new LineDrawer(dp, dpp));
		line.addActionListener(e->{
			this.dp.getDrawer().removeML();
			this.dp.setDrawer(new LineDrawer(dp, dpp));
		});
		circle.addActionListener(e->{
			this.dp.getDrawer().removeML();
			this.dp.setDrawer(new CircleDrawer(dp, dpp));
		});
	}
}
