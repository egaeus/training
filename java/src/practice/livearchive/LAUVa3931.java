package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 3931
 * @problemName Emoticons :-)
 * @judge http://livearchive.onlinejudge.org/
 * @category adhoc
 * @level medium
 * @date 19/10/2011
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class LAUVa3931 {
	static int set(int a, int b){
		if(lst.size()==0)return 0;
		int min,max;
		for(min=a;min<=b;min++){
			boolean ws=true;
			for(int[] l:lst)
				if(min>l[1]){ws=false;break;}
			if(!ws){break;}
		}
		for(max=b;max>=a;max--){
			boolean ws=true;
			for(int[] l:lst)
				if(max<l[0]){ws=false;break;}
			if(!ws){break;}
		}
		//System.out.println(a+" "+b+" "+max+" "+min);
		if(max<min-1)return 1;
		for(int i=0;i<lst.size();i++)
			if(lst.get(i)[0]<min||lst.get(i)[1]>max){
				lst.remove(i--);
			}
		return set(min,max)+2;
	}
	static ArrayList<int[]> search(char[][] patterns, char[] target) {
		ArrayList<int[]> res=new ArrayList<int[]>();
		Trie root=new Trie(),q=root,p;
		for(int k=0;k<patterns.length;k++)add(root,patterns[k],k);
		prepare(root);
		for(int j=0;j<target.length;j++) {
			while((p=q.gotoF(root,target[j]))==null)q=q.failure;
			q=p;
			if(q.out!=null)for(int id:q.out)res.add(new int[]{j-patterns[id].length+1,j});
		}
		return res;
	}
	static void prepare(Trie root){
		Queue<Trie> queue=new LinkedList<Trie>();Trie r,v,p;
		if(root.nodes!=null)for(Trie t:root.nodes){t.failure=root;queue.add(t);}
		while(!queue.isEmpty())
			if((r=queue.poll()).nodes!=null)
				for(Trie u:r.nodes){
					queue.add(u);
					for(v=r.failure;(p=v.gotoF(root,u.ch))==null;)v=v.failure;
					u.failure = p;
					if(p.out!=null)u.addOutputs(p.out);
				}
	}
	static void add(Trie root,char[] a,int idPattern) {
		Trie u=root,t;
		for(char c:a)
			if((t=u.get(c))==null) {
				u.nodes=u.nodes==null?new Trie[1]:Arrays.copyOf(u.nodes,u.nodes.length+1);
				(u=u.nodes[u.nodes.length-1]=new Trie()).ch=c;
			} else u=t;
		u.addOutputs(idPattern);
	}
	static class Trie{
		char ch=0;
		Trie[] nodes=null;
		int[] out=null;
		Trie failure=null;
		Trie() {}
		void addOutputs(int... arr) {
			if (out==null){out=arr;return;}
			int g=out.length,f=arr.length;
			System.arraycopy(arr,0,out=Arrays.copyOf(out,g+f),g,f);
		}
		Trie get(char c) {
			if(nodes!=null)for(Trie t:nodes)if(t.ch==c)return t;
			return null;
		}
		Trie gotoF(Trie root,char c) {
			Trie t=get(c);
			return t!=null?t:(this==root?root:null);
		}
	}
	static ArrayList<int[]> lst;
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int N=parseInt(st.nextToken()),M=parseInt(st.nextToken());
			if(N==0&&M==0)break;
			char[][] emoticones=new char[N][];
			for(int i=0;i<N;i++)emoticones[i]=in.readLine().trim().toCharArray();
			int res=0;
			for(int i=0;i<M;i++){
				char[] str=in.readLine().toCharArray();
				lst=search(emoticones,str);
				res+=set(0,str.length);
			}
			System.out.println(res);
		}
	}
}
