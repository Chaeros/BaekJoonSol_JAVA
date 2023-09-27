// https://www.acmicpc.net/problem/14503
// 로봇 청소기, Gold5
// 2023년 9월 26일
// 미제출

package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int N,M;
    static int map[][];
    static boolean visited[][];
    static int dx[] ={-1,0,1,0};
    static int dy[] ={0,1,0,-1};
    static int cleanArea=0;
    static boolean turnOff=false;

    static int mark=2;

    static void dfs(int row,int col,int direction){
        if(!visited[row][col]){
            if(turnOff) return;
//            System.out.println("row="+row+", "+"col="+col);
            visited[row][col]=true;
            ++cleanArea;

            map[row][col]=mark++;
            System.out.println("----------------------------------------------");
            System.out.println("direction="+direction);
            for(int i=0;i<N;++i){
                for(int j=0;j<M;++j){
                    System.out.printf("%3d",map[i][j]);
                }
                System.out.println();
            }
            System.out.println("----------------------------------------------");

            for(int i=direction+4;i>direction;--i){
                int mx = row+dx[i%4];
                int my = col+dy[i%4];

                if(mx<0 || mx>=N || my<0 || my>=M) continue;
                if(map[mx][my]==0) dfs(mx,my,i%4);

                boolean goAble=false;
                for(int j=0;j<4;++j){
                    int mx2 = row+dx[j];
                    int my2 = col+dy[j];

                    if(map[mx2][my2]==0 && visited[mx2][my2]==false) goAble=true;
                }
                if(!goAble && map[row+dx[(direction+2)%4]][col+dy[(direction+2)%4]]==1){
                    turnOff=true;
                    return;
                }

//                if(i==direction+1 && map[row+dx[(i+1)%4]][col+dy[(i+1)%4]]==1){
//                    turnOff=true;
//                    return;
//                }
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

//        System.out.println("r="+r+", c="+c);
//        for(int i=0;i<N;++i){
//            for(int j=0;j<M;++j){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

        dfs(r,c,direction);

        bw.write(cleanArea+"\n");
        bw.flush();
        bw.close();
    }
}
