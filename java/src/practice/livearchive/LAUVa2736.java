package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2736
 * @problemName Mobile Phones
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 30/07/2012
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class LAUVa2736{
	public static void main(String args[]) throws Throwable{
		int[] arr=new int[]{2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int c=1;;c++){
			TreeMap<Integer,ArrayList<String>> mapa=new TreeMap<Integer,ArrayList<String>>();
			for(String ln;!(ln=in.readLine().trim()).equals("#");){
				String r="";
				for(char a:ln.toCharArray())r+=arr[a-'a'];
				ArrayList<String> a=mapa.get(r.hashCode());
				if(a==null)a=new ArrayList<String>();
				a.add(ln);mapa.put(r.hashCode(),a);
			}
			if(mapa.size()==0)break;
			sb.append("SET "+c+"\n");
			for(String ln,w;!(ln=in.readLine().trim()).equals("#");){
				StringTokenizer st=new StringTokenizer(ln,"0");
				for(boolean primero=true;st.hasMoreTokens();primero=false){
					sb.append(!primero?" ":"");
					ArrayList<String> a=mapa.get((w=st.nextToken()).hashCode());
					if(a==null)for(int i=0;i<w.length();i++)sb.append("*");
					else if(a.size()==1)sb.append(a.get(0));
					else {
						sb.append("(");
						for(int i=0;i<a.size();i++){
							sb.append(i>0?"|":"");
							sb.append(a.get(i));
						}
						sb.append(")");
					}
				}
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
}
