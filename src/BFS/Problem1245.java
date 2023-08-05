// https://www.acmicpc.net/problem/1245
// 농장 관리, Gold5
// 2023년 8월 5일
// 통과

package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1245 {

    static int N,M;
    static int graph[][];
    static boolean visited[][];

    static int dx[]={-1,-1,0,1,1,1,0,-1};
    static int dy[]={0,1,1,1,0,-1,-1,-1};
    static boolean condition;

    static class Pos{
        int x;
        int y;
        public Pos(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static void bfs(int x,int y){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x,y));
        visited[x][y]=true;
        while(!q.isEmpty()){
            Pos now = q.poll();
            for(int i=0;i<8;++i){
                int mx=now.x+dx[i];
                int my=now.y+dy[i];
                if(mx>=0 && mx<N && my>=0 && my<M){
                    if(graph[now.x][now.y]<graph[mx][my]){
                        condition=false;
                    }
                    if(!visited[mx][my] && graph[now.x][now.y]==graph[mx][my]){
                        visited[mx][my]=true;
                        q.offer(new Pos(mx,my));
                    }
                }
            }
        }

    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        graph=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;++i){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int resultCount=0;
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                if(!visited[i][j]){
                    condition=true;
                    bfs(i,j);
                    if(condition) ++resultCount;
                }
            }
        }
        System.out.println(resultCount);
    }
}
