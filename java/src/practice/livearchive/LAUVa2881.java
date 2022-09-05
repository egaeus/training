package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2881
 * @problemName Dice
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2881 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int P=parseInt(st.nextToken()),S=parseInt(st.nextToken());
			if(P==S&&P==0)break;
			st=new StringTokenizer(in.readLine());
			int T1=parseInt(st.nextToken()),T2=parseInt(st.nextToken()),T3=parseInt(st.nextToken());
			int N=parseInt(in.readLine().trim());
			int ganador=-1;boolean[] perdio=new boolean[P];
			int[] pos=new int[P];
			for(int i=0,j=0;i<N;i++){
				st=new StringTokenizer(in.readLine());
				while(perdio[j]){perdio[j]=false;j=(j+1)%P;}
				pos[j]+=parseInt(st.nextToken())+parseInt(st.nextToken());
				if(pos[j]==T1||pos[j]==T2||pos[j]==T3)perdio[j]=true;
				if(pos[j]>S&&ganador==-1)ganador=j;
				j=(j+1)%P;
			}
			System.out.println(ganador+1);
		}
	}
}
