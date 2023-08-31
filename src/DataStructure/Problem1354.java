// https://www.acmicpc.net/problem/1354
// 무한 수열2, Gold5
// 2023년 8월 29일
// 통과

package DataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem1354{
    static long N,P,Q,X,Y;
    static Map<Long,Long> map = new HashMap<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        map.put(0L,1L);
        func(N);
        bw.write(map.get(N)+"\n");
        bw.flush();
        bw.close();
    }

    static long func(long num){
        if(map.containsKey(num)) return map.get(num);
        if(num<=0) return 1;

        long first = func(num/P-X);
        long secont = func(num/Q-Y);

        map.put(num,first+secont);
        return first+secont;
    }
}