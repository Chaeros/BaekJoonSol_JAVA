package Dijkstra;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4485 {

    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;

            int map[][] = new int[N][N];

            for(int i=0;i<N;++i){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;++j){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }


        }
    }
}