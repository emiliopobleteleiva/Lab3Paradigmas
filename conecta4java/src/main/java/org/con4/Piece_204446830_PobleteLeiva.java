package org.con4;

public class Piece_204446830_PobleteLeiva {
    private String color;
    private Player_204446830_PobleteLeiva player;

    //crear clase
    public Piece_204446830_PobleteLeiva(String color, Player_204446830_PobleteLeiva playerIn) {
        this.color = color;
        this.player = playerIn;
    }

    //obtener informacion
    public String getColor(){
        return color;
    }

    public Player_204446830_PobleteLeiva getPlayer() {
        return player;
    }
}