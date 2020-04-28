package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2061, 1910
 * @problemName The Triangle Game
 * @judge http://livearchive.onlinejudge.org/, http://acm.tju.edu.cn/
 * @category dp
 * @level easy
 * @date 01/08/2011
 **/
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LAUVa2061 {
	static int arr[][], mem[][][];
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(String ln;!(ln=in.readLine().trim()).equals("$");){
			if(ln.equals("*"))ln=in.readLine().trim();
			arr=new int[6][];
			StringTokenizer st=new StringTokenizer(ln);
			arr[0]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
			for(int i=1;i<6;i++){
				st=new StringTokenizer(in.readLine());
				arr[i]=new int[]{parseInt(st.nextToken()),parseInt(st.nextToken()),parseInt(st.nextToken())};
			}
			mem=new int[64][101][101];int res=function(0,0,0);
			System.out.println(res<0?"none":res);
		}
	}
	static int function(int llevo, int izq, int der){
		if(llevo==63)return izq==der?0:MIN_VALUE+10000000;
		if(mem[llevo][izq][der]!=0)return mem[llevo][izq][der];
		int max=MIN_VALUE+10000000;
		for(int i=0,n=llevo;i<6;i++,n=n>>1)
			if(n%2==0){
				int nuevoLL=llevo|1<<i;
				for(int j=0;j<3;j++){
					if(llevo==0||arr[i][j]==izq)
						max=Math.max(max, function(nuevoLL,arr[i][(j+1)%3],llevo==0?arr[i][j]:der)+arr[i][(j+2)%3]);
					if(llevo==0||arr[i][j]==der)
						max=Math.max(max, function(nuevoLL,llevo==0?arr[i][j]:izq,arr[i][(j+2)%3])+arr[i][(j+1)%3]);
				}
			}
		return mem[llevo][izq][der]=max;
	}
}
