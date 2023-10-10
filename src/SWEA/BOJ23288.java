// https://www.acmicpc.net/problem/23288
// 주사위 굴리기2, Gold3
// 2023년 10월 10일
// 통과

package SWEA;

import java.io.*;
import java.util.*;

public class BOJ23288 {

    static int R,C,T;
    static int map[][];

    static int currentRow=0;
    static int currentCol=0;

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    static int resultVal = 0;

    static int dice[] = {1,2,3,4,5,6}; // 위, 북, 동, 서, 남, 아래

    static void rightRoll() {
        int copyDice[] = dice.clone();
        dice[0]=copyDice[3];
        dice[2]=copyDice[0];
        dice[3]=copyDice[5];
        dice[5]=copyDice[2];
        currentCol+=1;
    }

    static void leftRoll() {
        int copyDice[] = dice.clone();
        dice[0]=copyDice[2];
        dice[2]=copyDice[5];
        dice[3]=copyDice[0];
        dice[5]=copyDice[3];
        currentCol-=1;
    }

    static void upRoll() {
        int copyDice[] = dice.clone();
        dice[0]=copyDice[4];
        dice[1]=copyDice[0];
        dice[4]=copyDice[5];
        dice[5]=copyDice[1];
        currentRow-=1;
    }

    static void downRoll() {
        int copyDice[] = dice.clone();
        dice[0]=copyDice[1];
        dice[1]=copyDice[5];
        dice[4]=copyDice[0];
        dice[5]=copyDice[4];
        currentRow+=1;
    }

    static void calScore() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {currentRow,currentCol});
        int currentMapVal=map[currentRow][currentCol];
        boolean visited[][] = new boolean[R][C];
        int sum=currentMapVal;
        visited[currentRow][currentCol]=true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0;i<4;++i) {
                int mx = now[0]+dx[i];
                int my = now[1]+dy[i];

                if(mx<0 || mx>=R || my<0 || my>=C) continue;
                if(map[mx][my]==currentMapVal && !visited[mx][my]) {
                    sum+=currentMapVal;
                    visited[mx][my]=true;
                    q.offer(new int[] {mx,my});
                }
            }
        }
        resultVal+=sum;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int r=0;r<R;++r) {
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;++c) {
                map[r][c]=Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> direction = new LinkedList<>();
        direction.offer(0);
        for(int i=0;i<T;++i) {
            int nextDirection = direction.poll();

            if(nextDirection==0) rightRoll();
            else if(nextDirection==1) downRoll();
            else if(nextDirection==2) leftRoll();
            else if(nextDirection==3) upRoll();

            calScore();

            if(dice[5]>map[currentRow][currentCol]) { // 시계방향
                int mx = currentRow+dx[(nextDirection+1)%4];
                int my = currentCol+dy[(nextDirection+1)%4];
                if(mx<0 || mx>=R || my<0 || my>=C) direction.offer((nextDirection+3)%4);
                else direction.offer((nextDirection+1)%4);
            }
            else if(dice[5]<map[currentRow][currentCol]) { // 반시계방향
                int mx = currentRow+dx[(nextDirection+3)%4];
                int my = currentCol+dy[(nextDirection+3)%4];
                if(mx<0 || mx>=R || my<0 || my>=C) direction.offer((nextDirection+1)%4);
                else direction.offer((nextDirection+3)%4);
            }
            else { // 그대로
                int mx = currentRow+dx[nextDirection];
                int my = currentCol+dy[nextDirection];
                if(mx<0 || mx>=R || my<0 || my>=C) direction.offer((nextDirection+2)%4);
                else direction.offer(nextDirection);
            }
        }

        bw.write(resultVal+"\n");
        bw.flush();
        bw.close();
    }
}
