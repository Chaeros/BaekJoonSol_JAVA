// https://www.acmicpc.net/problem/1753
// 최단경로, Gold4
// 2023년 8월 10일
// 통과

package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1753 {
    static class Node implements Comparable<Node>{
        int objective;
        int cost;

        public Node(int objective, int cost){
            this.objective=objective;
            this.cost=cost;
        }

        public int getObjective() {
            return objective;
        }

        public int getCost() {
            return cost;
        }

        // cost기준 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            if(this.cost<o.cost) return -1;
            else return 1;
        }
    }
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int distance[];
    static int INF = (int)1e9;

    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        distance[start]=0;

        while(!q.isEmpty()){
            Node temp = q.poll();
            int now = temp.getObjective();

            if(distance[now]<temp.getCost()) continue;

            for(Node node:graph.get(now)){
                if(distance[node.getObjective()]>
                    distance[now]+node.getCost()){
                    distance[node.getObjective()]=distance[now]+node.getCost();
                    q.offer(new Node(node.getObjective(),distance[node.getObjective()]));
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        distance = new int[V+1];
        for(int i=0;i<V+1;++i){
            graph.add(new ArrayList<Node>());
            distance[i]=INF;
        }

        for(int i=0;i<E;++i){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,cost));
        }

        dijkstra(start);
        for(int i=1;i<V+1;++i){
            if(distance[i]==(int)1e9) bw.write("INF\n");
            else bw.write(distance[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
