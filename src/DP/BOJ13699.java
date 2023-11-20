package DP;

import java.io.*;

public class BOJ13699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;++i){
            String str = br.readLine();
            char start = str.charAt(0);
            char end = str.charAt(str.length()-1);
            String result = String.valueOf(start+end);
            bw.write(start+""+end+"\n");
        }

        bw.flush();
        bw.close();
    }
}
