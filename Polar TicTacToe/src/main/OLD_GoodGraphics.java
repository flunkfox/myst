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
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class OLD_GoodGraphics extends JFrame{

    private JPanel game;
    private JPanel info;
	int hexSize = 700;
    
    public OLD_GoodGraphics()
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
}
