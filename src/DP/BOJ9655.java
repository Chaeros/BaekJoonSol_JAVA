package DP;

import java.io.*;

public class BOJ9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int d[] = new int[N+1];

        d[1]=1;
        if(N>=2) d[2]=2;
        if(N>=3) d[3]=1;

        for(int i=4;i<=N;++i){
            d[i]=Math.min(d[i-1],d[i-3])+1;
        }

        if(d[N]%2==1){
            bw.write("SK\n");
        }
        else{
            bw.write("CY\n");
        }
        bw.flush();
        bw.close();
    }
}
