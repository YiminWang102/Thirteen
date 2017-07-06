import java.util.*;

public class Hand implements Comparable<Hand>{
	//assumes hand is sorted by value, from lowest to highest, with Ace being the highest
	public enum HandType{
		STRAIGHTFLUSH(9),
		QUADS(8),
		FULLHOUSE(7),
		FLUSH(6),
		STRAIGHT(5),
		TRIPS(4),
		TWOPAIR(3),
		ONEPAIR(2),
		HIGHCARD(1);
		
		private int Value;
		
		private HandType(int value){
			Value = value;
		}
		
		public int getValue(){
			return Value;
		}
		
	}
	
	public int size;
	public ArrayList<Card> hand;
	public HandType type;
	
	public Hand(ArrayList<Card> h){
		size = h.size();
		hand = h;
		Collections.sort(hand);
		if (size == 5){
		if(isStraightFlush())
			type = HandType.STRAIGHTFLUSH;
		else if(isQuads())
			type = HandType.QUADS;
		else if(isFullHouse())
			type = HandType.FULLHOUSE;
		else if(isFlush())
			type = HandType.FLUSH;
		else if(isStraight())
			type = HandType.STRAIGHT;
		else if(isTrips())
			type = HandType.TRIPS;
		else if(isTwoPair())
			type = HandType.TWOPAIR;
		else if(isOnePair())
			type = HandType.ONEPAIR;
		else
			type = HandType.HIGHCARD;
		}
		
		if (size == 3){
			if(isTrips())
				type = HandType.TRIPS;
			else if(isOnePair())
				type = HandType.ONEPAIR;
			else
				type = HandType.HIGHCARD;
		}
	}
	
	public boolean isStraightFlush(){
		return isFlush() && isStraight();
	}
	
	public boolean isQuads(){
		if (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue() == hand.get(2).getValue() && hand.get(0).getValue() == hand.get(3).getValue())
			return true;
		else if (hand.get(4).getValue() == hand.get(1).getValue() && hand.get(4).getValue() == hand.get(2).getValue() && hand.get(4).getValue() == hand.get(3).getValue())
			return true;
		return false;
	}
	
	public boolean isFullHouse(){
		if (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue() == hand.get(2).getValue() && hand.get(3).getValue() == hand.get(4).getValue())
			return true;
		else if (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(2).getValue() == hand.get(3).getValue() && hand.get(2).getValue() == hand.get(4).getValue())
			return true;
		return false;
	}
	
	public boolean isFlush(){
		for (int i = 0; i < hand.size(); i++){
			if(!(hand.get(0).getSuit() == hand.get(i).getSuit()))
				return false;
		}
		return true;
	}
	
	public boolean isStraight(){
		if(size == 3){
			if (hand.get(0).getValue() == 2)
				if (hand.get(1).getValue() == 3)
					if (hand.get(2).getValue() == 14)
						return true;
		}
		if(size == 5)
			if (hand.get(0).getValue() == 2)
				if (hand.get(1).getValue() == 3)
					if (hand.get(2).getValue() == 4)
						if (hand.get(3).getValue() == 5)
							if (hand.get(4).getValue() == 14)
								return true;
		for(int i = 0; i < hand.size(); i++){
			if (!(hand.get(i).getValue() - hand.get(0).getValue() == i))
				return false;
		}
		return true;
	}
	
	public boolean isTrips(){
		for (int i = 0; i < hand.size() - 2; i++){
			if(hand.get(i).getValue() == hand.get(i+1).getValue() && hand.get(i).getValue() == hand.get(i+2).getValue())
				return true;
		}
		return false;
	}
	
	public boolean isTwoPair(){
		if(!(hand.get(0).getValue() == hand.get(1).getValue())){
			if(hand.get(1).getValue() == hand.get(2).getValue() && hand.get(3).getValue() == hand.get(4).getValue())
				return true;
		}
		else if(hand.get(2).getValue() == hand.get(3).getValue() || hand.get(3).getValue() == hand.get(4).getValue())
			return true;
		return false;
	}
	
	public boolean isOnePair(){
		for (int i = 0; i < hand.size() - 1; i++){
			if(hand.get(i).getValue() == hand.get(i+1).getValue()){
				return true;
			}
		}
		return false;
	}
	
	public boolean isHighCard(){
		return(type == HandType.HIGHCARD);
	}

	public String toString(){
		String s = "";
		for(int i = 0; i < hand.size(); i++){
			s = s + hand.get(i).toString() + "\n";
		}
		return s;
	}

	public int compareTo(Hand h){
		if (!(this.type.getValue() == h.type.getValue()))
			return this.type.getValue() - h.type.getValue();
		if (this.type == HandType.STRAIGHTFLUSH || this.type == HandType.STRAIGHT)
			return this.hand.get(3).getValue() - h.hand.get(3).getValue();
		if (this.type == HandType.FLUSH || this.type == HandType.HIGHCARD){
			for(int i = h.size - 1; i >= 0; i--){
				if (this.hand.get(i).getValue() != h.hand.get(i).getValue())
					return this.hand.get(i).getValue() - h.hand.get(i).getValue();
			}
			return 0;
		}
		if (this.type == HandType.QUADS){
			int tVal = 0;
			int hVal = 0;
			if (this.hand.get(0).getValue() == this.hand.get(1).getValue())
				tVal = this.hand.get(0).getValue();
			else
				tVal = this.hand.get(1).getValue();
			
			if (h.hand.get(0).getValue() == h.hand.get(1).getValue())
				hVal = h.hand.get(0).getValue();
			else
				hVal = h.hand.get(1).getValue();
			return tVal - hVal;
		}
		if (this.type == HandType.FULLHOUSE){
			int tVal = 0;
			int hVal = 0;
			if (this.hand.get(1).getValue() == this.hand.get(2).getValue())
				tVal = this.hand.get(0).getValue();
			else 
				tVal = this.hand.get(2).getValue();
			if (h.hand.get(1).getValue() == h.hand.get(2).getValue())
				hVal = h.hand.get(0).getValue();
			else
				hVal = h.hand.get(2).getValue();
			return tVal - hVal;
		}
		if (this.type == HandType.TRIPS){
			int tVal = 0;
			int hVal = 0;
			if (this.hand.get(0).getValue() == this.hand.get(1).getValue())
				tVal = this.hand.get(0).getValue();
			else if (this.hand.get(1).getValue() == this.hand.get(2).getValue())
				tVal = this.hand.get(1).getValue();
			else tVal = this.hand.get(2).getValue();
			
			if (h.hand.get(0).getValue() == h.hand.get(1).getValue())
				hVal = h.hand.get(0).getValue();
			else if (h.hand.get(1).getValue() == h.hand.get(2).getValue())
				hVal = h.hand.get(1).getValue();
			else hVal = h.hand.get(2).getValue();
			return tVal - hVal;
		}
		if (this.type == HandType.ONEPAIR){
			int tVal = 0;
			ArrayList<Integer> tKick = new ArrayList<Integer>();
			int hVal = 0;
			ArrayList<Integer> hKick = new ArrayList<Integer>();
			for(int i = 0; i < this.size; i++){
				if(tVal == 0 && this.hand.get(i).getValue() == this.hand.get(i + 1).getValue()){
					tVal = this.hand.get(i).getValue();
					i++;
				}
				else
					tKick.add(this.hand.get(i).getValue());
			}
			
			for(int i = 0; i < h.size; i++){
				if(hVal == 0 &&h.hand.get(i).getValue() == h.hand.get(i + 1).getValue()){
					hVal = h.hand.get(i).getValue();
					i++;
				}
				else
					hKick.add(h.hand.get(i).getValue());
			}
			if(tVal != hVal)
				return tVal - hVal;
			else{
				for(int i = hKick.size() - 1; i >= 0; i--)
					if(hKick.get(i) != tKick.get(i))
						return tKick.get(i) - hKick.get(i);
			}
			return 0;
			
		}
		else{
			int tVal1 = 0;
			int tVal2 = 0;
			int tKick = 0;
			int hVal1 = 0;
			int hVal2 = 0;
			int hKick = 0;
			
			if(this.hand.get(0).getValue() == this.hand.get(1).getValue()){
				tVal1 = this.hand.get(0).getValue();
				if(this.hand.get(2).getValue() == this.hand.get(3).getValue()){
					tVal2 = this.hand.get(2).getValue();
					tKick = this.hand.get(4).getValue();
				}
				else{
					tKick = this.hand.get(2).getValue();
					tVal2 = this.hand.get(3).getValue();
				}
			}
			else{
				tKick = this.hand.get(0).getValue();
				tVal1 = this.hand.get(1).getValue();
				tVal2 = this.hand.get(3).getValue();
			}
			
			if(h.hand.get(0).getValue() == h.hand.get(1).getValue()){
				hVal1 = h.hand.get(0).getValue();
				if(h.hand.get(2).getValue() == h.hand.get(3).getValue()){
					hVal2 = h.hand.get(2).getValue();
					hKick = h.hand.get(4).getValue();
				}
				else{
					hKick = h.hand.get(2).getValue();
					hVal2 = h.hand.get(3).getValue();
				}
			}
			else{
				hKick = h.hand.get(0).getValue();
				hVal1 = h.hand.get(1).getValue();
				hVal2 = h.hand.get(3).getValue();
			}
			
			if(tVal2 != hVal2)
				return tVal2 - hVal2;
			if(tVal1 != hVal1)
				return tVal1 - hVal1;
			return tKick = hKick;
				
			
		}
	}
}
