// https://www.acmicpc.net/problem/15664
// N과 M (10), Silver2
// 2023년 11월 5일
// 통과

package Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15664 {

    static int N,M;
    static int arr[];
    static int result[];
    static boolean check[];

    static Set<ArrayList<Integer>> set = new HashSet<>();

    static void print(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;++i){
            list.add(result[i]);
        }
        if(set.contains(list)) return;
        set.add(list);
        for(int i=0;i<M;++i){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static void dfs(int index, int depth){
        if(depth==M){
            print();
            return;
        }

        for(int i=index;i<N;++i){
            if(!check[i]){
                check[i]=true;
                result[depth] = arr[i];
                dfs(i+1,depth+1);
                check[i] = false;
            }
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
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0,0);
    }
}
