// https://www.acmicpc.net/problem/1351
// 무한 수열, Gold5
// 2023년 8월 7일
// 통과

package DP;

import java.io.*;
import java.util.*;

public class Problem1351{
    static long N,P,Q;
    static Map<Long,Long> map = new HashMap<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map.put(0L,1L);
        bw.write(func(N)+"\n");
        bw.flush();
        bw.close();
    }

    static long func(long num){
        if(map.containsKey(num)) return map.get(num);

        long first=func(num/P);
        long second=func(num/Q);
        map.put(num,first+second);

        return first+second;
    }
}