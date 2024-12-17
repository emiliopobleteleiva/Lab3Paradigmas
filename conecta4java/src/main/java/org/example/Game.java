import org.example.*;

public class Game {
    private Player p1;
    private Player p2;
    private Board tablero;
    private int currentTurn;
    private int history[];

    public Game(Player p1, Player p2, Board tablero, int currentTurn){
        this.p1 = p1;
        this.p2 = p2;
        this.tablero = Board();
        this.currentTurn = currentTurn;
    }

    public int history(){
        return history;
    }

    public bool esEmpate(){
        if(tablero.canPlay()){
            if(p1.getRemainingPieces() + p2.getRemainingPieces() == 0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    public Player getCurrentPlayer(){
        if(currentTurn == p1.getID()){
            return p1;
        }
        else{
            return p2;
        }
    }

    public Board boardGetState(){
        for(int i = 0; i < 6; i++){
            System.out.println("| ");
            for(int j = 0; j < 7; j++){
                System.out.println(tablero[i][j], " ");
            }
            System.out.println("|\n");
        }
        return tablero;
    }

    public Game endGame(){

    }

    public Game realizarMovimiento(Player p, int columna){
        
        return Game;
    }
}
