package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict No enviado
 * @problemId 5683
 * @problemName Avoiding a disaster
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jul 24, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class LAUVa5683 {
	static int[][] posibilidades=new int[][]{{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,1,0},{2,0,1}};
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int T=parseInt(in.readLine().trim()),t=0;t++<T;) {
			StringTokenizer st=new StringTokenizer(in.readLine().replaceAll(":", " "));
			int horas[]=new int[3],mod=12*60;
			String out[]=new String[3];
			for(int i=0;i<3;i++) {
				String a=st.nextToken(),b=st.nextToken();
				horas[i]=(parseInt(a)*60+parseInt(b))%mod;
				out[i]=a+":"+b;
			}
			TreeSet<Integer> s=new TreeSet<Integer>();
			for(int i=0;i<=480;i++)
				for(int j=0;j<posibilidades.length;j++) 
					if((horas[posibilidades[j][0]]+i)%mod==horas[posibilidades[j][1]]&&(horas[posibilidades[j][1]]+i)%mod==horas[posibilidades[j][2]]) 
						s.add(posibilidades[j][1]);
			if(s.size()==1)
				sb.append("The correct time is ").append(out[s.first()]);
			else
				sb.append("Look at the sun");
			sb.append("\n");
		
		}
		System.out.print(new String(sb));
	}
}
