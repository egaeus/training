package practice.tju; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 2427
 * @problemName The Cow Doctor
 * @judge http://acm.tju.edu.cn/
 * @category adhoc
 * @level easy
 * @date 02/08/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class TJU2427{
	public static void main(String args[]) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;){
			int n=parseInt(st.nextToken()),m=parseInt(st.nextToken());
			if(n==0&&m==0)break;
			TreeSet<TreeSet<Integer>> sets=new TreeSet<TreeSet<Integer>>(new Comparator<TreeSet<Integer>>(){
				public int compare(TreeSet<Integer> o1,TreeSet<Integer> o2){
					if(o1.size()!=o2.size())return o1.size()-o2.size();
					Object[] a=o1.toArray(),b=o2.toArray();
					for(int i=0;i<a.length;i++)
						if(((Integer)a[i]).compareTo((Integer)b[i])!=0)
							return ((Integer)a[i]).compareTo((Integer)b[i]);
					return 0;
				}
			});
			int r=0;
			for(int i=0;i<m;i++){
				st=new StringTokenizer(in.readLine());
				int c=parseInt(st.nextToken());
				TreeSet<Integer> set=new TreeSet<Integer>();
				for(int j=0;j<c;j++)set.add(parseInt(st.nextToken()));
				if(sets.contains(set))r++;
				else sets.add(set);
			}
			for(TreeSet<Integer> a:sets){
				TreeSet<Integer> s=new TreeSet<Integer>();
				for(TreeSet<Integer> b:sets)
					if(a!=b&&a.containsAll(b))s.addAll(b);
				if(s.size()==a.size())r++;
			}
			System.out.println(r);
		}
	}
}
