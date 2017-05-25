//Andy Bernhardt
//Sprite1
//May 17, 2017
import java.awt.*;
public class Sprite1
{
	Image img1, img2, img3, img4, currentImage;
	int x, y;
	public Sprite1(Image i1, Image i2, Image i3, Image i4, int xe, int ye)
	{
		img1 = i1;
		img2 = i2;
		img3 = i3;
		img4 = i4;
		currentImage = i1;
		x = xe;
		y = ye;
	}
	public void draw(Graphics g)
	{
		g.drawImage(currentImage, x, y, null);
	}
	/*public void cycleSprite()
	{
		if (currentImage == img1)
		{
			currentImage = img2;
		}
		else if (currentImage == img2)
		{
			currentImage = img3;
		}
		else if (currentImage == img3)
		{
			currentImage = img4;
		}
		else
		{
			currentImage = img1;
		}
	}*/
	public void right(boolean moverightornot)
	{
		if (moverightornot == false)
		{
		}
		else
		{
			x = x + 5;
			currentImage = img1;
		}
	}
	public void left(boolean moveleftornot)
	{
		if (moveleftornot == false)
		{
		}
		else
		{
			x = x - 5;
			currentImage = img3;
		}
	}
	public void up(boolean moveupornot)
	{
		if (moveupornot == false)
		{
		}
		else
		{
			y = y - 5;
			currentImage = img2;
		}
	}
	public void down(boolean movedownornot)
	{
		if (movedownornot == false)
		{
		}
		else
		{
			y = y + 5;
			currentImage = img4;
		}
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
}
