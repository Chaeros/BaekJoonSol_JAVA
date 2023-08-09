// https://www.acmicpc.net/problem/1932
// 정수 삼각형, Silver1
// 2023년 8월 9일
// 통과

package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1932 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n+1][n+1];
        int d[][] = new int[n+1][n+1];

        for(int i=1;i<n+1;++i){
            st = new StringTokenizer(br.readLine());
            int k=1;
            while(st.hasMoreTokens()){
                arr[i][k]=Integer.parseInt(st.nextToken());
                ++k;
            }
        }

        for(int i=1;i<n+1;++i){
            for(int j=1;j<n+1;++j){
                d[i][j]=Math.max(d[i-1][j-1]+arr[i][j],
                        d[i-1][j]+arr[i][j]);
            }
        }

        int maxVal=d[n][1];
        for(int i=2;i<n+1;++i){
            maxVal=Math.max(d[n][i],maxVal);
        }

        bw.write(maxVal+"\n");
        bw.flush();
        bw.close();
    }
}
