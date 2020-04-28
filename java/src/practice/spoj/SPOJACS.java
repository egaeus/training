package practice.spoj; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId ACS
 * @problemName A concrete simulation
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 14/03/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SPOJACS {
	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		int[] columns = new int[5678], columns1 = new int[5678];
		int[] rows = new int[1234], rows1 = new int[1234];
		for(int i = 0; i < columns.length; i++)columns[i] = columns1[i] = i;
		for(int i = 1; i < 1234; i++)rows[i] = rows1[i] = i;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln);
			char c = st.nextToken().charAt(0);
			switch(c){
				case 'R':{
					int x = parseInt(st.nextToken()) - 1, y = parseInt(st.nextToken()) - 1;
					int temp = rows[x];
					rows[x] = rows[y];
					rows[y] = temp;
					rows1[rows[x]] = x;
					rows1[rows[y]] = y;
					break;
				}
				case 'C':{
					int x = parseInt(st.nextToken()) - 1, y = parseInt(st.nextToken()) - 1;
					int temp = columns[x];
					columns[x] = columns[y];
					columns[y] = temp;
					columns1[columns[x]] = x;
					columns1[columns[y]] = y;
					break;
				}
				case 'Q':{
					int x = parseInt(st.nextToken()) - 1, y = parseInt(st.nextToken()) - 1;
					sb.append(rows[x]*columns.length+columns[y]+1 + "\n");
					break;
				}
				case 'W':{
					int z = parseInt(st.nextToken()) - 1;
					sb.append((rows1[z/columns.length] + 1) + " " + (columns1[z%columns.length] + 1) + "\n");
					break;
				}
			}
		}
		System.out.print(new String(sb));
	}
}
