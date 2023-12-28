// https://www.acmicpc.net/problem/17144
// 미세먼지 안녕, Gold4
// 2023년 10월 19일
// 통과

package 삼성기출;


import java.io.*;
import java.util.StringTokenizer;

public class BOJ17144 {
    static int R,C,T;
    static int map[][];
    static int airConditioner1[] = new int[2];
    static int airConditioner2[] = new int[2];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static boolean visited[][];
    static int tempMap[][];

    static void spread(int r, int c){
        visited[r][c] = true;
        int val = map[r][c]/5;

        for(int i=0;i<4;++i){
            int mx = r+dx[i];
            int my = c+dy[i];

            if(mx<0 || mx>=R || my<0 || my>=C) continue;
            if(map[mx][my]==-1) continue;

            tempMap[mx][my]+=val;
            tempMap[r][c]-=val;
        }
    }

    static void runConditioner(){

        // 윗쪽 공기청정기 왼쪽
        for(int i=airConditioner1[0]-2;i>=0;--i){
            map[i+1][0]=map[i][0];
        }

        // 윗쪽 공기청정기 윗쪽
        for(int i=0;i<C-1;++i){
            map[0][i]=map[0][i+1];
        }

        // 윗쪽 공기청정기 오른쪽
        for(int i=0;i<airConditioner1[0];++i){
            map[i][C-1]=map[i+1][C-1];
        }

        // 윗쪽 공기청정기 아랫쪽
        for(int i=C-1;i>1;--i){
            map[airConditioner1[0]][i]=map[airConditioner1[0]][i-1];
        }
        map[airConditioner1[0]][1]=0;

        // =========================================================
        // 아랫쪽 공기청정기 왼쪽
        for(int i=airConditioner2[0]+2;i<=R-1;++i){
            map[i-1][0]=map[i][0];
        }

        // 아랫쪽 공기청정기 아랫쪽
        for(int i=0;i<C-1;++i){
            map[R-1][i]=map[R-1][i+1];
        }

        // 아랫쪽 공기청정기 오른쪽
        for(int i=R-1;i>airConditioner2[0];--i){
            map[i][C-1]=map[i-1][C-1];
        }

        // 아랫쪽 공기청정기 윗쪽
        for(int i=C-1;i>1;--i){
            map[airConditioner2[0]][i]=map[airConditioner2[0]][i-1];
        }
        map[airConditioner2[0]][1]=0;
    }

    static int dustSum(){
        int sum=2;

        for(int r=0;r<R;++r){
            for(int c=0;c<C;++c){
                sum+=map[r][c];
            }
        }

        return sum;
    }

    static void printMap(){
        for(int r=0;r<R;++r){
            for(int c=0;c<C;++c){
                System.out.print(map[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        int index=0;
        for(int r=0;r<R;++r){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;++c){
                map[r][c]=Integer.parseInt(st.nextToken());
                if(map[r][c]==-1){
                    if(index==0){
                        airConditioner1[0]=r;
                        airConditioner1[1]=c;
                        index++;
                    }
                    else{
                        airConditioner2[0]=r;
                        airConditioner2[1]=c;
                    }
                }
            }
        }

        for(int t=0;t<T;++t){
            tempMap = new int[R][C];
            visited = new boolean[R][C];
            for(int r=0;r<R;++r){
                tempMap[r]=map[r].clone();
            }

            for(int r=0;r<R;++r){
                for(int c=0;c<C;++c){
                    spread(r,c);
                }
            }
            map=tempMap;
//            printMap();

            runConditioner();
        }

        bw.write(dustSum()+"\n");
        bw.flush();
        bw.close();
    }
}
