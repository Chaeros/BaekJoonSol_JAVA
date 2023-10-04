// https://www.acmicpc.net/problem/3190
// 뱀, Gold4
// 2023년 10월 4일
// 미제출

package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3190 {

    static int N,K;
    static int map[][];
    static boolean snake[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        snake = new boolean[N][N];

        for(int i=0;i<K;++i){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col]=1;
        }

    }
}
