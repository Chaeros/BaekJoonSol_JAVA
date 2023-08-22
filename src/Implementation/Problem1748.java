// https://www.acmicpc.net/problem/1748
// 수 이어 쓰기1
// 2023년 8월 22일
// 통과

package Implementation;

import java.io.*;

public class Problem1748 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result=0;
        int place=10;
        int numberOfDigit=1;
        for(int i=1;i<=N;++i){
            if(i%place==0){
                ++numberOfDigit;
                place*=10;
            }
            result+=numberOfDigit;
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
