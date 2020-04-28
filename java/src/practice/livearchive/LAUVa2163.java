package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2163
 * @problemName Led Codes
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 04/08/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2163 {
	public static void main(String[] args) throws Throwable{
		int[][] letras=new int[][]{{1,2,3,4,5,7},{1,2,3,4,5,6,7},{4,5,6},{1,5,8,0},{1,2,4,5,6},{1,2,4,9},{1,2,5,6,9},
				{1,3,4,5,7},{3,7},{3,5,6,7},{1,3,4,5,9},{1,5,6},{1,2,3,5,7},{3,5,7,9},{1,2,3,5,6,7},{1,4,5,8},{1,2,3,4,7},
				{1,2,3,4,5,9},{1,2,4,6,7},{2,7,8},{1,3,5,6,7},{1,3,7,9},{1,3,5,7,9,0},{9,0},{1,3,4,7},{2,3,4,5,6}};
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int c=0,C=parseInt(in.readLine().trim());c++<C;){
			sb.append("Phrase "+c+": ");
			char[] str=in.readLine().toCharArray();
			for(int i=0;i<str.length;i++){
				if(!Character.isDigit(str[i]))sb.append(str[i]);
				else{
					int j=i+1,h=0;
					for(;j<str.length&&Character.isDigit(str[j])&&str[j]!='0'&&str[j-1]!='0'&&str[j-1]<str[j];j++);
					if(j>=str.length||str[j-1]=='0'||!Character.isDigit(str[j])||(str[j]!='0'&&str[j-1]>str[j]))j--;
					if(j>i){
						boolean ws1=false;
						for(boolean ws=false;!ws;){
							for(h=0;h<letras.length;h++)
								if(letras[h].length==j-i+1){
									int k=0;
									for(;k<j-i+1;k++)if(letras[h][k]!=str[i+k]-'0')break;
									if(k==j-i+1)break;
								}
							if(h==letras.length){j--;ws1=true;}else ws=true;
						}
						sb.append((char)(h+'A')+(ws1?" ":""));
						if(ws1)j++;
					}
					else sb.append(" ");
					i=j;
				}
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}