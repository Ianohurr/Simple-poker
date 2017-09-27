package model;

import java.util.ArrayList;
import java.util.Collections;


// Model a five card PokerHand that is constructed with five Card objects
//
// PokerHand a = new PokerHand(H3, CA, D4, H6, DA);
//
public class PokerHand implements Comparable<PokerHand> {
  // Construct a five card poker hand.
  private ArrayList<Card> hand=new ArrayList<Card>();
  public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5)  {
	  //throws DuplicateCardException
	  //if (c1==c2 || c1==c3 || c1==c4 || c1==c5 || c2==c3 || c2==c4 || c2==c5 || c3==c4 || c3==c5 || c4==c5) {
	//	  throw new DuplicateCardException();
	 // }
	  hand.add(c1);
	  hand.add(c2);
	  hand.add(c3);
	  hand.add(c4);
	  hand.add(c5);
	  Collections.sort(hand);
	  
	  
  }
  public double isPair() {
	  double result = 0.0;
	  /* --------------------------------
      Checking: a a x y z
	 -------------------------------- */   
	  if(hand.get(0).getValue()==hand.get(1).getValue()) {
		  result=1.0+hand.get(0).getValue()*.01+hand.get(4).getValue()*.001+hand.get(3).getValue()*.0001+hand.get(2).getValue()*.00001;
		  return result;
	  }

   /* --------------------------------
      Checking: x a a y z
	 -------------------------------- */
   if(hand.get(1).getValue()==hand.get(2).getValue()) {
		  result=1.0+hand.get(1).getValue()*.01+hand.get(4).getValue()*.001+hand.get(3).getValue()*.0001+hand.get(0).getValue()*.00001;
		  return result;
	  }

   /* --------------------------------
      Checking: x y a a z
	 -------------------------------- */
   if(hand.get(2).getValue()==hand.get(3).getValue()) {
		  result=1.0+hand.get(2).getValue()*.01+hand.get(4).getValue()*.001+hand.get(1).getValue()*.0001+hand.get(0).getValue()*.00001;
		  return result;
	  }

   /* --------------------------------
      Checking: x y z a a
	 -------------------------------- */
   if(hand.get(3).getValue()==hand.get(4).getValue()) {
		  result=1.0+hand.get(3).getValue()*.01+hand.get(2).getValue()*.001+hand.get(1).getValue()*.0001+hand.get(0).getValue()*.00001;
		  return result;
	  }
	return result;
  }
  
  public double isTwoPair() {
	  double result=0.0;
	  /* --------------------------------
      Checking: a a  b b x
	 -------------------------------- */    
	  if(hand.get(0).getValue()==hand.get(1).getValue() && hand.get(2).getValue()==hand.get(3).getValue()) {
		  result+=2.0+hand.get(2).getValue()*.01+hand.get(0).getValue()*.001+hand.get(4).getValue()*.0001;
		  return result;
	  }


   /* ------------------------------
      Checking: a a x  b b
	 ------------------------------ */
	  if(hand.get(0).getValue()==hand.get(1).getValue() && hand.get(3).getValue()==hand.get(4).getValue()) {
		  result+=2.0+hand.get(3).getValue()*.01+hand.get(0).getValue()*.001+hand.get(2).getValue()*.0001;
		  return result;
	  }

   /* ------------------------------
      Checking: x a a  b b
	 ------------------------------ */
	  if(hand.get(1).getValue()==hand.get(2).getValue() && hand.get(3).getValue()==hand.get(4).getValue()) {
		  result+=2.0+hand.get(4).getValue()*.01+hand.get(1).getValue()*.001+hand.get(0).getValue()*.0001;
		  return result;
	  }

	  return result;
	  
  }
  
  public double isThreeOfAKind() {
      double result = 0.0;     
      /* ------------------------------------------------------
      Check for: x x x a b
	 ------------------------------------------------------- */    
   if(hand.get(0).getValue()==hand.get(1).getValue() && hand.get(1).getValue()==hand.get(2).getValue() && hand.get(3).getValue()!=hand.get(0).getValue() && 
		   hand.get(4).getValue()!=hand.get(0).getValue() && hand.get(3).getValue()!=hand.get(4).getValue()) {
	   result+=3.0+hand.get(0).getValue()*.01+hand.get(4).getValue()*.001+hand.get(3).getValue()*.0001;
	   return result;
   }

   /* ------------------------------------------------------
      Check for: a x x x b
	 ------------------------------------------------------- */   
   if(hand.get(1).getValue()==hand.get(2).getValue() && hand.get(2).getValue()==hand.get(3).getValue() && hand.get(0).getValue()!=hand.get(1).getValue() && 
		   hand.get(4).getValue()!=hand.get(1).getValue() && hand.get(0).getValue()!=hand.get(4).getValue()) {
	   result+=3.0+hand.get(1).getValue()*.01+hand.get(4).getValue()*.001+hand.get(0).getValue()*.0001;
	   return result;
   }

   /* ------------------------------------------------------
      Check for: a b x x x
	 ------------------------------------------------------- */  
   if(hand.get(2).getValue()==hand.get(3).getValue() && hand.get(3).getValue()==hand.get(4).getValue() && hand.get(0).getValue()!=hand.get(2).getValue() && 
		   hand.get(1).getValue()!=hand.get(2).getValue() && hand.get(0).getValue()!=hand.get(1).getValue()) {
	   result+=3.0+hand.get(2).getValue()*.01+hand.get(1).getValue()*.001+hand.get(0).getValue()*.0001;
	   return result;
   }
      
      return result;
}
  
  public double isFourOfAKind() {
      double result = 0.0;     
      if(hand.get(0).getValue()==hand.get(1).getValue()&&hand.get(1).getValue()==hand.get(2).getValue()&&hand.get(2).getValue()==hand.get(3).getValue()) {
    	  result=7.0+hand.get(0).getValue()*.01+hand.get(4).getValue()*.001;
    	  return result;
      }
      if(hand.get(1).getValue()==hand.get(2).getValue()&&hand.get(2).getValue()==hand.get(3).getValue()&&hand.get(3).getValue()==hand.get(4).getValue()) {
    	  result=7.0+hand.get(1).getValue()*.01+hand.get(0).getValue()*.001;
    	  return result;
      }
      
      return result;
}
  
  public double isStraight() {
	  double result =0.0;
      if(hand.get(4).getValue()==14) {
    	  boolean a= hand.get(0).getValue()==2 && hand.get(1).getValue()==3 && hand.get(2).getValue()==4 && hand.get(3).getValue()==5;
    	  boolean b= hand.get(0).getValue()==10 && hand.get(1).getValue()==11 && hand.get(2).getValue()==12 && hand.get(3).getValue()==13;
    	  if(a) {
    		  result= 4.05;
        	  return result;
          }
    	  if(b) {
    		  result=4.14;
    		  return result;
    		  
    	  }
      }
      else {
    	  for (int i = 0; i < hand.size() - 1; i++){
              if (hand.get(i).getValue() == hand.get(i+1).getValue() - 1) {
                  result = 4.0 + (hand.get(i+1).getValue() * 0.01);
                 
              } else {
                  result = 0.0;
                  break;
              }
          }
      }
      return result;
      
}
  
  public double isFlush() {
      double result = 0.0;
    //private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8)
      for (int i = 0; i < hand.size()-1; i++) {
    	  if(hand.get(i).getSuit() == hand.get(i+1).getSuit()) {
          result = 5.0;
    	  }
    	  else {
    		  result=0.0;
    		  return result;
    	  }

      }
      if(result>0.0) {
    	  result+=hand.get(4).getValue()*0.01+hand.get(3).getValue()*0.001+hand.get(2).getValue()*0.0001+hand.get(1).getValue()*0.00001+hand.get(0).getValue()*0.000001;
      }
      
      return result;
}
  
  public double isFullHouse() {
	  double result=0.0;
	  
	  boolean a = hand.get(0).getValue()==hand.get(1).getValue() &&  hand.get(1).getValue()==hand.get(2).getValue() &&  hand.get(3).getValue()==hand.get(4).getValue();
	  boolean b= hand.get(0).getValue()==hand.get(1).getValue() &&  hand.get(2).getValue()==hand.get(3).getValue() &&  hand.get(3).getValue()==hand.get(4).getValue();
	  
	  if(a) {
		  result=6.0+hand.get(0).getValue()*.01+hand.get(3).getValue()*.001;
	  }
	  if(b) {
		  result=6.0+hand.get(3).getValue()*.01+hand.get(0).getValue()*.001;
	  }
	  return result;
  }
  
  public double isStraightflush() {
	  double result=0.0;
	  if (this.isStraight()>4.0 && this.isFlush()>5.0) {
		  result=8.0+(this.isStraight()-4.0);
	  }
	  return result;	
	  
  }
  public double highCard() {
	  double result=0.0;
	  result=hand.get(4).getValue()*.01+hand.get(3).getValue()*.001+hand.get(2).getValue()*.0001+hand.get(1).getValue()*.00001+hand.get(0).getValue()*.000001;
	return result;
  }
  
  

  public String toString() {
	  return hand.toString();
  }
  
  public double getHandRanking() {
	double ranking=0.0;
	if(this.isStraightflush()>8.0) {
		ranking=this.isStraightflush();
	}
   else if (this.isFourOfAKind() > 7.0) {
      ranking = this.isFourOfAKind();
  } else if (this.isFullHouse() > 6.0) {
      ranking = this.isFullHouse();
  } else if (this.isFlush() > 5.0) {
      ranking = this.isFlush();
  } else if (this.isStraight() > 4.0) {
      ranking = this.isStraight();
  } else if (this.isThreeOfAKind() > 3.0) {
      ranking = this.isThreeOfAKind();
  } else if (this.isTwoPair() > 2.0) {
      ranking = this.isTwoPair();
  }   else if (this.isPair() > 1.0) {
      ranking = this.isPair();
  } else {
     ranking=this.highCard();
  }
  
return ranking;
	  
  }
  @Override
  public int compareTo(PokerHand o) throws DuplicateCardException {
	  for (int i = 0; i < this.hand.size(); i++) {
		  for (int c = 0; c < o.hand.size(); c++) {
			  if (this.hand.get(i) == o.hand.get(c)) {
				  //throw new DuplicateCardException();
			  }
		  }
	  }
	  
	  double playerRanking=this.getHandRanking();
	  double opponentRanking=o.getHandRanking();
	  if(playerRanking>opponentRanking) {
		  return 1;
	  }
	  if(playerRanking<opponentRanking) {
		  return -1;
	  }
	  
	  
    return 0;
  }
}
