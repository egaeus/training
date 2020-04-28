package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3473
 * @problemName Where Are My Genes
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 13/09/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa3473 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N,c=1;(N=parseInt(in.readLine().trim()))!=0;c++){
			sb.append("Genome "+c+"\n");
			int[] arr=new int[N];
			for(int i=0;i<N;i++)arr[i]=i;
			for(int M=parseInt(in.readLine().trim()),i=0;i<M;i++){
				StringTokenizer st=new StringTokenizer(in.readLine());
				int desde=parseInt(st.nextToken())-1,hasta=parseInt(st.nextToken())-1;
				for(int j=0,v;j<Math.ceil((hasta-desde)/2.);j++){
					v=arr[desde+j];
					arr[desde+j]=arr[hasta-j];
					arr[hasta-j]=v;
				}
				//System.out.println(Arrays.toString(arr));
			}
			int pos[]=new int[N];
			for(int i=0;i<N;i++)pos[arr[i]]=i;
			for(int Q=parseInt(in.readLine().trim()),i=0;i<Q;i++)
				sb.append((pos[parseInt(in.readLine().trim())-1]+1)+"\n");
		}
		System.out.print(new String(sb));
	}
}
