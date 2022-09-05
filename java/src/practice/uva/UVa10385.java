package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 10385
 * @problemName Duathlon
 * @judge http://uva.onlinejudge.org/
 * @category search
 * @level easy
 * @date 31/03/2011
 **/
import static java.lang.Double.MAX_VALUE;

import java.util.Locale;
import java.util.Scanner;
public class UVa10385 {
	static double velocidades[][];
	public static void main(String[] args) throws Throwable{
		for(Scanner sc = new Scanner(System.in); sc.hasNext(); ){
			dist = sc.nextInt();
			int N; velocidades = new double[N = sc.nextInt()][];
			for(int i = 0; i < N; i++)
				velocidades[i] = new double[]{sc.nextDouble(), sc.nextDouble()};
			double val = ternarySearch(0, dist/2, dist), time = min(val)-(val/velocidades[velocidades.length-1][0]+(dist-val)/velocidades[velocidades.length-1][1]);
			if(time<0&&Math.abs(time)>E)System.out.printf("The cheater cannot win.\n");
			else System.out.printf(Locale.US, "The cheater can win by %.0f seconds with r = %.2fkm and k = %.2fkm.\n", time*3600, val, dist-val);
		}
	}
	static double dist, E=1E-10;
	static double min(double n){
		double min = MAX_VALUE;
		for(int i = 0; i < velocidades.length - 1; i++)
			min = Math.min(min, n/velocidades[i][0]+(dist-n)/velocidades[i][1]);
		return min;
	}
	static double function(double n){		
		return min(n) - (n/velocidades[velocidades.length-1][0]+(dist-n)/velocidades[velocidades.length-1][1]);
	}
	static double ternarySearch(double a, double b, double c){
		if(Math.abs(a-b)>E){
			double p1=a-(a-b)/2;
			if(function(p1)<function(b))return ternarySearch(p1, p1-(p1-c)/2, c);
		}
		if(Math.abs(b-c)>E){
			double p1=b-(b-c)/2;
			if(function(p1)<function(b))return ternarySearch(a, a-(a-c)/2, p1);
		}
		return b;
	}
}
