package MineSweeperGame;

public interface GameBoardInterface {
	public void displayBoard();
	public boolean isFull();
	public void clearBoard();
	public boolean isWinner();
	public void revealBoard();
	public void displayWinner();
	public void displayLoss();
	
}
