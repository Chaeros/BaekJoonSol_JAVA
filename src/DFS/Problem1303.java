// https://www.acmicpc.net/problem/1303
// 전쟁-전투, Silver1
// 2023년 8월 7일
// 미제출

package DFS;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1303 {
    static int N,M;
    static int graph[][];
    static boolean visited[][];
    static int dx[]={-1,0,1,0};
    static int dy[]={0,1,0,-1};
    static int count;

    static void dfs(int x,int y){
        visited[x][y]=true;
        for(int i=0;i<4;++i){
            int mx=x+dx[i];
            int my=y+dy[i];

            if(mx>=0 && mx<M && my>=0 && my<N){
                if(!visited[mx][my] && graph[x][y]==graph[mx][my]){
                    dfs(mx,my);
                    ++count;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph=new int[M][N];
        visited=new boolean[M][N];

        for(int i=0;i<M;++i){
            String str = br.readLine();
            for(int j=0;j<N;++j){
                graph[i][j]=str.charAt(j);
            }
        }

        int whitePower=0;
        int bluePower=0;
        for(int i=0;i<M;++i){
            for(int j=0;j<N;++j){
                count=0;
                if(!visited[i][j]){
                    dfs(i,j);
                    ++count;
                }
                if(graph[i][j]=='W') whitePower+=(int)Math.pow(count,2);
                else bluePower+=(int)Math.pow(count,2);
            }
        }
        bw.write(whitePower+" "+bluePower);
        bw.flush();
        bw.close();
    }
}
