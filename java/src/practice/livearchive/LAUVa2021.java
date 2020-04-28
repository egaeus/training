package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2021
 * @problemName Rectangular Rectitude
 * @judge http://livearchive.onlinejudge.org/
 * @category geom
 * @level easy
 * @date 27/07/2011
 **/
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2021 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));int caso=1;
		StringBuilder sb=new StringBuilder();
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),C=parseInt(st.nextToken());
			if(N==0)break;
			char[][] arr=new char[201][201];
			for(int i=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				int c=parseInt(st.nextToken()),x1=parseInt(st.nextToken()),y1=parseInt(st.nextToken()),x2=parseInt(st.nextToken()),y2=parseInt(st.nextToken());
				for(int j=min(x1,x2);j<max(x1,x2);j++)
					for(int h=min(y1,y2);h<max(y1,y2);h++)
						arr[j+100][h+100]=(char)(c+1);
			}
			int res=0;
			for(int i=0;i<arr.length;i++)
				for(int j=0;j<arr.length;j++)
					if(arr[i][j]==(char)(C+1))res++;
			sb.append("The area of color "+C+" in dataset "+(caso++)+" is: "+res+"\n");
		}
		System.out.print(new String(sb));
	}
}
