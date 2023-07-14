package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1707 {

    static ArrayList<ArrayList<Integer>> graph;
    static int color[];

    static boolean bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        color[x]=1;
        q.offer(x);

        while(!q.isEmpty()){
            int val=q.poll();
            for(int i=0;i<graph.get(val).size();++i){
                if(color[val]==color[graph.get(val).get(i)]) return false;

                if(color[graph.get(val).get(i)]==0){
                    color[graph.get(val).get(i)]=color[val]*-1;
                    q.offer(graph.get(val).get(i));
                }
            }
        }
        return true;
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K=Integer.parseInt(st.nextToken());
        for(int i=0;i<K;++i){
            st=new StringTokenizer(br.readLine());
            int V=Integer.parseInt(st.nextToken());
            int E=Integer.parseInt(st.nextToken());

            graph=new ArrayList<>();
            for(int j=0;j<V+1;++j){
                graph.add(new ArrayList<>());
            }
            color=new int[V+1];

            for(int j=0;j<E;++j){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
            }

            boolean check=true;
            for(int j=1;j<V+1;++j) {
                if (color[i] == 0) {
                    check = bfs(i);
                    if(check==false) {
                        break;
                    }
                }
            }
            if(check==true) System.out.println("YES");
            else System.out.println("NO");
            graph.clear();
        }
    }
}
