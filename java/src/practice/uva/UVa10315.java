package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10315
 * @problemName Poker Hands 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 07/12/2010
 **/
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa10315 {
	static class Carta implements Comparable<Carta>{
		char palo; int valor;
		Carta(char palo, int valor){
			this.palo = palo;
			this.valor = valor;
		}
		Carta(String carta){
			int valor = 0;
			switch(carta.charAt(0)){
				case 'T': valor = 10;break;
				case 'J': valor = 11;break;
				case 'Q': valor = 12;break;
				case 'K': valor = 13;break;
				case 'A': valor = 14;break;
				default: valor = carta.charAt(0) - '0';
			}
			this.palo = carta.charAt(1);
			this.valor = valor;
		}
		public int compareTo(Carta o) {
			if(valor == o.valor)return ((Character)palo).compareTo((Character)o.palo);
			return valor-o.valor;
		}
	}
	public static int highCard(Carta[] j1, Carta[] j2){
		for (int i = j1.length - 1; i >= 0; i--) 
			if(j1[i].valor != j2[i].valor)return j1[i].valor - j2[i].valor; 
		return 0;
	}
	public static boolean straight(Carta[] j){
		for (int i = 1; i < j.length; i++) {
			if(i == 1 && j[i].valor == 2 && j[0].valor != 14)return false;
			else if(j[i].valor != j[i-1].valor + 1)return false;
		}
		return true;
	}
	public static boolean flush(Carta[] j){
		for (int i = 1; i < j.length; i++) 
			if(j[i].palo != j[i-1].palo)return false;
		return true;
	}
	public static int four(Carta[] j){
		int[] arr = new int[100];
		for (int i = 0; i < j.length; i++){ 
			arr[j[i].valor]++;
			if(arr[j[i].valor]==4)return j[i].valor;
		}
		return -1;
	}
	public static int full(Carta[] j){
		int[] arr = new int[15];
		for (int i = 0; i < j.length; i++) 
			arr[j[i].valor]++;
		int par = 0, trio = 0;
		for (int i = 0; i < arr.length; i++) 
			if(arr[i]==2)par = i;
			else if(arr[i]==3) trio = i;
		return par>0&&trio>0?trio:-1;
	}
	public static int three(Carta[] j){
		int[] arr = new int[15];
		for (int i = 0; i < j.length; i++){ 
			arr[j[i].valor]++;
			if(arr[j[i].valor]==3)return j[i].valor;
		}
		return -1;
	}
	public static int[] twoPair(Carta[] j){
		int[] arr = new int[15];
		for (int i = 0; i < j.length; i++) 
			arr[j[i].valor]++;
		int par1 = 0, par2 = 0, remaining = 0;
		for (int i = 0; i < arr.length; i++) 
			if(arr[i] == 2 && par1==0)par1 = i;
			else if(arr[i] == 2)par2 = i;
			else if(arr[i] == 1)remaining = i;
		return par1>0&&par2>0?new int[]{max(par1, par2), min(par1, par2), remaining}:null;
	}
	public static int pair(Carta[] j){
		int[] arr = new int[15];
		for (int i = 0; i < j.length; i++){arr[j[i].valor]++;if(arr[j[i].valor]==2)return j[i].valor;}		
		return -1;
	}
	public static int compareMano(Carta[] j1, Carta[] j2){
		{
			boolean jug1 = straight(j1) && flush(j1), jug2 = straight(j2) && flush(j2);
			if(jug1 && jug2)return highCard(j1, j2);
			if(jug1)return 1;if(jug2)return -1;
		}
		{
			int jug1 = four(j1), jug2 = four(j2);
			if(jug1 > 0 && jug2 > 0)return jug1 - jug2;
			if(jug1 > 0)return 1;if(jug2 > 0)return -1;
		}
		{
			int jug1 = full(j1), jug2 = full(j2);
			if(jug1 > 0 && jug2 > 0)return jug1 - jug2;
			if(jug1 > 0)return 1;if(jug2 > 0)return -1;
		}
		{
			boolean jug1 = flush(j1), jug2 = flush(j2);
			if(jug1 && jug2)return highCard(j1, j2);
			if(jug1)return 1;if(jug2)return -1;
		}
		{
			boolean jug1 = straight(j1), jug2 = straight(j2);
			if(jug1 && jug2)return highCard(j1, j2);
			if(jug1)return 1;if(jug2)return -1;
		}
		{
			int jug1 = three(j1), jug2 = three(j2);
			if(jug1 > 0 && jug2 > 0)return jug1 - jug2;
			if(jug1 > 0)return 1;if(jug2 > 0)return -1;
		}
		{
			int[] jug1 = twoPair(j1), jug2 = twoPair(j2);
			if(jug1 != null && jug2 != null)
				return jug1[0] == jug2[0]?(jug1[1] == jug2[1]?jug1[2]-jug2[2]:jug1[1]-jug2[1]):jug1[0]-jug2[0];
			if(jug1 != null)return 1;if(jug2 != null)return -1;
		}
		{
			int jug1 = pair(j1), jug2 = pair(j2);
			if(jug1 > 0 && jug2 > 0){
				if(jug1==jug2)return highCard(j1, j2);
				return jug1-jug2;
			}
			if(jug1 > 0)return 1;if(jug2 > 0)return -1;
		}
		return highCard(j1, j2);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln; (ln = in.readLine()) != null; ) {
			StringTokenizer st = new StringTokenizer(ln.trim());
			Carta[][] arr = new Carta[2][5];
			for (int i = 0; i < arr.length; i++) 
				for (int j = 0; j < arr[i].length; j++) 
					arr[i][j] = new Carta(st.nextToken());
			Arrays.sort(arr[0]);
			Arrays.sort(arr[1]);
			int res = compareMano(arr[0], arr[1]);
			System.out.println(res==0?"Tie.":((res<0?"White":"Black") + " wins."));
		}
	}
}
