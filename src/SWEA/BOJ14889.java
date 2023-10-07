// https://www.acmicpc.net/problem/14889
// 스타트와 링크, Silver1
// 2023년 10월 5일
// 통과

package SWEA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int N;
    static int map[][];
    static boolean visited[];

    static int resultMinVal=Integer.MAX_VALUE;

    static void func(){
        List<Integer> start = new ArrayList<>();
        List<Integer> link = new ArrayList<>();
        int start_sum=0;
        int link_sum=0;
        for(int i=0;i<N;++i){
            if(visited[i]) start.add(i);
            else link.add(i);
        }

        for(int i=0;i<N/2;++i){
            for(int j=0;j<N/2;++j){
                start_sum += map[start.get(i)][start.get(j)];
                link_sum += map[link.get(i)][link.get(j)];
            }
        }

        resultMinVal = Math.min(resultMinVal,Math.abs(start_sum-link_sum));
    }

    static void dfs(int idx, int depth){
        if(depth==N/2){
            func();
            return;
        }

        for(int i=idx;i<N;++i){
            if(!visited[i]){
                visited[i]=true;
                dfs(i+1,depth+1);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        bw.write(resultMinVal+"\n");
        bw.flush();
        bw.close();
    }
}
