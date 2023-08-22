// https://www.acmicpc.net/problem/10844
// 쉬운 계단 수
// 2023년 8월 22일
// 통과

package DP;

import java.io.*;

public class Problem10844 {
    static int N;
    static int d[][];
    static int resultCount=0;
    static int mod=1000000000;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        d = new int[N+1][10];

        d[1][0]=0;
        for(int i=1;i<=9;++i){
            d[1][i]=1;
        }

        for(int i=2;i<=N;++i){
            d[i][0]=d[i-1][1];
            for(int j=1;j<9;++j){
                d[i][j]=(d[i-1][j-1]+d[i-1][j+1])%mod;
            }
            d[i][9]=d[i-1][8];
        }

        int sum=0;
        for(int i=0;i<=9;++i){
            sum+=d[N][i];
            sum%=mod;
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
