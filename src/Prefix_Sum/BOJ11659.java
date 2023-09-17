// https://www.acmicpc.net/problem/11659
// 구간 합 구하기4, Silver3
// 2023년 9월 17일
// 통과

package Prefix_Sum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        int prefix_sum[] = new int[N+1];
        for(int i=0;i<N;++i){
            arr[i]=Integer.parseInt(st.nextToken());
            prefix_sum[i+1]=prefix_sum[i]+arr[i];
        }

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(prefix_sum[b]-prefix_sum[a-1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
