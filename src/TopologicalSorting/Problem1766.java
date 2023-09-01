// https://www.acmicpc.net/problem/1766
// 문제집, Gold2
// 2023년 9월 1일
// 통과

package TopologicalSorting;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1766{
    static int N,M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int indegree[];

    static void topology(){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1;i<=N;++i){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now+" ");
            for(int index:graph.get(now)){
                --indegree[index];
                if(indegree[index] == 0){
                    q.offer(index);
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N==1){
            for(int i=0;i<M;++i) {
                st = new StringTokenizer(br.readLine());
            }
            bw.write(1+"\n");
            bw.flush();
            bw.close();
            return;
        }

        for(int i=0;i<=N;++i){
            graph.add(new ArrayList<>());
        }
        indegree = new int[N+1];


        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            ++indegree[B];
        }
        topology();
    }
}