package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E.
 * @problemId 3666
 * @problemName What a Special Graph
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level ???
 * @date 21/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa3666 {
	static TreeSet<Integer>lAdy[];
	static int I;
	static boolean f(int v,int c,boolean[] vis){
		//if(I==2)System.out.println((v+1)+" "+c);
		if(c<1)return false;
		boolean ws=false;
		for(int u:lAdy[v]){
			//if(v==2&&c==1)System.out.println(u);
			if(u==I&&c==1)return true;
			if(!vis[u]){
				vis[u]=true;
				ws=ws||f(u,c-1,vis);
				//if(ws)return ws;
				vis[u]=false;
			}
		}
		return ws;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));int caso=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			if(N==0&&M==0)break;
			lAdy=new TreeSet[N];
			for(int i=0;i<N;i++)lAdy[i]=new TreeSet<Integer>();
			for(int i=0;i<M;i++){
				st=new StringTokenizer(in.readLine());
				int desde=parseInt(st.nextToken())-1,hasta=parseInt(st.nextToken())-1;
				lAdy[desde].add(hasta);
				lAdy[hasta].add(desde);
			}
			boolean v[]=new boolean[N],ws=false;
			for(I=0;I<N&&!ws;I++){
				v[I]=true;
				ws=f(I,4,v);
				v[I]=false;
			}
			if(ws)System.out.println("Case "+caso+++": YES");
			else System.out.println("Case "+caso+++": NO");
		}
	}
}
