package ctec.view;

import javax.swing.*;
import ctec.controller.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author mrir2917
 * @version 0.x Apr 22, 2016
 */
public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private ShapePanel shapePanel;
	private JButton addRectangleButton;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		addRectangleButton = new JButton("Add a rectangle");
		rectangleList = new ArrayList<Rectangle>();
		shapePanel =  new ShapePanel();

		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		this.add(addRectangleButton);
		this.add(shapePanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, addRectangleButton, 10, SpringLayout.WEST)
	}
	private void setupListeners()
	{
		addRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int) (Math.random() * getWidth());
				int yPosition = (int) (Math.random() * getWidth());
				int width = (int) (Math.random() * 100);
				int height = (int) (Math.random() * 100);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		mainGraphics.setStroke(new BasicStroke(20));
		mainGraphics.setColor(Color.ORANGE);
		mainGraphics.drawRect(50, 70, 200, 400);
		
		
		for(Rectangle current : rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(current);
		}
		
	}
	
	
}
