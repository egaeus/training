package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Acceped
 * @problemId NY10A
 * @problemName Penney Game
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 22/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SPOJNY10A {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[][] foo = new char[][]{"TTT".toCharArray(), "TTH".toCharArray(), "THT".toCharArray(), 
				"THH".toCharArray(), "HTT".toCharArray(), "HTH".toCharArray(), 
				"HHT".toCharArray(), "HHH".toCharArray()};
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C;){
			int r = parseInt(in.readLine().trim());
			char[] ln = in.readLine().trim().toCharArray();
			int[] res = new int[foo.length];
			for(int i = 0; i < ln.length-2; i++)
				for(int j = 0; j < foo.length; j++)
					if(ln[i]==foo[j][0]&&ln[i+1]==foo[j][1]&&ln[i+2]==foo[j][2]){res[j]++;break;}
			sb.append(r);
			for(int j = 0; j < foo.length; j++)
				sb.append(" "+res[j]);
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
/* C�digo en C++ (No pasa en java por tiempo, de hecho porque le pusieron un tiempo muy ficti al problema)
#include <iostream.h>
#include <string.h>
int main(int argc, char *argv[]){
	char foo[8][3] = {{'T','T','T'}, {'T','T','H'}, {'T', 'H', 'T'},
			{'T','H','H'}, {'H','T','T'}, {'H', 'T', 'H'},
			{'H','H','T'}, {'H','H','H'}};
	char ln[50];
	int i, j, n, r, res[8];
	cin>>r;
	for(;r;r--){
		for(i=0;i<8;i++)res[i]=0;
		cin>>n;
		cin>>ln;
		for(i = 0; i < strlen(ln) - 2; i++)
			for(j = 0; j < 8; j++)
				if(ln[i]==foo[j][0]&&ln[i+1]==foo[j][1]&&ln[i+2]==foo[j][2]){res[j]++;break;}
		cout<<n;
		for(j = 0; j < 8; j++)
			cout<<" "<<res[j];
		cout<<endl;
	}
	return 0;
}
*/