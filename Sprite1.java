//Andy Bernhardt
//Sprite1
//May 17, 2017
import java.awt.*;
public class Sprite1
{
	Image img1, img2, img3, img4, currentImage;
	int x, y, yvel, jnum;
	public Sprite1(Image i1, Image i2, Image i3, Image i4, int xe, int ye, int yvelly, int jumpnum)
	{
		img1 = i1;
		img2 = i2;
		img3 = i3;
		img4 = i4;
		currentImage = i1;
		x = xe;
		y = ye;
		yvel = yvelly;
		jnum = jumpnum;
	}
	public void draw(Graphics g)
	{
		g.drawImage(currentImage, x, y, null);
	}
	public void cycleSprite()
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
	}
	public void right()
	{
		x = x + 10;
	}
	public void left()
	{
		x = x - 10;
	}

	public void up()
	{
		y = y - 10;
	}

	public void down()
	{
		y = y + 10;
	}
	public void jump()
	{
	}
	public int getY()
	{
		return y;
	}

}