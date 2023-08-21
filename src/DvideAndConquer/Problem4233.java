// https://www.acmicpc.net/problem/4233
// 가짜 소수, Gold5
// 2023년 8월 20일
// 통과

package DvideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Problem4233 {
    static boolean isPrime(long num){
        if(num<2) return false;
        for(long i=2;i*i<=num;++i){
            if(num%i==0) return false;
        }
        return true;
    }

    static long fpow(long a, long p, long mod){

        if(p==1){
            return a;
        }
        else{
            long x = fpow(a,(long)(p/2),mod);

            if((p%2)==0){
                return (x*x)%mod;
            }
            else{
                return (((x*x)%mod)*a)%mod;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        long A,B;
        long a,p;

        while(true){
            st = new StringTokenizer(br.readLine());
            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());

            if(A==0 && B==0) break;

            a = Math.min(A,B);
            p = Math.max(A,B);

            if(isPrime(p)){
                bw.write("no\n");
            }
            else{
                if(fpow(a,p,p)==a) bw.write("yes\n");
                else bw.write("no\n");
            }

        }
        bw.flush();
        bw.close();
    }
}
