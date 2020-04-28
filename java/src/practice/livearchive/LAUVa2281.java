package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2281
 * @problemName Color me less
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 18/11/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2281 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int[][] arr=new int[16][];
		for(int i=0;i<16;i++){
			StringTokenizer st=new StringTokenizer(in.readLine());
			arr[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
		}
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int R=parseInt(st.nextToken()),G=parseInt(st.nextToken()),B=parseInt(st.nextToken());
			if(R==-1&&G==-1&&B==-1)break;
			double min=Double.POSITIVE_INFINITY,tmp;int p=-1;
			for(int i=0;i<16;i++)
				if((tmp=(arr[i][0]-R)*(arr[i][0]-R)+(arr[i][1]-G)*(arr[i][1]-G)+(arr[i][2]-B)*(arr[i][2]-B))<min){min=tmp;p=i;}
			System.out.println("("+R+","+G+","+B+") maps to ("+arr[p][0]+","+arr[p][1]+","+arr[p][2]+")");
		}
	}
}
