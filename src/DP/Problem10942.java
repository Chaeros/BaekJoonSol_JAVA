// https://www.acmicpc.net/problem/10942
// 펠린드롬, Gold4
// 2023년 8월 29일
// 통과

package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10942 {
    static boolean dp[][] = new boolean[2001][2001];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int list[] = new int[N+1];
        for(int i=1;i<=N;++i){
            list[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;++i){
            dp[i][i]=true;
        }

        for(int i=1;i<N;++i){
            if(list[i]==list[i+1]) dp[i][i+1]=true;
        }

        for(int i=2;i<N;++i){
            for(int j=1;j<=N-i;++j){
                if(list[j]==list[j+i] && dp[j+1][j+i-1]){
                    dp[j][j+i]=true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(dp[start][end]) bw.write(1+"\n");
            else bw.write(0+"\n");
        }
        bw.flush();
        bw.close();
    }
}
