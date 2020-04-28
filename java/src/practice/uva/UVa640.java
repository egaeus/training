package practice.uva;

/**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 640
 * @problemName Self Numbers
 * @judge http://uva.onlinejudge.org/
 * @category math
 * @level easy
 * @date 2009
 **/
public class UVa640 {
	public static void main(String[] args) {
		boolean arr[] = new boolean[1000001];
		for (int i = 1; i < arr.length; i++){
			char[] ch = (i + "").toCharArray();
			int n = i;
			for (int j = 0; j < ch.length; j++)n += ch[j] - '0';
			if(n<1000001)arr[n]=true;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < arr.length; i++) if(!arr[i])sb.append(i + "\n");
		System.out.print(new String(sb));
	}
}
