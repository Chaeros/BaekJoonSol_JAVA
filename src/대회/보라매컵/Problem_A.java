package 대회.보라매컵;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int sum=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            sum+=Integer.parseInt(st.nextToken());
        }

        if(sum%X==0) bw.write("1\n");
        else bw.write("0\n");
        bw.flush();
        bw.close();
    }
}
