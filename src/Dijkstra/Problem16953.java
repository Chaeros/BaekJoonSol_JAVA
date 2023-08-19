// https://www.acmicpc.net/problem/16953
// A->B, Silver2
// 2023년 8월 19일
// 통과

package Dijkstra;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem16953{

    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index,int cost){
            this.index=index;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost<o.cost) return -1;
            else return 1;
        }
    }
    static int A,B;
    static int MAX_VAL=1000000001;
    static boolean visited[] = new boolean[MAX_VAL];

    static int bfs(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,1));

        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.index]=true;
            //System.out.println("index="+now.index+","+"cost="+now.cost);
            if(now.index==B){
                return now.cost;
            }

            if(now.index<MAX_VAL/2+1 && !visited[now.index*2]) q.offer(new Node(now.index*2,now.cost+1));
            if(now.index<MAX_VAL/10+1 && !visited[now.index*10+1]) q.offer(new Node(now.index*10+1,now.cost+1));
        }
        return -1;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        bw.write(bfs(A)+"\n");
        bw.flush();
        bw.close();
    }
}