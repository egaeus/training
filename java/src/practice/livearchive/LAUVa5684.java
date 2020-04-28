package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5684
 * @problemName Roll-call in Woop Woop High
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jul 24, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class LAUVa5684 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int K=parseInt(in.readLine().trim()),k=0;k++<K;) {
			sb.append("Roll-call: ").append(k).append("\n");
			int N=parseInt(in.readLine().trim());
			int present=0,house=0,work=0,absent=0;
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(in.readLine());
				st.nextToken();
				ArrayList<Character> ans=new ArrayList<Character>();
				for(;st.hasMoreTokens();)ans.add(st.nextToken().charAt(0));
				if(ans.size()==0)absent++;
				else if(ans.get(0)=='y')present++;
				else if(ans.contains('y'))house++;
				else work++;
			}
			sb.append("Present: ").append(present).append(" out of ").append(N).append("\n");
			sb.append("Needs to study at home: ").append(house).append(" out of ").append(N).append("\n");
			sb.append("Needs remedial work after school: ").append(work).append(" out of ").append(N).append("\n");
			sb.append("Absent: ").append(absent).append(" out of ").append(N).append("\n");
		}
		System.out.print(new String(sb));
	}
}
