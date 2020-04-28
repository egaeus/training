package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10405
 * @problemName Longest Common Subsequence
 * @judge http://uva.onlinejudge.org/
 * @category dynamic programming
 * @level easy
 * @date 16/04/2010
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa10405 {
	static char[] st1, st2;
	static int[][] mem;
	static int function(int pos1, int pos2){
		if(pos1 == st1.length || pos2 == st2.length)return 0;
		if(mem[pos1][pos2]>0)return mem[pos1][pos2];
		for (int i = pos2; i < st2.length; i++) 
			if(st1[pos1]==st2[i])
				return mem[pos1][pos2] = Math.max(function(pos1 + 1, i + 1) + 1, function(pos1 + 1, pos2));
		return mem[pos1][pos2] = function(pos1 + 1, pos2);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln; (ln = in.readLine()) != null; ) {
			st1 = ln.trim().toCharArray();
			st2 = in.readLine().trim().toCharArray();
			mem = new int[st1.length][st2.length];
			System.out.println(function(0, 0));
		}
	}
}