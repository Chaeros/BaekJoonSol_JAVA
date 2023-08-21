// https://www.acmicpc.net/problem/1629
// 곱셈, Silver1
// 2023년 8월 20일
// 통과

package DvideAndConquer;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem1629{

    static BigInteger zero = new BigInteger("0");
    static BigInteger one = new BigInteger("1");
    static BigInteger two = new BigInteger("2");

    static BigInteger fpow(BigInteger A, BigInteger B, BigInteger C){
        if(B.compareTo(one)==0){
            return A;
        }
        else{
            BigInteger x = fpow(A,B.divide(two),C);
            if(B.remainder(two).compareTo(zero)==0){
                if(x.compareTo(C)==1)
                    return ((x.remainder(C)).multiply(x.remainder(C))).remainder(C);
                return x.multiply(x).remainder(C);
            }
            else{
                if(x.compareTo(C)==1)
                    return ((x.remainder(C)).multiply(x.remainder(C)).multiply(A)).remainder(C);
                return x.multiply(x).multiply(A).remainder(C);
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        BigInteger C = new BigInteger(st.nextToken());

        if(A.compareTo(C)==1) A=A.remainder(C);
        bw.write(fpow(A,B,C)+"\n");
        bw.flush();
        bw.close();
    }
}