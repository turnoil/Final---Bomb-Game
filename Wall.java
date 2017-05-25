//Walls
import java.awt.*;
public class Wall
{
	//Direction Numbers
	//Right 1, Up 2, Left 3, Down 4
	int x, y, xsize, ysize;
	boolean inwall;
	public Wall(int xe, int ye, int xsizee, int ysizee)
	{
		x = xe;
		y = ye;
		xsize = xsizee;
		ysize = ysizee;
	}
	public void drawWall(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(x, y, xsize, ysize);
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getXSize()
	{
		return xsize;
	}
	public int getYSize()
	{
		return ysize;
	}
	public boolean checkBoundaries(int playerx, int playery)
	{
		if ((playerx + 50 > x) && (playerx < x + xsize) && (playery + 50 > y) && (playery < y + ysize))
		{
			inwall = true;
		}
		else
		{
			inwall = false;
		}
		return inwall;
	}
}
