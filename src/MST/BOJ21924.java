// https://www.acmicpc.net/problem/21924
// 도시 건설, Gold4
// 2023년 10월 22일
// 통과

package MST;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ21924 {

    static class Node implements Comparable<Node>{
        int start;
        int objective;
        int distance;

        public Node(int start, int objective, int distance) {
            this.start = start;
            this.objective = objective;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance<o.distance) return -1;
            else return 1;
        }
    }

    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    static int parent[];

    static int findParent(int x){
        if(parent[x]==x){
            return x;
        }
        return findParent(parent[x]);
    }

    static void union(int a, int b){
        int a_parent = findParent(a);
        int b_parent = findParent(b);

        if(a_parent>b_parent){
            parent[a_parent]=b_parent;
        }
        else{
            parent[b_parent]=a_parent;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1;i<=N;++i){
            parent[i]=i;
        }

        long sum=0;
        for(int m=0;m<M;++m){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            priorityQueue.offer(new Node(a,b,c));
            sum+=c;
        }

        long result=0;
        int lineCount=0;
        while(!priorityQueue.isEmpty()){
            Node now = priorityQueue.poll();
            int a = now.start;
            int b = now.objective;

            if(findParent(a)!=findParent(b)){
                union(a,b);
                result+=now.distance;
                ++lineCount;
            }
        }

        if(lineCount!=N-1) bw.write("-1\n");
        else bw.write(sum-result+"\n");
        bw.flush();
        bw.close();
    }
}
