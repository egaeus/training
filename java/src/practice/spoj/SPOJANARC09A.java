package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId ANARC09A
 * @problemName Seinfeld
 * @judge http://www.spoj.pl
 * @category adhoc
 * @level easy
 * @date 22/03/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SPOJANARC09A {
	static int function(char[] arr, int pos1, int pos2){
		if(pos1>pos2)return 0;
		int cont = 0;
		if(arr[pos1]=='}'){
			arr[pos1]='{';
			cont++;
		}
		if(arr[pos2]=='{'){
			arr[pos2]='}';
			cont++;
		}
		for(int i = pos1, cantAbiertos = 0; i <= pos2; i++){
			if(arr[i]=='{')cantAbiertos++;
			if(arr[i]=='}')cantAbiertos--;
			if(cantAbiertos==0)return function(arr, i+1, pos2) + cont;
		}
		for(int i = pos2, cantAbiertos = 0; i >= pos1; i--){
			if(arr[i]=='{')cantAbiertos++;
			if(arr[i]=='}')cantAbiertos--;
			if(cantAbiertos==0)return function(arr, pos1, i-1) + cont;
		}
		return 0;
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		for(String ln; !(ln = in.readLine().trim()).contains("-"); caso++){
			char[] arr = ln.toCharArray();
			System.out.println(caso + ". " + function(arr, 0, arr.length-1));
		}
	}
}
