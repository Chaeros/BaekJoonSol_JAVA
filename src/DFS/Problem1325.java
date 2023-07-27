// https://www.acmicpc.net/problem/1325
// 효율적인 해킹, Silver1
// 2023년 7월 27일
// 불합

package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Problem1325 {
    static boolean visited[];
    static ArrayList<Integer>[] graph;
    static int hackCount[];

    static void dfs(int x){
        visited[x]=true;
        for(int a : graph[x]){
            if(!visited[a]){
                ++hackCount[a];
                dfs(a);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        hackCount=new int[N+1];
        graph=new ArrayList[N+1];
        for(int i=0;i<N+1;++i){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<M;++i){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        for(int i=1;i<N+1;++i){
            visited=new boolean[N+1];
            dfs(i);
        }

        int max=0;
        for(int i=1;i<N+1;++i){
            if (max < hackCount[i]) {
                max = hackCount[i];
            }
        }

        for(int i=1;i<N+1;++i){
            if(max==hackCount[i]) sb.append(i+" ");
        }
        System.out.println(sb);
    }
}
