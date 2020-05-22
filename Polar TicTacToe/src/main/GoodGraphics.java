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
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class GoodGraphics extends JFrame{

    private JPanel game;
    private JPanel info;
	int hexSize = 700;
    
    public GoodGraphics()
    {

        this.setTitle("Drawing tings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initialize();
        //this.add(new TestingPanelGraphics(), BorderLayout.CENTER);
        this.add(game);
        this.add(info, BorderLayout.LINE_END);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        System.out.println(game.getBounds());

    }

    /**
     * this part creates the cascading panels and other components, then
     * sets them to the appropriate size.
     */
    private void initialize()
    {
    	//canvas initialization
    	Canvas can = new Canvas(hexSize);
    	
    	//game panel initialization
    	game = new JPanel();
    	game.setLayout(new BorderLayout());
    	Border border = new EmptyBorder(10,10,10,10);
    	game.setBorder(border);
    	game.add(can);
    	
    	//info panel initialization
    	info = new JPanel();
    	
    	info.setLayout(new BorderLayout());
    	info.setPreferredSize(new Dimension(200, hexSize));
    	info.setBackground(Color.gray);
    	info.revalidate();
    	info.repaint();
    	info.setVisible(true);   		
    }
 /*   
private class Canvas extends JPanel
{
        
    //Override the paintComponent so we can use our own graphics
    @Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g); 
    	setPlot();
   /*     double fw = game.getWidth()-1;
        double w = fw/10;
        double r = fw/2;
        double cos = Math.cos(Math.toRadians(30));           
        Graphics2D graph2 = (Graphics2D) g;
                
        graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graph2.setColor(Color.red);
        //Shape rootRect = new Rectangle2D.Double(0, 0, fw, fw);
        //graph2.draw(rootRect);
                
        graph2.setColor(Color.BLACK);
                
                
        //HERE BEGINS CUSTOM CODE
                
  /*      //create the 30 individual polygons
   		cube = new Polygon[6][5];
 
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
      	
        graph2.setColor(Color.red);		
        graph2.fillPolygon(cube[2][2]);
        graph2.setColor(Color.black);
                
      	//draw the polygons to the screen for the first time
      	graph2.setStroke(new BasicStroke(3));
      	for(int i = 0; i < cube.length; i++)
      	{
      		for(int k = 0; k < cube[0].length; k++)
      		{
      			graph2.drawPolygon(cube[i][k]);
        		//graph2.drawString("polar tic tac toe game board", w/2, 9*w);
        	}
        }
                
                
        */
	}
