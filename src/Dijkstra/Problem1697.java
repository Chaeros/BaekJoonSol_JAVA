// https://www.acmicpc.net/problem/1697
// 숨바꼭질, Silver
// 2023년 8월 15일
// 통과

package Dijkstra;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1697 {
    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost){
            this.index=index;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost<o.cost) return -1;
            else return 1;
        }
    }

    static int N,K;
    static int result=0;
    static boolean visited[];

    static void dijkstar(Node startNode){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(startNode);

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.index==K){
                result=now.cost;
                break;
            }

            if(visited[now.index]) continue;
            visited[now.index]=true;

            if(now.index-1>=0) q.offer(new Node(now.index-1,now.cost+1));
            if(now.index+1<200001) q.offer(new Node(now.index+1,now.cost+1));
            if(now.index*2<200001) q.offer(new Node(now.index*2,now.cost+1));
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[200001];
        Node startNode = new Node(N,0);
        dijkstar(startNode);

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
