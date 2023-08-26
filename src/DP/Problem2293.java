// https://www.acmicpc.net/problem/2293
// 동전 1, Gold5
// 2023년 8월 26일
// 미제출

package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2293 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int coin[] = new int[n];
        int d[][] = new int[n][k+1];

        for(int i=0;i<=k;++i){
            d[0][i]=1;
        }

        for(int i=0;i<n;++i){
            coin[i]=Integer.parseInt(br.readLine());
        }

        for(int i=1;i<n;++i){
            d[i][0]=1;
            for(int j=1;j<=k;++j){
                if(j>=coin[i]) d[i][j]=d[i][j-coin[i]]+d[i-1][j];
                else d[i][j]=d[i-1][j];
            }
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<=k;++j){
                System.out.print(d[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        bw.write(d[n-1][k]+"\n");
        bw.flush();
        bw.close();
    }
}
