// https://www.acmicpc.net/problem/14500
// 테트로미노, Gold4
// 2023년 10월 8일
// 통과

package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int N,M;
    static int map[][];

    // 직선, 2유형 , 아래 모두 시계방향으로
    static int tetromino1X[][] = {{0,0,0,0},{0,1,2,3}};
    static int tetromino1Y[][] = {{0,1,2,3},{0,0,0,0}};

    // 정사각형, 1유형
    static int tetromino2X[][] = {{0,0,1,1}};
    static int tetromino2Y[][] = {{0,1,0,1}};

    // L 자 , 4유형
    static int tetromino3X[][] = {{0,1,2,2},{0,0,0,-1},{0,-1,-2,-2},{0,0,0,1},
            {0,1,2,2},{0,0,0,1},{0,-1,-2,-2},{0,0,0,-1}};
    static int tetromino3Y[][] = {{0,0,0,1},{0,1,2,2},{0,0,0,-1},{0,-1,-2,-2},
            {0,0,0,-1},{0,1,2,2},{0,0,0,1},{0,-1,-2,-2}};

    // ㄴㄱ 자, 2유형
    static int tetromino4X[][] = {{0,1,1,2},{0,0,-1,-1},{0,1,1,2},{0,0,1,1}};
    static int tetromino4Y[][] = {{0,0,1,1},{0,1,1,2},{0,0,-1,-1},{0,1,1,2}};

    // ㅗ 자, 4유형
    static int tetromino5X[][] = {{0,0,0,1},{0,-1,-2,-1},{0,0,0,-1},{0,1,2,1}};
    static int tetromino5Y[][] = {{0,1,2,1},{0,0,0,1},{0,-1,-2,-1},{0,0,0,-1}};

    static int resultMaxVal =0;

    static void calSum(int row,int col,int tetrominoX[][], int tetrominoY[][]){
        outter : for(int i=0;i<tetrominoX.length;++i){
            int sum=0;
            for(int j=0;j<4;++j){
                int mx = row + tetrominoX[i][j];
                int my = col + tetrominoY[i][j];

                if(mx<0 || mx>=N || my<0 || my>=M) continue outter;

                sum+=map[mx][my];
            }
            resultMaxVal = Math.max(resultMaxVal,sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                calSum(i,j,tetromino1X,tetromino1Y);
                calSum(i,j,tetromino2X,tetromino2Y);
                calSum(i,j,tetromino3X,tetromino3Y);
                calSum(i,j,tetromino4X,tetromino4Y);
                calSum(i,j,tetromino5X,tetromino5Y);
            }
        }

        bw.write(resultMaxVal+"\n");
        bw.flush();
        bw.close();
    }
}
