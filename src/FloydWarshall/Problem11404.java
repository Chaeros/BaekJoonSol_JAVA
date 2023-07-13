// https://www.acmicpc.net/problem/11404
// 플로이드 Gold4
// 2023년 7월 13일

package FloydWarshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.String.valueOf;

public class Problem11404 {

    static int[][] graph=new int[100][100];
    static final int INF = 987654321;
    static int n,m;

    static void floydWarshall(){
        for(int i=0;i<n;++i)
            for(int j=0;j<n;++j)
                for(int k=0;k<n;++k)
                    graph[j][k]=Math.min(graph[j][k],graph[j][i]+graph[i][k]);
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i=0;i<n;++i) Arrays.fill(graph[i],INF);
        for(int i=0;i<n;++i) graph[i][i]=0;

        for(int i=0;i<m;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a-1][b-1]=Math.min(graph[a-1][b-1],c);
        }

        floydWarshall();

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(graph[i][j]==INF) sb.append(0).append(' ');
                else sb.append(graph[i][j]).append(' ');
            }
            sb.append("\n");
        }
        bw.write(valueOf(sb));
        bw.flush();
        bw.close();
    }
}
