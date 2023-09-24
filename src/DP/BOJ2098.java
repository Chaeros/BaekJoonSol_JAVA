// https://www.acmicpc.net/problem/2098
// 외판원 순회, Gold1
// 2023년 9월 24일
// 통과

package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2098{
    static int N;
    static int graph[][];
    static int dp[][] = new int[17][1<<16];
    static int INF = (int)1e9;
    static int dfs(int x, int visited){

        if(visited==(1<<N)-1){
            if(graph[x][0]==0) return INF;
            return graph[x][0];
        }

        if(dp[x][visited]!=0) return dp[x][visited];

        dp[x][visited]=INF;
        for(int i=0;i<N;++i){
            if(graph[x][i]!=0 && (visited & (1<<i))==0){
                int next = visited | (1<<i);
                dp[x][visited]=Math.min(dp[x][visited],graph[x][i]+dfs(i,next));
            }
        }
        return dp[x][visited];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        bw.write(dfs(0,1)+"\n");
        bw.flush();
        bw.close();
    }
}