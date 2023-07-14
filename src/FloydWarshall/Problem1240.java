package FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1240 {

    static int[][] graph;
    static final int INF=987654321;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        graph=new int[N][N];
        for(int i=0;i<N;++i)
            Arrays.fill(graph[i],INF);
        for(int i=0;i<N;++i)
            graph[i][i]=0;

        for(int i=0;i<N-1;++i){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph[a-1][b-1]=c;
            graph[b-1][a-1]=c;
        }

        for(int k=0;k<N;++k)
            for(int i=0;i<N;++i)
                for(int j=0;j<N;++j)
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);

        for(int i=0;i<M;++i){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            System.out.println(graph[start-1][end-1]);
        }
    }
}