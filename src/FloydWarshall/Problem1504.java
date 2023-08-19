// https://www.acmicpc.net/problem/1504
// 특정한 최단 경로, Gold4
// 2023년 8월 19일
// 통과

package FloydWarshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1504{
    static int graph[][];
    static int INF = (int)1e9;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for(int i=0;i<N;++i){
            Arrays.fill(graph[i],INF);
            graph[i][i]=0;
        }

        for(int i=0;i<E;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a-1][b-1]=c;
            graph[b-1][a-1]=c;
        }
        st = new StringTokenizer(br.readLine());
        int v1=Integer.parseInt(st.nextToken())-1;
        int v2=Integer.parseInt(st.nextToken())-1;

        for(int k=0;k<N;++k){
            for(int i=0;i<N;++i){
                for(int j=0;j<N;++j){
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }

        int route1=(int)1e9;
        int route2=(int)1e9;
        if(graph[0][v1]!=(int)1e9 && graph[v1][v2]!=(int)1e9 && graph[v2][N-1]!=(int)1e9){
            route1 = graph[0][v1]+graph[v1][v2]+graph[v2][N-1];
        }

        if(graph[0][v2]!=(int)1e9 && graph[v2][v1]!=(int)1e9 && graph[v1][N-1]!=(int)1e9){
            route2 = graph[0][v2]+graph[v2][v1]+graph[v1][N-1];
        }


        int result = Math.min(route1,route2);

        if(result==(int)1e9) bw.write(-1+"\n");
        else bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}