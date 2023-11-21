// https://www.acmicpc.net/problem/2644
// 촌수계산, Silver2
// 2023년 11월 12일
// 통과

package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {

    static int N,M;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean visited[];
    static int distance[];

    static int bfs(int start,int end){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int x:list.get(now)){
                if(visited[x]) continue;
                distance[x]=distance[now]+1;
                if(x==end){
                    return distance[x];
                }
                visited[x]=true;
                q.offer(x);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;++i){
            list.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        distance = new int[N+1];

        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        bw.write(bfs(p1,p2)+"\n");
        bw.flush();
        bw.close();
    }
}
