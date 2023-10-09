// https://www.acmicpc.net/problem/14499
// 주사위 굴리기, Gold4
// 2023년 10월 8일
// 통과

package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14499 {

    static int N,M,x,y,K;
    static int map[][];
    static int dx[] = {0,0,-1,1}; // 동서북남
    static int dy[] = {1,-1,0,0};
    static int dice[]={0,0,0,0,0,0};

    static void print(){
        System.out.println("=================");
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        map[x][y]=0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;++i){
            int command = Integer.parseInt(st.nextToken());

            int mx = x+dx[command-1];
            int my = y+dy[command-1];

            if(mx<0 || mx>=N || my<0 || my>=M){
                continue;
            }

            if(command==1){ // 동
                int temp = dice[0];
                dice[0]=dice[3];
                dice[3]=dice[5];
                dice[5]=dice[2];
                dice[2]=temp;
            }
            else if(command==2){ // 서
                int temp=dice[0];
                dice[0]=dice[2];
                dice[2]=dice[5];
                dice[5]=dice[3];
                dice[3]=temp;
            }
            else if(command==3){ // 북
                int temp=dice[0];
                dice[0]=dice[4];
                dice[4]=dice[5];
                dice[5]=dice[1];
                dice[1]=temp;
            }
            else if(command==4){ // 남
                int temp=dice[0];
                dice[0]=dice[1];
                dice[1]=dice[5];
                dice[5]=dice[4];
                dice[4]=temp;
            }

            if(map[mx][my]==0) map[mx][my]=dice[5];
            else{
                dice[5]=map[mx][my];
                map[mx][my]=0;
            }
            bw.write(dice[0]+"\n");

            x=mx;
            y=my;
        }

        bw.flush();
        bw.close();
    }
}
