package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1961 {
    static int N;
    static int map[][];
    static int resultMap[][][];
    static int[][] rotate(int map[][]){
        int tempMap[][]=new int[N][N];
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                tempMap[i][j]=map[N-1-j][i];
            }
        }
        return tempMap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            resultMap = new int[3][N][N];
            for(int i=0;i<N;++i){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;++j){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            resultMap[0]=rotate(map);
            resultMap[1]=rotate(resultMap[0]);
            resultMap[2]=rotate(resultMap[1]);

            bw.write("#"+test_case+"\n");
            for(int i=0;i<N;++i){
                for(int j=0;j<3;++j){
                    for(int k=0;k<N;++k){
                        bw.write(String.valueOf(resultMap[j][i][k]));
                    }
                    if(j!=2) bw.write(" ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
