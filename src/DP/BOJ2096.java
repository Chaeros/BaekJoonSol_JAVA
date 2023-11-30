// https://www.acmicpc.net/problem/2096
// 내려가기, Gold5
// 2023년 12월 1일
// 통과

package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[N][3];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;++j){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int d[][] = new int[N][3];

        d[0][0]=map[0][0];
        d[0][1]=map[0][1];
        d[0][2]=map[0][2];

        for(int i=1;i<N;++i){
            d[i][0]=Math.max(d[i-1][0],d[i-1][1])+map[i][0];
            d[i][1]=Math.max(d[i-1][0],d[i-1][1]);
            d[i][1]=Math.max(d[i][1],d[i-1][2])+map[i][1];
            d[i][2]=Math.max(d[i-1][1],d[i-1][2])+map[i][2];
        }

        int maxValue = Math.max(d[N-1][0],d[N-1][1]);
        maxValue = Math.max(maxValue,d[N-1][2]);

        bw.write(maxValue+" ");

        d = new int[N][3];

        d[0][0]=map[0][0];
        d[0][1]=map[0][1];
        d[0][2]=map[0][2];

        for(int i=1;i<N;++i){
            d[i][0]=Math.min(d[i-1][0],d[i-1][1])+map[i][0];
            d[i][1]=Math.min(d[i-1][0],d[i-1][1]);
            d[i][1]=Math.min(d[i][1],d[i-1][2])+map[i][1];
            d[i][2]=Math.min(d[i-1][1],d[i-1][2])+map[i][2];
        }

        int minValue = Math.min(d[N-1][0],d[N-1][1]);
        minValue = Math.min(minValue,d[N-1][2]);

        bw.write(minValue+"\n");
        bw.flush();
        bw.close();
    }
}
