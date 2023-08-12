// https://www.acmicpc.net/problem/5972
// 택배 배송, Gold5
// 2023년 8월 12일
// 통과

package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem5972 {

    static class Node implements Comparable<Node>{
        int objective;
        int cost;

        public int getObjective() {
            return objective;
        }

        public int getCost() {
            return cost;
        }

        public Node(int objective, int cost) {
            this.objective = objective;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost<o.cost) return -1;
            else return 1;
        }

    }

    static ArrayList<ArrayList<Node>> graph= new ArrayList<>();
    static int distance[];
    static boolean visited[];

    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        distance[start]=0;

        while(!q.isEmpty()){
            Node temp = q.poll();
            int now = temp.getObjective();

            if(visited[now]) continue;

            visited[now]=true;
            for(Node node:graph.get(now)){
                if(distance[node.getObjective()]>distance[now]+node.getCost()){
                    distance[node.getObjective()]=distance[now]+node.getCost();
                    q.offer(new Node(node.getObjective(),distance[node.getObjective()]));
                }
            }
        }
    }
    public static void main(String agrs[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<N+1;++i){
            graph.add(new ArrayList<>());
            distance[i]=(int)1e9;
        }

        for(int i=0;i<M;++i){
            st=new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            Node node = new Node(B,C);
            graph.get(A).add(node);
            Node node2 = new Node(A,C);
            graph.get(B).add(node2);
        }

        dijkstra(1);

        bw.write(distance[N]+"\n");
        bw.flush();
        bw.close();
    }
}