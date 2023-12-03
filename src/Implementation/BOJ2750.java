// https://www.acmicpc.net/problem/2750
// 수 정렬하기, Bronze2
// 2023년 12월 2일
// 통과

package Implementation;

import java.io.*;
import java.util.TreeSet;

public class BOJ2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<N;++i){
            set.add(Integer.parseInt(br.readLine()));
        }

        for(int x:set){
            bw.write(x+"\n");
        }
        bw.flush();
        bw.close();
    }
}
