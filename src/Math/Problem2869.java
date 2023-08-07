// https://www.acmicpc.net/problem/2869
// 달팽이는 올라가고 싶다, Bronze1
// 2023년 8월 7일
// 통과

package Math;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2869 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        if((double)(V-B)/(A-B)==(V-B)/(A-B)) bw.write((V-B)/(A-B)+"\n");
        else bw.write((V-B)/(A-B)+1+"\n");
        bw.flush();
        bw.close();
    }
}
