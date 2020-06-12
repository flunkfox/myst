package main;
import java.awt.Color;
import java.awt.Polygon;

public class Hexashape extends Polygon
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xaxis;
	private int yaxis;
	private boolean filled = false;
	private boolean highlighted = false;
	private Color fillColor;
	
	public Hexashape(int newx, int newy)
	{
		xaxis = newx;
		yaxis = newy;
	}
	
	public void setColor(Color c)
	{
		fillColor = c;
	}
	public Color getColor()
	{
		return fillColor;
	}
	
	public void setX(int newx)
	{
		xaxis = newx;
	}
	public void setY(int newy)
	{
		yaxis = newy;
	}
	
	public int getX()
	{
		return xaxis;
	}
	public int getY()
	{
		return yaxis;
	}
	
	public void setFilled(boolean t)
	{
		filled = t;
	}
	public void setHighlighted(boolean t)
	{
		highlighted = t;
	}
	
	public boolean isFilled()
	{
		return filled;
	}
	public boolean isHighlighted()
	{
		return highlighted;
	}
}
