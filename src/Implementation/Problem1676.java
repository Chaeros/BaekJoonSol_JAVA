// https://www.acmicpc.net/problem/1676
// 팩토리얼 0의 개수
// 2023년 8월 3일
// 통과

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem1676 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger result = new BigInteger("1");
        for(int i=2;i<=N;++i){
            BigInteger temp = BigInteger.valueOf(i);
            result=result.multiply(temp);
        }
        int count=0;
        while(result.remainder(new BigInteger("10")).compareTo(new BigInteger("0"))==0){
            if(result.remainder(new BigInteger("10")).compareTo(new BigInteger("0"))==0){
                ++count;
            }
            result=result.divide(new BigInteger("10"));
        }
        System.out.println(count);
    }
}
