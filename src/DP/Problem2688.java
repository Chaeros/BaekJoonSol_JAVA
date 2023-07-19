// https://www.acmicpc.net/problem/2688
// 줄어들지 않아, Silver1
// 2023년 7월 17일

package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2688 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;++i) {
            long d[][] = new long[65][10];
            Arrays.fill(d[1],1);
            int n = Integer.parseInt(br.readLine());
            for (int j = 2; j <=n; ++j) {
                for (int k = 0; k < 10; ++k) {
                    for (int a = k; a < 10; ++a) {
                        d[j][k] += d[j - 1][a];
                    }
                }
            }
            long result=0;
            for(int j=0;j<10;++j){
                result+=d[n][j];
            }
            System.out.println(result);
        }
    }
}
