package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10205
 * @problemName Stack 'em Up
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 14/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class UVa10205 {
	public static String getCarta(int n){
		int valor = (n%13)+2;
		String res = "";
		switch(valor){
			case 11: res = "Jack";break;
			case 12: res = "Queen";break;
			case 13: res = "King";break;
			case 14: res = "Ace";break;
			default: res = valor+"";break; 
		}
		valor = n/13;
		switch(valor){
			case 0: res += " of Clubs";break;
			case 1: res += " of Diamonds";break;
			case 2: res += " of Hearts";break;
			case 3: res += " of Spades";break;
		}
		return res;
	}
	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		public int nextInt() throws Throwable{
			if(st.hasMoreTokens())return Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			return nextInt();
		}
	}
	public static void main(String[] args) throws Throwable{
		Escaner sc = new Escaner();
		StringBuilder sb = new StringBuilder();
		for (int c = 0, C = sc.nextInt(); c < C; c++) {
			int D = sc.nextInt();
			int[][] shuffle = new int[D][52];
			for (int i = 0; i < shuffle.length; i++) 
				for (int j = 0; j < shuffle[i].length; j++) 
					shuffle[i][j] = sc.nextInt() - 1;
			int[] inicial = new int[52];
			for (int i = 0; i < inicial.length; i++) 
				inicial[i] = i;
			for (String ln; (ln = sc.in.readLine()) != null && !ln.equals(""); ) {
				int s = Integer.parseInt(ln.trim()) - 1;
				int sol[] = new int[52];
				for (int i = 0; i < shuffle[s].length; i++)
					sol[i] = inicial[shuffle[s][i]];
				inicial = sol;
			}
			for (int i = 0; i < inicial.length; i++) 
				sb.append(getCarta(inicial[i]) + "\n");
			if(c < C-1)sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
