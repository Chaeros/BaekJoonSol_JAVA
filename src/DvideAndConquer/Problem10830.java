// https://www.acmicpc.net/problem/10830
// 행렬 제곱, Gold4
// 2023년 8월 21일
// 통과

package DvideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10830 {

    static int N;
    static long matrix[][];

    static long[][] fpow(long matrix[][], long squareNum){
        if(squareNum==1) return matrix;
        else{
            long x[][] = fpow(matrix,(long)(squareNum/2L));

            long evenResultMatrix[][] = new long[N][N];
            for(int i=0;i<N;++i){
                for(int j=0;j<N;++j){
                    for(int k=0;k<N;++k){
                        evenResultMatrix[i][j]+=(x[i][k]*x[k][j]);
                    }
                    evenResultMatrix[i][j]%=1000L;
                }
            }
            if(squareNum%2==0){
                return evenResultMatrix;
            }
            else{
                long oddResultMatrix[][] = new long[N][N];
                for(int i=0;i<N;++i){
                    for(int j=0;j<N;++j){
                        for(int k=0;k<N;++k){
                            oddResultMatrix[i][j]+=(evenResultMatrix[i][k]*matrix[k][j]);
                        }
                        oddResultMatrix[i][j]%=1000L;
                    }
                }
                return oddResultMatrix;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        matrix=new long[N][N];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                matrix[i][j]=Long.parseLong(st.nextToken())%1000;
            }
        }

        long resultMatrix[][] = fpow(matrix,B);

        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                bw.write(resultMatrix[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
