package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 489
 * @problemName Hangman Judge
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 6/03/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVa489{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int C;(C=parseInt(in.readLine().trim()))!=-1;){
			char[] word=in.readLine().trim().toCharArray(),guesses=in.readLine().trim().toCharArray();
			int l=0,w=0;
			for(int i=0;i<guesses.length&&l<7&&w<word.length;i++){
				boolean ws=false;
				for(int j=0;j<word.length;j++)
					if(word[j]==guesses[i]){word[j]='\0';ws=true;w++;}
				if(!ws)l++;
			}
			sb.append("Round "+C+"\n");
			if(w==word.length)sb.append("You win.\n");
			else if(l==7)sb.append("You lose.\n");
			else sb.append("You chickened out.\n");
		}
		System.out.print(new String(sb));
	}
}
