package com.codingf.puissance.modeles;

public class Joueur {

    /**
     * Définition de la classe Joueur :
     * Elle prend en compte le nom du joueur, son symbole et le nombre de tours joués
     */

    private String pseudo;

    private char symbol;

    private int turn;

    public Joueur(String pseudo, char symbol, int turn) {
        this.pseudo = pseudo;
        this.symbol = symbol;
        this.turn = turn;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "pseudo='" + pseudo + '\'' +
                ", symbol=" + symbol +
                '}';
    }

    public static Joueur playerSwitch(Joueur currentPlayer, Joueur player1, Joueur player2) {
        if (currentPlayer.getPseudo().equals(player1.getPseudo())){
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
        return currentPlayer;
    }

}
