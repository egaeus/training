package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 5551
 * @problemName Monkeys in a Regular Forest
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 24/11/2011
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class LAUVa5551 {
	static int[][] floodFill(char[][] mat){
		int[][] res=new int[mat.length][mat[0].length];
		for(int i=0,c=1;i<res.length;i++)
			for(int j=0;j<res[i].length;j++)
				if(res[i][j]==0)floodFill(mat,res,i,j,mat[i][j],c++);
		return res;
	}
	static void floodFill(char[][] mat,int[][] res, int i,int j,char ch,int c){
		LinkedList<int[]> cola=new LinkedList<int[]>();
		res[i][j]=c;
		cola.add(new int[]{i,j});
		while(!cola.isEmpty()){
			int[] p=cola.pollFirst();
			for(int h=-1;h<2;h++)
				for (int k=-1;k<2;k++)
					if(p[0]+h>=0&&p[0]+h<res.length&&p[1]+k>=0&&p[1]+k<res[p[0]+h].length&&res[p[0]+h][p[1]+k]==0&&mat[p[0]+h][p[1]+k]==ch){
						cola.add(new int[]{p[0]+h,p[1]+k});
						res[p[0]+h][p[1]+k]=c;						
					}
		}
	}
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(String ln="";ln!=null;){
			ArrayList<ArrayList<Character>> mat=new ArrayList<ArrayList<Character>>();
			for(;(ln=in.readLine())!=null&&!ln.trim().equals("%");){
				ArrayList<Character> nuevo=new ArrayList<Character>();
				StringTokenizer st=new StringTokenizer(ln);
				for(int i=0;st.hasMoreTokens();i++)nuevo.add(st.nextToken().charAt(0));
				mat.add(nuevo);
			}
			char[][] matriz=new char[mat.size()][mat.get(0).size()];
			for(int i=0;i<matriz.length;i++)
				for(int j=0;j<matriz[i].length;j++)
					matriz[i][j]=mat.get(i).get(j);
			int[][] res=floodFill(matriz);
			int[] maximos=new int[matriz[0].length];
			for(int j=0;j<matriz[0].length;j++)
				for(int i=0;i<matriz.length;i++)
					maximos[j]=Math.max(maximos[j],(res[i][j]+"").length());
			for(int[] m:res){
				for(int j=0;j<m.length;j++){
					sb.append(j>0?" ":"");
					for(int i=(m[j]+"").length();i<maximos[j];i++)sb.append(" ");
					sb.append(m[j]);
				}
				sb.append("\n");
			}
			sb.append("%\n");
		}
		System.out.print(new String(sb));
	}
}
