// https://www.acmicpc.net/problem/16398
// 행성 연결, Gold4
// 2023년 9월 14일
// 통과

package MST;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16398{
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost<o.cost) return -1;
            else if(this.cost>o.cost) return 1;
            return 0;
        }
    }
    static PriorityQueue<Node> q = new PriorityQueue<>();
    static int parent[];
    static int find_parnet(int x){
        if(parent[x]==x) return x;
        else return parent[x] = find_parnet(parent[x]);
    }
    static void union_parent(int a,int b){
        a=find_parnet(a);
        b=find_parnet(b);
        if(a>b) parent[a]=b;
        else parent[b]=a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        parent = new int[T];

        for(int i=0;i<T;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;++j) st.nextToken();
            for(int j=i+1;j<T;++j){
                int cost = Integer.parseInt(st.nextToken());
                q.offer(new Node(i,j,cost));
            }
            parent[i]=i;
        }

        long resultSum=0;
        int flowCount=0;
        while(!q.isEmpty()){
            Node now = q.poll();

            if(flowCount==T-1) break;

            if(find_parnet(now.start)!=find_parnet(now.end)){
                union_parent(now.start,now.end);
                resultSum+=now.cost;
                ++flowCount;
            }
        }

        bw.write(resultSum+"\n");
        bw.flush();
        bw.close();
    }
}