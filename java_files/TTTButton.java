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
	
	
	static boolean winner = false;
	static int turn = 0;
	ImageIcon iconX;
	ImageIcon iconO;
	static int [] array = new int[] {0,0,0,0,0,0,0,0,0};
	int x,y,z;
	JFrame popUpFrame = new JFrame();
	JPanel popUpPanel = new JPanel();
	JLabel popUpLabel = new JLabel();
	
	
	
		public TTTButton(){
			iconX = new ImageIcon(getClass().getResource("/resources/xavierX.jpg"));
			iconO = new ImageIcon(getClass().getResource("/resources/ohioStateO.jpg"));
			this.addActionListener(this);
			
		}
		
		public void actionPerformed(ActionEvent e){
			if (turn == 0){
				setIcon(iconX);
				z = setZ(getLocation().x,getLocation().y);
				setArray(z,array,turn);
				if(checkWinner(array) == true){
					turn = 3;
					popUpLabel.setText("Player X wins!");
					popUpPanel.add(popUpLabel);
					popUpFrame.setSize(200,100);
					popUpFrame.add(popUpPanel);
					popUpFrame.setVisible(true);
				}
				
				turn+=1;
			}
			else if (turn == 1){
				setIcon(iconO);
				z = setZ(getLocation().x,getLocation().y);
				setArray(z,array,turn);
				if(checkWinner(array) == true){
					turn = 3;
					popUpLabel.setText("Player O wins!");
					popUpPanel.add(popUpLabel);
					popUpFrame.setSize(200,100);
					popUpFrame.add(popUpPanel);
					popUpFrame.setVisible(true);
				}
				
				turn-=1;
			}
			
		}
		public void setArray(int z,int [] arraySet, int turn){
			if (turn == 0){
				array[z] = 1;
			}
			if (turn == 1){
				array[z] = 2;
			}
		}
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
