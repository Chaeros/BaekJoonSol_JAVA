// https://www.acmicpc.net/problem/2458
// 키 순서, Gold4
// 2023년 8월 18일
// 통과

package FloydWarshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2458{
    static int graph[][];
    static int INF = (int)1e9;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int i=0;i<N;++i){
            Arrays.fill(graph[i],INF);
            graph[i][i]=0;
        }

        for(int i=0;i<M;++i){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b-1][a-1]=1;
        }

        for(int k=0;k<N;++k){
            for(int i=0;i<N;++i){
                for(int j=0;j<N;++j){
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }

        int resultCount=0;
        for(int i=0;i<N;++i){
            int unIncomeCount=0;
            int outcomeCount=0;
            for(int j=0;j<N;++j){
                if(graph[j][i]!=INF) ++unIncomeCount;
                else if(graph[i][j]!=INF) ++outcomeCount;
            }
            if(unIncomeCount+outcomeCount==N) ++resultCount;
        }

        bw.write(resultCount+"\n");
        bw.flush();
        bw.close();
    }
}