package Blackjack;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;


public class Blackjack {
    public static void main(String[] args) {

        int bettingMoney = 250;
        int playerBet;




        JOptionPane.showMessageDialog(null, "BlackJack Rules!\n\n1.      The goal of blackjack is to beat the dealer's hand without going over 21." +
                "\n\n2.       Kings, Queens and Jacks are worth 10. Aces are worth 1 or 11, whichever makes a better hand." +
                "\n\n3.       Each player starts with two cards, one of the dealer's cards is hidden until the end." +
                "\n\n4.       To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn." +
                "\n\n5.       If you go over 21 you bust, and the dealer wins regardless of the dealer's hand." +
                "\n\n6.       If you are dealt 21 from the start (Ace & 10), you got a blackjack." +
                "\n\n7.       Press 'Ok' to begin playing", "Rules of Nolan Casino BlackJack", JOptionPane.INFORMATION_MESSAGE);

        String playerName = JOptionPane.showInputDialog(null, "Please enter your name before continuing.",
                "Name", JOptionPane.QUESTION_MESSAGE);

        if (playerName.equals(null) || playerName == " ") {
            playerName = "Undefined";
        }


        deck gameDeck = new deck();
        gameDeck.cardDeck();
        deck player = new deck();
        deck dealer = new deck();

        while (bettingMoney>0){

            playerBet = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Nolan Casino Blackjack " + playerName  +
                    "\nYou have €" + bettingMoney + ", how much do you want to bet? Bet cannot exceed the money you have."));

            if(bettingMoney<playerBet){JOptionPane.showMessageDialog(null, "You only have €" + bettingMoney +
                    "! Please bet an amount lower or equal to this.");

            }
            JOptionPane.showMessageDialog(null,"Dealer is shuffling deck.... get ready......");
            player.draw(gameDeck);
            dealer.draw(gameDeck);
            player.draw(gameDeck);
            dealer.draw(gameDeck);
            JOptionPane.showMessageDialog(null,player.toString());



        }





    }
}