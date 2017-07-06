import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void test() {
		Card SpadeA = new Card(Card.CardValue.ACE, Card.Suit.SPADES);
		Card Spade2 = new Card(Card.CardValue.TWO, Card.Suit.SPADES);
		Card Spade3 = new Card(Card.CardValue.THREE, Card.Suit.SPADES);
		Card Spade4 = new Card(Card.CardValue.FOUR, Card.Suit.SPADES);
		Card Spade5 = new Card(Card.CardValue.FIVE, Card.Suit.SPADES);
		Card Spade6 = new Card(Card.CardValue.SIX, Card.Suit.SPADES);
		Card Spade7 = new Card(Card.CardValue.SEVEN, Card.Suit.SPADES);
		Card Spade8 = new Card(Card.CardValue.EIGHT, Card.Suit.SPADES);
		Card Spade9 = new Card(Card.CardValue.NINE, Card.Suit.SPADES);
		Card Spade10 = new Card(Card.CardValue.TEN, Card.Suit.SPADES);
		Card SpadeJ = new Card(Card.CardValue.JACK, Card.Suit.SPADES);
		Card SpadeQ = new Card(Card.CardValue.QUEEN, Card.Suit.SPADES);
		Card SpadeK = new Card(Card.CardValue.KING, Card.Suit.SPADES);
		
		Card ClubA = new Card(Card.CardValue.ACE, Card.Suit.CLUBS);
		Card Club2 = new Card(Card.CardValue.TWO, Card.Suit.CLUBS);
		Card Club3 = new Card(Card.CardValue.THREE, Card.Suit.CLUBS);
		Card Club4 = new Card(Card.CardValue.FOUR, Card.Suit.CLUBS);
		Card Club5 = new Card(Card.CardValue.FIVE, Card.Suit.CLUBS);
		Card Club6 = new Card(Card.CardValue.SIX, Card.Suit.CLUBS);
		Card Club7 = new Card(Card.CardValue.SEVEN, Card.Suit.CLUBS);
		Card Club8 = new Card(Card.CardValue.EIGHT, Card.Suit.CLUBS);
		Card Club9 = new Card(Card.CardValue.NINE, Card.Suit.CLUBS);
		Card Club10 = new Card(Card.CardValue.TEN, Card.Suit.CLUBS);
		Card ClubJ = new Card(Card.CardValue.JACK, Card.Suit.CLUBS);
		Card ClubQ = new Card(Card.CardValue.QUEEN, Card.Suit.CLUBS);
		Card ClubK = new Card(Card.CardValue.KING, Card.Suit.CLUBS);
		
		Card DA = new Card(Card.CardValue.ACE, Card.Suit.DIAMONDS);
		Card D2 = new Card(Card.CardValue.TWO, Card.Suit.DIAMONDS);
		Card D3 = new Card(Card.CardValue.THREE, Card.Suit.DIAMONDS);
		Card D4 = new Card(Card.CardValue.FOUR, Card.Suit.DIAMONDS);
		Card D5 = new Card(Card.CardValue.FIVE, Card.Suit.DIAMONDS);

		
		ArrayList<Card> al = new ArrayList<Card>();
		al.add(SpadeA);
		al.add(Spade2);
		al.add(Spade3);
		al.add(Spade4);
		al.add(Spade5);
		
		Hand h1 = new Hand(al);
		System.out.println(h1);
		
		assertTrue(h1.isFlush());
		//assertTrue(hand.isFullHouse());
		assertTrue(h1.isStraight());
		assertTrue(h1.isStraightFlush());
		
		ArrayList<Card> a2 = new ArrayList<Card>();
		a2.add(ClubK);
		a2.add(SpadeK);
		a2.add(SpadeK);
		a2.add(D2);
		a2.add(Club4);
		
		Hand h2 = new Hand(a2);
		System.out.println(h2);
		System.out.println(h2.hand.get(3).getValue());
		//assertTrue(h2.isTwoPair());
		
		ArrayList<Card> a3 = new ArrayList<Card>();
		a3.add(ClubA);
		a3.add(DA);
		a3.add(Club3);
		a3.add(D3);
		a3.add(ClubK);
		Hand h3 = new Hand(a3);
		assertTrue(h3.compareTo(h2) < 0);
	}

}
