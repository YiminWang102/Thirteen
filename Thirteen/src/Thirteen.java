import java.util.*;

public class Thirteen {

	
	public static ArrayList<Hand> play(ArrayList<Card> c){
		Hand top = null;
		Hand middle = null;
		Hand bottom = null;
		
		int Score = 0;
		
		for (int i = 0; i < c.size()-4; i++)
			for(int j = i+1; j < c.size()-3; j++)
				for(int k = j+1; k < c.size()-2; k++)
					for(int l = k+1; l < c.size()-1; l++)
						for(int m = l+1; m < c.size(); m++){
							ArrayList<Card> temp = new ArrayList<Card>();
							for(Card card : c)
								temp.add(card);
							ArrayList<Card> a1 = new ArrayList<Card>();
							a1.add(c.get(i));
							a1.add(c.get(j));
							a1.add(c.get(k));
							a1.add(c.get(l));
							a1.add(c.get(m));
							temp.remove(i);
							temp.remove(j-1);
							temp.remove(k-2);
							temp.remove(l-3);
							temp.remove(m-4);
							Hand tBot = new Hand(a1);
							for (int v = 0; v < temp.size()-4; v++)
								for(int w = v+1; w < temp.size()-3; w++)
									for(int x = w+1; x < temp.size()-2; x++)
										for(int y = x+1; y < temp.size()-1; y++)
											for(int z = y+1; z < temp.size(); z++){
												ArrayList<Card> a2 = new ArrayList<Card>();
												ArrayList<Card> temp2 = new ArrayList<Card>();
												for(Card card : temp)
													temp2.add(card);
												a2.add(temp.get(v));
												a2.add(temp.get(w));
												a2.add(temp.get(x));
												a2.add(temp.get(y));
												a2.add(temp.get(z));
												temp2.remove(v);
												temp2.remove(w-1);
												temp2.remove(x-2);
												temp2.remove(y-3);
												temp2.remove(z-4);
												Hand tMid = new Hand(a2);
												
												Hand tTop = new Hand(temp2);
												
												if (tBot.compareTo(tMid) >= 0 && tMid.compareTo(tTop) >= 0){
													//get a score
													int tScore = tBot.type.getValue() + tMid.type.getValue() + tTop.type.getValue();
													//start with three "base" hands
													if(bottom == null){
														bottom = tBot;
														middle = tMid;
														top = tTop;
														Score = tScore;
													}
													//If score is better, go with new hand
													if (tScore > Score){
														Score = tScore;
														bottom = tBot;
														middle = tMid;
														top = tTop;
													}
													//here is where you can change up how to play hands if they have same score
													if(tScore == Score){
														//prioritize strongest bottom
														if(tBot.type.getValue() > bottom.type.getValue()){
															bottom = tBot;
															middle = tMid;
															top = tTop;									
														}
														//middle is next priority
														//All two-pairs get pushed down.
														else if(tMid.type.getValue() > middle.type.getValue()){
															bottom = tBot;
															middle = tMid;
															top = tTop;
														}
														else if(tTop.compareTo(top) >= 0){
															bottom = tBot;
															middle = tMid;
															top = tTop;
														}
													}
													
													
														
													
												}
												
											}
						}
					
				
			ArrayList<Hand> al = new ArrayList<Hand>();
			al.add(top);
			al.add(middle);
			al.add(bottom);
			
			return al;
	}

	public static ArrayList<Card> convert(String s){
		ArrayList<Card> c = new ArrayList<Card>();
		
		for(int i = 0; i < s.length(); i = i+2){
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(i+1);
			Card.Suit suit = null;
			Card.CardValue cv = null;
			if(ch1 == '2')
				cv = Card.CardValue.TWO;
			else if(ch1 == '3')
				cv = Card.CardValue.THREE;
			else if(ch1 == '4')
				cv = Card.CardValue.FOUR;
			else if(ch1 == '5')
				cv = Card.CardValue.FIVE;
			else if(ch1 == '6')
				cv = Card.CardValue.SIX;
			else if(ch1 == '7')
				cv = Card.CardValue.SEVEN;
			else if(ch1 == '8')
				cv = Card.CardValue.EIGHT;
			else if(ch1 == '9')
				cv = Card.CardValue.NINE;
			else if(ch1 == 't')
				cv = Card.CardValue.TEN;
			else if(ch1 == 'j')
				cv = Card.CardValue.JACK;
			else if(ch1 == 'q')
				cv = Card.CardValue.QUEEN;
			else if(ch1 == 'k')
				cv = Card.CardValue.KING;
			else if(ch1 == 'a')
				cv = Card.CardValue.ACE;
			
			if (ch2 == 'd')
				suit = Card.Suit.DIAMONDS;
			if (ch2 == 's')
				suit = Card.Suit.SPADES;
			if (ch2 == 'h')
				suit = Card.Suit.HEARTS;
			if (ch2 == 'c')
				suit = Card.Suit.CLUBS;
			
			Card temp = new Card(cv, suit);
			c.add(temp);
		}
		return c;
	}
}
