package tests;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Test;

import model.Card;
import model.DuplicateCardException;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the PokerHand class and the enums 
 * 
 * Rick includes all 52 cards to save you time (see end of file, after the @Test methods)
 * 
 * There are also some additional test cases here. However this unit test is in no way
 * complete since many more @Tests (test cases) are needed.   
 * 
 * Since PokerHand is not complete, all of the @Tests comparing PokerHand objects should fail.
 * 
 * The include enums Suit and Rank @Tests should pass since both enums are complete
*/
public class PokerHandTest {

  @Test
  public void testSuitEnum() {
    String result = "";
    for (Suit suit : Suit.values())
      result += suit + " ";
    assertEquals("CLUBS DIAMONDS HEARTS SPADES", result.trim());
  }

  @Test
  public void testRankEnum() {
    String result = "";
    for (Rank rank : Rank.values())
      result += rank + " ";
    assertEquals("DEUCE THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING ACE",
        result.trim());
  }


  @Test
  public void testTwoPairWhenOnePairIsEqual() {
    PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
    PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
  }

  @Test
  public void testAceLowStraight() {
    PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
    PokerHand b = new PokerHand(D2, D3, D4, D5, H6);
    boolean answer = a.compareTo(b) < 0;
    assertTrue(answer);
  }
  @Test
  public void testHandToString() {
    PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
    assertEquals("[2♣, 3♣, 4♣, 5♥, A♣]", a.toString());
    PokerHand b = new PokerHand(C5, C2, C4, C3, CA);
    assertEquals("[2♣, 3♣, 4♣, 5♣, A♣]", b.toString());
  }
  
  




@Test
public void testIsTwoPair() {
  PokerHand c = new PokerHand(D4, C4, C7, D6, H5);
  assertEquals(0.00, c.isTwoPair(),.001);
}




@Test
public void testIsStraight() {
  PokerHand a = new PokerHand(D2, C3, H4, D5, H6);
  assertEquals(4.06, a.isStraight(),.001);
  PokerHand b = new PokerHand(DA, C2, H3, D4, H5);
  assertEquals(4.05, b.isStraight(),.001);
  PokerHand c = new PokerHand(D10, CJ, HQ, DK, HA);
  assertEquals(4.14, c.isStraight(),.001);
  PokerHand d = new PokerHand(CJ, HQ, DK, HA,H2);
  assertEquals(0.00, d.isStraight(),.001);
  assertEquals(0.00, nothingA.isStraight(),.001);
}

@Test
public void testIsFlush() {
  PokerHand a = new PokerHand(D2, D3, D4, D5, D6);
  assertEquals(5.065432, a.isFlush(),.000001);
  PokerHand b = new PokerHand(D10, DJ, DQ, DK, DA);
  assertEquals(5.15432, b.isFlush(),.000001);
  PokerHand c = new PokerHand(D10, DJ, DQ, DK, CA);
  assertEquals(0.00, c.isFlush(),.001);
  PokerHand d = new PokerHand(D9,D10, DJ, DQ, DK);
  assertEquals(5.143209, d.isFlush(),.000001);
  PokerHand e = new PokerHand(D5,D6,D7,D8,D9);
  assertEquals(5.098765, e.isFlush(),.000001);
  assertEquals(0.00, nothingA.isFlush(),.001);
  assertEquals(0.00, nothingK8.isFlush(),.001);
  
}

@Test
public void testIsStraightFlush() {
	PokerHand a = new PokerHand(D2, D3, D4, D5, D6);
	assertEquals(8.06, a.isStraightflush(),.001);
	PokerHand B = new PokerHand(D10, DJ, DQ, DK, DA);
	assertEquals(8.14, B.isStraightflush(),.001);
}

@Test
public void testhighCard() {
	PokerHand a = new PokerHand(D2, D3, D7, C8, SA);
	assertEquals(.148732, a.highCard(),.001);
	PokerHand b = new PokerHand(D2, D3, D7, C8, S6);
	assertEquals(.087632, b.highCard(),.001);
}
@Test

public void testFullHouseHands() {

  PokerHand a = new PokerHand(S6, D6, DA, CA, HA);  // Both hands can have the same 3 Aces

  PokerHand b = new PokerHand(S3, D3, DA, CA, HA);

  assertTrue(a.compareTo(b) > 0);

  assertTrue(b.compareTo(a) < 0);

}



@Test

public void testFullHouseHands2() {

  PokerHand a = new PokerHand(S6, D6, DA, CA, HA);

  PokerHand b = new PokerHand(C6, H6, DA, CA, HA);

  assertTrue(a.compareTo(b) == 0);

  assertTrue(b.compareTo(a) == 0);

}



@Test

public void testFullHouseHands3() {

  PokerHand a = new PokerHand(S6, D6, DA, CA, HA);

  PokerHand b = new PokerHand(C7, H7, DA, CA, HA);

  assertTrue(a.compareTo(b) < 0);

  assertTrue(b.compareTo(a)> 0);

}



@Test

public void testThreeOfAKind() {

  PokerHand a = new PokerHand(S6, D7, DA, CA, HA);

  PokerHand b = new PokerHand(C5, H6, DA, CA, HA);

  assertTrue(a.compareTo(b) > 0);

  assertTrue(b.compareTo(a) <  0);

}



@Test

public void testThreeOfAKind3() {

  PokerHand a = new PokerHand(S7, D6, DA, CA, HA);

  PokerHand b = new PokerHand(C7, H6, DA, CA, HA);

  assertTrue(a.compareTo(b) == 0);

  assertTrue(b.compareTo(a) ==  0);

}



@Test

public void testFourOfAKind() {

  PokerHand a = new PokerHand(S7, CA, DA, HA, SA);

  PokerHand b = new PokerHand(D7, CA, DA, HA, SA);

  assertTrue(a.compareTo(b) == 0);

  assertTrue(b.compareTo(a) ==  0);

}



@Test

public void testFourOfAKind4() {

  PokerHand a = new PokerHand(S8, CA, DA, HA, SA);

  PokerHand b = new PokerHand(D7, CA, DA, HA, SA);

  assertTrue(a.compareTo(b) > 0);

  assertTrue(b.compareTo(a)<   0);

}


  // Set up 52 cards to use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
  private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
  private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
  private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
  private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
  private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
  private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
  private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
  private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
  private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
  private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
  private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
  private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
  private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

  private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
  private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
  private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
  private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
  private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
  private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
  private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
  private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
  private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
  private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
  private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
  private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
  private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

  private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
  private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
  private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
  private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
  private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
  private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
  private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
  private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
  private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
  private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
  private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
  private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
  private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

  private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
  private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
  private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
  private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
  private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
  private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
  private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
  private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
  private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
  private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
  private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
  private final static Card SK = new Card(Rank.KING, Suit.SPADES);
  private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

  // TEST CARD HGH HANDS

  private static PokerHand nothing72 = new PokerHand(C2, C3, C4, C5, D7);
  private static PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
  private static PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
  private static PokerHand nothingK9 = new PokerHand(CK, CQ, CJ, D10, H9);
  private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
  private static PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);
  private static PokerHand straightFlushA = new PokerHand(S10, SJ, SQ, SK, SA);
  private static PokerHand straightFlush10 = new PokerHand(D6,D7,D8,D9,D10);
  private static PokerHand straightFlush10Hearts = new PokerHand(H6,H7,H8,H9,H10);
  private static PokerHand straightFlush5 = new PokerHand(CA,C2,C3,C4,C5);
  private static PokerHand highestFourOfAKind = new PokerHand(SA,HA,CA,DA,DK);
  private static PokerHand highestFullHouse = new PokerHand(SA,HA,CA,CK,DK);
  private static PokerHand highestFlushNotRoyal = new PokerHand(SA,SK,SQ,SJ,S9);
  private static PokerHand highestStraight = new PokerHand(SA,SK,SQ,DJ,S10);
  private static PokerHand highestThreeOfAKind = new PokerHand(SA,DA,CA,DK,DQ);
  private static PokerHand highestTwoPair = new PokerHand(SA,DA,CK,DK,DQ);
  private static PokerHand highestOnePair = new PokerHand(SA,DA,CK,DQ,DJ);
  private static PokerHand highestOneCard = new PokerHand(SA,DK,CQ,DJ,D9);
  

  

  @Test
  public void testIsFullHouse() {
	  PokerHand aa = new PokerHand(C2, D2, C4, D4, H4);
	  PokerHand bb = new PokerHand(CA, DA, C3, D3, H3);
	  assertTrue(aa.compareTo(bb)<0);
  }
  

  @Test
  public void testTripsBeatsTwoPair() {
	  PokerHand aa = new PokerHand(C2, H2, S2, CQ, CJ);
	  PokerHand bb = new PokerHand(CA, DA, HK, SK, D2);
	  assertTrue(aa.compareTo(bb)>0);
	  assertTrue(bb.compareTo(aa)<0);
  }



  @Test
  public void testRankingIsThreeOfAKind() {
	  PokerHand aa = new PokerHand(D2, H2, C2, D6, D4);
  }
  
  
  

  

  @Test
  public void testStraightAceHighBeats10Highand5High() {
    assertTrue(straightFlushA.compareTo(straightFlush10) > 0);
    assertTrue(straightFlushA.compareTo(straightFlush5) > 0);
  }
  @Test
  public void testStraightFlush10HighBeats5High() {
	    assertTrue(straightFlush10.compareTo(straightFlush5) > 0);
	  }
  @Test
  public void testtIEsTRAIGHTfLUSH() {
	    assertTrue(straightFlush10.compareTo(straightFlush10Hearts) == 0);
	  }
  
  
  @Test
  public void testNothing0() {
    assertTrue(nothing73.compareTo(nothing72) > 0);
  }

  @Test
  public void testNothing1() {
    assertTrue(nothingJ.compareTo(nothing73) > 0);
  }

  @Test
  public void testNothing2() {
    assertTrue(nothingK8.compareTo(nothingJ) > 0);
  }

  @Test
  public void testNothing3() {
    assertTrue(nothingK9.compareTo(nothingK8) > 0);
  }

  @Test
  //private static PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);
  //private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8)
  public void testNothing4() {
	assertEquals(.154319, nothingA.getHandRanking(),.001);
	assertEquals(.143208, nothingK8.getHandRanking(),.001);
    assertTrue(nothingA.compareTo(nothingK8) > 0);
  }

  // Many more tests needed

}