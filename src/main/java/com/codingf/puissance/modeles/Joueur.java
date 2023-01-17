package com.codingf.puissance.modeles;

public class Joueur {

    private String pseudo;

    private char symbol;

    public Joueur(String pseudo, char symbol) {
        this.pseudo = pseudo;
        this.symbol = symbol;
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
