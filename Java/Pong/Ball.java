import java.awt.Graphics;
import javax.swing.JOptionPane;
import java.awt.Rectangle;
import java.awt.Color;

//Class for handling the ping pong ball

public class Ball{
	private int width=30;
	private int height=30;
	private Game game;
	//ball speed in x and y axis
	int x_change=2;
	int y_change=2;
	//used for ball position
	int x_coord;
	int y_coord;
	
	public Ball(Game g){
		game=g;
		x_coord=game.getWidth()/2;
		y_coord=game.getHeight()/2;
	}
	
	//updates the ball's positon in the panel
	public void move(){
		x_coord=x_coord+x_change;
		y_coord=y_coord+y_change;
		//if ball passes left paddle
		if(x_coord<0){
			game.getDisplay().scoreUpdate(1);//update score
			x_coord=game.getWidth()/2;//reset ball position
			x_change=-x_change;//reverse ball direction
		}
		//if ball passes right paddle
		else if(x_coord>game.getWidth()-width-7){
			game.getDisplay().scoreUpdate(2);//update score
			x_coord=game.getWidth()/2;//reset ball position
			x_change=-x_change;//reverse ball direction
		}
		//reverse y direction if top/bottom hit
		else if (y_coord<0 || y_coord>game.getHeight()-height-29)
            y_change = -y_change;
        checkHit();
	}
	
	//checks if the ball made contact with either paddle
	public void checkHit(){
		if(game.getDisplay().getPlayer(1).getLocation().intersects(getLocation())
			||game.getDisplay().getPlayer(2).getLocation().intersects(getLocation()))
			x_change=-x_change;//if a paddle is hit, reverse x direction
	}
	
	//return current location of ball
	public Rectangle getLocation(){
		return new Rectangle(x_coord, y_coord, width, height);
	}
	
	//draw ball with updated position
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(x_coord, y_coord, width, height);
	}
	
}
	