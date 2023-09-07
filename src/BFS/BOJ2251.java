// https://www.acmicpc.net/problem/2251
// 물통, Gold5
// 2023년 9월 4일
// 통과

package BFS;


import java.io.*;
import java.util.*;

public class BOJ2251 {
    static int A,B,C;
    static class Node{
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static boolean visited[][];
    static TreeSet<Integer> set = new TreeSet<>();

    static boolean pour(int x,int y){
        if(!visited[x][y]){
            visited[x][y]=true;
            return true;
        }
        return false;
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,C));
        visited[0][0]=true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.x==0){
                set.add(now.z);
            }

            // x->y
            int water = Math.min(now.x,B-now.y);
            if(pour(now.x-water,now.y+water)){
                q.offer(new Node(now.x-water,now.y+water,C-(now.x-water)-(now.y+water)));
            }

            // x->z
            water = Math.min(now.x,C-now.z);
            if(pour(now.x-water,now.y)){
                q.offer(new Node(now.x-water,now.y,now.z+water));
            }

            // y->x
            water = Math.min(now.y,A-now.x);
            if(pour(now.x+water,now.y-water)){
                q.offer(new Node(now.x+water,now.y-water,C-(now.x+water)-(now.y-water)));
            }

            // y->z
            water = Math.min(now.y,C-now.z);
            if(pour(now.x, now.y-water)){
                q.offer(new Node(now.x, now.y-water,C-now.x-(now.y-water)));
            }

            // z->x
            water = Math.min(now.z,A-now.x);
            if(pour(now.x+water,now.y)){
                q.offer(new Node(now.x+water,now.y,C-(now.x+water)-now.y));
            }

            // z->y
            water = Math.min(now.z,B-now.y);
            if(pour(now.x,now.y+water)){
                q.offer(new Node(now.x,now.y+water,C-now.x-(now.y+water)));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[A+1][B+1];

        bfs();

        for(int x:set){
            bw.write(x+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
