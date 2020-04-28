package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10152
 * @problemName ShellSort
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Aug 26, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10152 {
	static void move(int[] arr,int p) {
		int pos=-1;
		for(int i=0;i<arr.length&&pos==-1;i++)
			if(arr[i]==p)pos=i;
		for(int i=pos-1;i>=0;i--)
			arr[i+1]=arr[i];
		arr[0]=p;
	}
	static boolean isSolution(int[] arr){
		for(int i=0;i<arr.length;i++)
			if(arr[i]!=i)
				return false;
		return true;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int T=parseInt(in.readLine().trim()),t=0;t++<T;) {
			int N=parseInt(in.readLine().trim());
			String[] arr=new String[N];
			String[] fin=new String[N];
			for(int i=0;i<N;i++)arr[i]=in.readLine();
			for(int i=0;i<N;i++)fin[i]=in.readLine();
			int[] pos=new int[N];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++) 
					if(arr[j].equals(fin[i]))
						pos[j]=i;
			int[] copy=new int[N];
			int sol=-1;
			for(int i=0;i<=N&&sol==-1;i++) {
				for(int j=0;j<N;j++)copy[j]=pos[j];
				for(int j=i-1;j>=0;j--) 
					move(copy,j);
				if(isSolution(copy))
					sol=i;
			}
			for(int i=sol-1;i>=0;i--)
				sb.append(fin[i]).append("\n");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
