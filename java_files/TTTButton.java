import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class TTTButton extends JButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5345041896402092496L;
	
	//initializes all necessary variables
	static boolean winner = false;
	static int turn = 0;
	ImageIcon iconX;
	ImageIcon iconO;
	static int [] array = new int[] {0,0,0,0,0,0,0,0,0};
	int x,y,z;
	int frameWidth = 600;
	int frameHeight = 600;
	JFrame popUpFrame = new JFrame();
	JPanel popUpPanel = new JPanel();
	JLabel popUpLabel = new JLabel();
	
	
	//establishes the potential icons for each button and adds the action listener
		public TTTButton(){
			iconX = new ImageIcon(getClass().getResource("/resources/xavierX.jpg"));
			iconO = new ImageIcon(getClass().getResource("/resources/ohioStateO.jpg"));
			this.addActionListener(this);
		}
		
	//called when a TicTacToe button is pressed
		public void actionPerformed(ActionEvent e){
			if (turn == 0){   //player X turn
				setIcon(iconX);
				z = setZ(getLocation().x,getLocation().y);  //used to determine which button was clicked
				setArray(z,array,turn);   //sets the location in the analogous array to the proper result (X or O)
				if(checkWinner(array) == true){
					winnerDetermined();
				}
				turn+=1;
			}
			else if (turn == 1){
				setIcon(iconO);
				z = setZ(getLocation().x,getLocation().y);
				setArray(z,array,turn);
				if(checkWinner(array) == true){
					winnerDetermined();
				}
				turn-=1;
			}
		}
		//displays a pop-up JFrame stating which player won the game
		public void winnerDetermined(){
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
		//sets the analogous location in the array for the button clicked in the game
		public void setArray(int z,int [] arraySet, int turn){
			if (turn == 0){
				array[z] = 1;
			}
			if (turn == 1){
				array[z] = 2;
			}
		}
		//determines which button was clicked based on the x and y coordinates of the click
		public int setZ(int x,int y){
			if (x==1 && y==0)
				z = 0;
			else if (x<200 && x>1 && y==0)
				z = 1;
			else if (x<400 && x>200 && y==0)
				z = 2;
			else if (x==1 && y<200)
				z = 3;
			else if (x<200 && x>1 && y<200 && y>1)
				z = 4;
			else if (x<400 && x>200 && y<200 && y>1)
				z = 5;
			else if (x==1 && y<400 && y>200)
				z = 6;
			else if (x<200 && x>1 && y<400 && y>200)
				z = 7;
			else if (x<400 && x>200 && y<400 && y>200)
				z = 8;
			return z;
		}
		//checks for three in a row horizontally, vertically, and diagonally in the array representing the game buttons
		public boolean checkWinner(int[]arrayCheck){
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
