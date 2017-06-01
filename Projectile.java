//Andy Bernhardt
//Projectile
import java.awt.*;
public class Projectile
{
	//Direction Numbers
	//Right 1, Up 2, Left 3, Down 4
	int x, y, dir, movenum;
	long time1, time2;
	Image currentImage;
	public Projectile(Image i1)
	{
		currentImage = i1;
	}
	public void setLocation(int playerx, int playery, int playerdirection)
	{
		if (playerdirection == 1)
		{
			x = playerx + 50;
			y = playery;
			dir = 1;
		}
		if (playerdirection == 2)
		{
			x = playerx;
			y = playery - 50;
			dir = 2;
		}
		if (playerdirection == 3)
		{
			x = playerx - 50;
			y = playery;
			dir = 3;
		}
		if (playerdirection == 4)
		{
			x = playerx;
			y = playery + 50;
			dir = 4;
		}
	}
	public void drawProjectile(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 50, 50);
		g.setColor(Color.WHITE);
		g.drawArc(x + 5, y + 5, 40, 40, 20, 30);
		g.drawArc(x + 4, y + 4, 40, 40, 20, 30);
		g.setColor(Color.YELLOW);
		g.drawLine(x + 25, y, x + 35, y - 10);
		g.drawLine(x + 24, y, x + 34, y - 10);
		g.drawLine(x + 23, y, x + 33, y - 10);
		g.setColor(Color.RED);
		g.fillOval(x + 33, y - 13, 5, 5);
		//g.drawImage(currentImage, x, y, null);
	}
	public int moveProjectile(long time)
	{
		if (time <= 0)
		{
			movenum = 0;
		}
		if (time <= 20 && time > 0)
		{
			movenum = 20;
		}
		if (time > 20 && time <= 40)
		{
			movenum = 40;
		}
		if (time > 40 && time <= 60)
		{
			movenum = 60;
		}
		if (time > 60 && time <= 80)
		{
			movenum = 80;
		}
		if (time > 80 && time <= 100)
		{
			movenum = 100;
		}
		if (time > 100 && time <= 120)
		{
			movenum = 120;
		}
		if (time > 120 && time <= 140)
		{
			movenum = 140;
		}
		if (time > 140 && time <= 160)
		{
			movenum = 160;
		}
		if (time > 160 && time <= 180)
		{
			movenum = 180;
		}
		if (time > 180 && time <= 200)
		{
			movenum = 200;
		}
		if (time > 200 && time <= 220)
		{
			movenum = 220;
		}
		if (time > 220 && time <= 240)
		{
			movenum = 240;
		}
		if (time > 240)
		{
			movenum = 260;
		}
		return movenum;
	}
	public void moveRight()
	{
		x = x + 4;
	}
	public void moveUp()
	{
		y = y - 4;
	}
	public void moveLeft()
	{
		x = x - 4;
	}
	public void moveDown()
	{
		y = y + 4;
	}
	public void cycleSprite()
	{
		//Todo
	}
}
