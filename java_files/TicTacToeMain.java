
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToeMain{
	
	static JFrame popUpFrame = new JFrame();
	static JPanel popUpPanel = new JPanel();
	static JLabel popUpLabel = new JLabel();
	
		public static void main(String[]args){
				
			int [] arr = new int[] {0,0,0,0,0,0,0,0,0};
			
			//initializes the TicTacToe board and sets the default settings
			TicTacToeBoard theBoard = new TicTacToeBoard();
			theBoard.setTitle("Tic Tac Toe");	
			theBoard.setSize(theBoard.getWidth(),theBoard.getHeight());
			theBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			theBoard.setVisible(true);
			
			for(int i=0; i<theBoard.buttons.length; i++){
				JButton placeHolderButton = (JButton) theBoard.buttons[i];
				int j = i;
				placeHolderButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e){
						if (((TTTButton) placeHolderButton).getTurn() == 0){
							arr[j] = 1;
						} else {
							arr[j] = 2;
						}
						if (checkWinner(arr) == true){
							winnerDetermined(((TTTButton)placeHolderButton).getTurn());
						}
					}
				});
			
			}
			
		}
		
		public static void winnerDetermined(int turn){
			if(turn == 0){
				popUpLabel.setText("Player X wins!");
			}else if(turn == 1){
				popUpLabel.setText("Player O wins!");
			}
			popUpPanel.add(popUpLabel);
			popUpFrame.setSize(200,100);
			popUpFrame.add(popUpPanel);
			popUpFrame.setVisible(true);
			turn = 3;   //disables the user from continuing to play; the game has ended
		}
		
		public static boolean checkWinner(int[]arrayCheck){
			if(arrayCheck[0] == arrayCheck[1] && arrayCheck[0] == arrayCheck[2] && arrayCheck[0]!=0)
				return true;
			else if (arrayCheck[3] == arrayCheck[4] && arrayCheck[3] == arrayCheck[5] && arrayCheck[3]!=0)
				return true;
			else if (arrayCheck[6] == arrayCheck[7] && arrayCheck[6] == arrayCheck[8] && arrayCheck[6]!=0)
				return true;
			else if (arrayCheck[0] == arrayCheck[3] && arrayCheck[0] == arrayCheck[6] && arrayCheck[0]!=0)
				return true;
			else if (arrayCheck[1] == arrayCheck[4] && arrayCheck[1] == arrayCheck[7] && arrayCheck[1]!=0)
				return true;
			else if (arrayCheck[2] == arrayCheck[5] && arrayCheck[2] == arrayCheck[8] && arrayCheck[2]!=0)
				return true;
			else if (arrayCheck[2] == arrayCheck[4] && arrayCheck[2] == arrayCheck[6] && arrayCheck[2]!=0)
				return true;
			else if (arrayCheck[0] == arrayCheck[4] && arrayCheck[0] == arrayCheck[8] && arrayCheck[0]!=0)
				return true;
			else 
				return false;
		}
				
}

