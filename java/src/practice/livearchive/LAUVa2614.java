package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2614
 * @problemName Duty Free Shop
 * @judge http://livearchive.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 11/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class LAUVa2614 {
	static int M,L,sum[],arr[],mem[][];
	static boolean function(int i, int j){
		if(j>M)return false;
		if(i>0&&sum[i-1]-j>L)return false;
		if(i==arr.length)return true;
		if(mem[i][j]!=0)return mem[i][j]!=-1; 
		if(function(i+1,j+arr[i])){
			mem[i][j]=1;
			return true;
		}
		if(function(i+1,j)){
			mem[i][j]=2;
			return true;
		}
		mem[i][j]=-1;
		return false;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			M=parseInt(st.nextToken());L=parseInt(st.nextToken());
			if(M==0&&L==0)break;
			int N=parseInt(in.readLine().trim());
			st=new StringTokenizer(in.readLine());
			arr=new int[N];sum=new int[N];
			for(int i=0,s=0;i<N;i++)sum[i]=(s+=(arr[i]=parseInt(st.nextToken())));
			mem=new int[N][M+1];
			if(function(0, 0)){
				ArrayList<Integer> res=new ArrayList<Integer>();
				for(int i=0,j=0;i<N;j+=mem[i][j]==1?arr[i]:0,i++)if(mem[i][j]==1)res.add(i+1);
				sb.append(res.size()+" ");
				for(int n:res)sb.append(n+" ");
				sb.append("\n");
			}
			else sb.append("Impossible to distribute\n");
		}
		System.out.print(new String(sb));
	}
}
