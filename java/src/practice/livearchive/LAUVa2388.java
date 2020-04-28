package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2388
 * @problemName Genetic Combinations
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 10/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class LAUVa2388 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N,c=1;(N=parseInt(in.readLine().trim()))!=0;c++){
			arr=new char[2][N+1][];
			StringTokenizer st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)arr[0][i]=st.nextToken().toCharArray();
			{
				boolean ws[]=new boolean[20];
				for(int i=0;i<N;i++)for(int j=0;j<4;j++)ws[arr[0][i][j]-'A']=true;
				String t="";
				for(int i=0;i<20;i++)if(!ws[i])t+=(char)(i+'A');
				arr[0][N]=t.toCharArray();
			}
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++)arr[1][i]=st.nextToken().toCharArray();
			{
				boolean ws[]=new boolean[20];
				for(int i=0;i<N;i++)for(int j=0;j<4;j++)ws[arr[1][i][j]-'a']=true;
				String t="";
				for(int i=0;i<20;i++)if(!ws[i])t+=(char)(i+'a');
				arr[1][N]=t.toCharArray();
			}
			sb.append("Test #"+c+":");
			set=new TreeMap<char[],char[]>(new Comparator<char[]>() {
				public int compare(char[] o1, char[] o2) {
					for(int i=0;i<o1.length;i++)if(o1[i]!=o2[i])return o1[i]-o2[i];
					return 0;
				}
			});
			char sol[]=sol(new char[20]);
			for(int i=0;i<20;i++)
				sb.append((i%5==0?"\n":" ")+(char)(i+'A')+"-"+(sol[i]!='\0'?(char)(sol[i]):"?"));
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	static char[][][] arr;
	static TreeMap<char[],char[]> set;
	static char[] sol(char[] s){
		TreeMap<Character,TreeSet<Character>> mapa=new TreeMap<Character, TreeSet<Character>>();
		for(int i=0;i<arr[0].length;i++)
			for(int j=0;j<arr[0][i].length;j++)
				for(int h=0;h<arr[1][i].length;h++)
					if(s[arr[0][i][j]-'A']=='\0'&&esPosible(arr[0][i][j], arr[1][i][h], s)){
						TreeSet<Character> set=mapa.get(arr[0][i][j]);
						if(set==null)set=new TreeSet<Character>();
						set.add(arr[1][i][h]);
						mapa.put(arr[0][i][j], set);
					}
		boolean ws=false;
		for(Entry<Character,TreeSet<Character>> entry:mapa.entrySet()){
			if(entry.getValue().size()==1){
				s[entry.getKey()-'A']=entry.getValue().first();
				ws=true;
			}
		}
		if(ws){
			char[] s1=sol(s.clone());
			return s1.clone();
		}else return s.clone();
	}
	static boolean esPosible(char may, char min, char[] s){
		int a=may-'A',b=min-'a';
		if(s[a]==min)return true;
		if(s[a]!='\0')return false;
		for(int i=0;i<s.length;i++)if(s[i]==min)return false;
		for(int i=(int)Math.floor(a/5.0)*5;i<((int)Math.floor(a/5.0)+1)*5;i++)
			if(s[i]!='\0'&&(b<(int)Math.floor((s[i]-'a')/5.0)*5||b>=((int)Math.floor((s[i]-'a')/5.0)+1)*5))return false;
		boolean res=true;
		for(int i=0;i<arr[0].length&&res;i++){
			boolean ws=false,ws1=false;
			for(int j=0;j<arr[0][i].length;j++)if(arr[0][i][j]==may)ws=true;
			for(int j=0;j<arr[1][i].length;j++)if(arr[1][i][j]==min)ws1=true;
			res=!(ws^ws1);
		}
		return res;
	}
}
