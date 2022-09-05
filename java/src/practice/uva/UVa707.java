package practice.uva; /**
 * @author egaeus
 * @mail jsbeltran.valhalla@gmail.com
 * @veredict Accepted
 * @problemId 707
 * @problemName Robbery
 * @judge http://uva.onlinejudge.org/
 * @category dp
 * @level easy
 * @date 25/04/2012
 **/
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVa707 {
       static boolean[][][] mundos;
       public static void main(String[] args) throws Throwable{
               BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
               StringBuilder sb=new StringBuilder();int caso=1;
               mem=new int[101][100][100];
               for(StringTokenizer st;(st=new StringTokenizer(in.readLine()))!=null;caso++){
                       W=parseInt(st.nextToken());H=parseInt(st.nextToken());int t=parseInt(st.nextToken());
                       if(W==0&&H==0&&t==0)break;
                       int n=parseInt(in.readLine().trim());
                       mundos=new boolean[t+1][W][H];
                       for(int i=0;i<n;i++){
                               st=new StringTokenizer(in.readLine());
                               int time=parseInt(st.nextToken());
                               int li=parseInt(st.nextToken()),ti=parseInt(st.nextToken()),ri=parseInt(st.nextToken()),bi=parseInt(st.nextToken());
                               for(int j=li-1;j<ri;j++)for(int h=ti-1;h<bi;h++)
                                       mundos[time][j][h]=true;
                       }
                       for(int i=1;i<=t;i++)mundos[i]=getTablero(mundos[i],mundos[i-1]);
                       boolean seEscapo=false,loSe=false;
                       ArrayList<Integer> mundosConocidos=new ArrayList<Integer>();
                       for(int i=1;i<=t;i++){
                               int contar=contar(mundos[i]);
                               if(contar==1){loSe=true;mundosConocidos.add(i);}
                               if(contar==0)seEscapo=true;
                       }
                       sb.append("Robbery #"+caso+":\n");
                       if(seEscapo)sb.append("The robber has escaped.\n");
                       else if(!loSe)sb.append("Nothing known.\n");
                       else {
                               int tAct=1,posConocidos=0;
                               ArrayList<int[]> ubicaciones=new ArrayList<int[]>();
                               inicializarMemo();
                               for(;tAct<=t&&posConocidos<mundosConocidos.size()&&!seEscapo;tAct++){
                                       if(tAct==mundosConocidos.get(posConocidos)){
                                               inicializarMemo();
                                               int[] pos=getPos(mundos[tAct], tAct);
                                               posConocidos++;
                                               ubicaciones.add(new int[]{pos[0],pos[1],tAct});
                                       }
                                       else{
                                               int cant=0,pos[];
                                               pos=getPos(mundos[mundosConocidos.get(posConocidos)],mundosConocidos.get(posConocidos));
                                               llegadaI=pos[0];llegadaJ=pos[1];llegadaT=pos[2];
                                               for(int i=0;i<W;i++)
                                                       for(int j=0;j<H;j++)
                                                               if(!mundos[tAct][i][j]&&f(i,j,tAct)){
                                                                       cant++;pos=new int[]{i,j,tAct};
                                                               }
                                               if(cant==0)seEscapo=true;
                                               if(cant==1)ubicaciones.add(pos);
                                       }
                               }
                               if(seEscapo)sb.append("The robber has escaped.\n");
                               else for(int[] a:ubicaciones)sb.append("Time step "+(a[2])+": The robber has been at "+(a[0]+1)+","+(a[1]+1)+".\n");
                       }
                       sb.append("\n");
               }
               System.out.print(new String(sb));
       }

       static void inicializarMemo(){
               for(int[][] a:mem)for(int[] b:a)Arrays.fill(b, -1);
       }
       static int llegadaI,llegadaJ,llegadaT;
       static int[][][] mem;
       static boolean f(int i,int j,int p){
               if(p>llegadaT)return false;
               if(i==llegadaI&&j==llegadaJ&&p==llegadaT)return true;
               if(mem[i][j][p]!=-1)return mem[i][j][p]==1;
               for(int[] v:vecinos)
                       if(i+v[0]>=0&&i+v[0]<W&&j+v[1]>=0&&j+v[1]<H&&!mundos[p+1][i+v[0]][j+v[1]]&&f(i+v[0],j+v[1],p+1)){
                               mem[i][j][p]=1;
                               return true;
                       }
               mem[i][j][p]=0;
               return false;
       }
       static int contar(boolean tab[][]){
               int s=0;
               for(boolean[] a:tab)for(boolean m:a)s+=m?0:1;
               return s;
       }
       static int H,W,vecinos[][]=new int[][]{{0,-1},{0,0},{-1,0},{1,0},{0,1}};;
       static boolean[][] getTablero(boolean tab[][],boolean[][] tabAnt){
               boolean[][] res=new boolean[W][H];
               for(boolean[] m:res)Arrays.fill(m, true);
               for(int i=0;i<W;i++)
                       for(int j=0;j<H;j++)
                               if(!tabAnt[i][j])
                                       for(int[] v:vecinos)
                                               if(i+v[0]>=0&&i+v[0]<W&&j+v[1]>=0&&j+v[1]<H&&!tab[i+v[0]][j+v[1]])res[i+v[0]][j+v[1]]=false;
               return res;
       }
       static int[] getPos(boolean[][] tab,int t){
               for(int i=0;i<W;i++)for(int j=0;j<H;j++)if(!tab[i][j])return new int[]{i,j,t};
               return null;
       }
}