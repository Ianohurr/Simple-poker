package model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

//Ian O'Heir
//This class is where the players who will be playing the pokergame are made. This get given a balance and an array to hold their cards as well as functions to deal with certain poker elements.
public class Player{
	double balance =100.00;
	String playerNumber="";
	ArrayList<Card> hand=new ArrayList<Card>();
	ArrayList<Card> originalCards=new ArrayList<Card>();
	
	
	public double giveAnte() {
		balance-=2.0;
		return 2.0;
		
	}
	public void removeCards(){
		hand.clear();
		originalCards.clear();
	}
	public void sort(){
		Collections.sort(hand);
		Collections.sort(originalCards);
	}
	
	public String getHandRankingString() {
		PokerHand topHand = bestHand();
		if(topHand.getHandRanking()>8.0) {
			return "Straight Flush";
		}
	   else if (topHand.getHandRanking() > 7.0) {
		   return "Four Of A Kind";
	  } else if (topHand.getHandRanking() > 6.0) {
		  return "Full House";
	  } else if (topHand.getHandRanking() > 5.0) {
		  return "Flush";
	  } else if (topHand.getHandRanking() > 4.0) {
		  return "Straight";
	  } else if (topHand.getHandRanking() > 3.0) {
		  return "Three Of A Kind";
	  } else if (topHand.getHandRanking() > 2.0) {
		  return "Two Pair";
	  }   else if (topHand.getHandRanking() > 1.0) {
		  return "Pair";
	  } else {
		  return "High Card";
	  }
		
	}
	public PokerHand bestHand() {
		int cardsSelected = 0;
		PokerHand topHand = new PokerHand(hand.get(0),hand.get(1),hand.get(2),hand.get(3),hand.get(4));
		int hand2 = 0;
		// select first card not to be in the hand
		for(int firstCard = 0; firstCard < 7; firstCard++){
		    // select first card not to be in the hand
		    for(int secondCard = firstCard + 1; secondCard < 7; secondCard++){
		        // every card that is not the first or second will added to the hand
		    	ArrayList<Card> currentHand=new ArrayList<Card>();
		        for(int i = 0; i < 7; i++){
		            if(i != firstCard && i != secondCard){
		                currentHand.add(hand.get(i));
		            }
		        }
		        PokerHand current = new PokerHand(currentHand.get(0),currentHand.get(1),currentHand.get(2),currentHand.get(3),currentHand.get(4));
		        if(topHand.compareTo(current)<0) {
		        	topHand = new PokerHand(currentHand.get(0),currentHand.get(1),currentHand.get(2),currentHand.get(3),currentHand.get(4));
		        }
		        // next hand
		        cardsSelected = 0;
		        hand2++;
		    }
		}
		
		return topHand;
	}
}
