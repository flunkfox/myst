package main;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GoodGraphics extends JFrame {

    private JPanel debug_panel;
    private JPanel border;
    private JLabel mouse;
	
    private int psize = 600;
	private boolean debug = true;
    
	public GoodGraphics()
	{
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        this.setTitle("Hexagon Game");
        
        //Create border panel and set size
        border = new JPanel();
        border.setBackground(Color.white);
        border.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
        //create new canvas and assign to border
        border.add(new Canvas(), BorderLayout.CENTER);
        
        //add new border+canvas to JFrame
        add(border, BorderLayout.CENTER);
        
        if(debug) initializeDebug();
        
        //size and pack and configure JFrame
        pack();
        repaint();
        setVisible(true);
        
    }
    
    public void initializeDebug()
    {
    	debug_panel = new JPanel();
    	debug_panel.setLayout(new BorderLayout());
    	debug_panel.setPreferredSize(new Dimension(psize,50));
    	debug_panel.setBackground(Color.pink);
    	
    	JLabel id = new JLabel();
    	id.setText("DEBUG MODE   ");
    	debug_panel.add(id, BorderLayout.LINE_END);
    	
    	mouse = new JLabel();
    	mouse.setPreferredSize(new Dimension(20,100));
    	
    	debug_panel.add(mouse, BorderLayout.CENTER);
    	this.add(debug_panel, BorderLayout.PAGE_END);
    }

    class Canvas extends JPanel implements MouseListener
    {
        private Hexashape[][] cube;
        
        public Canvas()
        {            
        	//set background color
        	this.setBackground(Color.white);
        	
        	//create distinct polygons
            cube = new Hexashape[6][5];
            setCubePlots();

            //Add mouse Listener
            addMouseListener(this);

            //Set size to make sure that the whole triangle is shown
            setPreferredSize(new Dimension(psize, psize));
        }

        /** Draws the triangle as this frame's painting */
        public void paintComponent(Graphics g){
        	super.paintComponent(g);
        	Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(3));
            
            //draw hexa-shape
            for(int i = 0; i<6; i++)
            {
            	for(int k = 0; k<5; k++)
            	{
            		if(cube[i][k].isFilled())
            		{
            			g2d.setColor(cube[i][k].getColor());
            			g2d.fillPolygon(cube[i][k]);
            			g2d.setColor(Color.black);
            		}
            		else
            		{
            			g2d.setColor(this.getBackground());
            			g2d.fillPolygon(cube[i][k]);
            			g2d.setColor(Color.black);
            		}
            			
            		g2d.drawPolygon(cube[i][k]);
            	}
            }
        }
        
        public Hexashape checkIfFramed(Point p)
        {
        	for(int i = 0; i<6; i++)
        	{
        		for(int k = 0; k<5; k++)
        		{
        			if(cube[i][k].contains(p))
        			{
        				cube[i][k].setFilled(!cube[i][k].isFilled());
        				if(debug) mouse.setText("   Hexashape ID: " + i + "-" + k + " Painted: "+cube[i][k].isFilled());
        				return cube[i][k];
        			}
        		}
        	}
        	return null;
        }
        
       /** Called whenever the mouse is pressed.
         * Could be replaced with setting the value of a JLabel, etc. */
        public void mousePressed(MouseEvent e) {
        	Point p = e.getPoint();
            //if(triangle.contains(p)) mouse.setText("Inside Triangle");
            Hexashape focus = checkIfFramed(p);
        	if(focus!=null)
        	{
        		//mouse.setText("Inside Polygon: " + focus);
        		repaint();
        	}
        		
        	else if (debug) mouse.setText("   Outside Bounds");
        }
    
        //Required methods for MouseListener, though the only one you care about is click
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        
        public void setCubePlots()
        {
        	//create the 30 individual polygons
       		double fw = psize-1;
            double w = fw/10;
            double r = fw/2;
            double cos = Math.cos(Math.toRadians(30));
       		
       		//deca-slice 0        		
            for(int i = 0; i < 5; i++)
            {
            	cube[0][i] = new Hexashape(0,i);
            	cube[0][i].addPoint((int) (r-(cos*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
            	cube[0][i].addPoint((int)r, (int)(i*w));
            	cube[0][i].addPoint((int)r, (int)((i+1)*w));
            	cube[0][i].addPoint((int) (r-(cos*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
            }
            //deca-slice 1
            for(int i = 0; i < 5; i++)
            {
            	cube[1][i] = new Hexashape(1,i);
            	cube[1][i].addPoint((int) (r+(cos*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
            	cube[1][i].addPoint((int)r, (int)(i*w));
            	cube[1][i].addPoint((int)r, (int)((i+1)*w));
            	cube[1][i].addPoint((int) (r+(cos*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
            }
            //deca-slice 2
            for(int i = 0; i < 5; i++)
            {
            	cube[2][i] = new Hexashape(2,i);
            	cube[2][i].addPoint((int) (r+(cos*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
            	cube[2][i].addPoint((int) (r+(cos*(5-(i))*w)), (int) (r+(.5*(5-(i))*w)));
            	cube[2][i].addPoint((int) (r+(cos*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
            	cube[2][i].addPoint((int) (r+(cos*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
            }
            //deca-slice 3
            for(int i = 0; i < 5; i++)
            {
            	cube[3][i] = new Hexashape(3,i);
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
            	cube[4][i] = new Hexashape(4,i);
            	cube[4][i].addPoint((int)r, (int)((10-i)*w));
            	cube[4][i].addPoint((int) (r-(cos*(5-i)*w)), (int) (r+(.5*(5-i)*w)));
            	cube[4][i].addPoint((int) (r-(cos*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
            	cube[4][i].addPoint((int)r, (int)((9-i)*w));	
          	}
          	//deca-slice 5
          	for(int i = 0; i < 5; i++)
          	{
          		cube[5][i] = new Hexashape(5,i);
          		cube[5][i].addPoint((int) (r-(cos*(5-i)*w)), (int) (r+(.5*(5-i)*w)));
          		cube[5][i].addPoint((int) (r-(cos*(5-i)*w)), (int) (r-(.5*(5-i)*w)));
          		cube[5][i].addPoint((int) (r-(cos*(5-(i+1))*w)), (int) (r-(.5*(5-(i+1))*w)));
          		cube[5][i].addPoint((int) (r-(cos*(5-(i+1))*w)), (int) (r+(.5*(5-(i+1))*w)));
          	}
        }
    }
}
        