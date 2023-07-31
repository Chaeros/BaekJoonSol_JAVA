// https://www.acmicpc.net/problem/11725
// 트리의 부모 찾기, Silver2
// 2023년 7월 31일
// 통과

package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11725 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean visited[];
    static int parent[];

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while(!q.isEmpty()){
            int now=q.poll();
            for(int a:graph.get(now)){
                if(!visited[a]){
                    visited[a]=true;
                    parent[a]=now;
                    q.offer(a);
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N+1;++i){
            graph.add(new ArrayList<Integer>());
        }
        visited=new boolean[N+1];
        parent=new int[N+1];

        for(int i=0;i<N-1;++i){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        for(int i=2;i<N+1;++i){
            System.out.println(parent[i]);
        }
    }
}
