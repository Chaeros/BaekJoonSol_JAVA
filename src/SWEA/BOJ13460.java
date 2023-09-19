// https://www.acmicpc.net/problem/13460
// 구슬 탈출, Gold1
// 2023년 9월 19일
// 미제출

package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13460 {
    static int N,M;
    static int resultVal=0;
    static int objectRow,objectCol;
    static char defaultMap[][];
    static Node convertMap(int command, int map[][]){

        Node node = new Node(new int[N][M],false);
        int index;
        boolean flag;
        // ↑ 방향 이동
        if(command==1){
            for(int i=1;i<N-1;++i){
                index=1;
                flag=false;
                for(int j=1;j<M-1;++j){
                    if(map[i][j]!='.' && map[i][j]!='O'){
                        if(!flag){
                            if(map[i][j]=='R'){
                                if(objectCol==j && objectRow<=i){
                                    node.pass=true;
                                }
                            }

                            node.map[index][j]=map[i][j];
                            flag=true;
                        }
                        else{
                            node.map[index+1][j]=map[i][j];
                            break;
                        }
                    }
                }
            }
        }
        // → 방향 이동
        else if(command==2){

        }
        // ↓ 방향 이동
        else if(command==3){

        }
        // ← 방향 이동
        else if(command==4){

        }
        return node;
    }

    static class Node{
        int map[][];
        boolean pass;

        public Node(int[][] map, boolean pass) {
            this.map = map;
            this.pass = pass;
        }
    }

    static void dfs(int count, int map[][], boolean pass){
        if(pass){
            resultVal=count;
        }
        else{
            if(count==10){
                resultVal = -1;
                return;
            }

            for(int i=1;i<=4;++i){
                Node node = convertMap(i,map);
                dfs(count+1,node.map,node.pass);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char map[][] = new char[N][M];
        defaultMap = new char[N][M];

        for(int i=0;i<N;++i){
            String str = br.readLine();
            for(int j=0;j<M;++j){
                map[i][j]=str.charAt(j);
                defaultMap[i][j]=str.charAt(j);
                if(map[i][j]=='O'){
                    objectRow=i;
                    objectCol=j;
                    defaultMap[i][j]='.';
                }
                else if(map[i][j]=='R' || map[i][j]=='B') defaultMap[i][j]='.';
            }
        }
    }
}
