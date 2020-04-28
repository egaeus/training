package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3468
 * @problemName Tornado!
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 13/09/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class LAUVa3468 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(int N;(N=parseInt(in.readLine().trim()))!=0;){
			StringTokenizer st=new StringTokenizer(in.readLine());
			ArrayList<Integer> pos=new ArrayList<Integer>();
			for(int i=0;i<N;i++)if(parseInt(st.nextToken())==1)pos.add(i);
			if(pos.size()==0)System.out.println((int)Math.ceil(N/2.0));
			else{
				int res=(N-pos.get(pos.size()-1)-1+pos.get(0))/2;
				for(int i=0;i<pos.size()-1;i++)res+=(pos.get(i+1)-pos.get(i)-1)/2;
				System.out.println(res);
			}
		}
	}
}