package DP;

import java.io.*;

public class BOJ10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long d[] = new long[10001];

        d[0]=0;
        d[1]=1;
        for(int i=2;i<=n;++i){
            d[i]=d[i-1]+d[i-2];
        }
        bw.write(d[n]+"\n");
        bw.flush();
        bw.close();
    }
}
