// https://www.acmicpc.net/problem/11726
// 2xn 타일링, Silver3
// 2023년 7월 29일
// 미제출

package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem11726 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger d[] = new BigInteger[n+1];
        d[1]=new BigInteger("1");
        if(n>=2) d[2]=new BigInteger("2");
        for(int i=3;i<n+1;++i){
            d[i]=d[i-2].add(d[i-1]);
        }
        BigInteger remainder = new BigInteger("10007");
        System.out.println(d[n].remainder(remainder));
    }
}
