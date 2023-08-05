// https://www.acmicpc.net/problem/1926
// 그림, Silver1
// 2023년 8월 5일
// 통과

package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1926 {

    static int n,m;
    static int graph[][];
    static boolean visited[][];
    static int dx[]={-1,0,1,0};
    static int dy[]={0,1,0,-1};
    static int count=0;
    static int maxCount=0;

    static void dfs(int x,int y){
        if(!visited[x][y] && graph[x][y]==1){
            visited[x][y]=true;
            ++count;
            if(maxCount<count) maxCount=count;

            for(int i=0;i<4;++i){
                int mx=x+dx[i];
                int my=y+dy[i];
                if(mx>=0 && mx<n && my>=0 && my<m){
                    dfs(mx,my);
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;++i){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;++j){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int paintingCount=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                count=0;
                dfs(i,j);
                if(count!=0) ++paintingCount;
            }
        }
        System.out.println(paintingCount);
        System.out.println(maxCount);
    }
}
