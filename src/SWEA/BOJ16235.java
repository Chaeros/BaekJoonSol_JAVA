package SWEA;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ16235 {
    static int N,M,K;
    static int A[][];
    static ArrayList<Wood> woodList = new ArrayList<>();
    static int groundNourishment[][];
    static class Wood implements Comparable<Wood>{
        int x;
        int y;
        int age;
        public Wood(int x,int y,int age){
            this.x=x;
            this.y=y;
            this.age=age;
        }
        public int compareTo(Wood o){
            if(this.age<o.age){
                return -1;
            }
            else return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        groundNourishment = new int[N][N];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(groundNourishment[i],5);
        }

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            woodList.add(new Wood(x,y,age));
        }
        Collections.sort(woodList);


    }
}
