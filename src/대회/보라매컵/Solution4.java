package 대회.보라매컵;

// 3번

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    static int width,height;
    static int map[][];

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

    static int bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y]=true;
        int count=0;

        while(q.isEmpty()){
            Node now = q.poll();

            for(int i=0;i<4;++i){
                int mx = now.x+dx[i];
                int my = now.y+dy[i];

                if(mx>width || mx<0 || my>height || my<0) continue;
                if(visited[mx][my]) continue;
                if(map[now.x][now.y]!=map[mx][my]) continue;
                visited[mx][my]=true;
                q.offer(new Node(mx,my));
                count++;
            }
        }

        if(map[x][y]==0){
            return count;
        }
        else{
            return count;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        width = Integer.parseInt(br.readLine());
        height = Integer.parseInt(br.readLine());

        map = new int[height][width];
        visited = new boolean[height][width];

        for(int i=0;i<height;++i){
            String str = br.readLine();
            for(int j=0;j<width;++j){
                map[i][j]=Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }



    }
}
