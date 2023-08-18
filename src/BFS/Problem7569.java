// https://www.acmicpc.net/problem/7569
// 토마토 (2), Gold5
// 2023년 8월 15일
// 미제출

package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7569 {
    static int M,N,H;
    static int graph[][][];
    static int dx[] = {-1,0,1,0,0,0};
    static int dy[] = {0,1,0,-1,0,0};
    static int dz[] = {0,0,0,0,1,-1};

    static int dayCount=0;
    static class Node{
        int x;
        int y;
        int z;

        public Node(int x,int y,int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    static void bfs(ArrayList<Node> nodes){
        Queue<Node> q = new LinkedList<>();
        for(Node node:nodes){
            q.offer(node);
        }

        while(!q.isEmpty()){
            int roundQ = q.size();
            for(int k=0;k<roundQ;++k){
                Node nowNode = q.poll();

                for(int i=0;i<6;++i){
                    int mx = nowNode.x+dx[i];
                    int my = nowNode.y+dy[i];
                    int mz = nowNode.z+dz[i];

                    if(mx>=0 && mx<N && my>=0 && my<M && mz>=0 && mz<H){
                        if(graph[mx][my][mz]==0){
                            graph[mx][my][mz]=1;
                            q.offer(new Node(mx,my,mz));
                        }
                    }
                }
            }
            ++dayCount;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[N][M][H];

        ArrayList<Node> startNodes = new ArrayList<>();
        for(int h=0;h<H;++h){
            for(int i=0;i<N;++i){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;++j){
                    graph[i][j][h]=Integer.parseInt(st.nextToken());
                    if(graph[i][j][h]==1) startNodes.add(new Node(i,j,h));
                }
            }
        }


        bfs(startNodes);

        boolean allClear=true;
        outter :for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                for(int h=0;h<H;++h){
                    if(graph[i][j][h]==0){
                        allClear=false;
                        break outter;
                    }
                }
            }
        }
        if(allClear) bw.write(dayCount-1+"\n");
        else bw.write(-1+"\n");
        bw.flush();
        bw.close();
    }
}
