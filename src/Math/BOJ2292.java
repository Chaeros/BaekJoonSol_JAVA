// https://www.acmicpc.net/problem/2292
// 벌집, Bronze2
// 2024년 1월 13일
// 통과

package Math;

import java.io.*;

public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result=1;
        int layerLastNumber = 1;

        int round=1;
        while( N > layerLastNumber ){
            layerLastNumber = layerLastNumber + ( 6 * round++ );
            result++;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
