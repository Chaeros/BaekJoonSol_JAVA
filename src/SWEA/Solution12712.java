package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution12712
{

    static int N,M;
    static int map[][];

    static int plus_dx[]={-1,0,1,0}; // 상우하좌
    static int plus_dy[]={0,1,0,-1};

    static int cross_dx[]={-1,-1,1,1}; //북서,북동,남동,남서
    static int cross_dy[]={-1,1,1,-1};

    static int plusRemoveBug(int row,int col){
        int removeCount=map[row][col];
        for(int i=0;i<4;++i){
            int x=row;
            int y=col;
            for(int j=0;j<M-1;++j){
                int mx = x+plus_dx[i];
                int my = y+plus_dy[i];

                if(mx<0 || mx>=N || my<0 || my>=N) break;
                removeCount+=map[mx][my];
                x=mx;
                y=my;
            }
        }
        return removeCount;
    }

    static int crossRemoveBug(int row,int col){
        int removeCount=map[row][col];
        for(int i=0;i<4;++i){
            int x=row;
            int y=col;
            for(int j=0;j<M-1;++j){
                int mx = x+cross_dx[i];
                int my = y+cross_dy[i];

                if(mx<0 || mx>=N || my<0 || my>=N) break;
                removeCount+=map[mx][my];
                x=mx;
                y=my;
            }
        }
        return removeCount;
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for(int i=0;i<N;++i){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;++j){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            int result=0;
            for(int r=0;r<N;++r){
                for(int c=0;c<N;++c){
                    result=Math.max(result,plusRemoveBug(r,c));
                    result=Math.max(result,crossRemoveBug(r,c));
                }
            }
            bw.write("#"+test_case+" "+result+"\n");
        }
        bw.flush();
        bw.close();
    }
}