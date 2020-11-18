package Blackjack;

import java.util.ArrayList;

public class deck {
    private ArrayList<card> cards;

    public deck() {
        this.cards = new ArrayList<card>();
    }

    public void fullDeck() {
        for (cardType cardTypes : cardType.values()) {
            for (cardValue cValue : cardValue.values()) {
                this.cards.add(new card(cardTypes, cValue));
            }
        }

    }

    public int valueOfCards() {
        int totalVal = 0;

        for (card anyCard : this.cards) {

            switch (anyCard.getCard_Value()) {
                case One:
                    totalVal += 1;
                    break;
                case Two:
                    totalVal += 2;
                    break;
                case Three:
                    totalVal += 3;
                    break;
                case Four:
                    totalVal += 4;
                    break;
                case Five:
                    totalVal += 5;
                    break;
                case Six:
                    totalVal += 6;
                    break;
                case Seven:
                    totalVal += 7;
                    break;
                case Eight:
                    totalVal += 8;
                    break;
                case Nine:
                    totalVal += 9;
                    break;
                case Ten:
                    totalVal += 10;
                    break;
                case Queen:
                    totalVal += 10;
                    break;
                case King:
                    totalVal += 10;
                    break;
                case Jack:
                    totalVal += 10;
                    break;
                case Ace:
                    totalVal += 11;
                    break;
            }

        }
        return totalVal;
    }


    public void addCard(card addCard){
        this.cards.add(addCard);
    }
    public void removeCard(int i){
        this.cards.remove(i);
    }
    public card hitCard(int i){
        return this.cards.get(i);
    }

}
