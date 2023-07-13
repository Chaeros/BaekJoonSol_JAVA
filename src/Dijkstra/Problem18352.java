package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

import static java.lang.String.valueOf;

public class Problem18352 {

    static ArrayList<ArrayList<Node>> graph=new ArrayList<>();
    static int N,M,K,X;
    static boolean visited[];
    static int dist[];
    static final int INF=987654321;

    static class Node implements Comparable<Node>{
        int number;
        int weight;

        public int getNumber() {
            return number;
        }

        public int getWeight() {
            return weight;
        }

        public Node(int number, int weight){
            this.number=number;
            this.weight=weight;
        }

        @Override
        public int compareTo(Node node){
            return this.weight>node.weight?1:-1;
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,1));
        dist[start]=0;

        while(!pq.isEmpty()){
            Node tempNode=pq.poll();
            int now=tempNode.getNumber();

            if(visited[now]) continue;

            visited[now]=true;
            for(Node i:graph.get(now)){
                if(!visited[i.getNumber()] && dist[i.getNumber()]>dist[now]+1){
                    dist[i.getNumber()]=dist[now]+1;
                    pq.offer(new Node(i.getNumber(),dist[i.getNumber()]));
                }
            }
        }
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());

        visited=new boolean[N+1];
        dist=new int[N+1];

        for(int i=0;i<N+1;++i){
            graph.add(new ArrayList<>());
        }
        Arrays.fill(dist,INF);

        for(int i=0;i<M;++i){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end,1));
        }

        dijkstra(X);

        for(int i=0;i<dist.length;++i){
            if(dist[i]==K){
                sb.append(i).append('\n');
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sb);
        }
    }
}
