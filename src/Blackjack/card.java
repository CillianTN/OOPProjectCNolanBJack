package Blackjack;

public class card {
    private cardType cardTyp;
    private cardValue cardVal;

    public card(cardType card_Type,cardValue card_Value){
        this.cardTyp = cardTyp;
        this.cardVal = cardVal;
    }

    public cardValue getCard_Value(){
        return this.cardVal;
    }

    @Override
    public String toString(){
        return
                "\nCard Type: " + this.cardTyp.toString() + " \nValue: " + this.cardVal.toString();

    }
}
