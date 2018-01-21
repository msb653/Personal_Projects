import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.Timer;


//class for running/updating the game after initiation
public class GameDisplay extends JPanel implements ActionListener,KeyListener{
	private User player1, player2;
	private Ball ball;
	private Game game;
	private int p1_score, p2_score;

	public GameDisplay(Game g){
		game=g;
		ball=new Ball(g);
		setBackground(Color.BLACK);
		player1=new User(game,KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 36);
		player2 = new User(game, KeyEvent.VK_W, KeyEvent.VK_S, 20);
		Timer timer=new Timer(5,this);
		timer.start();
		addKeyListener(this);
		setFocusable(true);
	}
	
	//returns a user
	public User getPlayer(int i){
		if(i==1)
			return player1;
		else
			return player2;
	}
	
	//updates score
	public void scoreUpdate(int i){
		if(i==1)
			p1_score++;
		else
			p2_score++;
	}
	
	//return player score
	public int getScore(int i){
		if(i==1)
			return p1_score;
		else
			return p2_score;
	}
	
	//updates both users and ball location
	private void update() {
		player1.move();
        player2.move();
        ball.move();
    }
    
     public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
    
    //call user method for key press
    public void keyPressed(KeyEvent k) {
        player1.keyPress(k.getKeyCode());
        player2.keyPress(k.getKeyCode());
    }

    //call user method for key release
    public void keyReleased(KeyEvent k) {
        player1.keyRelease(k.getKeyCode());
        player2.keyRelease(k.getKeyCode());
    }
    
    public void keyTyped(KeyEvent e) {
        ;
    }
    
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        for (int i=10; i<=game.getHeight()-10; i=i+10){
        	g.drawLine(game.getWidth()/2,i,game.getWidth()/2,i+5);
        }
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
        g.drawString(game.getDisplay().getScore(1) +"" ,game.getWidth()/4, 50);
        g.drawString(game.getDisplay().getScore(2) +"" ,(game.getWidth()/4)*3, 50);
        
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);
    }
}
    
    
    