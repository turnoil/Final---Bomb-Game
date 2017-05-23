//Andy Bernhardt
//Projectile
import java.awt.*;
public class Projectile
{
	//Direction Numbers
	//Right 1, Up 2, Left 3, Down 4
	int x, y, dir, movenum;
	long time1, time2;
	public Projectile(/*Image i1...*/)
	{
	}
	public void drawProjectile(Graphics g, int playerx, int playery, int playerdirection)
	{
		if (playerdirection == 1)
		{
			x = playerx + 30;
			y = playery;
			dir = 1;
		}
		if (playerdirection == 2)
		{
			x = playerx;
			y = playery - 30;
			dir = 2;
		}
		if (playerdirection == 3)
		{
			x = playerx - 30;
			y = playery;
			dir = 3;
		}
		if (playerdirection == 4)
		{
			x = playerx;
			y = playery + 30;
			dir = 4;
		}
		g.drawImage(currentImage, x, y, null);
	}
	public long startTime()
	{
		time1 = System.nanoTime();
		return time1;
	}
	public long endTime()
	{
		time2 = System.nanoTime();
		return time2;
	}
	public void moveProjectile(long time)
	{
		if (time < 0.5)
		{
			movenum = 30;
		}
	}
	public void cycleSprite()
	{
		//Todo
	}
}