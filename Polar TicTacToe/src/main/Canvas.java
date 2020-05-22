package main;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Canvas extends JPanel
{
	public static int hexSize;
	private Polygon[][] cube;
	
	public Canvas(int h)
    {
		hexSize = h;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(h, h));
		setPlots();
    }

	 @Override
	public void paintComponent(Graphics g)
	{
		 super.paintComponent(g);
		 Graphics2D graph2 = (Graphics2D) g;
		 graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	     graph2.setColor(Color.red);
	     
	     hexSize = this.getWidth();
	     setPlots();
	     //DEBUG RECTANGLE
	     Shape rootRect = new Rectangle2D.Double(0, 0, hexSize-1, hexSize-1);
	     graph2.draw(rootRect);
	     //DEBUG LINE
	     graph2.drawLine(0, 0, hexSize-1, hexSize-1);
	     System.out.println("DEBUG: " +this.getBounds());
	     
	     //Fill a polygon
	     graph2.fillPolygon(cube[2][2]);
	     graph2.setColor(Color.black);	
	     
	     //draw the polygons to the screen for the first time
	     graph2.setStroke(new BasicStroke(3));
	     for(int i = 0; i < cube.length; i++)
	     {
	    	 for(int k = 0; k < cube[0].length; k++)
	    	 {
	    		 graph2.drawPolygon(cube[i][k]);
	    	 }
	     }
	} 
	

	
    public void setPlots()
    {
    	//create the 30 individual polygons
   		cube = new Polygon[6][5];
 
   		double fw = hexSize-1;
        double w = fw/10;
        double r = fw/2;
        double cos = Math.cos(Math.toRadians(30));
   		
   		//deca-slice 0        		
        for(int i = 0; i < 5; i++)
        {
        	cube[0][i] = new Polygon();
        	cube[0][i].addPoint((int) (r-(cos*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
        	cube[0][i].addPoint((int)r, (int)(i*w));
        	cube[0][i].addPoint((int)r, (int)((i+1)*w));
        	cube[0][i].addPoint((int) (r-(cos*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
        }
        //deca-slice 1
        for(int i = 0; i < 5; i++)
        {
        	cube[1][i] = new Polygon();
        	cube[1][i].addPoint((int) (r+(cos*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
        	cube[1][i].addPoint((int)r, (int)(i*w));
        	cube[1][i].addPoint((int)r, (int)((i+1)*w));
        	cube[1][i].addPoint((int) (r+(cos*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
        }
        //deca-slice 2
        for(int i = 0; i < 5; i++)
        {
        	cube[2][i] = new Polygon();
        	cube[2][i].addPoint((int) (r+(cos*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
        	cube[2][i].addPoint((int) (r+(cos*(5-(i))*w)), (int) (r+(.5*(5-(i))*w)));
        	cube[2][i].addPoint((int) (r+(cos*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
        	cube[2][i].addPoint((int) (r+(cos*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
        }
        //deca-slice 3
        for(int i = 0; i < 5; i++)
        {
        	cube[3][i] = new Polygon();
        	cube[3][i].addPoint((int) (r+(cos*(5-(i))*w)), (int) (r+(.5*(5-(i))*w)));
        	cube[3][i].addPoint((int)r, (int)((10-i)*w));
        	//use this line as a blueprint to fix the rest of the code
        	//cube[3][i].addPoint(r, (int) (fw*(1-(i*0.10))));
        	cube[3][i].addPoint((int)r, (int)((9-i)*w));				
        	cube[3][i].addPoint((int) (r+(cos*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
        }
        //deca-slice 4
        for(int i = 0; i < 5; i++)
        {
        	cube[4][i] = new Polygon();
        	cube[4][i].addPoint((int)r, (int)((10-i)*w));
        	cube[4][i].addPoint((int) (r-(cos*(5-i)*w)), (int) (r+(.5*(5-i)*w)));
        	cube[4][i].addPoint((int) (r-(cos*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
        	cube[4][i].addPoint((int)r, (int)((9-i)*w));	
      	}
      	//deca-slice 5
      	for(int i = 0; i < 5; i++)
      	{
      		cube[5][i] = new Polygon();
      		cube[5][i].addPoint((int) (r-(cos*(5-i)*w)), (int) (r+(.5*(5-i)*w)));
      		cube[5][i].addPoint((int) (r-(cos*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
      		cube[5][i].addPoint((int) (r-(cos*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
      		cube[5][i].addPoint((int) (r-(cos*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
      	}	
    }
        
}