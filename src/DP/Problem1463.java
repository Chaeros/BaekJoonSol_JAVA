// https://www.acmicpc.net/problem/1463
// 1로 만들기, Silver3
// 2023년 8월 15일
// 통과

package DP;

import java.io.*;

public class Problem1463 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int d[] = new int[1000001];
        d[0]=0;
        d[1]=0;
        d[2]=1;
        d[3]=1;

        for(int i=4;i<N+1;++i){
            if(i%2==0 && i%3==0) {
                d[i]=Math.min(Math.min(d[i-1]+1,d[i/3]+1),
                        Math.min(d[i-1]+1,d[i/2]+1));
            }
            else if(i%3==0) d[i]=Math.min(d[i-1]+1,d[i/3]+1);
            else if(i%2==0) d[i]=Math.min(d[i-1]+1,d[i/2]+1);
            else d[i]=d[i-1]+1;
        }

        bw.write(d[N]+"\n");
        bw.flush();
        bw.close();
    }
}
