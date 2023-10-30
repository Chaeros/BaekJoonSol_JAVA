// https://www.acmicpc.net/problem/15655
// N과 M(6), Silver3
// 2023년 10월 30일
// 미제출


package BackTracking;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {

    static int N,M;
    static int arr[];

    static int resultArr[];

    static void print(){
        for(int i=0;i<M;++i){
            System.out.print(resultArr[i]+" ");
        }
        System.out.println();
    }

    static void dfs(int index,int depth){

        if(depth==M){
            print();
            return;
        }

        for(int i=index;i<N;++i){
            resultArr[depth] = arr[i];
            dfs(i+1,depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        resultArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0,0);
    }
}
