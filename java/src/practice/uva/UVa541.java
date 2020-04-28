package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 541
 * @problemName  Error Correction 
 * @judge http://uva.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 2009
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa541 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n = Integer.parseInt(in.readLine().trim());
			if(n==0)break;
			boolean[][] arr = new boolean[n][n];
			int[] rows = new int[n], cols = new int[n];
			for (int i = 0; i < arr.length; i++) {
				String linea[] = in.readLine().trim().split(" +");
				for (int j = 0; j < arr.length; j++) {
					arr[i][j]=Integer.parseInt(linea[j])==1;
					if(arr[i][j]){
						rows[i]++;
						cols[j]++;
					}
				}
			}
			int cont=0, row = -1;
			for (int i = 0; i < cols.length; i++) 
				if(rows[i]%2!=0){
					cont++;
					row = i;
				}
			if(cont>1)System.out.println("Corrupt");
			else{
				if(cont==0){
					for (int i = 0; i < cols.length; i++) 
						if(cols[i]%2!=0)cont++;
					if(cont==0)System.out.println("OK");
					else System.out.println("Corrupt");
				}
				else{
					int col = -1;
					cont=0;
					for (int i = 0; i < cols.length; i++) 
						if(cols[i]%2!=0){
							cont++;
							col = i;
						}
					if(cont==0)System.out.println("Corrupt");
					else if(cont>1)System.out.println("Corrupt");
					else System.out.println("Change bit (" + (row+1) + "," + (col+1) + ")");
				}
			}
		}
	}
}
