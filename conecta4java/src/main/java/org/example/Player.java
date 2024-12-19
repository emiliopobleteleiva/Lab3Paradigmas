import org.example.*;

public class Player{
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    //crear clase Player
    public Player(int id, String name, String color, int remainingPieces){
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.remainingPieces = remainingPieces;
    }

    //obtenedores de informacion
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }
    public int getDraws() {
        return draws;
    }
    public int getRemainingPieces() {
        return remainingPieces;
    }

    //modificadores
    public void useFicha(){
        if (remainingPieces > 0){
            remainingPieces--;
        }
    }
    public void playerWon(){
        wins++;
    }
    public void playerLost(){
        losses++;
    }
    public void playerDraw(){
        draws++;
    }
}