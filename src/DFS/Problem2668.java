// https://www.acmicpc.net/problem/2668
// 숫자 고르기, Gold5

package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2668 {

    static boolean visited[];
    static int graph[];
    static TreeSet<Integer> result = new TreeSet<>();
    static LinkedList<Integer> temp = new LinkedList<>();

    static void dfs(int x){
        visited[x]=true;
        temp.add(x);

        if(temp.get(0)==graph[x]){
            result.addAll(temp);
            return;
        }

        if(!visited[graph[x]]){
            dfs(graph[x]);
        }
    }


    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        visited=new boolean[N+1];
        graph=new int[N+1];

        for(int i=1;i<N+1;++i){
            graph[i]=Integer.parseInt(br.readLine());
        }

        for(int i=1;i<N+1;++i){
            temp.clear();
            Arrays.fill(visited,false);
            dfs(i);
        }

        System.out.println(result.size());
        for(Integer x:result){
            System.out.println(x);
        }
    }
}
