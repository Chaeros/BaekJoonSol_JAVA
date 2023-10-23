// https://www.acmicpc.net/problem/11052
// 카드 구매하기, Silver1
// 2023년 10월 23일
// 통과

package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int card[] = new int[N+1];
        int d[] = new int[N+1];

        for(int i=1;i<=N;++i){
            card[i]=Integer.parseInt(st.nextToken());
            d[i]=card[i];
        }

        for(int i=1;i<=N;++i){
            for(int j=1;j<=N;++j){
                if(i>j) d[i]=Math.max(d[i],d[i-j]+card[j]);
            }
        }

        bw.write(d[N]+"\n");
        bw.flush();
        bw.close();
    }
}
