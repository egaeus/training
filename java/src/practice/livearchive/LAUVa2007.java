package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2007
 * @problemName Tag checked
 * @judge http://livearchive.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 26/07/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class LAUVa2007 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;!(ln=in.readLine().trim()).equals("#");){
			String str="";
			for(;!ln.contains("#");){
				str+=ln;
				ln=in.readLine();
			}
			str+=ln;char[] arr=str.toCharArray();
			boolean ws=true;
			LinkedList<Character> pila=new LinkedList<Character>();
			for(int i=0;ws&&i<arr.length;i++){
				if(i+2<arr.length&&arr[i]=='<'&&arr[i+1]>='A'&&arr[i+1]<='Z'&&arr[i+2]=='>')
					pila.add(arr[i+1]);
				if(i+3<arr.length&&arr[i]=='<'&&arr[i+1]=='/'&&arr[i+2]>='A'&&arr[i+2]<='Z'&&arr[i+3]=='>'){
					if(pila.isEmpty()){System.out.println("Expected # found </"+arr[i+2]+">");ws=false;}
					else{
						char act=pila.pollLast();
						if(act!=arr[i+2]){System.out.println("Expected </"+act+"> found </"+arr[i+2]+">");ws=false;}
					}
				}
			}
			if(ws)System.out.println(pila.isEmpty()?"Correctly tagged paragraph":"Expected </"+pila.getLast()+"> found #");
		}
	}
}
