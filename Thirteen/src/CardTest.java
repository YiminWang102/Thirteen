import static org.junit.Assert.*;
import java.util.*;


import org.junit.Test;

public class CardTest {

	@Test
	public void test() {
		ArrayList<Card> deck = Card.newDeck();
		System.out.println(deck);
	}

}
