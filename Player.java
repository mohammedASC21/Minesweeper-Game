package MineSweeperGame;

public class Player {
    private String playerName;
    private int numGames, numWins, numLosses;

    public Player(){
        playerName = "Player 1";
        numGames = 0;
        numWins = 0;
        numLosses = 0;
    }

    public Player(String name){
        this();
        
        if(name != null){playerName = name;}
    }


    protected void addNumWins(){
        numWins++;
        numGames++;
    }

    protected void addNumLosses(){
        numLosses++;
        numGames++;
    }
        


    public String getPlayerName() {
        return playerName;
    }

    public int getNumGames() {
        return numGames;
    }

    public int getNumWins() {
        return numWins;
    }

    public int getNumLosses() {
        return numLosses;
    }
    

    @Override
    public String toString() {
        return "Player [playerName="
                + playerName + ", numGames=" + numGames + ", numWins="
                + numWins + ", numLosses=" + numLosses + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (numGames != other.numGames)
            return false;
        if (numLosses != other.numLosses)
            return false;
        if (numWins != other.numWins)
            return false;
        if (playerName == null) {
            if (other.playerName != null)
                return false;
        } else if (!playerName.equals(other.playerName))
            return false;
        return true;
    }
}