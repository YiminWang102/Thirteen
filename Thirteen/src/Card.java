import java.util.*;

public class Card implements Comparable<Card>{
	public enum CardValue{
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		JACK(11),
		QUEEN(12),
		KING(13),
		ACE(14);
		
		private int cardValue;
		
		private CardValue(int value)
		{
			this.cardValue = value;
		}
		
		public int getValue() {
			return cardValue;
		}
	}
	
	public enum Suit {
		CLUBS,
		DIAMONDS,
		HEARTS,
		SPADES
	}
	
	
	private Suit suit;
	private CardValue cardValue;
	
	public int getValue(){
		return cardValue.getValue();
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	public Card(CardValue cv, Suit s){
		cardValue = cv;
		suit = s;
	}
	
	public String toString(){
		return cardValue + " of " + suit;
	}
	
	private static final List<Card> protoDeck = new ArrayList<Card>();
	
	static{
		for (Suit suit : Suit.values())
			for (CardValue cv : CardValue.values())
				protoDeck.add(new Card(cv, suit));
				
	}
	
	public static ArrayList<Card> newDeck() {
		return new ArrayList<Card>(protoDeck);
	}
	
	public int compareTo(Card card){
		return this.getValue() - card.getValue();
	}
	
}
