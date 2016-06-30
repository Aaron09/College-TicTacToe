import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class TicTacToeBoard extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7233404568688492988L;
	
	//initializes all necessary variables and objects
	int w = 600;
	int h = 600;
	JPanel panel = new JPanel();
	TTTButton buttons[]=new TTTButton[9];

	//creates the nine button TicTacToe board
	public TicTacToeBoard(){
		panel.setLayout(new GridLayout(3,3));
		for(int i=0; i<9; i++){
			buttons[i] = new TTTButton();
			panel.add(buttons[i]);
		}
		add(panel);
		panel.setVisible(true);
	}
	//used to make the size of the frame the same size as the board
	public int getWidth(){
		return w;
	}
	public int getHeight(){
		return h;
	}	
	
}