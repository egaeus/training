package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 401
 * @problemName Palindromes
 * @judge http://uva.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 03/01/2010
 **/
import java.util.Scanner;
import java.util.TreeMap;
public class UVa401 {
	static boolean esPalindroma(char[] str){
		return new String(new StringBuffer(new String(str)).reverse()).equals(new String(str));
	}
	static boolean esReflejada(char[] str){
		for(int i = 0; i < str.length/2 + (str.length%2==0?0:1); i++)
			if(!reflejos.containsKey(str[i]) || reflejos.get(str[i])!=str[str.length - 1 - i])return false;
		return true;
	}
	static TreeMap<Character, Character> reflejos = new TreeMap<Character, Character>(); 
	public static void main(String[] args) throws Throwable{
		Scanner sc = new Scanner(System.in);
		reflejos.put('A', 'A');reflejos.put('E', '3');reflejos.put('H', 'H');reflejos.put('I', 'I');
		reflejos.put('J', 'L');reflejos.put('L', 'J');reflejos.put('M', 'M');reflejos.put('O', 'O');
		reflejos.put('S', '2');reflejos.put('T', 'T');reflejos.put('U', 'U');reflejos.put('V', 'V');
		reflejos.put('W', 'W');reflejos.put('X', 'X');reflejos.put('Y', 'Y');reflejos.put('Z', '5');
		reflejos.put('1', '1');reflejos.put('2', 'S');reflejos.put('3', 'E');reflejos.put('5', 'Z');
		reflejos.put('8', '8');
		for(String ln; sc.hasNext();){
			ln = sc.next();
			boolean pal = esPalindroma(ln.trim().toCharArray()), esp = esReflejada(ln.trim().toCharArray());
			if(pal&&esp)System.out.println(ln.trim() + " -- is a mirrored palindrome.");
			else if(pal)System.out.println(ln.trim() + " -- is a regular palindrome.");
			else if(esp)System.out.println(ln.trim() + " -- is a mirrored string.");
			else System.out.println(ln.trim() + " -- is not a palindrome.");
			System.out.println();
		}
	}
}