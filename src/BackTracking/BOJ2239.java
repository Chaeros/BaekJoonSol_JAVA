// https://www.acmicpc.net/problem/2239
// 스도쿠, Gold4
// 2023년 9월 24일
// 통과

package BackTracking;

import java.io.*;

public class BOJ2239{

    static int map[][]=new int[9][9];
    static boolean row[][]=new boolean[9][10];
    static boolean col[][]=new boolean[9][10];
    static boolean square[][]=new boolean[9][10];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean end=false;
    static void dfs(int posNum) throws IOException {
        int x = posNum/9;
        int y = posNum%9;

        if(end) return;

        if(posNum==81){
            for(int i=0;i<9;++i){
                for(int j=0;j<9;++j){
                    bw.write(String.valueOf(map[i][j]));
                }
                bw.write("\n");
            }
            end=true;
            return;
        }

        if(map[x][y]==0){
            for(int i=1;i<=9;++i){
                if(row[x][i]==false && col[y][i]==false && square[3*(x/3)+y/3][i]==false){
                    row[x][i]=true;
                    col[y][i]=true;
                    square[3*(x/3)+y/3][i]=true;
                    map[x][y]=i;
                    dfs(posNum+1);
                    row[x][i]=false;
                    col[y][i]=false;
                    square[3*(x/3)+y/3][i]=false;
                    map[x][y]=0;
                }
            }
        }
        else{
            dfs(posNum+1);
        }

    }

    public static void main(String[] args) throws IOException {

        for(int i=0;i<9;++i){
            String str = br.readLine();
            for(int j=0;j<9;++j){
                int num=Integer.parseInt(String.valueOf(str.charAt(j)));
                map[i][j]=num;
                row[i][num]=true;
                col[j][num]=true;
                square[3*(i/3)+j/3][num]=true;
            }
        }

        dfs(0);

        bw.flush();
        bw.close();
    }
}