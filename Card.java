import java.security.cert.TrustAnchor;

/*
 * Card.java
 *
 * A blueprint class for objects that represent a single playing card
 * that has a rank and a suit.
 * 
 * starter code: CS 112 Staff (cs112-staff@cs.bu.edu)
 * completed by: Diya Gandhi and diyag15@bu.edu
 */

public class Card {
  /* 
   * fields that capture the state of a Card object
   */

  private int rank;
  private char suit;

  /* constructor that initializes rank and suit*/
  public Card (int rank, char suit) {
   if (this.rank < 1 || this.rank > 13){
    throw new IllegalArgumentException();
  }
   if (isValidSuit(suit) == false) {
    throw new IllegalArgumentException();
   }
    this.rank = rank;
    this.suit = suit;
  }

  /* 
   * constructor that intializes card
   */
  public Card (String card) {
    if (this.rank < 1 || this.rank > 13 || card == null) {
      throw new IllegalArgumentException();
    } else if (card.length() == 2) {
      this.suit = card.charAt(1);
      this.rank = rankNumFor(card.substring(0,1));
    } else if (card.length() == 3) {
      this.suit = card.charAt(2);
      this.rank = rankNumFor(card.substring(0,2));
    }
  }

  /* acessor methods */

  /*  returns the integer representing 
  the Card object's rank */
  public int getRank(){
    return this.rank;
  }

  /*  returns the char representing 
  the Card object’s suit*/
  public char getSuit(){ 
    return this.suit;
  }

  /* returns true if the Card 
  is an Ace and false if it is not */
  public boolean isAce(){
    if (this.rank == 1){ 
     return true;
  } else {
    return false;
  }
}

  /* returns true if the Card is a face card (
  Jack, Queen, or King) and and false if it is not */
  
  public boolean isFaceCard(){
    if(this.rank == 11 || this.rank == 12 || this.rank == 13){
      return true;
    } else {
      return false;
    }
  }
  
  /* which returns the Card object’s value */
  public int getValue(){
    if (this.isFaceCard() == true) {
      return 10; 
    } else {
      return this.rank;
    }
  }

  /* returns a String representation of 
  the Card object that can be used when 
  printing it or concatenating it to a String */
  public String toString() {
    return RANK_STRINGS[this.rank] + this.suit;
  }

    /* constants for the ranks of non-numeric cards */
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    /* other constants for the ranks */
    public static final int FIRST_RANK = 1;
    public static final int LAST_RANK = 13;
    
    /* 
     * class-constant array containing the string representations
     * of all of the card ranks. 
     * The string for the numeric rank r is given by RANK_STRINGS[r].
     */
    public static final String[] RANK_STRINGS = {
      null, "A", "2", "3", "4", "5", "6",
      "7", "8", "9", "10", "J", "Q", "K"
    };
    
    /* 
     * class-constant array containing the char representations
     * of all of the possible suits.
     */
    public static final char[] SUITS = {'C', 'D', 'H', 'S'};
    
    /* Put the rest of the class definition below. */
   
    /*
     * static method that takes a rank string as it only
     * parameter and returning the corresponding integer rank
     */
    public static int rankNumFor (String rankString) {
      if (rankString == null) {
        throw new IllegalArgumentException();
      }
      int rank = 0;
      for(int i = 1; i < RANK_STRINGS.length; i++){
         if (rankString == RANK_STRINGS[i]) {
          rank = i;
        } else {
          rank = -1;
        }
      }
      return rank;
    }
    
    /* static method that takes a single-character representation 
     * of a card's suit and returns true if that suit is valid,
     * and false otherwise
     */
    public static boolean isValidSuit (char Suit) {
      for(int i = 1; i < SUITS.length; i++) {
        if (Suit == (SUITS[i])) {
          return true;
        }
      }
      return false;
    }

    /* takes a Card object as a parameter and 
    * determines if it is has the same suit as 
    * the called object, returning true if they 
    * have the same suit and false if they do not have
    * the same suit. If a value of null is passed in for 
    * the parameter, the method should return false */
    public boolean sameSuitAS(Card otherCard){
      if (otherCard == null){
        return false; 
      } else if (this.suit == otherCard.getSuit()) {
        return true;
      } else {
        return false;
      }
    }

    /*  takes a Card object as a parameter and determines 
    * if it is equivalent to the called object, returning true 
    * if it is equivalent and false if it is not equivalent.
    * If null is passed in for the parameter, 
    * the method should return false. */
    public boolean equals(Card otherCard){
      if (otherCard == null){
        return false;
      } else if (this.rank == otherCard.rank 
      && this.suit == otherCard.suit) {
        return true;
      } else {
        return false;
      }
    }

    public static void main(String[] args) {
    Card.rankNumFor("Q");
    Card.rankNumFor("A");
    Card.rankNumFor("10");
    Card.isValidSuit('D');
    Card.isValidSuit('B');

} 
}
