// https://www.acmicpc.net/problem/21610
// 마법사 상어와 비바라기, Gold5
// 2023년 10월 2일
// 미제출

package SWEA;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ21610 {
    static int N,M;
    static int map[][];
    static boolean isCloud[][];
    static class Cloud{
        int row;
        int col;

        public Cloud(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int command[][];

    static int dx[] = {0,-1,-1,-1,0,1,1,1};
    static int dy[] = {-1,-1,0,1,1,1,0,-1};

    static List<Cloud> list = new LinkedList<>();

    static void func(){

        for(int i=0;i<M;++i){

            int direction = command[i][0];
            int distance = command[i][1];

            for(Cloud cloud:list){
                int row = cloud.row;
                int col = cloud.col;

                int mx = cloud.row+(dx[direction]*distance);
                int my = cloud.col+(dy[direction]*distance);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        isCloud = new boolean[N][N];

        command = new int[M][2]; // [x][0] = 방향, [x][1] = 거리

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isCloud[N-1][0]=true;
        isCloud[N-1][1]=true;
        isCloud[N-2][0]=true;
        isCloud[N-2][1]=true;
        list.add(new Cloud(N-1,0));
        list.add(new Cloud(N-1,1));
        list.add(new Cloud(N-2,0));
        list.add(new Cloud(N-2,1));
    }
}
