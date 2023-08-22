// https://www.acmicpc.net/problem/13023
// ABCDE, Gold5
// 2023년 8월 22일
// 통과

package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem13023 {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static boolean visited[];
    static boolean result;
    static void dfs(int start, int depth){
        if(depth==4){
            result=true;
            return;
        }

        for(int x:list.get(start)){
            if(!visited[x]){
                visited[x]=true;
                dfs(x,depth+1);
                visited[x]=false;
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;++i){
            list.add(new ArrayList<>());
        }
        visited=new boolean[N];

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=0;i<N;++i){
            Arrays.fill(visited,false);
            visited[i]=true;
            dfs(i,0);
            if(result) break;
        }

        if(result) bw.write(1+"\n");
        else bw.write(0+"\n");
        bw.flush();
        bw.close();
    }
}
