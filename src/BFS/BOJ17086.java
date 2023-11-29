// https://www.acmicpc.net/problem/17086
// 아기상어2, Silver2
// 2023년 11월 30일
// 통과

package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086 {

    public static int N,M;
    public static int map[][];

    public static int dx[] = {-1,-1,0,1,1,1,0,-1};
    public static int dy[] = {0,1,1,1,0,-1,-1,-1};
    public static int result=0;

    public static void bfs(int x,int y){
        if(map[x][y]==1) return;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        boolean visited[][] = new boolean[N][M];
        visited[x][y]=true;
        int distance[][] = new int[N][M];

        while(!q.isEmpty()){
            int now[] = q.poll();

            for(int i=0;i<8;++i){
                int mx = now[0]+dx[i];
                int my = now[1]+dy[i];

                if(mx<0 || mx>=N || my<0 || my>=M) continue;
                if(visited[mx][my]) continue;

                distance[mx][my]=distance[now[0]][now[1]]+1;
                if(map[mx][my]==1){
                    result=Math.max(result,distance[mx][my]);
                    return;
                }

                visited[mx][my]=true;
                q.offer(new int[]{mx,my});
            }
        }
    }

    public static void printMap(int tempMap[][]){
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                System.out.print(tempMap[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                bfs(i,j);
            }
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
