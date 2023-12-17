// https://www.acmicpc.net/problem/11724
// 연결 요소의 개수, Silver2
// 2023년 12월 17일
// 통과

package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int N,M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int x:graph.get(now)){
                if(!visited[x]){
                    visited[x]=true;
                    q.offer(x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;++i){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N+1];

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result=0;
        for(int i=1;i<=N;++i){
            if(!visited[i]){
                bfs(i);
                ++result;
            }
        }

        if(N==1 && M==0) result=1;
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
