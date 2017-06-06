//Driver
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GameDriver extends JApplet implements KeyListener, ActionListener
{
	Wall leftwall, rightwall, topwall, bottomwall, wall1, wall2, wall3, wall4;
	Image background;
	Image i1, i2, i3, i4;
	Image threebombs;
	Image bomb1;
	Image twoandhalfbombs;
	Image twobombs;
	Image oneandhalfbombs;
	Image onebomb;
	Image zeroandhalfbombs;
	Image zerobombs;
	Image currentImage;
	Projectile player1bomb, player1bomb2;
	Sprite1 player1;
	Sprite1 player2;
	BombAmmo ba1, ba2;
	Timer t;
	long time1_1, time1_2;
	int bombtime1 = 0;
	int bomb1movenum, bomb1movedir;
	int currentx1, currenty1;
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
	boolean player1throw = false;
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
		wall1 = new Wall(150, 150, 50, 300);
		wall2 = new Wall(960, 500, 50, 500);
		wall3 = new Wall(400, 500, 50, 200);
		wall4 = new Wall(600, 100, 50, 200);
		i1 = getImage(getDocumentBase(), "tankright.png");
		i2 = getImage(getDocumentBase(), "tankup.png");
		i3 = getImage(getDocumentBase(), "tankleft.png");
		i4 = getImage(getDocumentBase(), "tankdown.png");
		bomb1 = getImage(getDocumentBase(), "ez1.png");
		threebombs = getImage(getDocumentBase(), "3bombs.png");
		twoandhalfbombs = getImage(getDocumentBase(), "2andhalfbombs.png");
		twobombs = getImage(getDocumentBase(), "2bombs.png");
		oneandhalfbombs = getImage(getDocumentBase(), "1andhalfbombs.png");
		onebomb = getImage(getDocumentBase(), "1bomb.png");
		zeroandhalfbombs = getImage(getDocumentBase(), "0andhalfbombs.png");
		zerobombs = getImage(getDocumentBase(), "0bombs.png");
		player1 = new Sprite1(i1, i2, i3, i4, 200, 800);
		player2 = new Sprite1(i1, i2, i3, i4, 800, 800);
		ba1 = new BombAmmo(threebombs, twoandhalfbombs, twobombs, oneandhalfbombs, onebomb, zeroandhalfbombs, zerobombs, 0, 820, 0, 820);
		ba2 = new BombAmmo(threebombs, twoandhalfbombs, twobombs, oneandhalfbombs, onebomb, zeroandhalfbombs, zerobombs, 1080, 820, 1080, 820);
		currentx1 = 20;
		currenty1 = 850;
		player1bomb = new Projectile(bomb1);
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
			wall1.drawWall(g);
			wall2.drawWall(g);
			wall3.drawWall(g);
			wall4.drawWall(g);
			player1.draw(g);
			player2.draw(g);
			if (player1throw == true)
			{
				currentx1 = player1.getX();
				currenty1 = player1.getY();
				player1bomb.setLocation(currentx1, currenty1, dir);
			}
			player1bomb.drawProjectile(g);
			ba1.draw(g);
			ba2.draw(g);
		}
	}
	public void keyPressed(KeyEvent e)
	{
		//Player 1
		if (e.getKeyCode() == KeyEvent.VK_E)
		{
			player1throw = true;
		}
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
		//Player 2
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
		//Player 1
		if (e.getKeyCode() == KeyEvent.VK_E)
		{
			player1throw = false;
		}
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
			currentx1 = player1.getX();
			currenty1 = player1.getY();
			int currentx2 = player2.getX();
			int currenty2 = player2.getY();
			if (player1throw == true)
			{
				bombtime1++;
			}
			if (player1throw == false)
			{
				if (bomb1movenum == 0)
				{
					bomb1movenum = player1bomb.moveProjectile(bombtime1);
					bomb1movedir = dir;
				}
				if (bomb1movenum > 0)
				{
					if (bomb1movedir == 1)
					{
						player1bomb.moveRight();
					}
					if (bomb1movedir == 2)
					{
						player1bomb.moveUp();
					}
					if (bomb1movedir == 3)
					{
						player1bomb.moveLeft();
					}
					if (bomb1movedir == 4)
					{
						player1bomb.moveDown();
					}
				}
				bombtime1 = 0;
			}
			boolean leftwallboo1 = leftwall.checkBoundaries(currentx1, currenty1);
			boolean rightwallboo1 = rightwall.checkBoundaries(currentx1, currenty1);
			boolean topwallboo1 = topwall.checkBoundaries(currentx1, currenty1);
			boolean bottomwallboo1 = bottomwall.checkBoundaries(currentx1, currenty1);
			boolean wall1boo1 = wall1.checkBoundaries(currentx1, currenty1);
			boolean wall2boo1 = wall2.checkBoundaries(currentx1, currenty1);
			boolean wall3boo1 = wall3.checkBoundaries(currentx1, currenty1);
			boolean wall4boo1 = wall4.checkBoundaries(currentx1, currenty1);
			if (leftwallboo1 == true || rightwallboo1 == true || topwallboo1 == true || bottomwallboo1 == true || wall1boo1 == true || wall2boo1 == true || wall3boo1 == true || wall4boo1 == true)
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
			boolean wall1boo2 = wall1.checkBoundaries(currentx2, currenty2);
			boolean wall2boo2 = wall2.checkBoundaries(currentx2, currenty2);
			boolean wall3boo2 = wall3.checkBoundaries(currentx2, currenty2);
			boolean wall4boo2 = wall4.checkBoundaries(currentx2, currenty2);
			if (leftwallboo2 == true || rightwallboo2 == true || topwallboo2 == true || bottomwallboo2 == true || wall1boo2 == true || wall2boo2 == true || wall3boo2 == true || wall4boo2 == true)
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
			if (bomb1movenum > 0)
			{
				bomb1movenum = bomb1movenum - 1;
			}
		}
		repaint();
	}
}
