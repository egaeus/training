package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10281
 * @problemName Average Speed
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 12/08/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;
public class UVa10281 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double vel = 0;
		double dist = 0;
		int horasAnt = 0, minutosAnt = 0, segAnt = 0;
		for(String ln; (ln = in.readLine())!= null; ){
			StringTokenizer st = new StringTokenizer(ln.trim());
			String hora = st.nextToken();
			StringTokenizer stH = new StringTokenizer(hora, ":");
			int horas = parseInt(stH.nextToken()), mins =  parseInt(stH.nextToken()), seg = parseInt(stH.nextToken());
			dist += (((horas - horasAnt)*3600 + (mins - minutosAnt)*60 + (seg - segAnt))*vel)/3600;
			if(st.hasMoreTokens())vel = parseInt(st.nextToken());
			else System.out.printf(Locale.US, hora + " %.2f km%n", dist);
			horasAnt = horas; minutosAnt = mins; segAnt = seg;
		}
	}
}
