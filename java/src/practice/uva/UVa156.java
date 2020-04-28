package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 156
 * @problemName Ananagrams
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 22/12/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa156 {
	static class Objeto implements Comparable<Objeto>{
		private char s[];
		public String str;
		public Objeto(String str){
			this.str=str;
			s=str.toLowerCase().toCharArray();
			Arrays.sort(s);
		}
		public int compareTo(Objeto o) {
			if(s.length!=o.s.length)return s.length-o.s.length;
			for(int i=0;i<s.length;i++)if(s[i]!=o.s[i])return s[i]-o.s[i];
			return 0;
		}
		public String toString(){
			return str+" "+new String(s); 
		}
	}
	static class Escaner{
		private BufferedReader in;
		private StringTokenizer st;
		public Escaner(){
			in = new BufferedReader(new InputStreamReader(System.in));
			st=new StringTokenizer("");
		}
		public String next() throws Throwable{
			if(st.hasMoreTokens())return st.nextToken();
			st=new StringTokenizer(in.readLine());
			return next();
		}
	}
	public static void main(String args[]) throws Throwable {
		Escaner sc=new Escaner();
		Objeto[] arr=new Objeto[1000000];int c=0,C=0;
		for (String str;!(str=sc.next()).equals("#");)arr[c++]=new Objeto(str);
		Arrays.sort(arr,0,c);
		String[] res=new String[c];
		for(int i=0;i<c;i++)
			if((i==0||arr[i].compareTo(arr[i-1])!=0)&&(i==c-1||arr[i].compareTo(arr[i+1])!=0))
				res[C++]=arr[i].str;
		Arrays.sort(res,0,C);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<C;i++)sb.append(res[i]+"\n");
		System.out.print(new String(sb));
	}
}
