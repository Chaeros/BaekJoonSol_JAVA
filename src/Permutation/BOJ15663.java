// https://www.acmicpc.net/problem/15663
// N과 M (9), Silver2
// 2023년 11월 4일

package Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15663 {

    static int N,M;
    static int arr[];
    static int result[];

    static Set<int[]> set = new HashSet<>();

    static void print(){
        if(set.contains(result)) return;
        set.add(result);
        for(int i=0;i<M;++i){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static void dfs(int index,int depth){
        if(depth==M){
            print();
            return;
        }

        int last =0;
        for(int i=index;i<N;++i){
            result[depth] = arr[i];
            last = arr[i];
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
        result = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0,0);
    }
}
