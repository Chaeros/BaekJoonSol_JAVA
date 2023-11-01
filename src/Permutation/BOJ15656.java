package Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656 {

    static int N,M;
    static int arr[];
    static int result[];

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void dfs(int depth) throws IOException {
        if(depth==M){
            printArr();
            return;
        }

        for(int i=0;i<N;++i){
            result[depth] = arr[i];
            dfs(depth+1);
        }
    }

    static void printArr() throws IOException {
        for(int i=0;i<M;++i){
            bw.write(result[i]+" ");
        }
        bw.write("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        bw.flush();
        bw.close();
    }
}
