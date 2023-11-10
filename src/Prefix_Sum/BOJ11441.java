// https://www.acmicpc.net/problem/11441
// 합 구하기, Silver3
// 2023년 11월 10일
// 통과

package Prefix_Sum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];
        int d[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;++i){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;++i){
            d[i]=d[i-1]+arr[i];
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken());
            bw.write(d[b]-d[a]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
