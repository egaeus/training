package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 555
 * @problemName Bridge Hands
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 20/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
public class UVa555 {
	static class Carta implements Comparable<Carta>{
		char palo;
		int valor;
		Carta(String carta){
			palo = carta.charAt(0);
			if(palo=='H')palo = 'Z';
			switch(carta.charAt(1)){
				case 'T': valor = 10; break;
				case 'J': valor = 11; break;
				case 'Q': valor = 12; break;
				case 'K': valor = 13; break;
				case 'A': valor = 14; break;
				default: valor = carta.charAt(1)-'0';break;
			}
		}
		public int compareTo(Carta o) {
			if(palo!=o.palo)return ((Character)palo).compareTo((Character)o.palo);
			if(valor < o.valor)return -1;
			if(valor > o.valor)return 1;
			return 0;
		}		
		public String toString(){
			String res = "";
			if(palo == 'Z')res += 'H';
			else res += palo;
			switch(valor){
				case 10: res += 'T'; break;
				case 11: res += 'J'; break;
				case 12: res += 'Q'; break;
				case 13: res += 'K'; break;
				case 14: res += 'A'; break;
				default: res += valor;break;
			}
			return res;
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; !(ln = in.readLine().trim()).equals("#");){
			int j = 0;
			switch(ln.charAt(0)){
				case 'S': j = 1;break;
				case 'W': j = 2;break;
				case 'N': j = 3;break;
				case 'E': j = 0;break;
			}
			TreeSet<Carta> manos[] = new TreeSet[4];
			for (int i = 0; i < manos.length; i++) manos[i] = new TreeSet<Carta>();
			String str = in.readLine().trim() + in.readLine().trim();
			for(;str.length() > 0;){
				manos[j].add(new Carta(str.substring(0, 2)));
				str = str.substring(2);
				j=(j+1)%4;
			}
			for (int i = 0; i < manos.length; i++) 
				System.out.println((i == 0?"S":(i==1?"W":(i==2?"N":"E"))) + ": " + manos[i].toString().replaceAll("[\\[\\],]", ""));
		}
	}
}
