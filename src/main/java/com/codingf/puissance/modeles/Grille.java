package com.codingf.puissance.modeles;

import com.codingf.puissance.modeles.Cases;

public class Grille {

    Cases[][] casesList;

    public Grille(Cases[][] casesList) {
        this.casesList = casesList;
    }

    public void affichageGrille() {

        System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╝");

    }

}
