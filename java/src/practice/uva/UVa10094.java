package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10094
 * @problemName Place the Guards
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 11/04/2011
 **/
import java.util.Scanner;
public class UVa10094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(;sc.hasNextInt();){
			int N = sc.nextInt();
			if(N<4){sb.append("Impossible\n");continue;}
			if((N-4)%6<4){
				for(int i = N-1; i > 0; i-=2)
					sb.append(i + " ");
				for(int i = N; i > 0; i-=2)
					sb.append(i + (i>2?" ":""));
				sb.append("\n");
			}
			else{
				for(int i = N-3; i > 0; i-=2)
					sb.append(i + " ");
				sb.append(N-1 + " ");
				if((N-4)%6==4){
					for(int i = N-6; i > 0; i-=2)
						sb.append(i + " ");
					sb.append(N + " " + (N-2) + " " + (N-4) + "\n");
				}
				else{
					for(int i = N-4; i > 0; i-=2)
						sb.append(i + " ");
					sb.append(N + " " + (N-2) + "\n");
				}
			}
		}
		System.out.print(new String(sb));
	}
}
