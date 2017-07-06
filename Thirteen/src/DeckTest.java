import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	@Test
	public void test() {
		/*
		Deck deck = new Deck();
		System.out.println(deck);
		
		int n = 5;
		
		for (int i = 0; i < n; i++){
		
			deck.shuffle();
			System.out.println(deck);
		
		}
		
		Deck deck1 = new Deck();
		deck1.shuffle();
		System.out.println(deck1);
		Deck deck2 = new Deck();
		deck2.shuffle();
		System.out.println(deck2);
		Deck deck3 = new Deck();
		deck3.shuffle();
		System.out.println(deck3);
		Deck deck4 = new Deck();
		deck4.shuffle();
		System.out.println(deck4);
		Deck deck5 = new Deck();
		deck5.shuffle();
		System.out.println(deck5);
		*/
		
		for (int i = 0; i < 52;i++){
			Deck deck = new Deck();
			deck.shuffle();
			System.out.println(deck);
		}
		
	}

}
