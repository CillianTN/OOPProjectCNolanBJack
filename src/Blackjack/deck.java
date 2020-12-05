package Blackjack;
//Deck.java
/**A class that manages the operations that the deck must do to
 * @author Cillian Nolan */
import java.util.ArrayList;
import java.util.Random;

/**Created public class called deck*/

public class deck {
    /** Created an array list of cards called Cards.*/

    private ArrayList<card> cards;
    /** Made a deck, that grabs cards from Array list.*/
    public deck() {
        this.cards = new ArrayList<card>();
    }


    /** For loop creates cards with its type and value.*/

    public void cardDeck() {
        for (cardType cardTypes : cardType.values()) {
            for (cardValue cValue : cardValue.values()) {
                this.cards.add(new card(cardTypes, cValue));
            }
        }

    }

    public void addCard(card addCard) {
        this.cards.add(addCard);
    }
/**This would be to remove a card from the deck eg when player or dealer hits.*/

    public void removeCard(int i) {
        this.cards.remove(i);
    }
/**Gets card type and value of card drawn
 * @return a card drawn from the deck*/

    public card hitCard(int i) {
        return this.cards.get(i);
    }
/**Removes first card from deck.*/

public void draw(deck drawCardsFromDeck) {
        this.cards.add(drawCardsFromDeck.hitCard(0));
        drawCardsFromDeck.removeCard(0);
    }
    /**Moves cards to deck at end of hand. Code source below*/

    public void cardsToDeck(deck moveTo) {
        int thisDeckSize = this.cards.size();
        for (int i = 0; i < thisDeckSize; i++) {
            moveTo.addCard(this.hitCard(i));
        }
        for (int i = 0; i < thisDeckSize; i++) {
            this.removeCard(0);
        }
    }
/** Shuffles the deck so cards comd out randomly*/

    public void shuffle(){
        //Creates array for shuffling deck
        ArrayList<card> shuffleDeck = new ArrayList<card>();
        //Creates new 'Random' called randCards
        Random randCards = new Random();
        int randomCards = 0;
        int originalSize = this.cards.size();
        for(int i = 0; i<originalSize;i++){
            randomCards = randCards.nextInt((this.cards.size()-1 - 0) + 1) + 0;
            shuffleDeck.add(this.cards.get(randomCards));
            this.cards.remove(randomCards);
        }
        this.cards = shuffleDeck;
    }

/**This translates the card to string so it can be output to show player hand
 * @return the card as a string*/
    public String toString() {
        //Card string is originally blank.
        String strCards = "";
        int i = 0;
        for (card Card : this.cards) {
            strCards += Card.toString();
            i++;
        }
        return strCards;
    }
/**This turns the cards into a value. E.G. Club Four = 'value' 4.
 * @return The cards as a value*/
    public int cardVal() {
        int handVal = 0;

        for (card Card : this.cards) {

            switch (Card.getCardVal()) {
                case One:
                    handVal += 1;
                    break;
                case Two:
                    handVal += 2;
                    break;
                case Three:
                    handVal += 3;
                    break;
                case Four:
                    handVal += 4;
                    break;
                case Five:
                    handVal += 5;
                    break;
                case Six:
                    handVal+= 6;
                    break;
                case Seven:
                    handVal += 7;
                    break;
                case Eight:
                    handVal += 8;
                    break;
                case Nine:
                    handVal += 9;
                    break;
                case Ten:
                    handVal += 10;
                    break;
                case Jack:
                    handVal += 10;
                    break;
                case Queen:
                    handVal += 10;
                    break;
                case King:
                    handVal += 10;
                    break;
                case Ace:
                    handVal += 11;
                    //Tried have it so if player has hand value of 11 or greater then ace would be 1
                    //if(playerHand>=11){
                      //  handVal += 1;
                       // break;
         //           }
                    break;
            }

        }
        //Returns the card value
   return handVal; }
}

///*****************************************************
//*    Code from online coding forum (discord)
//*    Title:    …..java, lines 39-47
//*    Author: Freddie Morgan
//*    Site owner/sponsor:  NA
//*    Date: 30/11/2020
//*    Code version:  NA
//*    Availability: NA
//
//*    Modified:  Code refactored (Identifiers renamed)
//*****************************************************/
////public void cardsToDeck(deck moveTo) {
//    int thisDeckSize = this.cards.size();
//    for (int i = 0; i < thisDeckSize; i++) {
//        moveTo.addCard(this.hitCard(i));
//    }
//    for (int i = 0; i < thisDeckSize; i++) {
//        this.removeCard(0);
//    }
//}