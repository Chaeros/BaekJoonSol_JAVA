// https://www.acmicpc.net/problem/9095
// 1,2,3 더하기, Silver3
// 2023년 7월 29일
// 통과

package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9095 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        int d[]=new int[11];
        d[1]=1;
        d[2]=2;
        d[3]=4;
        for(int i=4;i<11;++i){
            d[i]=d[i-1]+d[i-2]+d[i-3];
        }

        for(int t=0;t<T;++t){
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
}
