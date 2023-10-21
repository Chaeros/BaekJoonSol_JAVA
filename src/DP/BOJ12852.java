// https://www.acmicpc.net/problem/12852
// 1로 만들기 2, Silver1
// 2023년 10월 21일
// 통과

package DP;

import java.io.*;

public class BOJ12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int before[] = new int[N+1];

        int d[] = new int[N+1];
        for(int i=2;i<=N;++i){
            d[i]=d[i-1]+1;
            before[i]=i-1;

            if(i%3==0 && d[i]>d[i/3]+1){
                d[i]=d[i/3]+1;
                before[i]=i/3;
            }

            if(i%2==0 && d[i]>d[i/2]+1){
                d[i]=d[i/2]+1;
                before[i]=i/2;
            }
        }

        bw.write(d[N]+"\n");
        int n=N;
        while(n>=1){
            bw.write(n+" ");
            n=before[n];
        }
        bw.flush();
        bw.close();
    }
}
