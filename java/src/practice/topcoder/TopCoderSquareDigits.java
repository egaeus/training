package practice.topcoder; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId SquareDigits
 * @problemName SquareDigits
 * @judge http://www.topcoder.com
 * @category Adhoc
 * @level easy
 * @date 02/12/2010
 **/
import java.util.ArrayList;
import java.util.TreeSet;
public class TopCoderSquareDigits {
	ArrayList<TreeSet<Integer>> arr = new ArrayList<TreeSet<Integer>>();
	public int smallestResult(int n){
		for(int i = 0;;i++)
			if(getN(i).contains(n))return i;
	}
	public TreeSet<Integer> getN(int n){
		if(n < arr.size())return arr.get(n);
		TreeSet<Integer> visitados = new TreeSet<Integer>();
		while(true){
			int res = 0;
			while(n!=0){
				res += (n%10)*(n%10);
				n/=10;
			}
			n = res;
			if(visitados.contains(n))break;
			visitados.add(n);
		}
		arr.add(visitados);
		return visitados;
	}
}
