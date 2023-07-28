// https://www.acmicpc.net/problem/4963
// 섬의 개수, Silver2
// 2023년 7월 28일
// 통과

package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem4963 {

    static int graph[][];
    static boolean[][] visited;

    static int dx[]= {-1,-1,0,1,1,1,0,-1};
    static int dy[]= {0,1,1,1,0,-1,-1,-1};
    static int w,h;

    static class Square{
        int x;
        int y;
        Square(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static boolean bfs(int x,int y){
        Queue<Square> q = new LinkedList<>();
        int tempCount=0;
        if(graph[x][y]==1 && visited[x][y]==false) tempCount++;
        visited[x][y]=true;
        Square square = new Square(x,y);
        q.offer(square);

        while(!q.isEmpty()){
            Square now = q.poll();
            for(int i=0;i<8;++i){
                int mx=now.x+dx[i];
                int my=now.y+dy[i];
                if(mx>=0 && mx<h && my>=0 && my<w){
                    if(!visited[mx][my] && graph[mx][my]==1){
                        Square s = new Square(mx,my);
                        visited[mx][my]=true;
                        q.offer(s);
                        tempCount++;
                    }
                }
            }
        }
        if(tempCount==0) return false;
        else return true;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;

            visited = new boolean[h][w];
            graph=new int[h][w];
            for(int i=0;i<h;++i){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<w;++j){
                    graph[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            int count=0;
            for(int i=0;i<h;++i){
                for(int j=0;j<w;++j){
                    if(bfs(i,j)) count++;
                }
            }
            System.out.println(count);
        }

    }
}
