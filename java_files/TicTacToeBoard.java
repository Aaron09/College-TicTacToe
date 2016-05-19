import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class TicTacToeBoard extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7233404568688492988L;
	
	
	int w = 600;
	int h = 600;
	int turn = 0;
	JPanel panel = new JPanel();
	TTTButton buttons[]=new TTTButton[9];

	public TicTacToeBoard(){
		panel.setLayout(new GridLayout(3,3));
		for(int i=0; i<9; i++){
			buttons[i]=new TTTButton();
			panel.add(buttons[i]);
		}
		add(panel);
		panel.setVisible(true);
	}
	public int getWidth(){
		return w;
	}
	public int getHeight(){
		return h;
	}	
	
}