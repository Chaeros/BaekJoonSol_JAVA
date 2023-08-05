// https://www.acmicpc.net/problem/1309
// 동물원, Silver1
// 2023년 8월 5일
// 미제출

package DP;

import java.io.*;

public class Problem1309 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =Integer.parseInt(br.readLine());

        int d[]=new int[100001];
        d[0]=1;
        d[1]=3;
        for(int i=2;i<=N;++i){
            d[i]=1+2*i;
            for(int k=0;k<N-k;++k){
                for(int j=1;j<i-k;++j){
                    d[i]+=2*(2*j-1);
                }
            }

        }
        System.out.println(d[N]%9901);
    }
}
