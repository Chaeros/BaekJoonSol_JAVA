package 대회.보라매컵.파댕이컵;

import java.io.*;
import java.util.StringTokenizer;

public class A_유치원생파댕이돌보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum=0;

        st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            sum+=Integer.parseInt(st.nextToken());
            i++;
        }

        if(sum>=T) bw.write("Padaeng_i Happy");
        else bw.write("Padaeng_i Cry");
        bw.flush();
        bw.close();
    }
}
