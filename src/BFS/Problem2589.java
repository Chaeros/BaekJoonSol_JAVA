// https://www.acmicpc.net/problem/2589
// 보물섬, Gold5
// 2023년 8월 30일
// 통과

package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2589{
    static int row,column;
    static char graph[][];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int longestDistance=0;
    static void bfs(int x,int y){
        int visited[][] = new int[row][column];
        visited[x][y]=1;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x,y));

        while(!q.isEmpty()){
            Pos now = q.poll();
            for(int i=0;i<4;++i){
                int mx = now.x+dx[i];
                int my = now.y+dy[i];
                if(mx>=0 && mx<row && my>=0 && my<column){
                    if(graph[mx][my]=='L' && visited[mx][my]==0){
                        visited[mx][my]=visited[now.x][now.y]+1;
                        longestDistance=Math.max(longestDistance,visited[mx][my]);
                        q.offer(new Pos(mx,my));
                    }
                }

            }
        }

//        System.out.println("<<x="+x+", y="+y+">>");
//        for(int i=0;i<row;++i){
//            for(int j=0;j<column;++j){
//                System.out.print(visited[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println();
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        graph = new char[row][column];;
        for(int i=0;i<row;++i){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<column;++j){
                graph[i][j]=str.charAt(j);
            }
        }

        for(int i=0;i<row;++i){
            for(int j=0;j<column;++j){
                if(graph[i][j]=='L') bfs(i,j);
            }
        }

        bw.write(longestDistance-1+"\n");
        bw.flush();
        bw.close();
    }
}