// https://www.acmicpc.net/problem/15684
// 사다리 조작, Gold3
// 2023년 12월 17일
// 통과

package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15684 {
    static int N,M,H;
    static boolean ladder[][] = new boolean[31][11];
    static int ladder_cnt=0;
    static boolean isSucess=false;

    static void dfs(int index,int cnt){
        if(ladder_cnt==cnt){
            boolean isColSuccess = true;
            for(int i=1;i<=N;++i){
                int currentLadder=i;
                isColSuccess = true;
                for(int j=0;j<H;++j){
                    if(currentLadder>1 && ladder[j][currentLadder-1]){
                        currentLadder--;
                    }
                    else if(ladder[j][currentLadder]){
                        currentLadder++;
                    }
                }

                if(currentLadder!=i){
                    isColSuccess=false;
                    break;
                }
            }
            if(isColSuccess){
                isSucess=true;
            }
            return;
        }

        for(int i=index;i<H;++i){
            for(int j=1;j<N;++j){
                if(!ladder[i][j-1] && !ladder[i][j] && !ladder[i][j+1]){
                    ladder[i][j]=true;
                    dfs(i,cnt+1);
                    ladder[i][j]=false;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a-1][b]=true;
        }

        for(int i=0;i<=3;++i){
            ladder_cnt=i;
            dfs(0,0);
            if(isSucess){
                bw.write(ladder_cnt+"\n");
                bw.flush();
                bw.close();
                return;
            }
        }
        bw.write("-1\n");
        bw.flush();
        bw.close();
    }
}
