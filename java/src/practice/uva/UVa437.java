package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 437
 * @problemName The Tower of Babylon
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 18/03/2011
 **/
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa437 {
	static int[][] blocks;
	static int[][] posiblesBases = new int[][]{{0,1,2},{0,2,1},{1,2,0},{1,0,2},{2,0,1},{2,1,0}};
	static TreeMap<int[], Integer> mem;
	static int function(int block, int base1, int base2){
		if(block==blocks.length)return 0;
		if(mem.containsKey(new int[]{block, base1, base2}))return mem.get(new int[]{block, base1, base2}); 
		int max = function(block+1, base1, base2);
		for(int i = 0; i < posiblesBases.length; i++)
			if(blocks[block][posiblesBases[i][0]]<base1&&blocks[block][posiblesBases[i][1]]<base2)
				max = max(max, function(0, blocks[block][posiblesBases[i][0]], blocks[block][posiblesBases[i][1]])+blocks[block][posiblesBases[i][2]]);
		mem.put(new int[]{block, base1, base2}, max);
		return max;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int N, c = 0; (N = parseInt(in.readLine().trim()))!=0; c++){
			blocks = new int[N][3];
			for(int i = 0; i < N; i++){
				StringTokenizer st = new StringTokenizer(in.readLine());
				blocks[i][0] = parseInt(st.nextToken());
				blocks[i][1] = parseInt(st.nextToken());
				blocks[i][2] = parseInt(st.nextToken());
			}
			mem = new TreeMap<int[], Integer>(new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					for(int i = 0; i < o1.length; i++)
						if(o1[i]<o2[i])return -1;
						else if(o1[i]>o2[i])return 1;
					return 0;
				}
			});
			System.out.println("Case " + (c+1) + ": maximum height = " + function(0,MAX_VALUE,MAX_VALUE));			
		}
	}
}
