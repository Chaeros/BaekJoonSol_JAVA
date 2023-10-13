// https://www.acmicpc.net/problem/20058
// 마법사 상어와 파이어스톰, Gold3
// 2023년 10월 13일
// 통과

package SWEA;

import java.util.*;
import java.io.*;

public class BOJ20058 {

    static int N,Q;
    static int MAP_SIZE;
    static int map[][];

    static int dx[]= {-1,0,1,0};
    static int dy[]= {0,1,0,-1};

    static void rotate(int lNum) {
        int slice = MAP_SIZE/(int)Math.pow(2, lNum);
        int boxSize = (int)Math.pow(2, lNum);
        int tempMap[][]=new int[MAP_SIZE][MAP_SIZE];
        for(int i=0;i<slice;++i) {
            for(int j=0;j<slice;++j) {
                for(int r=0;r<boxSize;++r) {
                    for(int c=0;c<boxSize;++c) {
                        tempMap[(i*boxSize)+c][(j+1)*boxSize-1-r]
                                =map[(i*boxSize)+r][(j*boxSize)+c];
                    }
                }
            }
        }
        map=tempMap;
    }

    static int tempMap[][];
    static void fireBall(int x,int y) {
        int count=0;
        for(int i=0;i<4;++i) {
            int mx=x+dx[i];
            int my=y+dy[i];

            if(mx<0 || mx>=MAP_SIZE || my<0 || my>=MAP_SIZE) continue;
            else if(map[mx][my]==0) continue;
            ++count;
        }

        if(count<3 && tempMap[x][y]>0) --tempMap[x][y];
    }

    static void printMap() {
        for(int i=0;i<MAP_SIZE;++i) {
            for(int j=0;j<MAP_SIZE;++j) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("=====================");
    }

    static int mapSum() {
        int sum=0;
        for(int i=0;i<MAP_SIZE;++i) {
            for(int j=0;j<MAP_SIZE;++j) {
                sum+=map[i][j];
            }
        }
        return sum;
    }

    static boolean visited[][];
    static int maxVal=0;
    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visited[x][y]=true;
        int size=1;

        while(!q.isEmpty()) {
            int now[] = q.poll();

            for(int i=0;i<4;++i) {
                int mx = now[0]+dx[i];
                int my = now[1]+dy[i];

                if(mx<0 || mx>=MAP_SIZE || my<0 || my>=MAP_SIZE) continue;
                else if(map[mx][my]==0) continue;
                else if(visited[mx][my]) continue;

                visited[mx][my]=true;
                q.offer(new int[] {mx,my});
                size++;
            }
        }
        maxVal=Math.max(maxVal, size);
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        MAP_SIZE=(int)Math.pow(2, N);

        map = new int[MAP_SIZE][MAP_SIZE];
        visited = new boolean[MAP_SIZE][MAP_SIZE];

        for(int i=0;i<Math.pow(2, N);++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<MAP_SIZE;++j) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Q;++i) {
            int lNum=Integer.parseInt(st.nextToken());
            rotate(lNum);
            tempMap = new int[MAP_SIZE][MAP_SIZE];
            for(int k=0;k<MAP_SIZE;++k) {
                tempMap[k]=map[k].clone();
            }
            for(int r=0;r<MAP_SIZE;++r) {
                for(int c=0;c<MAP_SIZE;++c) {
                    fireBall(r,c);
                }
            }
            map=tempMap;
        }

        for(int i=0;i<MAP_SIZE;++i) {
            for(int j=0;j<MAP_SIZE;++j) {
                if(!visited[i][j] && map[i][j]!=0) bfs(i,j);
            }
        }

        bw.write(mapSum()+"\n");
        bw.write(maxVal+"\n");
        bw.flush();
        bw.close();

    }

}
