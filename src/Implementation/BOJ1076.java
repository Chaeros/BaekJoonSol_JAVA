// https://www.acmicpc.net/problem/1076
// 저항, Bronze2
// 2023년 9월 25일
// 통과

package Implementation;

import java.io.*;
import java.util.Arrays;

public class BOJ1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] color = {"black", "brown", "red", "orange", "yellow", "green",
                "blue", "violet", "grey", "white"};

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        long result = (Arrays.asList(color).indexOf(A) * 10) + Arrays.asList(color).indexOf(B);
        result *= Math.pow(10, Arrays.asList(color).indexOf(C));

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}