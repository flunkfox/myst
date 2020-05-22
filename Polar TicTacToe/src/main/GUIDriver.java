package main;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class GUIDriver
{
	/** The main panel containing the game components. */
    private JPanel panel;
    
	public static void main(String[] argv)
	{
		int frameWidth = 717;
		int frameHeight = 740;
	    
		JFrame f = new JFrame();
		f.add(new CustomPaintComponent());
		f.setSize(frameWidth, frameHeight);
		f.setResizable(false);
		f.setVisible(true);
		f.setPreferredSize(new Dimension(700, 700));
	}
	

	/**
 * To draw on the screen, it is first necessary to subclass a Component 
 * and override its paint() method. The paint() method is automatically called 
 * by the windowing system whenever component's area needs to be repainted.
 */
static class CustomPaintComponent extends Component 
{

	private Polygon[][] cube;
	
	public void paint(Graphics g) 
	{

		// Retrieve the graphics context; this object is used to paint shapes
		
		Graphics2D g2d = (Graphics2D)g;

		// Draw an oval that fills the window

		int x = 1;
		int y = 1;
		int realwidth = getSize().width-1;
		int realheight = getSize().height-1;
		int w = realwidth/10;
		int h = realheight/10;
		//thickness of the lines
		g2d.setStroke(new BasicStroke(2));

		/**
		 * The coordinate system of a graphics context is such that the origin is at the 
		 * northwest corner and x-axis increases toward the right while the y-axis increases 
		 * toward the bottom.
		 */

		//abstract coordinate array for easy access.
		int r = realheight/2;
		double radians = Math.toRadians(30);
		int b = (int)(Math.sin(radians)*r);
		int l = (int)(Math.cos(radians)*r);
		
		//initialize the array of polygons
		int[] c = new int[4];
		
		// to draw a filled oval use : g2d.fillOval(x, y, w, h) instead
		
		/* old oval commands
		g2d.drawOval(x, y, 8*w, 8*h);
		g2d.drawOval(x+1*w, y+1*h, 6*w, 6*h);
		g2d.drawOval(x+2*w, y+2*h, 4*w, 4*h);
		g2d.drawOval(x+3*w, y+3*h, 2*w, 2*h);
		*/
		
		//System.out.println("height: " + realheight);
		//System.out.println("width: " + realwidth);
		//System.out.println("radius: " + r);
		
		//g2d.drawLine(r-b, r-l, r+b, r+l);
		//g2d.drawLine(r+b, r-l, r-b, r+l);
		//g2d.drawLine(r, 0, r, 2*r);
		
		/*initialize polygon array
		cube = new Polygon[4];
		cube[0] = new Polygon();
		cube[0].addPoint((int) (r-(.866*5*w)), (int) (r-(.5*5*w)));
		cube[0].addPoint(r, 0);
		cube[0].addPoint(r, w);
		cube[0].addPoint((int) (r-(.866*4*w)), (int) (r-(.5*4*w)));
		
		cube[1] = new Polygon();
		cube[1].addPoint((int) (r-(.866*3*w)), (int) (r-(.5*3*w)));
		cube[1].addPoint(r, w);
		cube[1].addPoint(r, 2*w);
		cube[1].addPoint((int) (r-(.866*2*w)), (int) (r-(.5*2*w)));
		*/
		
		//create the 30 individual polygons
		cube = new Polygon[6][5];
			//deca-slice 0
			for(int i = 0; i < 5; i++)
			{
				cube[0][i] = new Polygon();
				cube[0][i].addPoint((int) (r-(.8660254*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
				cube[0][i].addPoint(r, i*w);
				cube[0][i].addPoint(r, (i+1)*w);
				cube[0][i].addPoint((int) (r-(.8660254*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
			}
			//deca-slice 1
			for(int i = 0; i < 5; i++)
			{
				cube[1][i] = new Polygon();
				cube[1][i].addPoint((int) (r+(.8660254*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
				cube[1][i].addPoint(r, i*w);
				cube[1][i].addPoint(r, (i+1)*w);
				cube[1][i].addPoint((int) (r+(.8660254*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
			}
			
			//deca-slice 2
			for(int i = 0; i < 5; i++)
			{
				cube[2][i] = new Polygon();
				cube[2][i].addPoint((int) (r+(.8660254*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
				cube[2][i].addPoint((int) (r+(.8660254*(5-(i))*w)), (int) (r+(.5*(5-(i))*w)));
				cube[2][i].addPoint((int) (r+(.8660254*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
				cube[2][i].addPoint((int) (r+(.8660254*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
			}
			//deca-slice 3
			for(int i = 0; i < 5; i++)
			{
				cube[3][i] = new Polygon();
				cube[3][i].addPoint((int) (r+(.8660254*(5-(i))*w)), (int) (r+(.5*(5-(i))*w)));
				cube[3][i].addPoint(r, (10-i)*w);
				cube[3][i].addPoint(r, (9-i)*w);				
				cube[3][i].addPoint((int) (r+(.8660254*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
			}
			//deca-slice 4
			for(int i = 0; i < 5; i++)
			{
				cube[4][i] = new Polygon();
				cube[4][i].addPoint(r, (10-i)*w);
				cube[4][i].addPoint((int) (r-(.8660254*(5-i)*w)), (int) (r+(.5*(5-i)*w)));
				cube[4][i].addPoint((int) (r-(.8660254*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
				cube[4][i].addPoint(r, (9-i)*w);	
			}
			//deca-slice 5
			for(int i = 0; i < 5; i++)
			{
				cube[5][i] = new Polygon();
				cube[5][i].addPoint((int) (r-(.8660254*(5-i)*w)), (int) (r+(.5*(5-i)*w)));
				cube[5][i].addPoint((int) (r-(.8660254*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
				cube[5][i].addPoint((int) (r-(.8660254*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
				cube[5][i].addPoint((int) (r-(.8660254*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
			}
			
		//draw the polygons to the screen
		for(int i = 0; i < cube.length; i++)
		{
			for(int k = 0; k < cube[0].length; k++)
			{
				g2d.drawPolygon(cube[i][k]);
				g2d.drawString("polar tic tac toe game board", w/2, 9*h);
			}
		}
		
		/*
		g2d.drawLine(4*w, y, 4*w, 8*h);
		g2d.drawLine((int) (4*w-2*w), 2*w, 4*w+(int)(2*w), 6*w);
		g2d.drawLine(4*w-(int)(2*Math.sqrt(3)*w), 6*w, 4*w+(int)(2*Math.sqrt(3)*w), 2*w);
		 */
		
		// to draw a filled rectangle use : g2d.fillRect(x, y, w, h) instead

		//g2d.drawRect(x, y, w, h);

		// A start angle of 0 represents a 3 o'clock position, 90 represents a 12 o'clock position,

		// and -90 (or 270) represents a 6 o'clock position

		int startAngle = 90;

		int arcAngle = -60;

		// to draw a filled arc use : g2d.fillArc(x, y, w, h, startAngle, arcAngle) instead

		//g2d.fillArc(x, y, 8*w, 8*h, startAngle, arcAngle);
		//g2d.fillArc(x, y, 8*w, 8*h, 90, 60);

		// to draw a filled round rectangle use : g2d.fillRoundRect(x, y, w, h, arcWidth, arcHeight) instead

		//g2d.drawRoundRect(x, y, w, h, w/2, h/2);

		//cube[0][0].addPoint(4*w, 0);

		//cube[0][0].addPoint(4*w, h);

		//cube[0][0].addPoint(l, 4*h);
 
		//cube[0][0].addPoint(4*w, 0);

		// Add more points...

		// to draw a filled round rectangle use : g2d.fillPolygon(polygon) instead

		//g2d.drawPolygon(cube[0][0]);

		}

 	}

}
