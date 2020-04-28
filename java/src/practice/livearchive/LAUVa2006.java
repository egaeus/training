package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2006
 * @problemName Most wanted word
 * @judge http://livearchive.onlinejudge.org/
 * @category characters
 * @level easy
 * @date 26/07/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class LAUVa2006 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		Comparator<char[]> comp=new Comparator<char[]>() {			
			public int compare(char[] o1, char[] o2) {
				if(o1.length==o2.length)
					for(int i=0;i<o1.length;i++)
						if(o1[i]!=o2[i])return o1[i]-o2[i];
				return o1.length-o2.length;
			}
		};
		TreeMap<char[],Integer> mapa=new TreeMap<char[], Integer>(comp);
		TreeMap<char[],Integer> posiciones=new TreeMap<char[], Integer>(comp);
		StringBuilder sb=new StringBuilder();
		int c=0;
		for(String ln; (ln=in.readLine())!=null;){
			if(ln.trim().equals("#")){
				int max=0;char[] str=new char[0];
				if(mapa.size() == 0)break;
				for(Entry<char[],Integer> m:mapa.entrySet()){
					if(m.getValue()>max){
						str=m.getKey();
						max=m.getValue();
					}
					else if(m.getValue()==max){
						if(posiciones.get(str)>posiciones.get(m.getKey()))
							str=m.getKey();
					}
				}
				for(int i=(max+"").length();i<4;i++)sb.append(" ");
				sb.append(max+" "+new String(str)+"\n");
				mapa=new TreeMap<char[], Integer>(comp);
				posiciones=new TreeMap<char[], Integer>(comp);
				c=0;
			}
			else{
				ln=ln.replaceAll("[^a-zA-Z]+", " ");
				StringTokenizer st=new StringTokenizer(ln);
				for(char[] str;st.hasMoreTokens();){
					str=st.nextToken().toLowerCase().toCharArray();
					if(mapa.containsKey(str))mapa.put(str, mapa.get(str)+1);
					else mapa.put(str, 1);
					posiciones.put(str, c++);
				}
			}
		}
		System.out.print(new String(sb));
	}
}
