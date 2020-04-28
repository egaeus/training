package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId NY10C
 * @problemName Just The Simple Fax
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level medium
 * @date 23/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJNY10C {
	static String function(int[] arr, int pos){
		if(pos==arr.length)return "";
		boolean ws = false;
		int i;
		for(i = pos; i < arr.length - 1 && i-pos+1<130; i++)
			if(arr[i]==arr[i+1])ws=true;
			else break;
		if(ws)
			if(i-pos+1>2)
				return ((1<<7|(i-pos-2))<16?"0":"") + Integer.toString(1<<7|(i-pos-2), 16).toUpperCase() + (arr[i]<16?"0":"") + Integer.toString(arr[i], 16).toUpperCase() + function(arr, i+1);
		String r = "";
		for(i = pos; i < arr.length && i-pos+1<=128; i++){
			if(i<arr.length-2&&arr[i]==arr[i+1]&&arr[i]==arr[i+2])break;
			r+=(arr[i]<16?"0":"")+Integer.toString(arr[i], 16).toUpperCase();
		}
		return (i-pos-1<16?"0":"") + Integer.toString(i-pos-1, 16).toUpperCase() + r + function(arr, i);
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C; ){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int t = parseInt(st.nextToken()), N = parseInt(st.nextToken());
			int[] arr = new int[N];
			for(int i = 0; i < N;){
				char[] ln = in.readLine().trim().toCharArray();
				for(int j = 0; i < N && j < ln.length; j+=2)
					arr[i++]=parseInt(ln[j]+""+ln[j+1], 16);
			}
			String res = function(arr, 0);
			System.out.println(t + " " + res.length()/2);
			for(;res.length()>=80; res=res.substring(80))
				System.out.println(res.substring(0, 80));
			if(res.length()>0)System.out.println(res);
		}
	}
}
