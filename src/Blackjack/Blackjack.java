package Blackjack;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*This is a simple card game made using Java code
* that allows the user to play Blackjack, otherwise known as 21.*/

public class Blackjack {
    public static void main(String[] args) {

        int age;
        int bettingMoney = 50;
        int playerBet;
        int ans;


        age = Integer.parseInt(JOptionPane.showInputDialog(null, "How old are you?" +
                "\nPlease be truthful when entering the Casino.", "Please enter age", JOptionPane.QUESTION_MESSAGE));
        if(age > 99){
            JOptionPane.showMessageDialog(null,"Yikes! You're too old to be here.... Leave the betting money to your grandkids...." +
                    "\n\nSecurity now escorting you off the premises....","SECURITY WARNING!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        if (age < 18) {
            JOptionPane.showMessageDialog(null, "Security are escorting you! You're too young to play in " +
                    " the Nolan Blackjack Casino! \n\nCome back when you're 18!\n\nOr lie next time! ", "TOO YOUNG!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        else {

            JOptionPane.showMessageDialog(null, "BlackJack Rules!\n\n1.      The goal of blackjack is to beat the dealer's hand without going over 21." +
                    "\n\n2.       Kings, Queens and Jacks are worth 10. Aces are worth 1 or 11, whichever makes a better hand." +
                    "\n\n3.       Each player starts with two cards, one of the dealer's cards is hidden until the end." +
                    "\n\n4.       To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn." +
                    "\n\n5.       If you go over 21 you bust, and the dealer wins regardless of the dealer's hand." +
                    "\n\n6.       If you are dealt 21 from the start (Ace & 10), you got a blackjack." +
                    "\n\n7.       Press 'Ok' to begin playing" +
                    "\n\n8.       Blackjack usually means you win 1.5 the amount of your bet. Depends on the casino." +
                    "\n\n9        Dealer will hit until his/her cards total 17 or higher." +
                    "\n\n10.      You can't bet nothing, be careful in case security escorts you for trying......",
                    "Rules of Nolan Casino BlackJack"
                    , JOptionPane.INFORMATION_MESSAGE);

            String playerName = JOptionPane.showInputDialog(null, "Please enter your name before continuing.",
                    "Name", JOptionPane.QUESTION_MESSAGE);

             if (playerName == ("")) {
                playerName = "Undefined";
            }


            deck gameDeck = new deck();
            gameDeck.cardDeck();
            deck playerHand = new deck();
            deck dealerHand = new deck();

            while (bettingMoney > 0) {

                playerBet = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Nolan Casino Blackjack " + playerName +
                        "\nYou have €" + bettingMoney + ", how much do you want to bet? " +
                        "\n\nBet cannot exceed the money you have. "));

                if(playerBet <= 0) {
                    JOptionPane.showMessageDialog(null,"You're trying to bet nothing?? You're in a Casino! Security is now escorting " +
                            "you for time wasting....","SECURITY WARNING!!",JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
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


                if (playerHand.cardVal() > 21) {
                    JOptionPane.showMessageDialog(null, "BUST");
                }
                ans = Integer.parseInt(JOptionPane.showInputDialog(null, "Do you want to Hit or Stand?" +
                        "\n\n1 = Hit" +
                        "\n\n2 = Stand", "Hit Or Stand?", JOptionPane.QUESTION_MESSAGE));

                if (ans == 1) {
                    playerHand.draw(gameDeck);
                    JOptionPane.showMessageDialog(null, "You draw a " + playerHand.toString());
                    if (playerHand.cardVal() > 21) {
                        JOptionPane.showMessageDialog(null, "You've gone BUST! Over 21!! House wins this time!","Lose!",
                                JOptionPane.ERROR_MESSAGE);
                        bettingMoney -= playerBet;
                        playerHand.cardsToDeck(gameDeck);
                        dealerHand.cardsToDeck(gameDeck);

                        continue;

                    }


                    if (dealerHand.cardVal() > 17) {
                        JOptionPane.showMessageDialog(null, "Dealer decided to not hit.");
                        if (dealerHand.cardVal() > 21) {
                            JOptionPane.showMessageDialog(null, "Dealer went bust! You win!");
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

                        while (playerBet == 0) {
                            JOptionPane.showMessageDialog(null, "You are broke!? You can't play anymore!!" +
                                    "\n\nNolan Blackjack Casino Security is now escorting you from the premises......" +
                                    "\n\nThe wife won't be happy you lost all the shillings.... Best of luck! Thanks for playing.");
                        }
                    }
                    if (dealerHand.cardVal() > playerHand.cardVal()) {
                        JOptionPane.showMessageDialog(null, "House wins! You lost €" + playerBet +
                                "\n\nYour total balance is now €" + (bettingMoney - playerBet));
                        bettingMoney -= playerBet;

                        while (playerBet == 0) {
                            JOptionPane.showMessageDialog(null, "You are broke!? You can't play anymore!!" +
                                    "\n\nNolan Blackjack Casino Security is now escorting you from the premises......" +
                                    "\n\nThe wife won't be happy you lost all the shillings.... Best of luck! Thanks for playing.");
                            System.exit(0);
                        }
                    }


                    JOptionPane.showMessageDialog(null,
                            "******Now Showing Player Hands******" +
                            "\n\nPlayer Hand:\n " + playerHand.toString() +
                            "\n\n\nDealer Hand:\n" + dealerHand.toString());


                    playerHand.cardsToDeck(gameDeck);
                    dealerHand.cardsToDeck(gameDeck);


                }

                if (ans == 2) {
                    if (playerHand.cardVal() > dealerHand.cardVal()) {
                        JOptionPane.showMessageDialog(null, "You win €" + playerBet +
                                "\n\nYour new total balance is now €" + (bettingMoney + playerBet));
                        bettingMoney += playerBet;
                    }
                }



                if (dealerHand.cardVal() > playerHand.cardVal()) {
                    JOptionPane.showMessageDialog(null,
                            "House wins! You lost €" + playerBet +
                            "\n\nYour total balance is now €" + (bettingMoney - playerBet));
                    bettingMoney -= playerBet;


                }
                try {
                    File blackjackScore;
                    FileWriter endGame = new FileWriter("blackjackScore.txt");
                    endGame.write("Player age was " + age +
                            "\nPlayer name was " + playerName +
                            "\nLast Player Hand was " + playerHand.cardVal() +
                            "\n\nLast Dealer Hand was " + dealerHand.cardVal() +
                            "\n\nPlayer finished with a total of €" + bettingMoney +
                            "\nAfter beginning with a total of €50.");
                    endGame.close();
                    JOptionPane.showMessageDialog(null, "Receipt printed as blackjackScore.txt.");

                    playerHand.cardsToDeck(gameDeck);
                    dealerHand.cardsToDeck(gameDeck);
                    continue;
                }
                catch (IOException e){
                    JOptionPane.showMessageDialog(null,"Error occurred... No file output... Exiting Casino");
                    e.printStackTrace();
                    System.exit(0);
                }
                if (playerBet == 0)
                    JOptionPane.showMessageDialog(null, "You are broke!? You can't play anymore!!" +
                            "\n\nNolan Blackjack Casino Security is now escorting you from the premises......" +
                            "\n\nThe wife won't be happy you lost all the shillings.... Best of luck! Thanks for playing.");
                System.exit(0);



                playerHand.cardsToDeck(gameDeck);
                dealerHand.cardsToDeck(gameDeck);


            }
        }
    }
}



/**CITATIONS HERE!! WOULDN'T LET ME UPLOAD NEW CLASS/
/* Referred to below sources for creating card classes.
 * http://math.hws.edu/javanotes/c5/s4.html
 *
 *
 *
 *******************************************************/
///*****************************************************
//*    Code from online coding forum (Discord)
//*    Title:   Moving Cards back To Deck …..java, lines 39-47
//*    Author: Freddie Morgan
//*    Site owner/sponsor:  NA
//*    Date: 30/11/2020
//*    Code version:  NA
//*    Availability: NA
//*    Modified:  Code refactored (Identifiers renamed)
//*****************************************************/
////public void cardsToDeck(deck moveTo) {
//    int thisDeckSize = this.cards.size();
//    for (int i = 0; i < thisDeckSize; i++) {
//        moveTo.addCard(this.hitCard(i));
//    }
//    for (int i = 0; i < thisDeckSize; i++) {
//        this.removeCard(0);


//       Code from Stackoverflow (Discord)
////*    Title: Enum card deck
////*    Author: user3579225
////*    Site owner/sponsor:  NA
////*    Date: 15/11/2020
////*    Code version:  NA
////*    Availability: NA
////     https://stackoverflow.com/questions/23329132/building-a-deck-of-cards-in-java-using-2-different-enums
////*    Modified:  Code refactored (Identifiers renamed)

//

