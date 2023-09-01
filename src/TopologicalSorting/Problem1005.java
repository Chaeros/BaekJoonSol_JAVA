// https://www.acmicpc.net/problem/1005
// ACM Craft, Gold3
// 2023년 9월 1일
// 통과

package TopologicalSorting;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1005 {
    static int N,K;
    static int graph[];
    static int indegree[];
    static int result[];
    static ArrayList<ArrayList<Integer>> list;

    static void topology(int objective){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;++i){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int x:list.get(now)){
                --indegree[x];
                if(indegree[x]==0){
                    q.offer(x);
                }
                result[x]=Math.max(result[x],result[now]+graph[x]);
            }
        }
    }
    public static void main(String argsp[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;++t){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            list.add(new ArrayList<>());

            graph = new int[N+1];
            indegree = new int[N+1];
            result = new int[N+1];
            st=new StringTokenizer(br.readLine());
            for(int i=1;i<=N;++i){
                graph[i]=Integer.parseInt(st.nextToken());
                list.add(new ArrayList<>());
                result[i]=graph[i];
            }
            for(int i=0;i<K;++i){
                st=new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                ++indegree[b];
            }

            int victoryBuilding = Integer.parseInt(br.readLine());
            topology(victoryBuilding);
            bw.write(result[victoryBuilding]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
