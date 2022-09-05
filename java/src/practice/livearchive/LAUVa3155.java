package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict W.A.
 * @problemId 3155
 * @problemName Two-Stacks Solitaire
 * @judge http://livearchive.onlinejudge.org/
 * @category ???
 * @level ???
 * @date 01/09/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class LAUVa3155 {
	static int[] arr,ord;
	static boolean f(int p,int p1,int p2, int s){
		System.out.println(p+" "+p1+" "+p2+" "+s);
		if(p==arr.length)return true;
		if(arr[p]>=p1&&f(p+1,arr[p],p2,s))return true;
		if(arr[p]>=p2&&f(p+1,p1,arr[p],s))return true;
		if(arr[p]==ord[s]&&f(p+1,p1,p2,s-1))return true;
		return false;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in=new BufferedReader(new FileReader("C:\\Users\\Administrador\\Desktop\\2stacks.in.txt"));
		//System.setOut(new PrintStream("C:\\Users\\Administrador\\Desktop\\out.txt"));
		StringBuilder sb=new StringBuilder();
		for(int N,c=1;(N=parseInt(in.readLine().trim()))!=0;c++){
			sb.append("#"+c+"\n");
			arr=new int[N];ord=new int[N];
			StringTokenizer st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)ord[i]=arr[i]=parseInt(st.nextToken());
			Arrays.sort(ord);
			System.out.println(Arrays.toString(arr)+Arrays.toString(ord));
			System.out.println(f(0,0,0,N-1));
		}
		System.out.print(new String(sb));
	}
}
