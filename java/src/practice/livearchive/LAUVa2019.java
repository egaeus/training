package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2019
 * @problemName The Party's in Dolores's Driveway
 * @judge http://livearchive.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 27/07/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LAUVa2019 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int c=1;
		for(String ln;!(ln=in.readLine().trim()).equals("STOP");c++){
			if(c>1)System.out.println();
			char[] st=ln.toCharArray();
			System.out.println("Dataset #"+c+":  The initial order is "+ln+".");
			for(int i=0,N=parseInt(in.readLine().trim());i<N;i++){
				char[] nuevo=new char[st.length-1];int pos=0;
				char ch=in.readLine().trim().charAt(0);
				for(;st[pos]!=ch;pos++);
				if(pos<st.length/2+st.length%2){
					for(int j=0;j<pos;j++)nuevo[pos-j-1]=st[j];
					for(int j=pos+1;j<st.length;j++)nuevo[j-1]=st[j];
				}
				else{
					for(int j=0;j<pos;j++)nuevo[j]=st[j];
					for(int j=pos+1;j<st.length;j++)nuevo[j-1]=st[st.length-1-(j-pos-1)];
				}
				System.out.println("After "+ch+" leaves, the order is "+new String(nuevo)+".");
				st=nuevo;
			}
		}
	}
}
