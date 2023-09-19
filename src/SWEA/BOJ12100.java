// https://www.acmicpc.net/problem/12100
// 2048, Gold2
// 2023년 9월 18일
// 미제출

package SWEA;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ12100 {
    static int N;
    static int maxVal=0;

    static void printMap(int[][] map){
        for(int k=0;k<N;++k){
            for(int j=0;j<N;++j){
                System.out.print(map[k][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    static int[][] convertMap(int command, int[][] map){
        int t_map[][] = new int[N][N];

        int index;
        boolean flag;

        // ↑ 버튼을 누른 경우
        if(command==1){
            for(int i=0;i<N;++i){
                index=0;
                flag=false;
                for(int j=0;j<N;++j){
                    if(map[j][i]!=0){
                        if(!flag){
                            t_map[index][i]=map[j][i];
                            flag=true;
                        }
                        else{
                            if(t_map[index][i]==map[j][i]){
                                t_map[index][i]*=2;
                                flag=false;
                            }
                            else{
                                t_map[index+1][i]=map[j][i];
                            }
                            ++index;
                        }
                    }
                }
            }
        }
        // → 버튼을 누른 경우
        else if(command==2){
            for(int i=0;i<N;++i){
                index=N-1;
                flag=false;
                for(int j=N-1;j>=0;--j){
                    if(map[i][j]!=0){
                        if(!flag){
                            t_map[i][index]=map[i][j];
                            flag=true;
                        }
                        else{
                            if(t_map[i][index]==map[i][j]){
                                t_map[i][index]*=2;
                                flag=false;
                            }
                            else{
                                t_map[i][index-1]=map[i][j];
                            }
                            --index;
                        }
                    }
                }
            }
        }
        // ↓ 버튼을 누른 경우
        else if(command==3){
            for(int i=0;i<N;++i){
                index=N-1;
                flag=false;
                for(int j=N-1;j>=0;--j){
                    if(map[j][i]!=0){
                        if(!flag){
                            t_map[index][i]=map[j][i];
                            flag=true;
                        }
                        else{
                            if(t_map[index][i]==map[j][i]){
                                t_map[j][i]*=2;
                                flag=false;
                            }
                            else{
                                t_map[index-1][i]=map[j][i];
                            }
                            --index;
                        }
                    }
                }
            }
        }
        // ← 버튼을 누른 경우
        else if(command==4){
            for(int i=0;i<N;++i){
                index=0;
                flag=false;
                for(int j=0;j<N;++j){
                    if(map[i][j]!=0){
                        if(!flag){
                            t_map[index][j]=map[i][j];
                            flag=true;
                        }
                        else{
                            if(t_map[index][j]==map[i][j]){
                                t_map[index][j]*=2;
                                flag=false;
                            }
                            else{
                                t_map[index+1][j]=map[i][j];
                            }
                            ++index;
                        }
                    }
                }
            }
        }
        return t_map;
    }

    static void dfs(int count, int map[][]){

        if(count>=5){
            for(int i=0;i<N;++i){
                for(int j=0;j<N;++j){
                    maxVal = Math.max(maxVal,map[i][j]);
                    System.out.println("count="+count);
//                    printMap(map);
                }
            }
            return;
        }
        else{
            for(int i=1;i<=4;++i){
                int[][] transMap=convertMap(i,map);
                System.out.println("i="+i+" count="+count);
                printMap(transMap);

                dfs(++count,transMap); // 명령 수행후 변화가 없다면 다음 단계로 진행하지 않는다.
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int map[][] = new int[N][N];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                int currentNum = Integer.parseInt(st.nextToken());
                map[i][j]=currentNum;
                maxVal = Math.max(maxVal,currentNum);
            }
        }

        dfs(0,map);

        bw.write(maxVal+"\n");
        bw.flush();
        bw.close();
    }
}
