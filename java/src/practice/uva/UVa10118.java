package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10118
 * @problemName Free Candies
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level medium
 * @date 17/03/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa10118 {
	static int[][] pilas;
	static TreeMap<int[], Integer> mem;
	public static int function(int N, int X){
		if(mem.containsKey(new int[]{N, X}))return mem.get(new int[]{N, X});
		int[] posPilas = new int[4];
		for(int i = 0, n = N; i < 4; i++, n=n>>6)
			posPilas[i]=n&(63);
		int[] candies = new int[5];
		for(int i = 0, x = X; i < 5; i++, x=x>>5)
			candies[i]=x&(31);
		Arrays.sort(candies);
		if(candies[0]>0)return 0;
		int max = 0;
		for(int i = 0; i < posPilas.length; i++)
			if(posPilas[i]<pilas[i].length){
				int bs = Arrays.binarySearch(candies, pilas[i][posPilas[i]]);
				if(bs<0)candies[0] = pilas[i][posPilas[i]];
				else candies[bs] = 0;
				long n = 0, x = 0;
				posPilas[i]++;
				for(int j = 0; j < posPilas.length; j++, n=n<<6)
					n+=posPilas[posPilas.length-1-j];
				n=n>>6;
				for(int j = 0; j < candies.length; j++, x=x<<5)
					x+=candies[j];
				x=x>>5;
				max = max(max, function((int)n, (int)x) + (bs<0?0:1));
				posPilas[i]--;
				if(bs<0)candies[0] = 0;
				else candies[bs] = pilas[i][posPilas[i]];
			}		
		mem.put(new int[]{N, X}, max);
		return max;
	}
	public static void main(String[] args) throws Throwable{
		Comparator<int[]> comp = new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0]<o2[0])return -1;
				if(o1[0]>o2[0])return 1;
				if(o1[1]<o2[1])return -1;
				if(o1[1]>o2[1])return 1;
				return 0;
			}
		};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int N; (N = parseInt(in.readLine().trim()))!=0;){
			pilas = new int[4][N];
			for(int i = 0; i < N; i++){
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0; j < 4; j++)
					pilas[j][i] = parseInt(st.nextToken());
			}
			mem = new TreeMap<int[], Integer>(comp);
			System.out.println(function(0,0));
		}
	}
}
