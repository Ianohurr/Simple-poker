package tests;

import static org.junit.Assert.assertEquals;
import model.Card;
import model.DuplicateCardException;
import model.PokerHand;
import model.Rank;
import model.Suit;

import org.junit.Test;

public class CardTest {
	@Test
	  public void testCardCompareTo() {
	    Card a= new Card(Rank.ACE, Suit.CLUBS);
	    Card b= new Card(Rank.QUEEN, Suit.CLUBS);
	    assertEquals(1,a.compareTo(b));
	    assertEquals(-1,b.compareTo(a));
	    Card two=new Card(Rank.DEUCE, Suit.CLUBS);
	    assertEquals(1,a.compareTo(two));
	    assertEquals(-1,two.compareTo(a));
	    Card c= new Card(Rank.ACE, Suit.DIAMONDS);
	    assertEquals(0,a.compareTo(c));
	  }
}
