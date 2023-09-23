// https://www.acmicpc.net/problem/14501
// 퇴사, Silver3
// 2023년 9월 21일
// 통과

package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int T[] = new int[N+1];
        int P[] = new int[N+1];
        for(int i=1;i<=N;++i){
            st = new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }
        int d[] = new int[N+2];
        if(T[N]==1) d[N]=P[N];
        for(int i=N-1;i>0;--i){
            if(i+T[i]-1>N) d[i]=d[i+1];
            else d[i]=Math.max(P[i]+d[i+T[i]],d[i+1]);
        }

        bw.write(d[1]+"\n");
        bw.flush();
        bw.close();
    }
}
