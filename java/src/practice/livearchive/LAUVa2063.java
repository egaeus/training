package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2063
 * @problemName Colorville
 * @judge http://livearchive.onlinejudge.org/
 * @category simulation
 * @level easy
 * @date 01/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2063 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken()),R=parseInt(st.nextToken());
			if(N==0)break;
			char[] str=in.readLine().trim().toCharArray();
			char[][] s=new char[R][];
			for(int i=0;i<R;i++)s[i]=in.readLine().trim().toCharArray();
			int[] pos=new int[N];
			int i=0;
			for(;i<R&&!termino(pos,M);i++)
				for(int j=0;j<s[i].length;j++){
					for(;pos[i%N]<M&&str[pos[i%N]]!=s[i][j];pos[i%N]++);
					pos[i%N]++;
				}
			if(termino(pos, M))sb.append("Player "+(((i-1)%N)+1)+" won after "+i+" cards.\n");
			else sb.append("No player won after "+R+" cards.\n");
		}
		System.out.print(new String(sb));
	}
	static boolean termino(int pos[], int M){
		for(int i=0;i<pos.length;i++)if(pos[i]>=M)return true;
		return false;
	}
}
