package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5130
 * @problemName Ancient Messages
 * @judge http://livearchive.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 20/06/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class LAUVa5130 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));int caso=1;
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			if(N==M&&N==0)break;
			int[][] mat=new int[N+2][(M+2)*4];
			for(int i=0;i<N;i++){
				char[] str=in.readLine().trim().toCharArray();
				for(int j=0;j<M;j++){
					String hex=Integer.toBinaryString(parseInt(str[j]+"",16));
					for(;hex.length()!=4;)hex="0"+hex;
					for(int h=0;h<hex.length();h++)mat[i+1][(j+1)*4+h]=hex.charAt(h)=='0'?0:1;
				}
			}
			boolean primero=true;int cant=0;char[] sol = new char[1000000];
			for(int i=0;i<mat.length;i++)
				for(int j=0;j<mat[i].length;j++){
					if(mat[i][j]==1){
						sol[cant++]=getTipoGeroglifico(mat, i, j, primero);
						primero=false;
					}
				}
			Arrays.sort(sol,0,cant);
			String res="";
			for(int i=0;i<cant;i++)res+=sol[i];
			System.out.println("Case " + caso++ + ": " + res);
		}
	}
	static char getTipoGeroglifico(int[][] mat, int posI, int posJ, boolean primero){
		LinkedList<int[]> cola = new LinkedList<int[]>();
		int cant=0;
		mat[posI][posJ]=2;
		cola.add(new int[]{posI,posJ});
		while(!cola.isEmpty()){
			int[] pos=cola.removeFirst();
			if(pos[0]<mat.length-1){
				if(mat[pos[0]+1][pos[1]]==1){
					cola.add(new int[]{pos[0]+1,pos[1]});
					mat[pos[0]+1][pos[1]]=2;
				}
				else if(mat[pos[0]+1][pos[1]]==0){
					cant++;
					rellenarBlancos(mat, pos[0]+1, pos[1]);
				}
			}
			if(pos[0]>0){
				if(mat[pos[0]-1][pos[1]]==1){
					cola.add(new int[]{pos[0]-1,pos[1]});
					mat[pos[0]-1][pos[1]]=2;
				}
				else if(mat[pos[0]-1][pos[1]]==0){
					cant++;
					rellenarBlancos(mat, pos[0]-1, pos[1]);
				}
			}
			if(pos[1]<mat[pos[0]].length-1){
				if(mat[pos[0]][pos[1]+1]==1){
					cola.add(new int[]{pos[0],pos[1]+1});
					mat[pos[0]][pos[1]+1]=2;
				}
				else if(mat[pos[0]][pos[1]+1]==0){
					cant++;
					rellenarBlancos(mat, pos[0], pos[1]+1);
				}
			}
			if(pos[1]>0){
				if(mat[pos[0]][pos[1]-1]==1){
					cola.add(new int[]{pos[0],pos[1]-1});
					mat[pos[0]][pos[1]-1]=2;
				}
				else if(mat[pos[0]][pos[1]-1]==0){
					cant++;
					rellenarBlancos(mat, pos[0], pos[1]-1);
				}
			}
		}
		int[] soluciones = new int[]{1,3,5,4,0,2};
		char[] sols=new char[]{'A','J','D','S','W','K'};
		for(int i=0;i<soluciones.length;i++)
			if(primero&&soluciones[i]+1==cant)return sols[i];
			else if(!primero&&soluciones[i]==cant)return sols[i];
		return 0;
	}
	static void rellenarBlancos(int[][] mat, int posI, int posJ){
		LinkedList<int[]> cola = new LinkedList<int[]>();
		mat[posI][posJ]=3;
		cola.add(new int[]{posI,posJ});
		while(!cola.isEmpty()){
			int[] pos=cola.removeFirst();
			if(pos[0]<mat.length-1&&mat[pos[0]+1][pos[1]]==0){
				cola.add(new int[]{pos[0]+1,pos[1]});
				mat[pos[0]+1][pos[1]]=3;
			}
			if(pos[0]>0&&mat[pos[0]-1][pos[1]]==0){
				cola.add(new int[]{pos[0]-1,pos[1]});
				mat[pos[0]-1][pos[1]]=3;
			}
			if(pos[1]<mat[pos[0]].length-1&&mat[pos[0]][pos[1]+1]==0){
				cola.add(new int[]{pos[0],pos[1]+1});
				mat[pos[0]][pos[1]+1]=3;
			}
			if(pos[1]>0&&mat[pos[0]][pos[1]-1]==0){
				cola.add(new int[]{pos[0],pos[1]-1});
				mat[pos[0]][pos[1]-1]=3;
			}
		}
	}
}
