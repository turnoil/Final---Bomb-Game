//Driver
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameDriver extends JApplet implements KeyListener, ActionListener
{
	Wall leftwall, rightwall, topwall, bottomwall;
	Image background;
	Image i1, i2, i3, i4;
	Sprite1 player1;
	Sprite1 player2;
	Timer t;
	int delay = 10;
	boolean right = false;
	boolean left = false;
	boolean up = false;
	boolean down = false;
	boolean a = false;
	boolean d = false;
	boolean w = false;
	boolean s = false;
	boolean moveornotplayer1right, moveornotplayer1up, moveornotplayer1left, moveornotplayer1down, moveornotplayer2right, moveornotplayer2up, moveornotplayer2left, moveornotplayer2down;
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
		i1 = getImage(getDocumentBase(), "tankright.png");
		i2 = getImage(getDocumentBase(), "tankup.png");
		i3 = getImage(getDocumentBase(), "tankleft.png");
		i4 = getImage(getDocumentBase(), "tankdown.png");
		player1 = new Sprite1(i1, i2, i3, i4, 200, 800);
		player2 = new Sprite1(i1, i2, i3, i4, 800, 800);
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
			player1.draw(g);
			player2.draw(g);
		}
	}
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			w = true;
			//dir = 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			d = true;
			//dir = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			a = true;
			//dir = 3;
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			s = true;
			//dir = 4;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			right = true;
			//dir2 = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			left = true;
			//dir2 = 3;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			up = true;
			//dir2 = 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			down = true;
			//dir2 = 4;
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
			int currentx1 = player1.getX();
			int currenty1 = player1.getY();
			int currentx2 = player2.getX();
			int currenty2 = player2.getY();
			boolean leftwallboo1 = leftwall.checkBoundaries(currentx1, currenty1);
			boolean rightwallboo1 = rightwall.checkBoundaries(currentx1, currenty1);
			boolean topwallboo1 = topwall.checkBoundaries(currentx1, currenty1);
			boolean bottomwallboo1 = bottomwall.checkBoundaries(currentx1, currenty1);
			if (leftwallboo1 == true || rightwallboo1 == true || topwallboo1 == true || bottomwallboo1 == true)
			{
				if (dir == 1)
				{
					moveornotplayer1right = false;
					moveornotplayer1up = true;
					moveornotplayer1left = true;
					moveornotplayer1down = true;
					player1.left(moveornotplayer1left);
				}
				else if (dir == 2)
				{
					moveornotplayer1up = false;
					moveornotplayer1right = true;
					moveornotplayer1left = true;
					moveornotplayer1down = true;
					player1.down(moveornotplayer1down);
				}
				else if (dir == 3)
				{
					moveornotplayer1left = false;
					moveornotplayer1up = true;
					moveornotplayer1right = true;
					moveornotplayer1down = true;
					player1.right(moveornotplayer1right);
				}
				else
				{
					moveornotplayer1down = false;
					moveornotplayer1up = true;
					moveornotplayer1left = true;
					moveornotplayer1right = true;
					player1.up(moveornotplayer1up);
				}
			}
			else
			{
				moveornotplayer1right = true;
				moveornotplayer1up = true;
				moveornotplayer1left = true;
				moveornotplayer1down = true;
			}
			boolean leftwallboo2 = leftwall.checkBoundaries(currentx2, currenty2);
			boolean rightwallboo2 = rightwall.checkBoundaries(currentx2, currenty2);
			boolean topwallboo2 = topwall.checkBoundaries(currentx2, currenty2);
			boolean bottomwallboo2 = bottomwall.checkBoundaries(currentx2, currenty2);
			if (leftwallboo2 == true || rightwallboo2 == true || topwallboo2 == true || bottomwallboo2 == true)
			{
				if (dir2 == 1)
				{
					moveornotplayer2right = false;
					moveornotplayer2up = true;
					moveornotplayer2left = true;
					moveornotplayer2down = true;
					player2.left(moveornotplayer2left);
				}
				else if (dir2 == 2)
				{
					moveornotplayer2up = false;
					moveornotplayer2right = true;
					moveornotplayer2left = true;
					moveornotplayer2down = true;
					player2.down(moveornotplayer2down);
				}
				else if (dir2 == 3)
				{
					moveornotplayer2left = false;
					moveornotplayer2up = true;
					moveornotplayer2right = true;
					moveornotplayer2down = true;
					player2.right(moveornotplayer2right);
				}
				else
				{
					moveornotplayer2down = false;
					moveornotplayer2up = true;
					moveornotplayer2left = true;
					moveornotplayer2right = true;
					player2.up(moveornotplayer2up);
				}
			}
			else
			{
				moveornotplayer2right = true;
				moveornotplayer2up = true;
				moveornotplayer2left = true;
				moveornotplayer2down = true;
			}
			//Player 1 Move
			if (d == true && w == false && a == false && s == false)
			{
				dir = 1;
				player1.right(moveornotplayer1right);
			}
			if (w == true && d == false && a == false && s == false)
			{
				dir = 2;
				player1.up(moveornotplayer1up);
			}
			if (a == true && d == false && w == false && s == false)
			{
				dir = 3;
				player1.left(moveornotplayer1left);
			}
			if (s == true && w == false && a == false && d == false)
			{
				dir = 4;
				player1.down(moveornotplayer1down);
			}
			//Player 2 Move
			if (right == true && up == false && left == false && down == false)
			{
				dir2 = 1;
				player2.right(moveornotplayer2right);
			}
			if (up == true && right == false && left == false && down == false)
			{
				dir2 = 2;
				player2.up(moveornotplayer2up);
			}
			if (left == true && right == false && up == false && down == false)
			{
				dir2 = 3;
				player2.left(moveornotplayer2left);
			}
			if (down == true && up == false && left == false && right == false)
			{
				dir2 = 4;
				player2.down(moveornotplayer2down);
			}
		}
		repaint();
	}
}
