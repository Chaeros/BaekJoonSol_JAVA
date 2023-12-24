// https://www.acmicpc.net/problem/21609
// 상어 중학교, Gold2
// 2023년 12월 24일

package SWEA;

import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21609 {

    static int N,M;
    static int map[][];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static void bfs(int r,int c,int block){
        Queue<>
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){

            }
        }
    }
}
