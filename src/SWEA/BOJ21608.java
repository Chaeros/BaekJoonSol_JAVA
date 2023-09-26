// https://www.acmicpc.net/problem/21608
// 상어 초등학교, Gold5
// 2023년 9월 26일
// 통과

package SWEA;

import java.io.*;
import java.util.*;

public class BOJ21608 {
    static int N, nodeCnt;
    static int classRoom[][];

    static int dx[]={-1,0,1,0};
    static int dy[]={0,1,0,-1};
    static int resultRow=0,resultCol=0,resultFavoriteCnt=0,resultEmptyCnt=0;
    static List<Node> list = new ArrayList<>();
    static int satisfaction=0;

    static class Node{
        int val;
        int favorite[]=new int[4];

        public Node() {
        }

        public Node(int val, int[] favorite) {
            this.val = val;
            this.favorite = favorite;
        }
    }

    static void setValueFunc(int row,int col, Node node){
        if(classRoom[row][col]==0){ // 비어있는 좌표일 때 학생을 배치시킬 수 있으므로

            int currentFavoriteCount=0;
            int emptyCount=0;
            for(int i=0;i<4;++i){ // 인접한 학생 상하좌우로 확인
                int mx = row+dx[i];
                int my = col+dy[i];

                if(mx<0 || mx>=N || my<0 || my>=N) continue;

                for(int j=0;j<4;++j){
                    if(classRoom[mx][my]==node.favorite[j]){
                        ++currentFavoriteCount;
                    }
                    if(classRoom[mx][my]==0){
                        ++emptyCount;
                    }
                }
            }
            if(resultFavoriteCnt<currentFavoriteCount){
                setValue(row, col, currentFavoriteCount, emptyCount);
            }
            else if(resultFavoriteCnt==currentFavoriteCount){
                if(resultEmptyCnt<emptyCount){
                    setValue(row, col, currentFavoriteCount, emptyCount);
                }
                else if(resultEmptyCnt==emptyCount){
                    if(resultRow<row){
                        setValue(row, col, currentFavoriteCount, emptyCount);
                    }
                    else if(resultRow==row){
                        if(resultCol<col){
                            setValue(row, col, currentFavoriteCount, emptyCount);
                        }
                    }
                }
            }
        }
    }

    static void setValue(int row, int col, int currentFavoriteCount, int emptyCount) {
        resultRow= row;
        resultCol= col;
        resultFavoriteCnt= currentFavoriteCount;
        resultEmptyCnt= emptyCount;
    }

    static void favoriteCountFunc() {

        for(int r=0;r<N;++r){
            for(int c=0;c<N;++c){
                Node node = new Node();
                for(Node tempNode:list){
                    if(classRoom[r][c]==tempNode.val){
                        node.val=tempNode.val;
                        for(int i=0;i<4;++i){
                            node.favorite[i]=tempNode.favorite[i];
                        }
                        break;
                    }
                }

                int currentFavoriteCount=0;
                for(int i=0;i<4;++i){ // 인접한 학생 상하좌우로 확인
                    int mx = r+dx[i];
                    int my = c+dy[i];

                    if(mx<0 || mx>=N || my<0 || my>=N) continue;

                    for(int j=0;j<4;++j){
                        if(classRoom[mx][my]==node.favorite[j]){
                            ++currentFavoriteCount;
                        }
                    }
                }
                if(currentFavoriteCount!=0) satisfaction+=(int)Math.pow(10,currentFavoriteCount-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nodeCnt=(int)Math.pow(N,2);
        classRoom = new int[N][N];

        for(int i=0;i<nodeCnt;++i){
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int favoriteFriends[] = new int[4];
            for(int f=0;f<4;++f) favoriteFriends[f]=Integer.parseInt(st.nextToken());
            Node node = new Node(val,favoriteFriends);
            list.add(node);
            resultRow=0;resultCol=0;resultFavoriteCnt=0;resultEmptyCnt=0;
            for(int r=0;r<N;++r){
                for(int c=0;c<N;++c){
                    setValueFunc(r,c,node);
                }
            }
            classRoom[resultRow][resultCol]=val;
        }

//        for(int r=0;r<N;++r){
//            for(int c=0;c<N;++c){
//                System.out.print(classRoom[r][c]+" ");
//            }
//            System.out.println();
//        }

        favoriteCountFunc();
        bw.write(satisfaction+"\n");
        bw.flush();
        bw.close();
    }
}