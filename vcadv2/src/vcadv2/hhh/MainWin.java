package vcadv2.hhh;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainWin extends JFrame {
	private int width, height;
	private JLayeredPane layers;
	private JPanel panel, grid, uipane;
	private DrawingPanel drawingpane;
	private DrawedPanel dpp;

	public MainWin(int width, int height) throws HeadlessException {
		super();
		this.width = width;
		this.height = height;
		this.layers = new JLayeredPane();
		this.grid = new DottedGrid(width, height);
		this.grid.setOpaque(true);
		this.grid.setBackground(Color.BLUE);
		this.grid.setBounds(0, 0, width, height);
		this.panel = new MainPane();
		this.panel.setOpaque(false);
		this.panel.setBounds(0, 0, width, height);
		this.drawingpane = new DrawingPanel();
		this.drawingpane.setBounds(0, 0, width, height);
		this.dpp = new DrawedPanel();
		this.dpp.setBounds(0, 0, width, height);
		this.uipane = new UserSelectionPanel(this.drawingpane, this.dpp);
		this.uipane.setBounds(0, 0, width, height);
		this.uipane.setOpaque(false);
		this.layers.add(panel, Integer.valueOf(2));
		this.layers.add(grid, Integer.valueOf(1));
		this.layers.add(dpp, Integer.valueOf(3));
		this.layers.add(drawingpane, Integer.valueOf(4));
		this.layers.add(uipane, Integer.valueOf(5));
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setTitle("vCad-reborn");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(this.layers);
		this.setVisible(true);
	}
	
	
}
