// https://www.acmicpc.net/problem/2294
// 동전 2, Gold5
// 2023년 8월 27일
// 통과

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int INF=(int)1e9;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int coins[] = new int[n];

        int d[] = new int[k+1];
        for (int i = 0; i < n; ++i) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(d,INF);

        d[0]=0;
        for(int i=1;i<=k;++i){
            for(int x:coins){
                if(i>=x) d[i]=Math.min(d[i],d[i-x]+1);
            }
        }

        if(d[k]!=INF) bw.write(d[k]+"\n");
        else bw.write(-1+"\n");
        bw.flush();
        bw.close();
    }
}


//import java.io.*;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Main{
//    static int n,k;
//    static class Node implements Comparable<Node>{
//        int count;
//        int cost;
//
//        public Node(int count,int cost){
//            this.count=count;
//            this.cost=cost;
//        }
//
//        @Override
//        public int compareTo(Node o){
//            if(this.count<o.count) return -1;
//            else if(this.count>o.count) return 1;
//            else return 0;
//        }
//    }
//
//    static int minVal=0;
//    static int coin[];
//    static void bfs(int count, int cost){
//        PriorityQueue<Node> q = new PriorityQueue<>();
//        Node node = new Node(count,cost);
//        q.offer(node);
//
//        while(!q.isEmpty()){
//            Node now = q.poll();
//
//            if(now.cost==k){
//                minVal=now.count;
//                break;
//            }
//
//            for(int i=0;i<n;++i){
//                Node newNode = new Node(now.count+1,now.cost+coin[i]);
//                q.offer(newNode);
//            }
//        }
//    }
//
//    public static void main(String args[]) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
//
//        coin = new int[n];
//        for(int i=0;i<n;++i){
//            coin[i]=Integer.parseInt(br.readLine());
//        }
//
//        bfs(0,0);
//        bw.write(minVal+"\n");
//        bw.flush();
//        bw.close();
//    }
//}