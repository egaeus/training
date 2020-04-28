package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId practice.spoj.SPOJNY10B
 * @problemName Nim-B Sum
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 23/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class SPOJNY10B {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C; ){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int t = parseInt(st.nextToken()), B = parseInt(st.nextToken()),
			X = parseInt(st.nextToken()), Y = parseInt(st.nextToken());
			ArrayList<Integer> Xs = new ArrayList<Integer>();
			for(; X>0; X/=B)
				Xs.add(X%B);
			ArrayList<Integer> Ys = new ArrayList<Integer>();
			for(; Y>0; Y/=B)
				Ys.add(Y%B);
			ArrayList<Integer> res = new ArrayList<Integer>();
			for(int i = 0; i < Xs.size() || i < Ys.size(); i++)
				res.add(((i<Xs.size()?Xs.get(i):0)+(i<Ys.size()?Ys.get(i):0))%B);
			long sol = 0, b = 1;
			for(int i = 0; i < res.size(); i++, b*=B)
				sol+=b*res.get(i);
			System.out.println(t + " " + sol);
		}
	}
}
