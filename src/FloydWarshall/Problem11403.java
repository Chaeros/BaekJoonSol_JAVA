package FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.String.valueOf;

public class Problem11403 {

    static int graph[][];
    static final int INF = 987654321;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N=Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for(int i=0;i<N;++i)
            Arrays.fill(graph[i],INF);

        for(int i=0;i<N;++i){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                if(st.nextToken().equals("1"))
                    graph[i][j]=1;
            }
        }

        for(int i=0;i<N;++i)
            for(int j=0;j<N;++j)
                for(int k=0;k<N;++k)
                    graph[j][k]=Math.min(graph[j][k],graph[j][i]+graph[i][k]);

        for(int i=0;i<N;++i) {
            for (int j = 0; j < N; ++j) {
                if (graph[i][j] == INF) sb.append(0).append(' ');
                else sb.append(1).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(valueOf(sb));
    }
}
