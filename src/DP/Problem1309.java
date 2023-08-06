// https://www.acmicpc.net/problem/1309
// 동물원, Silver1
// 2023년 8월 5일
// 통과

package DP;

import java.io.*;

public class Problem1309 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =Integer.parseInt(br.readLine());

        long d[][]=new long[N+1][3];
        d[1][0]=1;
        d[1][1]=1;
        d[1][2]=1;
        for(int i=2;i<=N;++i){
            d[i][0]=(d[i-1][0]+d[i-1][1]+d[i-1][2])%9901;
            d[i][1]=(d[i-1][0]+d[i-1][2])%9901;
            d[i][2]=(d[i-1][0]+d[i-1][1])%9901;
        }

        long answer=(d[N][0]+d[N][1]+d[N][2])%(long)9901;
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}