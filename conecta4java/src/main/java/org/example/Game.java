

public class Game {
    Player p1;
    Player p2;
    Board tablero;
    int currentTurn;
    int history[];

    public Game(Player p1, Player p2, Board tablero, int currentTurn){
        this.p1 = p1;
        this.p2 = p2;
        this.tablero = tablero;
        this.currentTurn = currentTurn;
    }

    
}
