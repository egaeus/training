package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 422
 * @problemName Word-Search Wonder
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 27/12/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa422 {
	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		int[][] cambios = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{-1,1},{1,-1},{-1,-1},{1,1}};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[][] matriz = new char[Integer.parseInt(in.readLine().trim())][];
		for (int i = 0; i < matriz.length; i++) 
			matriz[i] = in.readLine().trim().toCharArray();
		for(String ln; !(ln = in.readLine().trim()).equals("0");){
			char[] str = ln.toCharArray();
			boolean wsM = false;
			for (int i = 0; i < matriz.length && !wsM; i++) 
				for (int j = 0; j < matriz[0].length && !wsM; j++) 
					for (int k = 0; k < cambios.length && !wsM; k++) {
						boolean ws = false;
						for (int h = 0; h < str.length && i+cambios[k][0]*h >= 0 && i+cambios[k][0]*h < matriz.length && j+cambios[k][1]*h >= 0 && j+cambios[k][1]*h < matriz[i].length; h++){
							if(!(matriz[i+cambios[k][0]*h][j+cambios[k][1]*h]==str[h]))break;
							if(h == str.length - 1)ws = true;
						}
						if(ws){
							wsM = true;
							sb.append((i+1) + "," + (j+1) + " " + (i+1+cambios[k][0]*(str.length-1)) + "," + (j+1+cambios[k][1]*(str.length-1)) + "\n");
						}
					}
			if(!wsM)sb.append("Not found\n");
		}
		System.out.print(new String(sb));
	}
}
