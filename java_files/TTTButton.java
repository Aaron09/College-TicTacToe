import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TTTButton extends JButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5345041896402092496L;
	
	//initializes all necessary variables and objects
	static int turn = 0;
	ImageIcon iconX;
	ImageIcon iconO;
	
	//establishes the potential icons for each button and adds the action listener
		public TTTButton(){
			iconX = new ImageIcon(getClass().getResource("xavierX.jpg"));
			iconO = new ImageIcon(getClass().getResource("ohioStateO.jpg"));
			this.addActionListener(this);
		}
		
	//called when a TicTacToe button is pressed
		public void actionPerformed(ActionEvent e){
			if (turn == 0){   //player X turn
				setIcon(iconX);
				turn+=1;
			}
			else if (turn == 1){
				setIcon(iconO);
				turn-=1;
			}
		}
		public int getTurn(){
			return turn;
		}
}
