// https://www.acmicpc.net/problem/14916
// 거스름돈, Silver5
// 2024년 1월 5일
// 통과

package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int d[] = new int[100001];
        Arrays.fill(d,-1);
        d[2]=1;
        d[4]=2;
        d[5]=1;

        for(int i=6;i<=n;++i){
            if(d[i-2]!=-1) d[i]=d[i-2]+1;
            if(d[i-5]!=-1) d[i]=Math.min(d[i],d[i-5]+1);
        }
        bw.write(d[n]+"\n");
        bw.flush();
        bw.close();
    }
}
