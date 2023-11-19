package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1446 {

    static class Node implements Comparable<Node>{
        int start;
        int objective;
        int cost;

        public Node(int start, int objective,int cost){
            this.start=start;
            this.objective=objective;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o){
            if(this.start-o.start<0) return -1;
            else return 1;
        }
    }

    static int N,D;
    static ArrayList<Node> list = new ArrayList<>();
    static int distant[];
    static int INF = (int)1e9;

    static void dijkstra(int start){
        distant[start]=0;
        int move =0;
        int index=0;

        while(move<D){
            if(index<list.size()){
                Node node = list.get(index);
                if(move==node.start){
                    distant[node.objective]=Math.min(distant[node.objective],distant[node.start]+node.cost);
                    index++;
                }
                else{
                    distant[move+1]=Math.min(distant[move+1],distant[move]+1);
                    move++;
                }
            }
            else{
                distant[move+1]=Math.min(distant[move+1],distant[move]+1);
                move++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        distant = new int[D+1];
        for(int i=0;i<D+1;++i){
            distant[i]=INF;
        }

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(end>D) continue;
            if(end-start>cost) list.add(new Node(start,end,cost));
        }
        Collections.sort(list);
        dijkstra(0);

        bw.write(distant[D]+"\n");
        bw.flush();
        bw.close();
    }
}
