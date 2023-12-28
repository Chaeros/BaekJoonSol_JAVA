// https://www.acmicpc.net/problem/14503
// 로봇 청소기, Gold5
// 2023년 9월 26일
// 통과

package 삼성기출;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int N,M;
    static int map[][];
    static boolean visited[][];
    static int dx[] ={-1,0,1,0};
    static int dy[] ={0,1,0,-1};
    static int cleanArea=0;

    static void sol(int row,int col,int direction){

        while(true){
            if(!visited[row][col]){
                visited[row][col]=true;
                ++cleanArea;
            }

            boolean goAble=false;
            for(int i=0;i<4;++i){
                int mx = row+dx[i];
                int my = col+dy[i];

                if(mx<0 || mx>=N || my<0 || my>=M) continue;
                if(map[mx][my]==0 && !visited[mx][my]) goAble=true;
            }
            if(!goAble){
                row=row+dx[(direction+2)%4];
                col=col+dy[(direction+2)%4];
                if(map[row][col]==1) break;
                continue;
            }

            for(int i=0;i<4;++i){
                direction=(direction+3)%4;
                int mx = row+dx[direction];
                int my = col+dy[direction];

                if(map[mx][my]==0 && !visited[mx][my]){
                    row=mx;
                    col=my;
                    break;
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        sol(r,c,direction);

        bw.write(cleanArea+"\n");
        bw.flush();
        bw.close();
    }
}
