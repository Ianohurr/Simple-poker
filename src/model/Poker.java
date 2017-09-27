package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

import model.Card;
import model.DuplicateCardException;
import model.PokerHand;
import model.Rank;
import model.Suit;
import java.text.DecimalFormat;
import java.text.NumberFormat;

//Ian O'Heir
//This class is where the game of poker is actually played. It uses other classes such as player, pokerhand, card...

public class Poker {
	private static ArrayList<Card> deck=new ArrayList<Card>(52);
	private static int ante=0;
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many players?");
	int players = keyboard.nextInt();
	ArrayList<Player> playerArray = new ArrayList<Player>();
	for (int i =1;i<players+1;i++){
		playerArray.add(new Player());
		playerArray.get(i-1).playerNumber="Player "+i;
	}
	String answer="y";
	while (answer.equals("y")) {
		createDeck();
		shuffleDeck();
		ante=0;
		ArrayList<Player> winners = new ArrayList<Player>();
		ArrayList<Card> communityCards=new ArrayList<Card>();
		communityCards.add(giveCard());
		communityCards.add(giveCard());
		communityCards.add(giveCard());
		communityCards.add(giveCard());
		communityCards.add(giveCard());
		System.out.println("Community Cards: "+communityCards.toString());
		System.out.println("++++++++++++++++++++++++++++++++++++");
		//When player antes, give them two cards
		for (int i =0;i<players;i++){
			playerArray.get(i).removeCards();
			ante+=playerArray.get(i).giveAnte();
			playerArray.get(i).hand.add(giveCard());
			playerArray.get(i).hand.add(giveCard());
			playerArray.get(i).originalCards.add(playerArray.get(i).hand.get(0));
			playerArray.get(i).originalCards.add(playerArray.get(i).hand.get(1));
		}
		for (int i =0;i<players;i++){
			for (int c =0;c<communityCards.size();c++){
				playerArray.get(i).hand.add(communityCards.get(c));
			}
			playerArray.get(i).sort();
			playerArray.get(i).bestHand();
		}
		//Players turn
		NumberFormat formatter = DecimalFormat.getCurrencyInstance();
		PokerHand bestHand = playerArray.get(0).bestHand();
		for (int i =0;i<players;i++){
			PokerHand current = playerArray.get(i).bestHand();	
			System.out.println(playerArray.get(i).playerNumber+": "+  formatter.format(playerArray.get(i).balance)+" - " + playerArray.get(i).originalCards.get(0) +" "+ playerArray.get(i).originalCards.get(1));
			System.out.println("\tBest hand:  "+current.toString()+" - "+playerArray.get(i).getHandRankingString());
			System.out.println("");
			if (current.compareTo(bestHand)>0){
				bestHand=current;
			}
		}
		for (int i =0;i<players;i++){
			if(playerArray.get(i).bestHand().compareTo(bestHand)==0) {
				winners.add(playerArray.get(i));
			}
		}
		if(winners.size()<=1) {
			winners.get(0).balance+=ante;
			System.out.println("Winner: "+ winners.get(0).playerNumber +" "+  formatter.format(winners.get(0).balance));
			System.out.println("++++++++++++++++++++++++++++++++++++");
		}
		else {
			System.out.println("Winning hands (tie)");
			System.out.println("++++++++++++++++++++++++++++++++++++");
			for (int i =0;i<winners.size();i++){
				winners.get(i).balance+=ante/winners.size();
				System.out.println(winners.get(i).bestHand()+" "+ winners.get(i).getHandRankingString()+" "+ winners.get(i).playerNumber +" "+formatter.format(winners.get(i).balance));
			}
		}
		System.out.println("Play another game? <y or n>");
		answer = keyboard.next();
		System.out.println("");
		}

		

	}
	
	public static void createDeck() {
		deck.clear();
		deck.add(new Card(Rank.DEUCE, Suit.CLUBS));
		deck.add(new Card(Rank.THREE, Suit.CLUBS));
		deck.add(new Card(Rank.FOUR, Suit.CLUBS));
		deck.add(new Card(Rank.FIVE, Suit.CLUBS));
		deck.add(new Card(Rank.SIX, Suit.CLUBS));
		deck.add(new Card(Rank.SEVEN, Suit.CLUBS));
		deck.add(new Card(Rank.EIGHT, Suit.CLUBS));
		deck.add(new Card(Rank.NINE, Suit.CLUBS));
		deck.add(new Card(Rank.TEN, Suit.CLUBS));
		deck.add(new Card(Rank.JACK, Suit.CLUBS));
		deck.add(new Card(Rank.QUEEN, Suit.CLUBS));
		deck.add(new Card(Rank.KING, Suit.CLUBS));
		deck.add(new Card(Rank.ACE, Suit.CLUBS));
		deck.add(new Card(Rank.DEUCE, Suit.DIAMONDS));
		deck.add(new Card(Rank.THREE, Suit.DIAMONDS));
		deck.add(new Card(Rank.FOUR, Suit.DIAMONDS));
		deck.add(new Card(Rank.FIVE, Suit.DIAMONDS));
		deck.add(new Card(Rank.SIX, Suit.DIAMONDS));
		deck.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
		deck.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
		deck.add(new Card(Rank.NINE, Suit.DIAMONDS));
		deck.add(new Card(Rank.TEN, Suit.DIAMONDS));
		deck.add(new Card(Rank.JACK, Suit.DIAMONDS));
		deck.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
		deck.add(new Card(Rank.KING, Suit.DIAMONDS));
		deck.add(new Card(Rank.ACE, Suit.DIAMONDS));
		deck.add(new Card(Rank.DEUCE, Suit.SPADES));
		deck.add(new Card(Rank.THREE, Suit.SPADES));
		deck.add(new Card(Rank.FOUR, Suit.SPADES));
		deck.add(new Card(Rank.FIVE, Suit.SPADES));
		deck.add(new Card(Rank.SIX, Suit.SPADES));
		deck.add(new Card(Rank.SEVEN, Suit.SPADES));
		deck.add(new Card(Rank.EIGHT, Suit.SPADES));
		deck.add(new Card(Rank.NINE, Suit.SPADES));
		deck.add(new Card(Rank.TEN, Suit.SPADES));
		deck.add(new Card(Rank.JACK, Suit.SPADES));
		deck.add(new Card(Rank.QUEEN, Suit.SPADES));
		deck.add(new Card(Rank.KING, Suit.SPADES));
		deck.add(new Card(Rank.ACE, Suit.SPADES));
		deck.add(new Card(Rank.DEUCE, Suit.HEARTS));
		deck.add(new Card(Rank.THREE, Suit.HEARTS));
		deck.add(new Card(Rank.FOUR, Suit.HEARTS));
		deck.add(new Card(Rank.FIVE, Suit.HEARTS));
		deck.add(new Card(Rank.SIX, Suit.HEARTS));
		deck.add(new Card(Rank.SEVEN, Suit.HEARTS));
		deck.add(new Card(Rank.EIGHT, Suit.HEARTS));
		deck.add(new Card(Rank.NINE, Suit.HEARTS));
		deck.add(new Card(Rank.TEN, Suit.HEARTS));
		deck.add(new Card(Rank.JACK, Suit.HEARTS));
		deck.add(new Card(Rank.QUEEN, Suit.HEARTS));
		deck.add(new Card(Rank.KING, Suit.HEARTS));
		deck.add(new Card(Rank.ACE, Suit.HEARTS));
		
	}

	
	public static void shuffleDeck() {

		Collections.shuffle(deck);

	}
	public static Card giveCard() {
		Card current =deck.get(0);
		deck.remove(0);
		return current;
		
	}
}
