
import javax.swing.JFrame;


public class TicTacToeMain{
	
		public static void main(String[]args){
			
				TicTacToeBoard theBoard = new TicTacToeBoard();
				theBoard.setTitle("Tic Tac Toe");	
				theBoard.setSize(theBoard.getWidth(),theBoard.getHeight());
				theBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				theBoard.setVisible(true);		
				
		}
		
}

