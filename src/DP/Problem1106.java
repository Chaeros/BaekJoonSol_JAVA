// https://www.acmicpc.net/problem/1106
// 호텔, Gold5
// 2023년 8월 6일
// 통과

package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1106{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int val[]= new int[C+101];
        Arrays.fill(val,Integer.MAX_VALUE);

        val[0]=0;
        for(int i=0;i<N;++i){
            st=new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customerNum = Integer.parseInt(st.nextToken());
            for(int j=customerNum;j<C+101;++j){
                if(val[j-customerNum]!=Integer.MAX_VALUE)
                    val[j]=Math.min(val[j],val[j-customerNum]+cost);
            }
        }

        int result=Integer.MAX_VALUE;
        for(int i=C;i<C+101;++i){
            result=Math.min(val[i],result);
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}