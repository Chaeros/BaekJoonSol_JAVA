// https://www.acmicpc.net/problem/16234
// 인구 이동, Gold4
// 2023년 10월 9일
// 통과

package SWEA;

import java.io.*;
import java.util.*;

public class BOJ16234 {

    static int N,L,R;
    static int map[][];
    static int visited[][];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static class Node{
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int unionCnt=0;
    static boolean proceed=true;

    static void bfs(int row, int col){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        q.offer(new int[] {row,col});
        list.add(new int[] {row,col});
        ++unionCnt;
        int sum=map[row][col];
        visited[row][col]=unionCnt;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0;i<4;++i){
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if(mx<0 || mx>=N || my<0 || my>=N) continue;

                if(visited[mx][my]==0){ // 방문하지 않은 상태
                    if(Math.abs(map[mx][my]-map[now[0]][now[1]])>=L &&
                            Math.abs(map[mx][my]-map[now[0]][now[1]])<=R){
                        visited[mx][my]=unionCnt;
                        sum+=map[mx][my];
                        proceed=true;
                        q.offer(new int[] {mx,my});
                        list.add(new int[] {mx,my});
                    }
                }
            }
        }
        if(list.size()>1){
            int avg = sum/list.size();
            for(int i=0;i<list.size();++i){
                map[list.get(i)[0]][list.get(i)[1]]=avg;
            }
        }
    }

//    static void transMap(int result){
//        for(int i=0;i<N;++i){
//            for(int j=0;j<N;++j){
//                if(visited[i][j]==unionCnt) map[i][j]=result;
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int resultCount=-1;
        while(proceed){
            ++resultCount;
            for(int i=0;i<N;++i){
                Arrays.fill(visited[i],0);
            }
            unionCnt=0;
            proceed=false;

            for(int i=0;i<N;++i){
                for(int j=0;j<N;++j){
                    if(visited[i][j]==0) bfs(i,j);
                }
            }
        }
        bw.write(resultCount+"\n");
        bw.flush();
        bw.close();
    }

}
