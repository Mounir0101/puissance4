package com.codingf.puissance.modeles;

public class Cases {

    /**
     * Définition de la classe Cases :
     * Elle prend en compte les positions x et y de la case, et le symbole qu'elle contient
     */

    private int line;

    private int column;

    private char symbol;

    public Cases(int line, int column, char symbol) {
        this.line = line;
        this.column = column;
        this.symbol = symbol;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "line=" + line +
                ", column=" + column +
                ", symbol=" + symbol +
                '}';
    }
}
