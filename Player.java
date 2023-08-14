import java.util.*;

public class Player {
    private String name;
    private Card [] hand;
    private int numCards;

    public Player(String n) {
        this.name = n;
        this.numCards = 0;
        this.hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
    }

    public String getName() {
        return this.name;
    }

    public int getNumCards() {
        return this.numCards;
    }

    public String toString() {
        return this.name;
    }

    public void addCard(Card object) {
        if (object == null || this.getNumCards() ==  Blackjack.MAX_CARDS_PER_PLAYER - 1) {
            throw new IllegalArgumentException("card cannot be null or exceed amount of cards in player's hand");
        } else {
                this.hand[this.numCards] = (object);
                this.numCards++;
            }
        }

    public Card getCard(int i){
        if (this.hand[i] == null) {
            throw new IllegalArgumentException("no card");
        } else {
            return this.hand[i];
        }
    }

    public int getHandValue(){
    int value = 0;
    int numAces = 0;
        for (int i = 0; i < this.getNumCards(); i++) {
            if (hand[i].isAce()){
                numAces ++;
                value += 11;
                    } if (numAces > 1) {
                        value -= 10;
                } else {
                value += hand[i].getValue();
            }    
        } return value;
    }

    public void printHand() {
        for (int i = 0; i < this.numCards; i++){
            System.out.print(this.hand[i] + "  ");
        } System.out.println("(value = " + this.getHandValue() + ")");
    }

    public boolean hasBlackjack(){
        if (this.getNumCards() == 2 && this.getHandValue() == 21) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean wantsHit(Scanner hit, Player opponent) {
        opponent = new Player("opponent");   
        System.out.print("Want another hit, " + this.getName() + " y/n? ");
        String answer = hit.nextLine();

        if (answer.equals("Y")|| answer.equals("y")){
            return true;
        } else {
            return false;
        }
    }

    public void discardCards(){
        this.hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
        this.numCards = 0;
    }
}
