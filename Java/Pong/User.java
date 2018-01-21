import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

//Used to create the users paddles

public class User{
	private int width=10;
	private int height=60;
	private int x_coord, y_coord, y_change, up, down;
	private Game game;
	
	public User(Game g, int u, int d, int x){
		game=g;
		x_coord=x;
		//set values that control vertical movement
		up=u;
		down=d;
		//y coordiante is set to be half the height to start
		y_coord=game.getHeight()/2;
	}
	
	//method for moving user paddle position
	public void move(){
		//apply y changes if paddle isn't at top or bottom of screen
		if(y_coord>0 && y_coord<game.getHeight()-(height+height/2))
			y_coord=y_coord+y_change;
		//move paddle down 1 if it's at the top
		else if(y_coord<=0)
			y_coord=y_coord+3;
		//move paddle up if it's at the bottom
		else if(y_coord>=game.getHeight()-(height+height/2))
			y_coord=y_coord-3;
	}
	
	//redraws the paddle in updates position
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
        g.fillRect(x_coord, y_coord, width, height);
    }
    
    //returns the paddles position and dimensions
    public Rectangle getLocation() {
        return new Rectangle(x_coord, y_coord, width, height);
    }

	//method that updates y_change value based on key pressed
	public void keyPress(int input) {
        if (input==up)
            y_change=-3;
        else if (input==down)
            y_change=3;
    }
    
    //sets y_change back to 0 after key is released
    public void keyRelease(int input) {
        if (input==up || input==down)
            y_change=0;
    }
}
	
			
			
		