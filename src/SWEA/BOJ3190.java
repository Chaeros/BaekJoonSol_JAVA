// https://www.acmicpc.net/problem/3190
// 뱀, Gold4
// 2023년 10월 4일
// 통과

package SWEA;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {
    static int N,K,L;
    static int map[][];
    static boolean snake[][];
    static int snakeHaedRow=0, snakeHeadCol=0;
    static int snakeRearRow=0, snakeRearCol=0;
    static int currentDirection=0;
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static Queue<Move> moveQ = new LinkedList<>();
    static List<Position> snakeList = new LinkedList<>();
    static int lastDistnac=0;

    static class Position{
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static class Move{
        int distance;
        char direction;

        public Move(int distance, char direction) {
            this.distance = distance;
            this.direction = direction;
        }
    }

    static int moveSnake(){
        int resultCount=0;
        for(Move move:moveQ){
            int mx=snakeHaedRow;
            int my=snakeHeadCol;

            for(int i=resultCount;i<move.distance;++i){
                mx+=dx[currentDirection];
                my+=dy[currentDirection];
                ++resultCount;

                if(mx<0 || mx>=N || my<0 || my>=N){
                    return resultCount;
                }
                else if(map[mx][my]==2) return resultCount;
                else{
                    snakeHaedRow=mx;
                    snakeHeadCol=my;
                    snakeList.add(new Position(mx,my));
                    if(map[mx][my]==1){
                        map[snakeRearRow][snakeRearCol]=2;
                    }
                    else{
                        Position snakeRear = snakeList.remove(0);
                        map[snakeRear.row][snakeRear.col]=0;
                        snakeRearRow = snakeList.get(0).row;
                        snakeRearCol = snakeList.get(0).col;
                    }
                    map[mx][my]=2;
                }
            }

            if(move.direction=='D'){
                currentDirection=(currentDirection+1)%4;
            }
            else{
                currentDirection=(currentDirection+3)%4;
            }

        }

        return resultCount;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        snake = new boolean[N][N];

        // 맵 생성
        for(int i=0;i<K;++i){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1;
            int col = Integer.parseInt(st.nextToken())-1;
            map[row][col]=1;
        }

        // 이동 거리 및 방향 설정
        L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;++i){
            st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            moveQ.offer(new Move(distance,direction));
            lastDistnac=distance;
        }
        moveQ.offer(new Move(lastDistnac+N,'D'));

        snakeList.add(new Position(0,0));
        map[0][0]=2;


        bw.write(moveSnake()+"\n");
        bw.flush();
        bw.close();
    }
}
