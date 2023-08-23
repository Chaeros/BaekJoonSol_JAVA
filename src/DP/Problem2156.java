// https://www.acmicpc.net/problem/2156
// 포도주 시식, Silver1
// 2023년 8월 23일
// 통과

package DP;

import java.io.*;

public class Problem2156 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[10001];
        int d[] = new int[10001];

        for(int i=1;i<=n;++i){
            arr[i]=Integer.parseInt(br.readLine());
        }

        d[0]=0;
        d[1]=arr[1];
        d[2]=arr[1]+arr[2];
        for(int i=3;i<=n;++i){
            d[i]=Math.max(d[i-2]+arr[i],d[i-3]+arr[i-1]+arr[i]);
            d[i]=Math.max(d[i],d[i-1]);
        }

        bw.write(d[n]+"\n");
        bw.flush();
        bw.close();
    }
}
