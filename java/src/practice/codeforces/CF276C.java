package practice.codeforces; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 276
 * @problemName Little Girl and Maximum Sum
 * @judge http://www.codeforces.com
 * @category adhoc
 * @level easy
 * @date Sep 26, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF276C {
	static void mergeSort(long[] arr, long[] arrTmp, int pi, int pf) { 
		 if (pf<=pi) return; 
		 int m=(pi+pf)/2+1,i,j,k; mergeSort(arr,arrTmp,pi,m-1); mergeSort(arr,arrTmp,m,pf); 
		 for (i=pi,j=m,k=pi; i<=m-1&&j<=pf; k++) arrTmp[k]=arr[i]<=arr[j]?arr[i++]:arr[j++]; 
		 for (; i<=m-1; k++,i++) arrTmp[k]=arr[i]; 
		 for (k=pi; k<j; k++) arr[k]=arrTmp[k]; 
		} 
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
		st=new StringTokenizer(in.readLine());
		long[] arr=new long[N];
		long[] cont=new long[N];
		long[] arrTmp=new long[N];
		for(int i=0;i<N;i++)
			arr[i]=parseInt(st.nextToken());
		mergeSort(arr, arrTmp, 0, N-1);
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(in.readLine());
			int desde=parseInt(st.nextToken())-1;
			int hasta=parseInt(st.nextToken())-1;
			cont[desde]++;
			if(hasta<N-1)
				cont[hasta+1]--;
		}
		long res=0;
		for(int i=1;i<N;i++)
			cont[i]+=cont[i-1];
		mergeSort(cont, arrTmp, 0, N-1);
		for(int i=0;i<N;i++)
			res+=arr[i]*cont[i];
		System.out.println(res);
	}
}
