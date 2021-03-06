import java.awt.*;
public class BombAmmo
{
	Image threebombs;
	Image twoandhalfbombs;
	Image twobombs;
	Image oneandhalfbombs;
	Image onebomb;
	Image zeroandhalfbombs;
	Image zerobombs;
	Image currentImage;
	int bombs = 3;
	int x, y, a, b;
	public BombAmmo(Image b3, Image bhalf2, Image b2, Image bhalf1, Image b1, Image bhalf0, Image b0, int xe, int why, int aye, int bee)
	{
		threebombs = b3;
		twoandhalfbombs = bhalf2;
		twobombs = b2;
		oneandhalfbombs = bhalf1;
		onebomb = b1;
		zeroandhalfbombs = bhalf0;
		zerobombs = b0;
		currentImage = b3;
		x = xe;
		y = why;
		a = aye;
		b = bee;
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(a, b, 200, 100);
		g.drawImage(currentImage, x, y, null);
	}

	public void removeBomb()
	{
		if(currentImage == threebombs)
		{
			currentImage = twobombs;
		}
		else if(currentImage == twoandhalfbombs)
		{
			currentImage = oneandhalfbombs;
		}

		else if(currentImage == twobombs)
		{
			currentImage = onebomb;
		}
		else if(currentImage == oneandhalfbombs)
		{
			currentImage = zeroandhalfbombs;
		}
		else if(currentImage == onebomb)
		{
			currentImage = zerobombs;
		}
	}

	public int getAmount(int amount)
	{
		amount = bombs;
		return amount;
	}

	public void addBomb()
	{
		if(currentImage == twoandhalfbombs)
		{
			currentImage = threebombs;
		}
		else if(currentImage == twobombs)
		{
			currentImage = twoandhalfbombs;
		}
		else if(currentImage == oneandhalfbombs)
		{
			currentImage = twobombs;
		}
		else if(currentImage == onebomb)
		{
			currentImage = oneandhalfbombs;
		}
		else if(currentImage == zeroandhalfbombs)
		{
			currentImage = onebomb;
		}
		else if(currentImage == zerobombs)
		{
			currentImage = zeroandhalfbombs;
		}
	}

	public Image checkBomb()
	{
		return currentImage;
	}

}