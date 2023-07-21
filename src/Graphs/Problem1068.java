package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem1068 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];
    static int count=0;
    static int removeNode;
    static int root=0;
    static int parent[];

    static void dfs(int x){
        visited[x]=true;

        if(graph.get(x).size()==0) count++;
        for(Integer a : graph.get(x)){
            if(visited[a]==false){
                dfs(a);
            }
        }
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N];
        parent = new int[N];
        for(int i=0;i<N;++i){
            parent[i]=i;
        }
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;++i){
            int temp = Integer.parseInt(st.nextToken());
            parent[i]=temp;
            if(temp==-1) root=i;
            else graph.get(temp).add(i);
        }

        removeNode = Integer.parseInt(br.readLine());
        if(removeNode!=root){
            graph.get(parent[removeNode]).remove(Integer.valueOf(removeNode));
            dfs(root);
        }

        System.out.println(count);
    }
}
