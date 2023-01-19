package com.codingf.puissance.modeles;

import com.codingf.puissance.modeles.Cases;

public class VictoryChecker {

    /**
     * Cette classe sert à renvoyer si une victoire a eu lieu ou non
     * Si c'est le cas, on peut récupérer les 4 cases victorieuses
     */

    boolean victory;

    Cases case1;

    Cases case2;

    Cases case3;

    Cases case4;

    public VictoryChecker(boolean victory) {
        this.victory = victory;
    }

    public VictoryChecker(boolean victory, Cases case1, Cases case2, Cases case3, Cases case4) {
        this.victory = victory;
        this.case1 = case1;
        this.case2 = case2;
        this.case3 = case3;
        this.case4 = case4;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public Cases getCase1() {
        return case1;
    }

    public void setCase1(Cases case1) {
        this.case1 = case1;
    }

    public Cases getCase2() {
        return case2;
    }

    public void setCase2(Cases case2) {
        this.case2 = case2;
    }

    public Cases getCase3() {
        return case3;
    }

    public void setCase3(Cases case3) {
        this.case3 = case3;
    }

    public Cases getCase4() {
        return case4;
    }

    public void setCase4(Cases case4) {
        this.case4 = case4;
    }
}
