package com.codingf.puissance.games;

import com.codingf.puissance.modeles.Joueur;

import java.util.Scanner;

public class InitPlayers {

    public static Joueur[] players2() {

        Scanner players = new Scanner(System.in);
        System.out.println("Joueur 1, choisissez votre pseudo");
        String player1Pseudo = players.nextLine();
        System.out.println("Joueur 1, choisissez votre symbole");
        char player1Symbol = players.nextLine().charAt(0);
        System.out.println("Joueur 2, choisissez votre pseudo");
        String player2Pseudo = players.nextLine();
        char player2Symbol;

        while (true) {
            System.out.println("Joueur 2, choisissez votre symbole");
            player2Symbol = players.nextLine().charAt(0);
            if (player2Symbol == player1Symbol) {
                System.out.println("Les deux joueurs ne peuvent pas avoir le même symbole");
                continue;
            } else {
                break;
            }
        }

        Joueur[] joueurs = new Joueur[2];
        joueurs[0] = new Joueur(player1Pseudo, player1Symbol, 1);
        joueurs[1] = new Joueur(player2Pseudo, player2Symbol, 0);
        return joueurs;

    }

    public static Joueur player1() {

        Scanner player = new Scanner(System.in);
        System.out.println("Choisissez votre pseudo");
        String playerPseudo = player.nextLine();

        char playerSymbol;

        while (true) {
            System.out.println("Choisissez votre symbole");
            playerSymbol = player.nextLine().charAt(0);
            if (playerSymbol == '@') {
                System.out.println("Désolé, ce symbole est réservé pour l'ordi");
            }
            else {
                break;
            }
        }

        return new Joueur(playerPseudo ,playerSymbol, 1);

    }

}
