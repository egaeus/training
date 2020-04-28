package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 6164
 * @problemName Crossnumber
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Jul 22, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class LAUVa6164 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N=parseInt(in.readLine().trim());
		for (;N!=0;) {
			char[][] mat=new char[N][];
			for(int i=0;i<N;i++)mat[i]=in.readLine().trim().toCharArray();
			ArrayList<int[]> across=new ArrayList<int[]>(),down=new ArrayList<int[]>();
			in.readLine();
			for(String ln;!(ln=in.readLine().trim()).equals("Down");) {
				StringTokenizer st=new StringTokenizer(ln);
				across.add(new int[]{parseInt(st.nextToken())-1,parseInt(st.nextToken())-1,parseInt(st.nextToken())});
			}
			for(String ln;(ln=in.readLine().trim())!=null;) {
				StringTokenizer st=new StringTokenizer(ln);
				N=parseInt(st.nextToken());
				if(!st.hasMoreTokens())break;
				down.add(new int[]{N-1,parseInt(st.nextToken())-1,parseInt(st.nextToken())});
			}
			for(int sum=1,pos[]=new int[]{-1,-1,-1};sum!=0;pos[0]=-1) {
				sum=0;
				for(int i=0;i<across.size()&&pos[0]==-1;i++) {
					int c=mat[across.get(i)[1]][across.get(i)[0]]=='.'?1:0,s=c==0?mat[across.get(i)[1]][across.get(i)[0]]-'0':0;
					pos[0]=across.get(i)[1];
					pos[1]=across.get(i)[0];
					for(int k=across.get(i)[0]-1;k>=0;k--) {
						if(mat[across.get(i)[1]][k]=='#')break;
						if(mat[across.get(i)[1]][k]=='.') {
							pos[0]=across.get(i)[1];
							pos[1]=k;
							c++;
						}
						else s+=mat[across.get(i)[1]][k]-'0';
					}
					for(int k=across.get(i)[0]+1;k<mat.length;k++) {
						if(mat[across.get(i)[1]][k]=='#')break;
						if(mat[across.get(i)[1]][k]=='.'){
							c++;
							pos[0]=across.get(i)[1];
							pos[1]=k;
						}
						else s+=mat[across.get(i)[1]][k]-'0';
					}
					sum+=c;
					if(c!=1)pos[0]=-1;
					else mat[pos[0]][pos[1]]=(char)(across.get(i)[2]-s+'0');
				}
				for(int i=0;i<down.size()&&pos[0]==-1;i++) {
					int c=mat[down.get(i)[1]][down.get(i)[0]]=='.'?1:0,s=c==0?mat[down.get(i)[1]][down.get(i)[0]]-'0':0;
					pos[0]=down.get(i)[1];
					pos[1]=down.get(i)[0];
					for(int k=down.get(i)[1]-1;k>=0;k--) {
						if(mat[k][down.get(i)[0]]=='#')break;
						if(mat[k][down.get(i)[0]]=='.'){
							pos[0]=k;
							pos[1]=down.get(i)[0];
							c++;
						}
						else s+=mat[k][down.get(i)[0]]-'0';
					}
					for(int k=down.get(i)[1]+1;k<mat.length;k++) {
						if(mat[k][down.get(i)[0]]=='#')break;
						if(mat[k][down.get(i)[0]]=='.'){
							pos[0]=k;
							pos[1]=down.get(i)[0];
							c++;
						}
						else s+=mat[k][down.get(i)[0]]-'0';
					}
					sum+=c;
					if(c!=1)pos[0]=-1;
					else mat[pos[0]][pos[1]]=(char)(down.get(i)[2]-s+'0');
				}
			}
			for(char[] m:mat)sb.append(new String(m)).append("\n");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
