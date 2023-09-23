// https://www.acmicpc.net/problem/2573
// 빙산, Gold4
// 2023년 9월 23일
// 통과

package Implementation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2573{
    static int N,M;
    static int graph[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static boolean visited[][];
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean bfs(int x,int y){
        if(graph[x][y]==0 || visited[x][y]==true) return false;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y]=true;
        int map[][] = new int[N][M];

        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].length; j++) {
                map[i][j] = graph[i][j];
            }
        }

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i=0;i<4;++i){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

                if(map[nx][ny]!=0 && visited[nx][ny]==false){
                    visited[nx][ny]=true;
                    q.offer(new Node(nx,ny));
                }
                else if(map[nx][ny]==0){
                    if(graph[now.x][now.y]>0) --graph[now.x][now.y];
                }
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int lumpCount=9999999;
        int round=0;
        boolean success=false;
        while(lumpCount!=0){

            visited = new boolean[N][M];
            lumpCount=0;
            for(int i=0;i<N;++i){
                for(int j=0;j<M;++j){
                    if(bfs(i,j)){
                        ++lumpCount;

                    }
                }
            }

            ++round;

//            System.out.println("=====round"+round+"==========");
//            for(int k=0;k<N;++k){
//                for(int l=0;l<M;++l){
//                    System.out.print(graph[k][l]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("lumpCount="+lumpCount);
//            System.out.println("-------------------------");
            if(lumpCount>=2){
                success=true;
                break;
            }
        }

        if(success) bw.write(round-1+"\n");
        else bw.write("0\n");
        bw.flush();
        bw.close();
    }
}