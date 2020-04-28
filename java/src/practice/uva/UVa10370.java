package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10370
 * @probleName Above Average 
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2008
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
public class UVa10370 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < n; i++) {
			String y[] = in.readLine().trim().split(" +");
			int x = Integer.parseInt(y[0]);;
			int[] arr = new int[x];
			int cont = 0, sum = 0;
			boolean bool = true;
			while(cont!=x){
				for (int j = bool?1:0; j < y.length; j++) {
					bool = false;
					arr[cont++]=Integer.parseInt(y[j]);
					sum += arr[cont-1];
				}
				if(cont==x)break;
				y = in.readLine().trim().split(" +");
			}
			double media = sum/x;
			cont = 0;
			for (int j = 0; j < arr.length; j++)
				if(arr[j]>media)cont++;
			media = cont>0?(1.*(cont*100)/x):0.0;
			char c = '%';
			System.out.printf(Locale.US, "%.3f%c\n", media, c);
		}
	}
}
