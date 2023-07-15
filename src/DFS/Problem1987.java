//https://www.acmicpc.net/problem/1987
// 알파벳, Gold4
//2023년 7월 15일

package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1987 {

    static ArrayList<String> graph;
    static int R,C;
    static int visited[][];
    static Queue<Character> q = new LinkedList<>();
    static int nx[] = {-1,0,1,0};
    static int ny[] = {0,1,0,-1};

    static int dfs(int x,int y){
        visited[x][y]=1;
        q.offer(graph.get(x).charAt(y));

        for(int i=0;i<graph.get(x).length();i++){

        }

        return 0;

    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new int[R][C];
        graph=new ArrayList<>();
        for(int i=0;i<R;i++)
        {
            graph.add(br.readLine());
        }
    }
}
