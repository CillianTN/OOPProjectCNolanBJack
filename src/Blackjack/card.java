package Blackjack;

public class card {
    private cardType cardTyp;
    private cardValue cardVal;

    public card(cardType cardTyp,cardValue cardVal){
        this.cardTyp = cardTyp;
        this.cardVal = cardVal;
    }

    public cardValue getCardVal(){
        return this.cardVal;
    }

    @Override
    public String toString(){
        return
                "\nCard Type: " + this.cardTyp.toString()
                        + " \nValue: " + this.cardVal.toString() + "\n";

    }
}
