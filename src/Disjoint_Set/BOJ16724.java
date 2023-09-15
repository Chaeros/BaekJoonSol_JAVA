// https://www.acmicpc.net/problem/16724
// 피리 부는 사나이, Gold3
// 2023년 9월 15일
// 통과

package Disjoint_Set;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ16724{
    static int N,M;
    static char graph[][];
    static boolean visited[][];
    static int parent[][];

    static int find_parent(int x, int y){
        if(parent[x][y]==M*x+y) return M*x+y;
        else return parent[x][y]=find_parent(parent[x][y]/M,parent[x][y]%M);
    }

    static void union_parent(int aX, int aY, int bX, int bY){
        int A = find_parent(aX,aY);
        int B = find_parent(bX,bY);
        if(A<B) parent[B/M][B%M]=A;
        else parent[A/M][A%M]=B;
    }

    static void dfs(int x,int y){
        if(graph[x][y]=='U' && find_parent(x,y)!=find_parent(x-1,y)){
            union_parent(x,y,x-1,y);
            dfs(x-1,y);
        }
        else if(graph[x][y]=='D' && find_parent(x,y)!=find_parent(x+1,y)){
            union_parent(x,y,x+1,y);
            dfs(x+1,y);
        }
        else if(graph[x][y]=='L' && find_parent(x,y)!=find_parent(x,y-1)){
            union_parent(x,y,x,y-1);
            dfs(x,y-1);
        }
        else if(graph[x][y]=='R' && find_parent(x,y)!=find_parent(x,y+1)){
            union_parent(x,y,x,y+1);
            dfs(x,y+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];
        parent = new int[N][M];

        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                parent[i][j]=i*M+j;
            }
        }

        for(int i=0;i<N;++i){
            String str = br.readLine();
            for(int j=0;j<M;++j){
                graph[i][j]=str.charAt(j);
            }
        }

        if(N==1 && M==1){
            bw.write("1\n");
            bw.flush();
            bw.close();
            return;
        }

        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                dfs(i,j);
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                set.add(find_parent(i,j));
            }
        }

        bw.write(set.size()+"\n");
        bw.flush();
        bw.close();
    }
}