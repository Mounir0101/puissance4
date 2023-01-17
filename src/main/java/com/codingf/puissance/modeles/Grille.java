package com.codingf.puissance.modeles;

//import com.codingf.puissance.modeles.Cases;

public class Grille {

    Cases[][] casesList;

    public Grille(Cases[][] casesList) {
        this.casesList = casesList;
    }

    public void affichageGrille() {

        System.out.println("  1   2   3   4   5   6   7");

        System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
        for (int i = 0 ; i < 6; i++ ){
            for (int j = 0 ; j < 7 ; j++){
                if (j == 0) {
                    System.out.print("║ " + casesList[i][j].getSymbol());
                }
                else {
                    System.out.print(" ║ " + casesList[i][j].getSymbol());
                }



            }
            System.out.println(" ║");
            if ( i == 5){
                System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
            }else{
                System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            }


        }


        //System.out.println("║ "+casesList[0][0]+" ║   ║   ║   ║   ║   ║   ║");
        /*System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        System.out.println("║   ║   ║   ║   ║   ║   ║   ║");
        */

    }

}
