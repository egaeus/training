package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict T.L.E.
 * @problemId 2886
 * @problemName X-Mart
 * @judge http://livearchive.onlinejudge.org/
 * @category graph
 * @level medium
 * @date 25/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa2886 {
	/* -p -> p negado, p está entre [1,N] */
	static boolean sat2(int[][] clausulas,int n){
		TreeSet<Integer> lAdy[]=new TreeSet[2*n];boolean v[]=new boolean[2*n];
		for(int i=0;i<2*n;i++)lAdy[i]=new TreeSet<Integer>();
		for(int[] c:clausulas){
			int d=c[0]<0?n-c[0]-1:c[0]-1,h=c[1]<0?n-c[1]-1:c[1]-1;
			lAdy[d<n?d+n:d-n].add(h);lAdy[h<n?h+n:h-n].add(d);
		}
		for(int i=0;i<1;i++)
			if(!sat2(lAdy,i,i+n,new boolean[2*n])&&!sat2(lAdy,i+n,i,new boolean[2*n]))return false;
		return true;
	}
	static boolean sat2(TreeSet<Integer> lAdy[],int s,int d,boolean[] v){
		if(s==d)return false;
		v[s]=true;
		for(int u:lAdy[s])if(!v[u]&&!sat2(lAdy,u,d,v))return false;
		v[s]=false;
		return true;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			boolean ws=true;
			int C=parseInt(st.nextToken()),P=parseInt(st.nextToken());
			if(C==0&&P==0)break;
			int[][] m=new int[C*2][];int c=0;
			for(int i=0;i<C;i++){
				st=new StringTokenizer(in.readLine());
				int X=parseInt(st.nextToken()),Y=parseInt(st.nextToken()),S=parseInt(st.nextToken()),T=parseInt(st.nextToken());
				if(X==0)
					if(Y!=0)m[c++]=new int[]{Y,Y};
					else {}
				else if(Y==0)m[c++]=new int[]{X,X};
				else m[c++]=new int[]{X,Y};
				if(S==0)
					if(T!=0)m[c++]=new int[]{-T,-T};
					else {}
				else if(T==0)m[c++]=new int[]{-S,-S};
				else m[c++]=new int[]{-S,-T};				
			}
			if(ws&&sat2(Arrays.copyOfRange(m,0,c),P))System.out.println("yes");
			else System.out.println("no");
		}
	}
}
