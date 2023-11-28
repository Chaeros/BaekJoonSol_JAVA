package Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr1[][] = new int[N][M];
        int arr2[][] = new int[N][M];
        int result[][] = new int[N][M];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j){
                arr1[i][j]=Integer.parseInt(st.nextToken());
                result[i][j]+=arr1[i][j];
            }
        }

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j){
                arr2[i][j]=Integer.parseInt(st.nextToken());
                result[i][j]+=arr2[i][j];
            }
        }

        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
