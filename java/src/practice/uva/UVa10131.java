package practice.uva; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 10131
 * @problemName Is Bigger Smarter? 
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 06/12/2010
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class UVa10131 {
	static int[][] arr;
	static int[][][] mem;
	static int f(int i,int j){
		if(j==mem.length)return 0;
		if(mem[i][j]!=null)return mem[i][j][0];
		if(arr[i][0]<arr[j][0]&&arr[i][1]>arr[j][1]){
			if(f(i,j+1)>f(j,j+1)+1)mem[i][j]=new int[]{f(i,j+1),0};
			else mem[i][j]=new int[]{f(j,j+1)+1,1};
			return mem[i][j][0];
		}
		mem[i][j]=new int[]{f(i,j+1),0};
		return mem[i][j][0];
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> elefantes=new ArrayList<int[]>();
		elefantes.add(new int[]{0,100001});
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(ln);
			elefantes.add(new int[]{parseInt(st.nextToken()),parseInt(st.nextToken())});
		}
		arr=new int[elefantes.size()][];
		for(int i=0;i<elefantes.size();i++)arr[i]=elefantes.get(i);
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0]!=o2[1]?o1[0]-o2[0]:o1[1]-o2[1];
			}
		});
		mem=new int[elefantes.size()][elefantes.size()][];
		//for(int i[]:arr)System.out.println(Arrays.toString(i));
		System.out.println(f(0,1));
		boolean ws=true;
		for(int i=0,j=1;j<mem.length;){
			if(mem[i][j][1]==1){
				if(!ws){
					int h=0;
					for(;h<arr.length;h++)if(elefantes.get(h)==arr[j])break;
					System.out.println(h);
				}
				i=j;j++;
			}
			else j++;
			ws=false;
		}
	}
}