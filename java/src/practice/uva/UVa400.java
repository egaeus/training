package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict No enviado
 * @problemId 400
 * @problemName Unix ls
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 4/01/2012
 **/
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.ceil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVa400 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (String ln;(ln=in.readLine())!=null;) {
			int N=parseInt(ln.trim()),max=0,C,R;
			String[] arr=new String[N];
			for(int i=0;i<N;i++)max=max(max,(arr[i]=in.readLine()).length());
			Arrays.sort(arr);C=(60-max)/(max+2)+1;R=(int)ceil(1.*N/C);
			for(int i=0;i<60;i++)sb.append("-");
			sb.append("\n");
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++)
					if(j*R+i<N){
						sb.append((j>0?"  ":"")+arr[j*R+i]);
						for(int h=arr[j*R+i].length();h<max;h++)sb.append(" ");
					}
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
}
