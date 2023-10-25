// https://www.acmicpc.net/problem/6603
// 로또, Silver2
// 2023년 10월 25일
// 통과

package Combinatorics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ6603 {

    static int num=0;
    static int arr[];

    static int result[] = new int[6];
    static void printArr(){
        for(int x:result){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    static void dfs(int index, int depth){
        if(depth==6) {
            printArr();
            return;
        }

        for(int i=index;i<num;++i){
            result[depth]=arr[i];
            dfs(i+1,depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            if(num==0) break;
            arr = new int[num];
            for(int i=0;i<num;++i){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            System.out.println();
        }
    }
}
