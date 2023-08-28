// https://www.acmicpc.net/problem/2294
// 동전 2, Gold5
// 2023년 8월 27일
// 통과

package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2294{
    static int INF=(int)1e9;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int coins[] = new int[n];

        int d[] = new int[k+1];
        for (int i = 0; i < n; ++i) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(d,INF);

        d[0]=0;
        for(int i=1;i<=k;++i){
            for(int x:coins){
                if(i>=x) d[i]=Math.min(d[i],d[i-x]+1);
            }
        }

        if(d[k]!=INF) bw.write(d[k]+"\n");
        else bw.write(-1+"\n");
        bw.flush();
        bw.close();
    }
}
