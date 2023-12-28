// https://www.acmicpc.net/problem/21610
// 마법사 상어와 비바라기, Gold5
// 2023년 10월 2일
// 통과

package 삼성기출;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ21610_2 {
    static int N,M;
    static int map[][];
    static class Position{
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int command[][];

    static int dx[] = {0,-1,-1,-1,0,1,1,1};
    static int dy[] = {-1,-1,0,1,1,1,0,-1};

    static int dx2[] = {-1,-1,1,1};
    static int dy2[] = {-1,1,1,-1};

    static List<Position> cloudList = new ArrayList<>();

    static void func(){

        for(int i=0;i<M;++i){

            int direction = command[i][0];
            int distance = command[i][1]%N;

            boolean isRained[][]= new boolean[N][N];


            for(Position cloud:cloudList){

                int mx = cloud.row+(dx[direction]*distance);
                int my = cloud.col+(dy[direction]*distance);

                if(mx<0) mx = N+mx;
                else mx%=N;
                if(my<0) my = N+my;
                else my%=N;

                map[mx][my]++;
                isRained[mx][my]=true;
            }
            cloudList.clear();

            for(int r=0;r<N;++r){
                for(int c=0;c<N;++c){
                    if(isRained[r][c]){
                        for(int j=0;j<4;++j){
                            int mx = r + dx2[j];
                            int my = c + dy2[j];

                            if(mx<0 || mx>=N || my<0 || my>=N) continue;
                            if(map[mx][my]!=0) map[r][c]++;
                        }
                    }
                }
            }

            for(int row=0;row<N;++row){
                for(int col=0;col<N;++col){
                    if(!isRained[row][col] && map[row][col]>=2){
                        cloudList.add(new Position(row,col));
                        map[row][col]-=2;
                    }

                }
            }
        }
    }

    static int resultSum(){
        int sum=0;
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                sum+=map[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        command = new int[M][2]; // [x][0] = 방향, [x][1] = 거리

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            command[i][0]=Integer.parseInt(st.nextToken())-1;
            command[i][1]=Integer.parseInt(st.nextToken());
        }

        cloudList.add(new Position(N-1,0));
        cloudList.add(new Position(N-1,1));
        cloudList.add(new Position(N-2,0));
        cloudList.add(new Position(N-2,1));

        func();



        bw.write(resultSum()+"\n");
        bw.flush();
        bw.close();
    }
}
