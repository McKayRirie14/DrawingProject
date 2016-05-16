package ctec.view;

import javax.swing.*;

/**
 * @author mrir2917
 * @version 0.x Apr 22, 2016
 */
public class DrawingFrame 
{
	private DrawingPanel basePanel;
	private DrawingController baseController;
	
	public DrawingFrame(DrawingController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(BasePanel);
		this.setTitle("Drawing stuff in Java");
		this.setSize(800,800);
		this.setVisible(true);
	}
}
