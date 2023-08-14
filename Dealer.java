import java.util.*;

public class Dealer extends Player {
    private boolean revealFirstCard;

public Dealer() {
    super("dealer");
    this.revealFirstCard = false;
}

public void revealFirstCard() {
    this.revealFirstCard = true;
}

public void printHand() {
    String hand = "XX  ";
    if (this.revealFirstCard == false) {
        for (int i = 1; i < this.getNumCards(); i++) {
            hand += this.getCard(i) + "  ";
        }
    } else {
        for (int i = 0; i < this.getNumCards(); i++) {
            if (i == 0) {
                hand += this.getCard(i) + "  ";
            } else {
                hand +=  "(value = " + this.getHandValue() + ")";
            } 
        }
    } System.out.println(hand);
}

public boolean wantsHit(Scanner hit, Player opponent) {
    System.out.print("Want another hit, " + this.getName() + " y/n? ");
    String answer = hit.nextLine();
        if (answer.equals("Y")|| answer.equals("y")){
            if (this.getHandValue() < 17) {
             return true;
        } else {
        return false;
        }
    } else {
        return false;
    }
}

public void discardCards(){
    super.discardCards();
    this.revealFirstCard = false;
}

}
