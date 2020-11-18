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
}
