package practice.uva;

/**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 291
 * @problemName The House Of Santa Claus
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 20/12/2011
 **/
public class UVa291 {
	static StringBuilder sb;
	static int[][] mat=new int[][]{{1,2},{1,3},{1,5},{2,3},{2,5},{3,4},{3,5},{4,5}};
	static void f(int n, String s){
		if(n==((1<<8)-1)){sb.append(s+"\n");return;}
		for(int i=0;i<8;i++){
			if(((1<<i)&n)==0){
				if(mat[i][0]==s.charAt(s.length()-1)-'0')
					f(((1<<i)|n),s+mat[i][1]);
				if(mat[i][1]==s.charAt(s.length()-1)-'0')
					f(((1<<i)|n),s+mat[i][0]);
			}
		}
	}
	public static void main(String args[]) throws Throwable {
		sb=new StringBuilder();
		f(1,"12");
		f(1<<1,"13");
		f(1<<2,"15");
		System.out.print(new String(sb));
	}
}
