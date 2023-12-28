// https://www.acmicpc.net/problem/9657
// 돌 게임2, Silver3
// 2023년 12월 29일
// 통과

package DP;

import java.io.*;

public class BOJ9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int d[] = new int[1001];

        d[1]=1;
        d[2]=2;
        d[3]=1;
        d[4]=1;

        for(int i=5;i<=N;++i){
            d[i]=1;
            if(d[i-1]==1 && d[i-3]==1 && d[i-4]==1) d[i]=2;
        }

        if(d[N]%2==1){
            bw.write("SK\n");
        }
        else{
            bw.write("CY\n");
        }
        bw.flush();
        bw.close();
    }
}
