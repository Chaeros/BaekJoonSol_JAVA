package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int d[] = new int[N];
        int endIndex=0;
        st = new StringTokenizer(br.readLine());
        d[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;++i){
            int val = Integer.parseInt(st.nextToken());
            for(int j=0;j<=endIndex;++j){
                if(d[j]>=val){
                    d[j]=val;
                    break;
                }
                if(j==endIndex){
                    endIndex++;
                    d[endIndex]=val;
                }
            }
        }
        bw.write(endIndex+1+"\n");
        bw.flush();
        bw.close();
    }
}
