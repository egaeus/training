package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 598
 * @problemName Bundling Newspapers
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 17/07/2012
 **/
import static java.lang.Integer.bitCount;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
public class UVa598{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int T=parseInt(in.readLine().trim()),t=0;t<T;t++){
			if(t==0)in.readLine();
			else sb.append("\n");
			int desde=0,hasta=0;
			String[] a=in.readLine().trim().split(" +");
			if(a.length==2){desde=parseInt(a[0]);hasta=parseInt(a[1]);}
			else if(a[0].charAt(0)=='*'){desde=1;hasta=12;}
			else desde=hasta=parseInt(a[0]);
			ArrayList<String> strs=new ArrayList<String>();
			for(String ln;(ln=in.readLine())!=null&&!ln.equals("");)strs.add(ln);
			TreeMap<String,String> arr[]=new TreeMap[13];
			for(int i=0;i<arr.length;i++)if(i>=desde&&i<=hasta&&i<=strs.size())arr[i]=new TreeMap<String,String>();
			for(int i=0;i<1<<strs.size();i++)
				if(bitCount(i)>=desde&&bitCount(i)<=hasta&&bitCount(i)<=strs.size()){
					String s="";
					for(int j=0;j<strs.size();j++)
						if((i&(1<<j))>0)s+=strs.get(j)+", ";
					s=s.substring(0,s.length()-2);
					arr[bitCount(i)].put(new String(new StringBuffer(toBinaryString(i)).reverse()),s);
				}
			for(int i=0;i<arr.length;i++)
				if(arr[i]!=null){
					sb.append("Size "+i+"\n");
					for(Entry<String,String> s:arr[i].descendingMap().entrySet())sb.append(s.getValue()+"\n");
					sb.append("\n");
				}
		}
		System.out.print(new String(sb));
	}
}
