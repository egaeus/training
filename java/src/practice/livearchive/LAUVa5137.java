package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5137
 * @problemName Pyramids
 * @judge http://livearchive.onlinejudge.org/
 * @category pd
 * @level medium
 * @date 28/06/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;
public class LAUVa5137 {
	static int arr[], mem[][];
	public static void main(String[] args) throws Throwable{
		TreeMap<Integer, String> mapa=new TreeMap<Integer, String>();
		arr=new int[323];int c=0;
		for(int i=2,K=1;K<=1000000;i++)mapa.put(arr[c++]=K+=i*i, i+"H");
		for(int i=3,K=1;K<=1000000;i+=2)mapa.put(arr[c++]=K+=i*i, i+"L");
		for(int i=4,K=4;K<=1000000;i+=2)mapa.put(arr[c++]=K+=i*i, i+"L");
		Arrays.sort(arr);
		mem=new int[10][1000001];
		int pos[]=new int[1000001];
		for(int i=0,p=0;i<pos.length;i++){if(i==arr[p])p++;pos[i]=p;}
		mem=new int[10][];
		int[] ant=new int[1000001];
		int[] nuevo=new int[1000001];
		ant[0]=1;
		for(int i=0;i<3;i++){
			mem[i]=ant;
			Arrays.fill(nuevo, 0);
			for(int j=0;j<ant.length;j++)
				if(ant[j]>0)
					for(int k=0;j+arr[k]<1000001;k++)
						if(k+2>nuevo[j+arr[k]]&&!usado(k+2,i,j))nuevo[j+arr[k]]=k+2;
			ant=nuevo.clone();
		}
		for(int i=3;i<mem.length-1;i++){
			mem[i]=ant;
			Arrays.fill(nuevo,0);
			for(int j=0;j<ant.length;j++)
				for(int k=pos[j]-1;k>=0;k--)
					if(ant[j-arr[k]]>0&&!usado(k+2,i,j-arr[k])){nuevo[j]=k+2;k=-1;}
			ant=nuevo.clone();
		}
		mem[mem.length-1]=ant;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int N,caso=1;(N=parseInt(in.readLine().trim()))!=0;caso++){
			int i=0;
			for(;i<mem.length;i++)
				if(mem[i][N]!=0)break;
			String sol="";
			int[] sols=new int[10];c=0;
			if(i<mem.length){
				for(;i>0;N-=arr[mem[i][N]-2],i--)sols[c++]=arr[mem[i][N]-2];
				Arrays.sort(sols,0,c);
				for(int j=c-1;j>=0;j--)sol+=" "+mapa.get(sols[j]);
			}
			else sol=" impossible";
			sb.append("Case "+caso+":"+sol+"\n");
		}
		System.out.print(new String(sb));
	}
	static boolean usado(int n, int i, int j){
		for(;i>0;j-=arr[mem[i][j]-2],i--)if(mem[i][j]==n)return true;
		return false;
	}
}
