package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2798 {

    static int N,M;
    static int cards[];
    static boolean visited[];

    static int maxSum = 0;

    static int currentCards[];
    public static void dfs(int index, int depth){
        if ( depth == 3 ){
            int sum = calculateSum();
            if( sum <= M ){
                maxSum = Math.max(maxSum,sum);
            }
            return;
        }

        for ( int i = index ; i < N ; ++i ){
            currentCards[depth] = cards[i];
            dfs(i+1,depth+1);
        }
    }

    public static int calculateSum(){
        int sum = 0;
        for ( int card : currentCards ){
            sum += card;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        visited = new boolean[N];
        currentCards = new int[N];

        st = new StringTokenizer(br.readLine());
        for ( int i = 0 ; i < N ; ++ i ){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        bw.write(maxSum+"\n");
        bw.flush();
        bw.close();
    }
}
