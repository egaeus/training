package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 531
 * @problemName Compromise
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date Aug 26, 2013
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVa531 {
	static ArrayList<Integer> first,second;
	static int[][][] mem;
	static int f(int p,int p1) {
		if(p==first.size()||p1==second.size())return 0;
		if(mem[p][p1]!=null)return mem[p][p1][0];
		int[] s=new int[]{f(p+1,p1),p+1,p1};
		int max=s[0];
		if(max<f(p,p1+1))
			s=new int[]{max=f(p,p1+1),p,p1+1};
		if(first.get(p)==second.get(p1)&&max<f(p+1,p1+1)+1)
			s=new int[]{max=f(p+1,p1+1)+1,p+1,p1+1};
		mem[p][p1]=s;
		return max;
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			TreeMap<String,Integer> map=new TreeMap<String,Integer>();
			ArrayList<String> words=new ArrayList<String>();
			first=new ArrayList<Integer>();
			second=new ArrayList<Integer>();
			for(;!ln.trim().equals("#");) {
				StringTokenizer st=new StringTokenizer(ln);
				for(String str;st.hasMoreTokens();) {
					str=st.nextToken();
					int p=map.containsKey(str)?map.get(str):map.size();
					if(p==map.size())words.add(str);
					map.put(str, p);
					first.add(p);
				}
				ln=in.readLine();
			}
			ln=in.readLine();
			for(;!ln.trim().equals("#");) {
				StringTokenizer st=new StringTokenizer(ln);
				for(String str;st.hasMoreTokens();) {
					str=st.nextToken();
					int p=map.containsKey(str)?map.get(str):map.size();
					if(p==map.size())words.add(str);
					map.put(str, p);
					second.add(p);
				}
				ln=in.readLine();
			}
			mem=new int[first.size()][second.size()][];
			f(0,0);
			for(int i=0,j=0,h=0;i<first.size()&&j<second.size();) {
				if(mem[i][j][1]!=i&&mem[i][j][2]!=j) {
					sb.append(h>0?" ":"").append(words.get(first.get(i)));
					h++;
				}
				int tmp=mem[i][j][1];
				j=mem[i][j][2];
				i=tmp;
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
