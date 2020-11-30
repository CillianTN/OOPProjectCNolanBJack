package Blackjack;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;


public class Blackjack {
    public static void main(String[] args) {

        int bettingMoney = 250;
        int playerBet;
        int ans;


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

        while (bettingMoney > 0) {

            playerBet = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Nolan Casino Blackjack " + playerName +
                    "\nYou have €" + bettingMoney + ", how much do you want to bet? Bet cannot exceed the money you have."));

            if (bettingMoney < playerBet) {
                JOptionPane.showMessageDialog(null, "You only have €" + bettingMoney +
                        "! Please bet an amount lower or equal to this.");
                System.exit(0);

            }
            JOptionPane.showMessageDialog(null, "Dealer is shuffling deck.... get ready......");
            gameDeck.shuffle();
            playerHand.draw(gameDeck);
            playerHand.draw(gameDeck);

            JOptionPane.showMessageDialog(null, "Your hand is: \n" + playerHand.toString() +
                    "\n\nYour hand is worth " + playerHand.cardVal());

            dealerHand.draw(gameDeck);
            dealerHand.draw(gameDeck);
            JOptionPane.showMessageDialog(null, "Dealer's hand is: \n" + dealerHand.hitCard(1).toString() +
                    "\nand\n" + "\n[FACEDOWN CARD]");
            if(playerHand.cardVal()>21){
                JOptionPane.showMessageDialog(null,"BUST");
            }
            ans = Integer.parseInt(JOptionPane.showInputDialog(null,"Do you want to Hit or Stand?" +
                    "\n\n1 = Hit" +
                    "\n\n2 = Stand","Hit Or Stand?",JOptionPane.QUESTION_MESSAGE));

            if(ans == 1){
                playerHand.draw(gameDeck);
                JOptionPane.showMessageDialog(null, "You draw a " + playerHand.toString());
                if(playerHand.cardVal()>21){
                    JOptionPane.showMessageDialog(null,"BUST");
                    bettingMoney -= playerBet;
                    playerHand.cardsToDeck(gameDeck);
                    dealerHand.cardsToDeck(gameDeck);

                    continue;

                }
                if (dealerHand.cardVal() > 17) {
                    JOptionPane.showMessageDialog(null, "Dealer decided to not hit.");
                    if(dealerHand.cardVal()>21){
                        JOptionPane.showMessageDialog(null,"Dealer went bust! You win!");
                        bettingMoney += playerBet;
                        playerHand.cardsToDeck(gameDeck);
                        dealerHand.cardsToDeck(gameDeck);

                        continue;
                    }
                }
                if (dealerHand.cardVal() < 17 || JOptionPane.YES_NO_OPTION == JOptionPane.YES_OPTION) {
                    dealerHand.draw(gameDeck);
                    JOptionPane.showMessageDialog(null, "Dealer decided to Hit....");
                }

                if (playerHand.cardVal() > dealerHand.cardVal()) {
                    JOptionPane.showMessageDialog(null, "You win €" + playerBet +
                            "\n\nYour new total balance is now €" + (bettingMoney + playerBet));
                    bettingMoney += playerBet;
                    while(playerBet == 0){
                        JOptionPane.showMessageDialog(null,"You are broke!? You can't play anymore!!" +
                                "\n\nNolan Blackjack Casino Security is now escorting you from the premises......" +
                                "\n\nThe wife won't be happy you lost all the shillings.... Best of luck! Thanks for playing.");
                    }
                }
                if (dealerHand.cardVal() > playerHand.cardVal()) {
                    JOptionPane.showMessageDialog(null, "House wins! You lost €" + playerBet +
                            "\n\nYour total balance is now €" + (bettingMoney - playerBet));
                    bettingMoney -= playerBet;
                    while(playerBet == 0){
                        JOptionPane.showMessageDialog(null,"You are broke!? You can't play anymore!!" +
                                "\n\nNolan Blackjack Casino Security is now escorting you from the premises......" +
                                "\n\nThe wife won't be happy you lost all the shillings.... Best of luck! Thanks for playing.");
                        System.exit(0);
                    }
                }


                JOptionPane.showMessageDialog(null,"******Now Showing Player Hands******" +
                        "\n\nPlayer Hand:\n " +playerHand.toString() +
                        "\n\n\nDealer Hand:\n" +dealerHand.toString());
                playerHand.cardsToDeck(gameDeck);
                dealerHand.cardsToDeck(gameDeck);


            }
            if(ans==2){
                if (playerHand.cardVal() > dealerHand.cardVal()) {
                    JOptionPane.showMessageDialog(null, "You win €" + playerBet +
                            "\n\nYour new total balance is now €" + (bettingMoney + playerBet));
                    bettingMoney += playerBet;
                    }
                }
                if (dealerHand.cardVal() > playerHand.cardVal()) {
                    JOptionPane.showMessageDialog(null, "House wins! You lost €" + playerBet +
                            "\n\nYour total balance is now €" + (bettingMoney - playerBet));
                    bettingMoney -= playerBet;
                    if(playerBet == 0)
                        JOptionPane.showMessageDialog(null,"You are broke!? You can't play anymore!!" +
                                "\n\nNolan Blackjack Casino Security is now escorting you from the premises......" +
                                "\n\nThe wife won't be happy you lost all the shillings.... Best of luck! Thanks for playing.");
                        System.exit(0);

            }

            playerHand.cardsToDeck(gameDeck);
            dealerHand.cardsToDeck(gameDeck);



        }



    }
}


/* Referred to below sources for creating card classes.
 * http://math.hws.edu/javanotes/c5/s4.html
 *
 *
 *
 *************/