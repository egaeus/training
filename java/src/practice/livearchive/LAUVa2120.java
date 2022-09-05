package practice.livearchive; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 2120
 * @problemName The Spiral of Primes
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date 16/11/2011
 **/
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
public class LAUVa2120 {
	public static void main(String[] args) {
		int MAX=10000,MAXP=1230;int[] cambios=new int[]{-1,1};
		int[][] coord=new int[1230][];
		coord[0]=new int[2];
		for(int i=1,j=1;i<MAXP;j++){
			for(int h=0;h<j&&i<MAXP;h++,i++)
				coord[i]=new int[]{coord[i-1][0]+cambios[j%2],coord[i-1][1]};
			for(int h=0;h<j&&i<MAXP;h++,i++)
				coord[i]=new int[]{coord[i-1][0],coord[i-1][1]+cambios[j%2]};
		}
		boolean[] primos=new boolean[MAX];
		primos[0]=primos[1]=true;
		TreeMap<int[],Integer> mapa=new TreeMap<int[],Integer>(new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2) {
				return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];
			}
		});
		for(int i=0,c=0;i<MAX;i++)
			if(!primos[i]){
				mapa.put(coord[c++],i);
				for(int j=i+i;j<MAX;j+=i)primos[j]=true;
			}
		Scanner sc=new Scanner(System.in);
		for(int x,c=1;(x=sc.nextInt())!=-999;c++){
			int y=sc.nextInt();
			System.out.println((c>1?"\n":"")+"Case "+c+": The prime at location ("+x+","+y+")"+" is "+mapa.get(new int[]{x,y})+".");
		}
	}
}
