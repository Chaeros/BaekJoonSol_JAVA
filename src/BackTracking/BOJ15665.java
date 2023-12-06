package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15665 {

    static int N,M;
    static int arr[];
    static int result[];

    static void dfs(int index,int depth){
        if(depth==M){

            return;
        }

        for(int i=index;i<N;++i){
            result[i]=arr[i];
            dfs(i,depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[st.countTokens()];
        result = new int[st.countTokens()];
        int i=0;
        while(st.hasMoreTokens()){
            arr[i]=Integer.parseInt(st.nextToken());
            i++;
        }

    }
}
