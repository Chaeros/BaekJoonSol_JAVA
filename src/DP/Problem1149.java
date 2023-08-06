// https://www.acmicpc.net/problem/1149
// RGB거리, Silver1
// 2023년 8월 6일
// 통과

package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1149 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int d[][]=new int[N+1][3];

        for(int i=1;i<N+1;++i){
            st=new StringTokenizer(br.readLine());
            int red=Integer.parseInt(st.nextToken());
            int green=Integer.parseInt(st.nextToken());
            int blue=Integer.parseInt(st.nextToken());

            d[i][0]=Math.min(d[i-1][1],d[i-1][2])+red;
            d[i][1]=Math.min(d[i-1][0],d[i-1][2])+green;
            d[i][2]=Math.min(d[i-1][0],d[i-1][1])+blue;
        }
        int minVal=Math.min(d[N][0],d[N][1]);
        bw.write(Math.min(minVal,d[N][2])+"\n");
        bw.flush();
        bw.close();
    }
}
