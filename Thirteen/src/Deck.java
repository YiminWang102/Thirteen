import java.util.*;


public class Deck {
	public static final ArrayList<Card> newDeck = Card.newDeck();
	
	public ArrayList<Card> deck = newDeck;

	public void shuffle(){
	
		for (int i = 51; i >= 0; i--){
			int n = (int)(i * Math.random());

			Card t = deck.get(i);
			deck.set(i, deck.get(n));
			deck.set(n, t);
			
		}
		
	}
	
	public String toString(){
		return deck.toString();
	}
	
}
