package main;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
class MenuDriver extends JFrame implements ActionListener
{
	private int psize = 700;
	private boolean debug = true;
	private JLabel mouse;
	private CardLayout card;
	private JPanel cont;
	private Hexashape[][] cube;

	private JButton single;
	private JButton multi;
	private JButton back;
	private JButton play;
	
	//the main menu panel
	private JPanel Menu;
	//the sub menu panel
	private JPanel SubMenu;
	//the panel in which the entire game runs
	private JPanel Game;
	//the panel where all the info is displayed
	private JPanel hud;
	//the game over panel
	private JPanel GameOver;

	public MenuDriver()
	{
	setTitle("Prototype Menu");
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	
	card = new CardLayout();
	
	cont = new JPanel();
	cont.setLayout(card);
	cont.add("menu", initMenu());
	cont.add("submenu", initSubMenu());
	cont.add("game", initGame());
	
	add(cont);
	setVisible(true);
	pack();
}
	
	
	public JPanel initMenu()
	{
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\Owner\\Pictures\\test.png"));
		ImageIcon button = new ImageIcon("C:\\\\Users\\\\Owner\\\\Pictures\\\\button.png");
		ImageIcon pressed = new ImageIcon("C:\\\\Users\\\\Owner\\\\Pictures\\\\button_press.png");
		ImageIcon clicked = new ImageIcon("C:\\\\Users\\\\Owner\\\\Pictures\\\\light_button_press.png");
		
		Menu = new JPanel();
			Menu.setPreferredSize(new Dimension(psize+200, psize));
			Menu.setLayout(new BorderLayout());
			Menu.add(background);
		
		background.setLayout(new GridBagLayout());
		JPanel buttons = new JPanel(); 
			buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
			buttons.setOpaque(true);
			buttons.setBackground(new Color(0,0,0,0));
				single = new JButton();
					Border emptyBorder = BorderFactory.createEmptyBorder();
					single.setBorder(emptyBorder);
					single.setText("SINGLEPLAYER");
						single.setHorizontalTextPosition(JLabel.CENTER);
						single.setForeground(Color.WHITE);
						single.setFont(new Font("Rockwell", Font.PLAIN, 37));
						single.setIcon(button);
						single.setRolloverIcon(pressed);
						single.setPressedIcon(clicked);
						single.addActionListener(this);	
				multi  = new JButton("Multiplayer");
					multi.setBorder(emptyBorder);
					multi.setText("MULTIPLAYER");
						multi.setHorizontalTextPosition(JLabel.CENTER);
						multi.setForeground(Color.WHITE);
						multi.setFont(new Font("Rockwell", Font.PLAIN, 37));
						multi.setIcon(button);
						multi.setRolloverIcon(pressed);
						multi.setPressedIcon(clicked);
						multi.addActionListener(this);
			buttons.add(Box.createRigidArea(new Dimension(0,300)));
			buttons.add(single);
			buttons.add(Box.createRigidArea(new Dimension(0,40)));
			buttons.add(multi);
		background.add(buttons);
		
		Menu.setVisible(true);
		return Menu;
	}
	
	@SuppressWarnings("unchecked")
	public JPanel initSubMenu()
	{
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\Owner\\Pictures\\test2.png"));
		ImageIcon panel = new ImageIcon("C:\\\\Users\\\\Owner\\\\Pictures\\\\panel.png");
		ImageIcon button = new ImageIcon("C:\\\\Users\\\\Owner\\\\Pictures\\\\small_button.png");
		ImageIcon pressed = new ImageIcon("C:\\\\Users\\\\Owner\\\\Pictures\\\\small_button_press.png");
		ImageIcon clicked = new ImageIcon("C:\\\\Users\\\\Owner\\\\Pictures\\\\small_light_button_press.png");
		SubMenu = new JPanel();
		SubMenu.setPreferredSize(new Dimension(psize, psize));
		SubMenu.setLayout(new BorderLayout());
		SubMenu.add(background);
		background.setLayout(new GridBagLayout());

		//Create a transparent panel that will be attached to the "background" object. All our content
		//will be contained in here.
		JPanel content = new JPanel();
			content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
			content.setOpaque(true);
			content.setBackground(new Color(0,0,0,0));
			
			Box b1 = Box.createHorizontalBox();
				JLabel pl1 = new JLabel("Player 1");
					pl1.setHorizontalTextPosition(JLabel.CENTER);
					pl1.setForeground(Color.WHITE);
					pl1.setFont(new Font("Rockwell", Font.PLAIN, 27));
					pl1.setIcon(panel);
				JLabel pl2 = new JLabel("Player 2");
					pl2.setHorizontalTextPosition(JLabel.CENTER);
					pl2.setForeground(Color.WHITE);
					pl2.setFont(new Font("Rockwell", Font.PLAIN, 27));
					pl2.setIcon(panel);
				JLabel pl3 = new JLabel("VS");
					pl3.setHorizontalTextPosition(JLabel.CENTER);
					pl3.setForeground(Color.WHITE);
					pl3.setFont(new Font("Rockwell", Font.BOLD, 20));
				b1.add(pl1);
				b1.add(Box.createRigidArea(new Dimension(30,0)));
				b1.add(pl3);
				b1.add(Box.createRigidArea(new Dimension(30,0)));
				b1.add(pl2);
			content.add(b1);
			content.add(Box.createRigidArea(new Dimension(0,30)));
			
			Box b2 = Box.createHorizontalBox();
				JLabel colour = new JLabel("avatar color");
				colour.setHorizontalTextPosition(JLabel.CENTER);
				colour.setForeground(Color.BLACK);
				colour.setFont(new Font("Rockwell", Font.BOLD, 20));
			
			Box leftbutton = Box.createHorizontalBox();
			    //Create the radio buttons.
			    JRadioButton redbut = new JRadioButton("Red");
			    	//birdButton.setActionCommand(birdString);
			    redbut.setSelected(true);
			    JRadioButton bluebut = new JRadioButton("Blue");
			    	//catButton.setActionCommand(catString);
			    JRadioButton greenbut = new JRadioButton("Green");
			    	//dogButton.setActionCommand(dogString);
			    //Group the radio buttons.
			    ButtonGroup group = new ButtonGroup();
			    group.add(redbut);
			    group.add(bluebut);
			    group.add(greenbut);
			    //Register a listener for the radio buttons.
			    redbut.addActionListener(this);
			    bluebut.addActionListener(this);
			    greenbut.addActionListener(this);
			    leftbutton.add(redbut);
			    leftbutton.add(bluebut);
			    leftbutton.add(greenbut);
				
				Box rightbutton = Box.createHorizontalBox();
			    //Create the radio buttons.
			    JRadioButton redbut1 = new JRadioButton("Red");
			    	//birdButton.setActionCommand(birdString);
			    redbut1.setSelected(true);
			    JRadioButton bluebut1 = new JRadioButton("Blue");
			    	//catButton.setActionCommand(catString);
			    JRadioButton greenbut1 = new JRadioButton("Green");
			    	//dogButton.setActionCommand(dogString);
			    //Group the radio buttons.
			    ButtonGroup group1 = new ButtonGroup();
			    group1.add(redbut1);
			    group1.add(bluebut1);
			    group1.add(greenbut1);
			    //Register a listener for the radio buttons.
			    redbut1.addActionListener(this);
			    bluebut1.addActionListener(this);
			    greenbut1.addActionListener(this);
			    rightbutton.add(redbut1);
			    rightbutton.add(bluebut1);
			    rightbutton.add(greenbut1);		
		    b2.add(leftbutton);
		    b2.add(Box.createRigidArea(new Dimension(30,0)));
		    b2.add(colour);
		    b2.add(Box.createRigidArea(new Dimension(30,0)));
		    b2.add(rightbutton);
		    content.add(b2);
		    content.add(Box.createRigidArea(new Dimension(0,30)));
		    
		    Box number = Box.createHorizontalBox();
		    	JLabel numberofgames = new JLabel("Number of games");
		    	number.add(numberofgames);
		    	
		    content.add(number);
		    
		    JSlider slider = new JSlider(1,15);
		    	slider.setValue(3);
		    	slider.setMajorTickSpacing(2);
		    	slider.setMinorTickSpacing(1);
		    	slider.setPaintTicks(true);
		    	//Create the label table
		    	Hashtable labelTable = new Hashtable();
		    	labelTable.put( new Integer( 1 ), new JLabel("1") );
		    	labelTable.put( new Integer( 5 ), new JLabel("5") );
		    	labelTable.put( new Integer( 10 ), new JLabel("10") );
		    	labelTable.put( new Integer( 15 ), new JLabel("15") );
		    	slider.setLabelTable( labelTable );
		    	slider.setPaintLabels(true);
		    content.add(slider);
		    background.add(content);
		    content.add(Box.createRigidArea(new Dimension(0,30)));
		    
		    Box b3 = Box.createHorizontalBox();
			    back = new JButton();
					Border emptyBorder = BorderFactory.createEmptyBorder();
					back.setBorder(emptyBorder);
					back.setText("Main Menu");
					back.setHorizontalTextPosition(JLabel.CENTER);
					back.setForeground(Color.WHITE);
					back.setFont(new Font("Rockwell", Font.PLAIN, 27));
					back.setIcon(button);
					back.setRolloverIcon(pressed);
					back.setPressedIcon(clicked);
					back.addActionListener(this);
				play  = new JButton();
					play.setBorder(emptyBorder);
					play.setText("Let's Play!");
					play.setHorizontalTextPosition(JLabel.CENTER);
					play.setForeground(Color.WHITE);
					play.setFont(new Font("Rockwell", Font.PLAIN, 27));
					play.setIcon(button);
					play.setRolloverIcon(pressed);
					play.setPressedIcon(clicked);
					play.addActionListener(this);
				b3.add(back);
				b3.add(Box.createRigidArea(new Dimension(85,0)));
				b3.add(play);
				
				content.add(b3);
		    return SubMenu;
	}

	public JPanel initGame()
	{
		Border emptyBorder = BorderFactory.createEmptyBorder();
		Game = new JPanel();
		Game.setBorder(emptyBorder);
        Game.setBackground(Color.white);
		hud = new JPanel();
		hud.setBorder(emptyBorder);
        hud.setBackground(Color.pink);
        hud.setPreferredSize(new Dimension(200,psize));
        Game.add(new Canvas(), BorderLayout.CENTER);
        Game.add(hud, BorderLayout.EAST);
        
        return Game;
	}
 	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		 //the source of the button click
        JButton j = (JButton)(e.getSource());
        
        if(j.equals(single))
        {
        	card.show(cont, "submenu");
        	//game.setMode("singleplayer");
        	//System.out.println("singleplayer button");
        }
        if(j.equals(multi))
        {
        	//game.setMode("multiplayer")
        	//System.out.println("multiplayer button");
        } 
        if(j.equals(back))
        {
        	card.show(cont, "menu");
        	//System.out.println("back button");
        } 
        if(j.equals(play))
        {
        	card.show(cont, "game");
        	//System.out.println("Play button");
        }
	}

	
	/*This is a custom JPanel that will server as our canvas. All polygons will be drawn on this canvas.
	 * 
	 */
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
        				//cube[i][k].setFilled(!cube[i][k].isFilled());
        				//if(debug) mouse.setText("   Hexashape ID: " + i + "-" + k + " Painted: "+cube[i][k].isFilled());
        				return cube[i][k];
        			}
        		}
        	}
        	return null;
        }
        
        public void flipFilled(Hexashape shape)
        {
        	shape.setFilled(!shape.isFilled());
        }
        
       /** Called whenever the mouse is pressed.
         * Could be replaced with setting the value of a JLabel, etc. */
        public void mousePressed(MouseEvent e) 
        {
        	Point p = e.getPoint();
            //if(triangle.contains(p)) mouse.setText("Inside Triangle");
            Hexashape focus = checkIfFramed(p);
        	if(focus!=null)
        	{
        		//mouse.setText("Inside Polygon: " + focus);
        		flipFilled(focus);
        		repaint();
        		//displayWin(cube[2][2]);
        	}	
        	else if (debug) 
        	{
        		mouse.setText("   Outside Bounds");
        	}
        	
        }
    
        //Required methods for MouseListener, though the only one you care about is click
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        
        public void displayWin(Hexashape cube)
        {
        	int flashnumber = 10;
        	int x = cube.getX();
        	int y = cube.getY();
        	
        	for(int t = 0; t < flashnumber; t++)
        	{
        		cube.setColor(Color.BLUE);
        		repaint();
        		try 
        		{
        			Thread.sleep(5);
        	    } 
        		catch (InterruptedException e) 
        		{
        			e.printStackTrace();
        	    }
        		cube.setColor(Color.RED);
        		repaint();   		
        	}
        }
        
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