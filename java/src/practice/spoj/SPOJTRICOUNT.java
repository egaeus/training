package practice.spoj; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId TRICOUNT
 * @problemName Counting Triangles
 * @judge http://www.spoj.pl
 * @category Adhoc
 * @level easy
 * @date 22/02/2011
 **/
/*NOTA: Con Java no pasa ni la lectura, vota T.L.E., con C++ si*/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SPOJTRICOUNT {
	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		long[][] arr = new long[1000001][2];
		for(long i = 1; i < arr.length; i++)arr[(int)i][1] = arr[(int)i-1][1] + (arr[(int)i][0] = arr[(int)i-1][0] + i) + (i-1)/2*((i-1)/2+1) + (i%2==0?i/2:0);  
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine()); c++ < C;)in.readLine();
			sb.append(arr[parseInt(in.readLine())][1] + "\n");
		System.out.print(new String(sb));
	}
}
/*#include <iostream.h>
const int n = 1000001;
int main(int argc, char *argv[]){
	long long int arr[n][2];
	long long int i;
	int h, j, c;
	arr[0][1]=arr[0][0]=0;
	for(i = 1; i < n; i++)arr[(int)i][1] = arr[(int)i-1][1] + (arr[(int)i][0] = arr[(int)i-1][0] + i) + (i-1)/2*((i-1)/2+1) + (i%2==0?i/2:0);
	cin>>c;
	for(h = 0; h++ < c; ){
		cin>>j;
		cout<<arr[j][1]<<endl;
	}
	return 0;
}
*/