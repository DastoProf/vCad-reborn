package vcadv2.hhh;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class AbstractGrid extends JPanel{
	private int xStep, yStep, width, height;

	public AbstractGrid(int xStep, int yStep, int width, int height) {
		super();
		this.xStep = xStep;
		this.yStep = yStep;
		this.width = width;
		this.height = height;
	}
	
	public AbstractGrid(int width, int height) {
		this(20, 20, width, height);
	}

	public int getxStep() {
		return xStep;
	}

	public void setxStep(int xStep) {
		this.xStep = xStep;
	}

	public int getyStep() {
		return yStep;
	}

	public void setyStep(int yStep) {
		this.yStep = yStep;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public abstract void paint(Graphics g);
	
}
