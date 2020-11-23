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
        deck playerHand = new deck();
        deck dealerHand = new deck();

        while (bettingMoney>0){
            boolean gameStatus = false;

            playerBet = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Nolan Casino Blackjack " + playerName  +
                    "\nYou have €" + bettingMoney + ", how much do you want to bet? Bet cannot exceed the money you have."));

            if(bettingMoney<playerBet){JOptionPane.showMessageDialog(null, "You only have €" + bettingMoney +
                    "! Please bet an amount lower or equal to this.");

            }
            JOptionPane.showMessageDialog(null,"Dealer is shuffling deck.... get ready......");

            playerHand.draw(gameDeck);
            playerHand.draw(gameDeck);

            JOptionPane.showMessageDialog(null,"Your hand is: \n" + playerHand.toString() +
                    "\n\nYour hand is worth " + playerHand.cardVal());

            dealerHand.draw(gameDeck);
            dealerHand.draw(gameDeck);
            JOptionPane.showMessageDialog(null,"Dealer's hand is: \n" + dealerHand.hitCard(1).toString() +
                   "\nand\n" + "\n[FACEDOWN CARD]");

            if (JOptionPane.showConfirmDialog(null, "Remember your hand is worth " + playerHand.cardVal() + "." +
                            "\n\nWould you like to Hit or Stand?" + "\n\nYes for Hit, No for Stand.", "Hit or Stand?",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ) {
                playerHand.draw(gameDeck);
                JOptionPane.showMessageDialog(null,"You draw a " + playerHand.toString());
            }
            else{
                //
            }
                if(dealerHand.cardVal()<=17)
                    dealerHand.draw(gameDeck);
                JOptionPane.showMessageDialog(null,"Dealer decided to hit...." +
                        "\n\nDealer hand is: " + dealerHand.toString());



            {


            }
            JOptionPane.showMessageDialog(null,"End of dealing......." +
                    "\n\nDealer Cards: " + dealerHand.toString());

            {

            }

        }





    }
}

/* Referred to below sources for creating card classes.
 * http://math.hws.edu/javanotes/c5/s4.html
 *
 *
 *
 *************/