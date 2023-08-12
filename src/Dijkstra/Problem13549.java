// https://www.acmicpc.net/problem/13549
// 숨바꼭질 3, Gold5
// 2023년 8월 11일
// 통과

package Dijkstra;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem13549 {
    static int N,K;
    static int MAX_COUNT=100001;
    static boolean visited[]=new boolean[MAX_COUNT];

    static class Pos implements Comparable<Pos>{
        int index;
        int cost;

        public int getIndex(){
            return this.index;
        }

        public int getCost(){
            return this.cost;
        }

        public Pos(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o) {
            if(this.cost<o.cost) return -1;
            else return 1;
        }
    }
    static int dijkstra(int start){
        PriorityQueue<Pos> q = new PriorityQueue<>();
        q.offer(new Pos(start,0));
        int result=0;

        while(!q.isEmpty()){
            Pos temp = q.poll();
            int now = temp.getIndex();
            visited[now]=true;

            if(now==K){
                result=temp.getCost();
                break;
            }

            if(now*2<MAX_COUNT && !visited[now*2]){
                int cost=temp.getCost();
                q.offer(new Pos(now*2,cost));
            }
            if(now-1>=0 && now-1<MAX_COUNT && !visited[now-1]){
                int cost=temp.getCost()+1;
                q.offer(new Pos(now-1,cost));
            }
            if(now+1<MAX_COUNT && !visited[now+1]){
                int cost=temp.getCost()+1;
                q.offer(new Pos(now+1,cost));
            }
        }
        return result;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(N)+"\n");
        bw.flush();
        bw.close();
    }
}
