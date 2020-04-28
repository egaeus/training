package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 100
 * @problemName Ecological Bin Packing
 * @judge http://uva.onlinejudge.org/
 * @category Simulation
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa102 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true){
			String s = in.readLine();
			if(s==null)break;
			String arr[] = s.trim().split(" +");
			int g[][] = new int[3][3];
			for(int i=0;i<3;i++){g[i][0]=Integer.parseInt(arr[i]);g[i][1]=Integer.parseInt(arr[i+3]);g[i][2]=Integer.parseInt(arr[i+6]);}
			int sum1 = g[0][1] + g[0][2] + g[1][0] + g[1][2] + g[2][0] + g[2][1],
			sum2 = g[0][1] + g[0][2] + g[1][0] + g[1][1] + g[2][0] + g[2][2],
			sum3 = g[0][0] + g[0][2] + g[1][1] + g[1][2] + g[2][0] + g[2][1],
			sum4 = g[0][0] + g[0][2] + g[1][0] + g[1][1] + g[2][1] + g[2][2],
			sum5 = g[0][0] + g[0][1] + g[1][1] + g[1][2] + g[2][0] + g[2][2],
			sum6 = g[0][0] + g[0][1] + g[1][0] + g[1][2] + g[2][1] + g[2][2];
			if (Math.min(sum1, Math.min(sum2, Math.min(sum3, Math.min(sum4, Math.min(sum5, sum6))))) == sum2) System.out.println("BCG " + sum2);
			else if (Math.min(sum1, Math.min(sum2, Math.min(sum3, Math.min(sum4, Math.min(sum5, sum6))))) == sum1) System.out.println("BGC " + sum1);
			else if (Math.min(sum1, Math.min(sum2, Math.min(sum3, Math.min(sum4, Math.min(sum5, sum6))))) == sum4) System.out.println("CBG " + sum4); 
			else if (Math.min(sum1, Math.min(sum2, Math.min(sum3, Math.min(sum4, Math.min(sum5, sum6))))) == sum6) System.out.println("CGB " + sum6);
			else if (Math.min(sum1, Math.min(sum2, Math.min(sum3, Math.min(sum4, Math.min(sum5, sum6))))) == sum3) System.out.println("GBC " + sum3);
			else if (Math.min(sum1, Math.min(sum2, Math.min(sum3, Math.min(sum4, Math.min(sum5, sum6))))) == sum5) System.out.println("GCB " + sum5);
		}
	}
}
