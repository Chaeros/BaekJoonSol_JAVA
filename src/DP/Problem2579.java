// https://www.acmicpc.net/problem/2579
// 계단 오르기, Silver3
// 2023년 7월 29일
// 통과

package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2579 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int stairs[] = new int[N+1];

        for(int i=1;i<N+1;++i){
            stairs[i]=Integer.parseInt(br.readLine());
        }

        int d[]= new int[301];
        if(N>=1) d[1]=stairs[1];
        if(N>=2) d[2]=stairs[1]+stairs[2];
        for(int i=3;i<N+1;++i){
            d[i]=Math.max(d[i-3]+stairs[i-1]+stairs[i],d[i-2]+stairs[i]);
        }
        System.out.println(d[N]);
    }
}