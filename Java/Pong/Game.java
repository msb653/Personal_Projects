import javax.swing.JFrame;
import java.awt.Color;

/*
Class which initiates the game and calls the 
class to create the game display
*/

public class Game extends JFrame{
	private int width=700;
	public int height=450;
	private GameDisplay display;
	
	public Game(){
		setTitle("2 Player Ping Pong");
		setSize(width,height);
		setBackground(Color.BLACK);
		setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        display=new GameDisplay(this);
        add(display);
    }
    
    //method to return display panel
    public GameDisplay getDisplay(){
    	return display;
    }
    
    public static void main(String[] args) {
        new Game();
    }
}