package com.codingf.puissance.modeles;

public class Align3 {

    boolean check;

    int column;

    public Align3(boolean check, int column) {
        this.check = check;
        this.column = column;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
