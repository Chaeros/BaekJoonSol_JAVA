// https://www.acmicpc.net/problem/9656
// 돌 게임2, Silver5
// 2023년 12월 28일
// 통과

package DP;

import java.io.*;

public class BOJ9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int d[] = new int[N+1];

        d[1]=1;
        if(N>=2) d[2]=2;
        if(N>=3) d[3]=1;

        for(int i=4;i<=N;++i){
            d[i]=Math.min(d[i-1],d[i-3])+1;
        }

        if(d[N]%2==1){
            bw.write("CY\n");
        }
        else{
            bw.write("SK\n");
        }
        bw.flush();
        bw.close();
    }
}
