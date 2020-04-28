package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 123
 * @problemName Searching Quickly
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 11/01/2012
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
public class UVa123 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> exc=new TreeSet<String>();
		exc.add("");
		for(String ln;!(ln=in.readLine()).equals("::");)exc.add(ln.toLowerCase());
		TreeMap<String,ArrayList<String>> mapa=new TreeMap<String, ArrayList<String>>();
		for(String ln;(ln=in.readLine())!=null;){
			char[] ch=ln.toCharArray();String esp="";
			for(int i=ch.length-1;i>=0;i--)if(ch[i]==' ')esp+=" ";else break;
			String[] arr=ln.toLowerCase().split(" ");			
			for(int i=0;i<arr.length;i++)
				if(!exc.contains(arr[i])){
					String agr="";
					for(int j=0;j<arr.length;j++){
						if(i==j)agr+=arr[j].toUpperCase();
						else agr+=arr[j];
						if(j<arr.length-1)agr+=" ";
					}
					ArrayList<String> r=mapa.get(arr[i]);
					if(r==null){
						r=new ArrayList<String>();
						mapa.put(arr[i],r);
					}
					r.add(agr+esp);
				}				
		}
		StringBuilder sb=new StringBuilder();
		for(Entry<String,ArrayList<String>> entry:mapa.entrySet()){
			for(String s:entry.getValue())
				sb.append(s+"\n");
		}
		System.out.print(new String(sb));
	}
}
