// https://www.acmicpc.net/problem/12100
// 2048, Gold2
// 2023년 9월 18일
// 미제출

package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ12100 {
    static int N;
    static int graph[][];
    static int maxSum=0;
    static int mapSum(int map[][]){
        int sum=0;
        for(int i=0;i<N;++i)
            for(int j=0;j<N;++j) sum+=map[i][j];

        return sum;
    }

    static int[][] convertMap(int command, int map[][]){
        boolean checkSum=false;
        // ↑ 버튼을 누른 경우
        if(command==1){
            for(int i=0;i<N;++i){
                for(int j=0;j<N-1;++j){
                    if(map[j][i]==map[j+1][i]){
                        map[j][i]*=2;
                        for(int k=j+1;k<N-1;++k){
                            map[k][i]=map[k+1][i];
                            map[N-1][i]=0;
                        }
                        checkSum=true;
                    }
                }
            }
        }
        // → 버튼을 누른 경우
        else if(command==2){
            for(int i=0;i<N;++i){
                for(int j=N-1;j>0;--j){
                    if(map[i][j]==map[i][j-1]){
                        map[i][j]*=2;
                        for(int k=j-1;k>0;--k){
                            map[i][k]=map[i][k-1];
                            map[i][0]=0;
                        }
                        checkSum=true;
                    }
                }
            }
        }
        // ↓ 버튼을 누른 경우
        else if(command==3){
            for(int i=0;i<N;++i){
                for(int j=N-1;j>0;--j){
                    if(map[j][i]==map[j-1][i]){
                        map[j][i]*=2;
                        for(int k=j-1;k>0;--k){
                            map[k][i]=map[k-1][i];
                            map[0][i]=0;
                        }
                        checkSum=true;
                    }
                }
            }
        }
        // ← 버튼을 누른 경우
        else if(command==4){
            for(int i=0;i<N;++i){
                for(int j=0;j<N-1;++j){
                    if(map[i][j]==map[i][j+1]){
                        map[i][j]*=2;
                        for(int k=j+1;k<N-1;++k){
                            map[i][k]=map[i][k+1];
                            map[i][N-1]=0;
                        }
                        checkSum=true;
                    }
                }
            }
        }
        if(checkSum) return map;
        else{
            map[0][0]=-1;
            return map;
        }
    }

    static void dfs(int count, int map[][]){

        if(count==N){
            maxSum=Math.max(maxSum,mapSum(map));
            System.out.println("maxSum="+maxSum);
            return;
        }

        for(int i=1;i<=4;++i){
            int transMap[][]=convertMap(i,map);
            if(map[0][0]!=-1) dfs(++count,transMap); // 명령 수행후 변화가 없다면 다음 단계로 진행하지 않는다.
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,graph);

        bw.write(maxSum+"\n");
        bw.flush();
        bw.close();
    }
}
