//https://www.youtube.com/watch?v=cEs3T7jcsI0&ab_channel=mohammedchowdhury

package MineSweeperGame;

import java.util.Random;

public class Grid
{
	private boolean[][] bombGrid;
	private int[][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;

	public Grid(){
		numRows = 10;
		numColumns = 10;
		numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		createBombGrid();
		createCountGrid();
	}
	
	public Grid(int rows, int columns) {
	    this.numRows = rows;
	    this.numColumns = columns;
	    this.numBombs = 25; 
	    this.bombGrid = new boolean[numRows][numColumns];
	    this.countGrid = new int[numRows][numColumns];
	    createBombGrid();
	    createCountGrid();
	}

	public Grid(int rows, int columns, int numBombs) {
	    this.numRows = rows;
	    this.numColumns = columns;
	    this.numBombs = numBombs; 
	    this.bombGrid = new boolean[numRows][numColumns];
	    this.countGrid = new int[numRows][numColumns];
	    createBombGrid();
	    createCountGrid();
	}


	public int getNumRows(){
		return numRows;
	}

	public int getNumColumns(){
		return numColumns;
	}

	public int getNumBombs(){
		return numBombs;
	}

	public boolean[][] getBombGrid(){
		boolean[][] bombGridCopy = new boolean[numRows][numColumns];

		for (int row = 0; row < numRows; row++){
			for (int col = 0; col < numColumns; col++){
				bombGridCopy[row][col] = bombGrid[row][col];
			}
		}

		return bombGridCopy;



	}

	public int[][] getCountGrid(){
		int[][] countGridCopy = new int[numRows][numColumns];

		for (int row = 0; row < numRows; row++){
			for (int col = 0; col < numColumns; col++){
				countGridCopy[row][col] = countGrid[row][col];
			}
		}

		return countGridCopy;


	}

	public boolean isBombAtLocation(int row, int column){

		return bombGrid[row][column];

	}



	public int getCountAtLocation(int row, int column){

		return countGrid[row][column];

	} 




	private void createBombGrid() {
		Random random = new Random();
		int bombsPlaced = 0;

		while (bombsPlaced < numBombs) {
			int row = random.nextInt(getNumRows()); 
			int col = random.nextInt(getNumColumns());

			if (!bombGrid[row][col]) {
				bombGrid[row][col] = true;
				bombsPlaced++; 
			}
		}
	}



	public void createCountGrid() {
		countGrid = new int[numRows][numColumns];
		boolean[][] bombGrid = getBombGrid();

		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				int bombCount = 0;

				for (int c = col - 1; c <= col + 1; c++) {
					for (int r = row - 1; r <= row + 1; r++) {


						if (c >= 0 && c < numColumns && r >= 0 && r < numRows) {
							if (bombGrid[r][c]) {
								bombCount++;
							}
						}
					}
				}

				countGrid[row][col] = bombCount;
			}
		}
	}


}




//MineSweeperDriver

//public class MineSweeperDriver {
//
//	public static void main(String[] args) {
//		MineSweeperGUI gui = new MineSweeperGUI();
//
//	}
//
//}


//GameBoardInterface

//public interface GameBoardInterface {
//	public void displayBoard();
//	public boolean isFull();
//	public void clearBoard();
//	public boolean isWinner();
//	public void revealBoard();
//	public void displayWinner();
//	public void displayLoss();
//	
//}



//Player Class

//public class Player {
//    private String playerName;
//    private int numGames, numWins, numLosses;
//
//    public Player(){
//        playerName = "Player 1";
//        numGames = 0;
//        numWins = 0;
//        numLosses = 0;
//    }
//
//    public Player(String name){
//        this();
//        
//        if(name != null){playerName = name;}
//    }
//
//
//    protected void addNumWins(){
//        numWins++;
//        numGames++;
//    }
//
//    protected void addNumLosses(){
//        numLosses++;
//        numGames++;
//    }
//        
//
//
//    public String getPlayerName() {
//        return playerName;
//    }
//
//    public int getNumGames() {
//        return numGames;
//    }
//
//    public int getNumWins() {
//        return numWins;
//    }
//
//    public int getNumLosses() {
//        return numLosses;
//    }
//    
//
//    @Override
//    public String toString() {
//        return "Player [playerName="
//                + playerName + ", numGames=" + numGames + ", numWins="
//                + numWins + ", numLosses=" + numLosses + "]";
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Player other = (Player) obj;
//        if (numGames != other.numGames)
//            return false;
//        if (numLosses != other.numLosses)
//            return false;
//        if (numWins != other.numWins)
//            return false;
//        if (playerName == null) {
//            if (other.playerName != null)
//                return false;
//        } else if (!playerName.equals(other.playerName))
//            return false;
//        return true;
//    }


//}  End of player class 




//MineSweeperGUI class (main GUI class)

//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//public class MineSweeperGUI extends JFrame{
//
//	private JPanel jpMain;
//	private MineSweeperBoard jpMSBoard;
//	private ScoreBoard jpScoreBoard;
//
//	private Player player1;
//
//
//
//	public MineSweeperGUI(){
//		player1 = new Player("Spider-man");
//
//
//		jpMain = new JPanel();
//		jpMain.setLayout(new BorderLayout());
//
//		jpMSBoard  = new MineSweeperBoard();
//		jpScoreBoard = new ScoreBoard();
//
//		//add to jpMain 
//		jpMain.add(jpScoreBoard, BorderLayout.NORTH);
//		jpMain.add(jpMSBoard, BorderLayout.CENTER);
//
//		add(jpMain);//add the main JPanel to this JFrame
//		setSize(600,600);
//		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//	}//end of constructor
//
//
//
//	private class  MineSweeperBoard extends JPanel implements GameBoardInterface, ActionListener{
//		private JButton [][] board;
//		public Grid grid;
//
//		private static final Font BOLD_NUMBER_FONT = new Font("Arial Rounded MT Bold", Font.BOLD, 30);
//		private static final Font minesweeperFont = new Font("Arial", Font.BOLD, 30);
//		private static final Font buttonFont = new Font("Tahoma", Font.PLAIN, 30);
//		//		Imageicon
//		ImageIcon bombImageIcon = new ImageIcon("bomb.png");
//		ImageIcon scaledbombImageIcon = new ImageIcon(bombImageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_FAST));
//
//
//		private static final int NUM_ROWS=10;
//		private static final int NUM_COLS=10;
//
//
//		public MineSweeperBoard(){
//			grid = new Grid();
//
//			//			Below code only for test 
//			printGridsToConsole();  // Print initial grids
//			//			Above code only for test 
//
//			setLayout(new GridLayout(NUM_ROWS,NUM_COLS));
//			displayBoard();
//		}
//
//
//		//		Below code only for test 
//		//		Below code only for test 
//		private void printGridsToConsole() {
//			System.out.println("\nBOMB GRID");
//			for (int r = 0; r < NUM_ROWS; r++) {
//				for (int c = 0; c < NUM_COLS; c++) {
//					System.out.print(grid.isBombAtLocation(r, c) ? "T " : "F ");
//				}
//				System.out.println();
//			}
//
//			System.out.println("\nCOUNT GRID");
//			for (int r = 0; r < NUM_ROWS; r++) {
//				for (int c = 0; c < NUM_COLS; c++) {
//					System.out.print(grid.getCountAtLocation(r, c) + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//		//		Above code only for test 
//		//		Above code only for test 
//
//
//
//		@Override
//		public void displayBoard() {
//			board = new JButton[NUM_ROWS][NUM_COLS];
//			Font bigFont = new Font(Font.SANS_SERIF,Font.BOLD, 25);
//			for(int row=0; row<NUM_ROWS; row++){
//				for(int col=0; col<NUM_COLS; col++){
//					board[row][col] = new JButton();
//					board[row][col].setFont(bigFont);
//
//
//					board[row][col].setBackground(new Color(102,165,88));
//					board[row][col].setForeground(Color.RED); 
//					board[row][col].setOpaque(true);
//					board[row][col].setBorderPainted(true);
//
//
//					board[row][col].addActionListener(this);
//					board[row][col].setEnabled(true);
//					this.add(board[row][col]);
//				}
//			}
//		}
//
//
//		@Override
//		public void clearBoard() {
//			for(int row=0; row<board.length; row++){
//				for(int col=0; col < board[row].length; col++){
//					board[row][col].setIcon(null);
//					board[row][col].setText("");     
//					board[row][col].setBackground(new Color(102,165,88));     
//					board[row][col].setEnabled(true);
//				}
//			}
//		}
//
//		@Override
//		public void displayWinner() {
//			String message = player1.getPlayerName() + " won!";
//			JOptionPane.showMessageDialog(null, message);
//			jpScoreBoard.jlPlayer1NumWins.setText(String.format("%02d",player1.getNumWins()));
//
//		}
//
//		@Override
//		public void displayLoss() {
//			JOptionPane.showMessageDialog(null, "YOU LOST!");
//			jpScoreBoard.jlPlayer1Losses.setText(String.format("%02d",player1.getNumLosses()));
//
//		}
//
//		@Override
//		public boolean isFull() {
//			for(int row=0; row<board.length; row++){
//				for(int col=0; col < board[row].length; col++){
//					if(board[row][col].getText().trim().isEmpty()){
//						return false;
//					}
//				}
//			}
//			return true;
//		}
//
//
//		@Override
//		public boolean isWinner() {
//			for (int row = 0; row < board.length; row++) {
//				for (int col = 0; col < board[row].length; col++) {
//					if (!grid.isBombAtLocation(row, col) && 
//							board[row][col].isEnabled() && 
//							board[row][col].getText().isEmpty()) {
//						return false;
//					}
//				}
//			}
//			return true;
//		}
//
//		@Override
//		public void revealBoard() {
//			boolean[][] BombGridReveal = grid.getBombGrid();
//			int[][] CountGridReveal = grid.getCountGrid();
//
//			for (int row = 0; row < board.length; row++) {
//				for (int col = 0; col < board[row].length; col++) {
//					if (grid.isBombAtLocation(row, col)) {
//						if (BombGridReveal[row][col]) {
//							board[row][col].setIcon(scaledbombImageIcon);
//							board[row][col].setForeground(Color.RED);
//						}
//					} else {
//						int count = grid.getCountAtLocation(row, col);
//						board[row][col].setText(String.valueOf(count));
//						Color setColor = getNumberColor(count);
//						board[row][col].setForeground(setColor);
//						board[row][col].setFont(buttonFont);
//					}
//				}
//			}
//		}
//
//		public void revealAfter0Clicked(int ClickedRow, int ClickedCol) {
//			boolean[][] BombGridReveal_NonBomb = grid.getBombGrid();
//			int[][] CountGridReveal_0 = grid.getCountGrid();
//
//			if (CountGridReveal_0[ClickedRow][ClickedCol] == 0) {
//
//				for (int c = ClickedCol - 1; c <= ClickedCol + 1; c++) {
//					if (c < 0 || c >= board[0].length) continue;
//
//					for (int r = ClickedRow - 1; r <= ClickedRow + 1; r++) {
//						if (r < 0 || r >= board.length   || (r == ClickedRow && c == ClickedCol)) continue;
//
//						if (CountGridReveal_0[r][c] == 0 || !BombGridReveal_NonBomb[r][c]) {
//							int count = grid.getCountAtLocation(r, c);
//							board[r][c].setText(String.valueOf(count));
//							board[r][c].setForeground(Color.BLUE); 
//							board[r][c].setEnabled(false);
//						}
//					}	
//				}
//			}
//		}
//
//	
//		
//		private Color getNumberColor(int num) {
//			switch(num) {
//			case 1: return Color.BLUE;
//			case 2: return new Color(0, 128, 0); 
//			case 3: return Color.RED;
//			case 4: return new Color(0, 0, 128); 
//			case 5: return new Color(128, 0, 0);
//			case 6: return new Color(0, 128, 128); 
//			default: return Color.BLACK;
//			}
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("inside actionPerformed Method");
//			JButton btnClicked = (JButton) e.getSource();
//			btnClicked.setBackground(Color.GREEN); 
//
//			//Imageicon
//			ImageIcon bombImageIcon = new ImageIcon("bomb.png");
//			ImageIcon scaledbombImageIcon = new ImageIcon(bombImageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_FAST));
//
//			// getting the rows and column of button btnClicked
//			int btnClickedRow = -1;
//			int btnClickedCol = -1;
//
//			for (int row = 0; row < board.length; row++) {
//				for (int col = 0; col < board[row].length; col++) {
//					if (board[row][col] == btnClicked) {
//						btnClickedRow = row;
//						btnClickedCol = col;
//						break;
//					}
//				}
//			}
//
//			// Handle bomb cell click
//			if (grid.isBombAtLocation(btnClickedRow, btnClickedCol)) {
//				btnClicked.setBackground(Color.RED);
//				revealBoard();
//				player1.addNumLosses();
//				displayLoss();
//				promptPlayAgain();
//
//			} else {
//				// Handle safe cell click
//				int count = grid.getCountAtLocation(btnClickedRow, btnClickedCol);
//				btnClicked.setText(String.valueOf(count));
//
//				revealAfter0Clicked(btnClickedRow, btnClickedCol);
//
//
//				btnClicked.setFont(BOLD_NUMBER_FONT);
//				btnClicked.setForeground(Color.BLACK);
//				
//				btnClicked.setEnabled(false);
//
//				if (isWinner()) {
//					revealBoard();
//					player1.addNumWins();
//					displayWinner();
//					promptPlayAgain();
//				}
//			}
//		}
//
//
//		private void promptPlayAgain() {
//			int yesNo = JOptionPane.showConfirmDialog(null, "Play Again?", "Yes or No", JOptionPane.YES_NO_OPTION);
//			if(yesNo == JOptionPane.YES_OPTION){
//				clearBoard();
//			}
//			else{
//				System.exit(EXIT_ON_CLOSE);
//			}
//		}
//		
//	}//end of MineSweeperBoard class
//
//
//	private class ScoreBoard extends JPanel {
//		private JPanel jpPlayScoreInfo;
//		private JLabel jlForPlayerNames, jlPlayer1Name,
//		jlForPlayerWins,  jlPlayer1NumWins,
//		jlForPlayerLOSSES, jlPlayer1Losses;
//
//		public ScoreBoard() {
//			setLayout(new BorderLayout());
//			setBackground(new Color(248, 249, 250)); 
//		    setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 30));
//
//			Font labelFont = new Font("Segoe UI Semibold", Font.PLAIN,  18);
//			Font valueFont = new Font("Segoe UI Semibold", Font.BOLD, 20);
//			Color labelColor = new Color(73,80,87);  // charcoal
//			Color valueColor = new Color(13,110,253);  // blue
//
//			jpPlayScoreInfo = new JPanel(new GridLayout(3, 3));
//			jpPlayScoreInfo.setOpaque(false);
//
//			jlForPlayerNames  = new JLabel("NAME: ");
//			jlPlayer1Name     = new JLabel(player1.getPlayerName());
//			jlForPlayerWins   = new JLabel("NUM WINS: ");
//			jlPlayer1NumWins  = new JLabel("--------");
//			jlForPlayerLOSSES = new JLabel("NUM LOSSES: ");
//			jlPlayer1Losses   = new JLabel("--------");
//
//			JLabel[] scoreLabels = {
//					jlForPlayerNames,  jlPlayer1Name,
//					jlForPlayerWins,   jlPlayer1NumWins,
//					jlForPlayerLOSSES, jlPlayer1Losses
//			};
//
//			for (int i = 0; i < scoreLabels.length; i++) {
//				if (i % 2 == 0) {
//					scoreLabels[i].setFont(labelFont);
//					scoreLabels[i].setForeground(labelColor);
//				} else {
//					scoreLabels[i].setFont(valueFont);
//					scoreLabels[i].setForeground(valueColor);
//				}
//				jpPlayScoreInfo.add(scoreLabels[i]);
//			}
//
//			add(jpPlayScoreInfo, BorderLayout.NORTH);
//		}
//	}
//	//end of ScoreBoard class
//}//end of MineSweeperGUI JFrame class





