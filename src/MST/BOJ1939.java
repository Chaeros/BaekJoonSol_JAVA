// https://www.acmicpc.net/problem/1939
// 중량제한, Gold3
// 2023년 10월 31일
// 통과

package MST;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1939 {

    static int N,M;

    static class Node implements Comparable<Node>{
        int start;
        int objective;
        int weight;

        public Node(int start, int objective, int weight) {
            this.start = start;
            this.objective = objective;
            this.weight =weight;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight>o.weight) return -1; // 내림차순
            else return 1;
        }
    }

    static int parent[];

    static int find_parent(int x){
        if(parent[x]==x) return x;
        return parent[x] = find_parent(parent[x]);
    }

    static void union(int a,int b){
        int aRoot = find_parent(a);
        int bRoot = find_parent(b);

        if(aRoot<bRoot){
            parent[bRoot]=aRoot;
        }
        else{
            parent[aRoot]=bRoot;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        parent = new int[N+1];

        for(int i=0;i<=N;++i){
            parent[i]=i;
        }

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Node node = new Node(a,b,c);
            queue.offer(node);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while(!queue.isEmpty()){
            Node now = queue.poll();
            int start =now.start;
            int objective = now.objective;
            union(start,objective);

            if(find_parent(a)==find_parent(b)){
                bw.write(now.weight+"\n");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
