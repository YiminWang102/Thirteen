import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ThirteenTest {

	@Test
	public void test() {
		String s = "kdqsjcjstd9c8h8c5d5c4c3d3h";
		ArrayList<Card> cards = Thirteen.convert(s);
		ArrayList<Hand> hands = Thirteen.play(cards);
		
		System.out.println(hands);
	}

}
