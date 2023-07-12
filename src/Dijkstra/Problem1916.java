// https://www.acmicpc.net/problem/1916
// 최소비용 구하기 Gold5
// 2023년 7월 12일
package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.String.valueOf;

public class Problem1916 {

    static LinkedList<LinkedList<Node>> graph;
    static int distance[];
    static boolean visited[];

    static class Node implements Comparable<Node>{
        int index;
        int distance;

        public Node(int index,int distance){
            this.index=index;
            this.distance=distance;
        }

        int getIndex(){
            return this.index;
        }
        int getDistance(){
            return this.distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance>node.getDistance()?1:-1;  //오름차순
        }
    }

    static private void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        distance[start]=0;

        while(!pq.isEmpty()){

            Node tempNode = pq.poll();
            int now=tempNode.getIndex();

            if(visited[now])  continue;

            visited[now]=true;
            for(Node node : graph.get(now)){
                if(!visited[node.getIndex()] && distance[node.getIndex()]>distance[now]+node.getDistance()){
                    distance[node.getIndex()]=distance[now]+node.getDistance();
                    pq.offer(new Node(node.getIndex(),distance[node.getIndex()]));
                }
            }
        }
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        graph=new LinkedList<>();
        distance = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0;i<=N;++i){
            graph.add(new LinkedList());
            distance[i]=987654321;
        }

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int sp=Integer.parseInt(st.nextToken());
            int objective=Integer.parseInt(st.nextToken());
            int distance=Integer.parseInt(st.nextToken());
            graph.get(sp).add(new Node(objective,distance));
        }

        st = new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int objective=Integer.parseInt(st.nextToken());
        dijkstra(start);

        bw.write(valueOf(distance[objective]));
        bw.flush();
        bw.close();
    }
}