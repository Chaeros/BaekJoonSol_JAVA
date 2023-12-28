// https://www.acmicpc.net/problem/21609
// 상어 중학교, Gold2
// 2023년 12월 25일

package 삼성기출;

import java.io.*;
import java.util.*;

public class BOJ21609 {

    static int N,M;
    static int map[][];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static List<Position> blockSet = new ArrayList<>();
    static int rainbowBlockSize=0;
    static int standardRow=0;
    static int standardCol=0;
    static int totalScore=0;
    static boolean visited[][];
    static final int SPACE_NUMBER = -2;

    static class Position{
        int row;
        int col;

        public Position(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    static void removeBlock(){
        for(Position block:blockSet){
            int row = block.row;
            int col = block.col;
            map[row][col]=SPACE_NUMBER;
        }
        totalScore+=(int)Math.pow(blockSet.size(),2);
    }

    static void gravity(){
        for(int col=0;col<N;++col){
            for(int i=N-2;i>=0;--i){
                for(int j=i;j<N-1;++j){
                    if(map[j][col]==-1 || map[j][col]==SPACE_NUMBER) break;
                    if(map[j+1][col]==SPACE_NUMBER){
                        map[j+1][col]=map[j][col];
                        map[j][col]=SPACE_NUMBER;
                    }
                    else break;
                }
            }
        }
    }

    static void rotate(){
        int tempMap[][] = new int[N][N];
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                tempMap[i][j]=map[j][N-1-i];
            }
        }
        for(int i=0;i<N;++i){
            System.arraycopy(tempMap[i],0,map[i],0,tempMap[i].length);
        }
    }

    static void printMap(){
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int bfs(int r,int c,int standardBlock){
        int blockSize=0;
        if(visited[r][c]) return blockSize;
        if(standardBlock==-1 || standardBlock==0 || standardBlock == SPACE_NUMBER){
            return blockSize;
        }
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(r,c));
        int tempRainbowBlockSize=0;
        int tempStandardRow=N-1;
        int tempStandardCol=N-1;
        visited[r][c]=true;
        List<Position> list = new ArrayList<>();
        List<Position> rainbowList = new ArrayList<>();
        list.add(new Position(r,c));
        blockSize++;

        while(!q.isEmpty()){
            Position now = q.poll();
            for(int i=0;i<4;++i){
                int mx = now.row+dx[i];
                int my = now.col+dy[i];

                if(mx<0 || mx>=N || my<0 || my>= N) continue;
                if(visited[mx][my]) continue;
                if(map[mx][my]==-1 || map[mx][my]==SPACE_NUMBER) continue;
                if(map[mx][my]!=0 && map[mx][my]!=standardBlock) continue;

                if(map[mx][my]==0){
                    tempRainbowBlockSize++;
                    rainbowList.add(new Position(mx,my));
                }
                
                if(map[mx][my]!=0){
                    if(tempStandardRow>mx){
                        tempStandardRow=mx;
                        tempStandardCol=my;
                    }
                    else if(tempStandardRow==mx){
                        if(tempStandardCol>my){
                            tempStandardRow=mx;
                            tempStandardCol=my;
                        }
                    }
                }
                visited[mx][my]=true;
                q.offer(new Position(mx,my));
                list.add(new Position(mx,my));
                blockSize++;
            }
        }

        if(blockSize<2) return blockSize;

        for(Position position:rainbowList){
            visited[position.row][position.col]=false;
        }

        if(blockSet.size()<list.size()){
            blockSet=new ArrayList<>(list);
            standardRow=tempStandardRow;
            standardCol=tempStandardCol;
        }
        else if(blockSet.size()==list.size()){
            if(rainbowBlockSize<tempRainbowBlockSize){
                blockSet=new ArrayList<>(list);
                standardRow=tempStandardRow;
                standardCol=tempStandardCol;
            }
            else if(rainbowBlockSize==tempRainbowBlockSize){
                if(standardRow<tempStandardRow){
                    blockSet=new ArrayList<>(list);
                    standardRow=tempStandardRow;
                    standardCol=tempStandardCol;
                }
                else if(standardRow==tempStandardRow){
                    if(standardCol<tempStandardCol){
                        blockSet=new ArrayList<>(list);
                        standardRow=tempStandardRow;
                        standardCol=tempStandardCol;
                    }
                }
            }
        }
        return blockSize;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            blockSet = new ArrayList<>();
            visited = new boolean[N][N];
            boolean isContinue=false;
            standardRow=0;
            standardCol=0;
            for(int i=0;i<N;++i){
                for(int j=0;j<N;++j){
                    if(bfs(i,j,map[i][j])>=2) isContinue=true;
                }
            }
            if(!isContinue) break;

            removeBlock();
            gravity();
            rotate();
            gravity();

//            System.out.println("=================origin=============");
//            printMap();
//            removeBlock();
//            System.out.println("=================revmoe=============");
//            printMap();
//            gravity();
//            System.out.println("=================gravty=============");
//            printMap();
//            rotate();
//            System.out.println("=================rotate=============");
//            printMap();
//            gravity();
//            System.out.println("=================gravity=============");
//            printMap();
        }

        bw.write(totalScore+"\n");
        bw.flush();
        bw.close();
    }
}
