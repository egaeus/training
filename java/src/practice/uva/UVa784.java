package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 784
 * @problemName Maze Exploration
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date Nov 5, 2013
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVa784 {
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int N=parseInt(in.readLine().trim()),n=0;n++<N;) {
			ArrayList<char[]> maze=new ArrayList<char[]>();
			ArrayList<boolean[]> vis=new ArrayList<boolean[]>();
			int pos[]=null;
			String ln="";
			for(;!(ln=in.readLine()).replaceAll("_", "").isEmpty();) {
				maze.add(ln.toCharArray());
				vis.add(new boolean[ln.length()]);
				for(int i=0;i<maze.get(maze.size()-1).length;i++)
					if(maze.get(maze.size()-1)[i]=='*')
						pos=new int[]{maze.size()-1, i};
			}
			if(pos!=null) {
				int[][] cola=new int[30*80][];
				int p=0,c=0;
				cola[c++]=pos;
				vis.get(pos[0])[pos[1]]=true;
				for(;p<c;) {
					pos=cola[p++];
					for(int i=-1;i<2;i+=2) {
						if(pos[0]+i>=0&&pos[0]+i<maze.size()&&!vis.get(pos[0]+i)[pos[1]]&&!isWall(maze.get(pos[0]+i)[pos[1]])) {
							vis.get(pos[0]+i)[pos[1]]=true;
							cola[c++]=new int[]{pos[0]+i,pos[1]};
						}
						if(pos[1]+i>=0&&pos[1]+i<maze.get(pos[0]).length&&!vis.get(pos[0])[pos[1]+i]&&!isWall(maze.get(pos[0])[pos[1]+i])) {
							vis.get(pos[0])[pos[1]+i]=true;
							cola[c++]=new int[]{pos[0],pos[1]+i};
						}
					}
						
				}
			}
			for(int i=0;i<maze.size();i++) {
				for(int j=0;j<maze.get(i).length;j++)
					if(vis.get(i)[j])
						sb.append("#");
					else
						sb.append(maze.get(i)[j]);
				sb.append("\n");
			}
			sb.append(ln).append("\n");
		}
		System.out.print(new String(sb));
	}
	static boolean isWall(char a) {
		return a!='_'&&a!=' '&&a!='*';
	}
}
