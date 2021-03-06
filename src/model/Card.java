package model;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

// Model a Card, five of which will model a poker hand.
//
public class Card implements Comparator<Card>,Comparable <Card>{
  private final Rank rank;
  private final Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Suit getSuit() {
    return suit;
  }

  public Rank getRank() {
    return rank;
  }

  public int getValue() {
    return rank.getValue();
  }

    public String toString() {
      // These four unicode characters will print solid suit icons if
      // your Eclipse default character set is UTF-8:
      //
      //  1. Preferences > General > Workspace
      //  2. At the bottom of the dialog box, set "Text file encoding" default to UTF-8
      //
      char suitChar = '\u2663';
      if (suit == Suit.DIAMONDS)
        suitChar = '\u2666';
      if (suit == Suit.HEARTS)
        suitChar = '\u2665';
      if (suit == Suit.SPADES)
        suitChar = '\u2660';

      int value = getValue();
      String cardChar = "" + (value);
      if (value == 10)
        cardChar = "10";
      if (value == 11)
        cardChar = "J";
      if (value == 12)
        cardChar = "Q";
      if (value == 13)
        cardChar = "K";
      if (value == 14)
        cardChar = "A";
  
      return cardChar + suitChar;
    }

	@Override
	public int compareTo(Card o) {
		if(this.getValue()>o.getValue()) {
			return 1;
		}
		if(this.getValue()<o.getValue()) {
			return -1;
		}
		return 0;
	}

	@Override
	public int compare(Card o1, Card o2) {
		if(o1.getValue()>o2.getValue()) {
			return 1;
		}
		if(o1.getValue()<o2.getValue()) {
			return -1;
		}
		return 0;
	}

}