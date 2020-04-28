package practice.livearchive; /**
 * @author egaeus
 * @mail sebegaeusprogram@gmail.com
 * @veredict Accepted
 * @problemId 6170
 * @problemName Esspe-Peasee
 * @judge http://livearchive.onlinejudge.org/
 * @category math
 * @level easy
 * @date Jul 22, 2013
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class LAUVa6170 {
	static long[] euclidesExtendido(long a,long b) {
		long r0=a,r1=b,s0=1,t0=0,s1=0,t1=1;
		for(;r1!=0;) {
			long q=r0/r1,r=r0%r1,s=s0-q*s1,t=t0-q*t1;
			r0=r1;s0=s1;t0=t1;
			r1=r;s1=s;t1=t;
		}
		return new long[]{r0,s0,t0};
	}
	public static void main(String args[]) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;) {
			BigInteger A=new BigInteger(st.nextToken()),B=new BigInteger(st.nextToken()),C=new BigInteger(st.nextToken());
			if(A.equals(BigInteger.ZERO)&&B.equals(BigInteger.ZERO)&&C.equals(BigInteger.ZERO))break;
			BigInteger x=BigInteger.valueOf(-1),y=BigInteger.valueOf(-1);
			if(C.equals(BigInteger.ZERO)) {
				x=BigInteger.ZERO;
				y=BigInteger.ZERO;
			}
			else if(A.equals(BigInteger.ZERO)) {
				if(C.mod(B).equals(BigInteger.ZERO)) {
					x=BigInteger.ZERO;
					y=C.divide(B);
				}
			}
			else if(B.equals(BigInteger.ZERO)) {
				if(C.mod(A).equals(BigInteger.ZERO)) {
					x=C.divide(A);
					y=BigInteger.ZERO;
				}
			}
			else {
				long[] euclides=euclidesExtendido(A.longValue(), B.longValue());
				BigInteger gcd=BigInteger.valueOf(euclides[0]),X=BigInteger.valueOf(euclides[1]),Y=BigInteger.valueOf(euclides[2]);
				if(C.mod(gcd).equals(BigInteger.ZERO)) {
					BigInteger k=C.divide(gcd);
					X=X.multiply(k);Y=Y.multiply(k);					
					if(X.compareTo(BigInteger.ZERO)<0) {
						BigInteger Mx=B.divide(gcd),My=A.divide(gcd),dif1=X.abs().divide(Mx).add(X.abs().mod(Mx).equals(BigInteger.ZERO)?BigInteger.ZERO:BigInteger.ONE),
								dif2=Y.divide(My),x1=X.add(dif1.multiply(Mx)),y1=Y.subtract(dif1.multiply(My)),x2=X.add(dif2.multiply(Mx)),y2=Y.subtract(dif2.multiply(My));
						if(x1.compareTo(BigInteger.ZERO)>=0&&y1.compareTo(BigInteger.ZERO)>=0){x=x1;y=y1;}
						if(x2.compareTo(BigInteger.ZERO)>=0&&y2.compareTo(BigInteger.ZERO)>=0&&(x.compareTo(BigInteger.ZERO)<0||x.add(y).compareTo(x2.add(y2))>0)){x=x2;y=y2;}
					}
					else if(Y.compareTo(BigInteger.ZERO)<0) {
						BigInteger Mx=B.divide(gcd),My=A.divide(gcd),dif1=Y.abs().divide(My).add(Y.mod(My).equals(BigInteger.ZERO)?BigInteger.ZERO:BigInteger.ONE),
								dif2=X.divide(Mx),x1=X.subtract(dif1.multiply(Mx)),y1=Y.add(dif1.multiply(My)),x2=X.subtract(dif2.multiply(Mx)),y2=Y.add(dif2.multiply(My));
						if(x1.compareTo(BigInteger.ZERO)>=0&&y1.compareTo(BigInteger.ZERO)>=0){x=x1;y=y1;}
						if(x2.compareTo(BigInteger.ZERO)>=0&&y2.compareTo(BigInteger.ZERO)>=0&&(x.compareTo(BigInteger.ZERO)<0||x.add(y).compareTo(x2.add(y2))>0)){x=x2;y=y2;}
					}
					else if(X.compareTo(BigInteger.ZERO)>=0&&Y.compareTo(BigInteger.ZERO)>=0) {
						BigInteger Mx=B.divide(gcd),My=A.divide(gcd),dif1=Y.divide(My),dif2=X.divide(Mx),x1=X.add(dif1.multiply(Mx)),y1=Y.subtract(dif1.multiply(My)),
								x2=X.subtract(dif2.multiply(Mx)),y2=Y.add(dif2.multiply(My));
						if(x1.compareTo(BigInteger.ZERO)>=0&&y1.compareTo(BigInteger.ZERO)>=0){x=x1;y=y1;}
						if(x2.compareTo(BigInteger.ZERO)>=0&&y2.compareTo(BigInteger.ZERO)>=0&&(x.compareTo(BigInteger.ZERO)<0||x.add(y).compareTo(x2.add(y2))>0)){x=x2;y=y2;}
					}
				}
			}
			if(x.equals(BigInteger.valueOf(-1))&&y.equals(BigInteger.valueOf(-1)))sb.append("Unquibable!");
			else sb.append(x).append(" foom").append(x.equals(BigInteger.ONE)?"":"s").append(" and ").append(y).append(" foob").append(y.equals(BigInteger.ONE)?"":"s").append(" for a twob!");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
