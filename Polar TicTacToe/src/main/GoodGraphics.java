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

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GoodGraphics extends JFrame{

    private JPanel game;
    private JPanel info;
	
    public GoodGraphics(){

        //this.setSize(600,600);
        //this.setPreferredSize(new Dimension(600,600));
        this.setTitle("Drawing tings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //this.add(new TestingPanelGraphics(), BorderLayout.CENTER);
        
        initialize();
        this.add(game);
        this.add(info, BorderLayout.LINE_END);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);

    }

    /**
     * this part creates the cascading panels and other components, then
     * sets them to the appropriate size.
     */
    private void initialize()
    {
    	//game panel initialization
    	game = new JPanel();
    	
    	game.setLayout(new BorderLayout());
    	game.setPreferredSize(new Dimension(700, 700));
    	game.add(new DrawStuff(), BorderLayout.CENTER);
    	game.revalidate();
    	game.repaint();
    	game.setVisible(true);
    	
    	//info panel initialization
    	info = new JPanel();
    	
    	info.setLayout(new BorderLayout());
    	info.setPreferredSize(new Dimension(200, 700));
    	info.setBackground(Color.gray);
    	info.revalidate();
    	info.repaint();
    	info.setVisible(true);   		
    }
    
    private class DrawStuff extends JComponent{
        
    	//declare an array of polygons
    	private Polygon[][] cube;
		
    	//Override the paintComponent so we can use our own graphics
        @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                
                int fw = game.getWidth()-1;
                int w = fw/10;
                int r = fw/2;
                
                Graphics2D graph2 = (Graphics2D) g;
                System.out.println(game.getWidth() + " " + w +" "+ r);
                graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                graph2.setColor(Color.red);
                Shape rootRect = new Rectangle2D.Float(100, 100, 500, 500);
                graph2.drawLine(0, 0, 700, 700);
                graph2.drawLine(0, 700, 700, 0);
                graph2.drawLine(349, 0, 349, 699);
                graph2.draw(rootRect);
                
                graph2.setColor(Color.BLACK);
                              
                //HERE BEGINS CUSTOM CODE
                
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
        				//use this line as a blueprint to fix the rest of the code
        				//cube[3][i].addPoint(r, (int) (fw*(1-(i*0.10))));
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
        			
        		//draw the polygons to the screen for the first time
        		graph2.setStroke(new BasicStroke(2));
        		for(int i = 0; i < cube.length; i++)
        		{
        			for(int k = 0; k < cube[0].length; k++)
        			{
        				graph2.drawPolygon(cube[i][k]);
        				//graph2.drawString("polar tic tac toe game board", w/2, 9*w);
        			}
        		}
                
                
            }
        }
    }