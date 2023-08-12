// https://www.acmicpc.net/problem/1956
// 운동, Gold4
// 2023년 8월 11일
// 통과

package FloydWarshall;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1956 {

    static int graph[][];
    static int INF = (int)1e9;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph=new int[V+1][V+1];

        for(int i=0;i<V+1;++i){
            Arrays.fill(graph[i],INF);
        }

        for(int i=0;i<E;++i){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int objective = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start][objective]=cost;
        }

        for(int i=1;i<V+1;++i)
            for(int j=1;j<V+1;++j)
                for(int k=1;k<V+1;++k){
                    graph[j][k]=Math.min(graph[j][k],graph[j][i]+graph[i][k]);
                }

        int minVal=INF;
        for(int i=1;i<V+1;++i){
            if(minVal>graph[i][i]){
                minVal=graph[i][i];
            }
        }

        if(minVal!=INF) bw.write(minVal+"\n");
        else bw.write(-1+"\n");
        bw.flush();
        bw.close();
    }
}
