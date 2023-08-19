// https://www.acmicpc.net/problem/9465
// 스티커, Silver1
// 2023년 8월 19일
// 통과

package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9465 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int d[][] = new int[100001][2];
        int sticker[][] = new int[100001][2];


        for(int t=0;t<T;++t){
            int n = Integer.parseInt(br.readLine());
            for(int i=0;i<2;++i){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;++j){
                    sticker[j][i]=Integer.parseInt(st.nextToken());
                }
            }

            d[1][0]=sticker[1][0];
            d[1][1]=sticker[1][1];
            for(int j=2;j<=n;++j){
                d[j][0]=Math.max(d[j-1][1]+sticker[j][0],
                            d[j-2][1]+sticker[j][0]);
                d[j][1]=Math.max(d[j-1][0]+sticker[j][1],
                            d[j-2][0]+sticker[j][1]);
            }

            bw.write(Math.max(d[n][0],d[n][1])+"\n");
        }
        bw.flush();
        bw.close();
    }
}
