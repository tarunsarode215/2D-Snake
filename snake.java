import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

class Fdemo extends JFrame
{
	JPdemo jp;
	Fdemo()
	{
	 jp=new JPdemo();	
	 add(jp);
	}
}
class JPdemo extends JPanel implements ActionListener,KeyListener
{
	ImageIcon img1,img2,img3;
	Image dot,head1,food;
	int  x[]=new int[100];
	int  y[]=new int[100];
	int dots=5;
	boolean start_game=false;
	boolean left=false,right=true,up=false,down=false;
	int r1=0,r2=0;
	
	JPdemo()
	{
		x[0]=120;
		y[0]=120;
		x[1]=100;
		y[1]=100;
		x[2]=80;
		y[2]=100;
		x[3]=60;
		y[3]=100;
		x[4]=40;
		y[4]=100;
		// x[0]=120;
		// y[0]=100;
	  setBackground(Color.white);	
	  img1 =new ImageIcon("dot.png");
	  dot=img1.getImage();
	  img2 =new ImageIcon("head1.png");
	  head1=img2.getImage();
	  img3 =new ImageIcon("food.png");
	  food=img3.getImage();
      Timer t=new Timer(200,this);
      t.start();	  
      addKeyListener(this);	
	  setFocusable(true); 
      randomDemo();	  
	}
	void randomDemo()
	{
		r1=(int)Math.round(Math.random()*45+1);
		r1=r1*20;
		r2=(int)Math.round(Math.random()*45+1);
		r2=r2*20;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(food,r1,r2,this);
		for(int i=0;i<dots;i++)
		{
			if(i==0)
			{
				g.drawImage(head1,x[i],y[i],this);
			}
			else
			{
				g.drawImage(dot,x[i],y[i],this);
	        }
	    }
	}
	public void actionPerformed(ActionEvent e)
	{
		if(start_game)
		{	 
		for(int i=dots;i>0;i--)
		{
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		if(right)
		{	
		x[0]=x[0]+20;
		repaint();
		}
		if(left)
		{	
		x[0]=x[0]-20;
		repaint();
		}
		if(up)
		{	
		y[0]=y[0]-20;
		repaint();
		}
		if(down)
		{	
		y[0]=y[0]+20;
		repaint();
		}
		}
		}
		
	public void keyReleased(KeyEvent e)
	 {}
	 public void keyPressed(KeyEvent e)
	 
	 {
		 start_game=true;
		 if(e.getKeyCode()==KeyEvent.VK_LEFT)
		 {
			 right=false;
			 up=false;
			 down=false;
			 left=true;
		 }
	  		 if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		 {
			 right=true;
			 up=false;
			 down=false;
			 left=false;
		 }
	  		 if(e.getKeyCode()==KeyEvent.VK_UP)
		 {
			 right=false;
			 up=true;
			 down=false;
			 left=false;
		 }
	  		 if(e.getKeyCode()==KeyEvent.VK_DOWN)
		 {
			 right=false;
			 up=false;
			 down=true;
			 left=false;
		 }
	  }
     public void keyTyped(KeyEvent e){}
}
class snake
{
  public static void main (String ar[])	
  {
	Fdemo f=new Fdemo();
	f.setVisible(true);
	f.setSize(1000,1000);
	f.setLocation(200,50);
	f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
  }
}