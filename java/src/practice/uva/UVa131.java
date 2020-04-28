package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 131
 * @problemName The Psychic Poker Player
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 16/6/2015
 **/
import java.io.*;
import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;
public class UVa131 {
	static class Card implements Comparable<Card>{
		int value;
		char color;
		boolean change;
		public Card(char[] str) {
			if(Character.isDigit(str[0]))
				value=str[0]-'0';
			else if(str[0]=='T')
				value=10;
			else if(str[0]=='J')
				value=11;
			else if(str[0]=='Q')
				value=12;
			else if(str[0]=='A')
				value=1;
			else
				value=13;
			color=str[1];
			change=false;
		}
		static boolean isStraight(ArrayList<Card> cards) {
			Collections.sort(cards);
			boolean ws=true;
			for(int i=1;i<cards.size();i++)
				if(cards.get(i).value!=cards.get(i-1).value+1)
					ws=false;
			if(!ws) {
				if(cards.get(0).value==1) {
					cards.get(0).value=14;
					ws=isStraight(cards);
					for(int i=1;i<cards.size();i++)
						if(cards.get(i).value==14)
							cards.get(i).value=1;
				}
			}
			return ws;
		}
		static boolean isFlush(ArrayList<Card> cards) {
			for(int i=1;i<cards.size();i++)
				if(cards.get(i).color!=cards.get(i-1).color)
					return false;
			return true;
		}
		@Override
		public int compareTo(Card o) {
			if(value!=o.value)
				return value-o.value;
			return color-o.color;
		}
		static int getGame(ArrayList<Card> cards) {
			if(isFlush(cards)&&isStraight(cards)) 
				return 0;
			int[] count=new int[14];
			for(Card card:cards)
				count[card.value]++;
			for(int c:count)
				if(c==4)
					return 1;
			boolean ws=false, ws1=false;
			for(int c:count)
				if(c==2)
					ws=true;
				else if(c==3)
					ws1=true;
			if(ws&&ws1)
				return 2;
			if(isFlush(cards))
				return 3;
			if(isStraight(cards))
				return 4;
			if(ws1)
				return 5;
			ws=false;
			ws1=false;
			for(int c:count)
				if(c==2)
					if(ws)
						ws1=true;
					else
						ws=true;
			if(ws1&&ws) 
				return 6;
			if(ws)
				return 7;
			return 8;
		}
		@Override
		public String toString() {
			return value+""+color+(change?"d":"h");
		}
	}
	public static void main(String args[]) throws Throwable {
		String[] hands=new String[]{"straight-flush","four-of-a-kind","full-house","flush","straight","three-of-a-kind","two-pairs","one-pair","highest-card"};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			StringTokenizer st=new StringTokenizer(ln);
			sb.append("Hand:");
			ArrayList<Card> cards=new ArrayList<Card>();
			ArrayList<Card> deck=new ArrayList<Card>();
			for(int i=0;i<5;i++) {
				char[] a=st.nextToken().toCharArray();
				cards.add(new Card(a));
				sb.append(" ").append(new String(a));
			}
			sb.append(" Deck:");
			for(int i=0;i<5;i++) {
				char[] a=st.nextToken().toCharArray();
				Card card = new Card(a);
				card.change=true;
				deck.add(card);
				sb.append(" ").append(new String(a));
			}
			int bestHand=bestHand(cards, deck);
			sb.append(" Best hand: ").append(hands[bestHand]).append("\n");
		}
		System.out.print(new String(sb));
	}
	static int bestHand(ArrayList<Card> cards, ArrayList<Card> deck) {
		if(deck.isEmpty())
			return Card.getGame(cards);
		int min=Card.getGame(cards);
		Collections.sort(cards);
		for(int i=0;i<cards.size();i++)
			if(!cards.get(i).change) {
				Card c=deck.remove(0);
				Card h=cards.set(i, c);
				min=Math.min(min, bestHand(cards, deck));
				deck.add(0, c);
				int j=0;
				for(;j<cards.size();j++)
					if(cards.get(j).compareTo(c)==0)
						break;
				cards.set(j, h);
				Collections.sort(cards);
			}
		return min;
	}
}
