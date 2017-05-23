//Driver
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameDriver extends JApplet implements KeyListener, ActionListener
{
	Wall leftwall, rightwall, topwall, bottomwall;
	Image background;
	Image i1, i2, i3, i4;
	Sprite1 spritee;
	Sprite1 spriteq;
	Timer t;
	int delay = 20;
	boolean right = false;
	boolean left = false;
	boolean up = false;
	boolean down = false;
	boolean a = false;
	boolean d = false;
	boolean w = false;
	boolean s = false;
	boolean moveornotplayer1, moveornotplayer2;
	int dir = 0;
	int dir2 = 0;
	//Right 1, Up 2, Left 3, Down 4
	public void init()
	{
		setContentPane(new DrawingPanel());
		addKeyListener(this);
		setFocusable(true);
		background = getImage(getDocumentBase(), "background.png");
		leftwall = new Wall(0, 0, 20, 1000);
		rightwall = new Wall(1260, 0, 20, 1000);
		topwall = new Wall(0, 0, 1260, 20);
		bottomwall = new Wall(0, 900, 1260, 20);
		i1 = getImage(getDocumentBase(), "sprite1_1.png");
		i2 = getImage(getDocumentBase(), "sprite1_2.png");
		i3 = getImage(getDocumentBase(), "sprite1_3.png");
		i4 = getImage(getDocumentBase(), "sprite1_4.png");
		spritee = new Sprite1(i1, i2, i3, i4, 200, 800);
		spriteq = new Sprite1(i1, i2, i3, i4, 800, 800);
		t = new Timer(delay, this);
		t.start();
	}
	public class DrawingPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(background, 0, 0, null);
			leftwall.drawWall(g);
			rightwall.drawWall(g);
			topwall.drawWall(g);
			bottomwall.drawWall(g);
			spritee.draw(g);
			spriteq.draw(g);
		}
	}
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			w = true;
			dir = 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			d = true;
			dir = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			a = true;
			dir = 3;
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			s = true;
			dir = 4;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			right = true;
			dir2 = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			left = true;
			dir2 = 3;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			up = true;
			dir2 = 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			down = true;
			dir2 = 4;
		}
	}
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			d = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			a = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			w = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			s = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			down = false;
		}
	}
	public void keyTyped(KeyEvent e)
	{
	}
	public void actionPerformed(ActionEvent q)
	{
		if (q.getSource() == t)
		{
			int currentx1 = spritee.getX();
			int currenty1 = spritee.getY();
			int currentx2 = spriteq.getX();
			int currenty2 = spriteq.getY();
			boolean leftwallboo1 = leftwall.checkBoundaries(currentx1, currenty1);
			boolean rightwallboo1 = rightwall.checkBoundaries(currentx1, currenty1);
			boolean topwallboo1 = topwall.checkBoundaries(currentx1, currenty1);
			boolean bottomwallboo1 = bottomwall.checkBoundaries(currentx1, currenty1);
			if (leftwallboo1 == true || rightwallboo1 == true || topwallboo1 == true || bottomwallboo1 == true)
			{
				moveornotplayer1 = false;
				if (dir == 1)
				{
					spritee.left();
				}
				if (dir == 2)
				{
					spritee.down();
				}
				if (dir == 3)
				{
					spritee.right();
				}
				if (dir == 4)
				{
					spritee.up();
				}
			}
			else
			{
				moveornotplayer1 = true;
			}
			boolean leftwallboo2 = leftwall.checkBoundaries(currentx2, currenty2);
			boolean rightwallboo2 = rightwall.checkBoundaries(currentx2, currenty2);
			boolean topwallboo2 = topwall.checkBoundaries(currentx2, currenty2);
			boolean bottomwallboo2 = bottomwall.checkBoundaries(currentx2, currenty2);
			if (leftwallboo2 == true || rightwallboo2 == true || topwallboo2 == true || bottomwallboo2 == true)
			{
				moveornotplayer2 = false;
				if (dir2 == 1)
				{
					spriteq.left();
				}
				if (dir2 == 2)
				{
					spriteq.down();
				}
				if (dir2 == 3)
				{
					spriteq.right();
				}
				if (dir2 == 4)
				{
					spriteq.up();
				}
			}
			else
			{
				moveornotplayer2 = true;
			}
			if (moveornotplayer1 == true)
			{
				if (d == true)
				{
					spritee.right();
				}
				if (a == true)
				{
					spritee.left();
				}
				if (w == true)
				{
					spritee.up();
				}
				if (s == true)
				{
					spritee.down();
				}
			}
			if (moveornotplayer2 == true)
			{
				if (right == true)
				{
					spriteq.right();
				}
				if (up == true)
				{
					spriteq.up();
				}
				if (down == true)
				{
					spriteq.down();
				}
				if (left == true)
				{
					spriteq.left();
				}
			}
		}
		repaint();
	}
}
