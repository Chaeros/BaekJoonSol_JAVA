// https://www.acmicpc.net/problem/1497
// 기타콘서트, Silver2
// 2023년 8월 2일
// 통과

package BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1497 {
    static int N,M;
    static long bit[];
    static int maxPlay=0;
    static int minCount=(int)1e9;

    static void func(int depth, long col[]){
        if(depth==N){
            long result=0;
            int elementCount=0;
            for(int i=0;i<N;++i){
                result|=col[i];
                if(col[i]!=0) ++elementCount;
            }
            int playCount=0;
            for(int i=0;i<M;++i){
                if((result&((long)1<<(long)i))==((long)1<<(long)i)) ++playCount;
            }
            if(playCount>=maxPlay){
                maxPlay=playCount;
                if(minCount>elementCount) minCount=elementCount;
            }
            return;
        }
        col[depth]=bit[depth];
        func(depth+1,col);
        col[depth]=0;
        func(depth+1,col);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String str[]=new String[N];
        bit = new long [N+1];

        for(int i=0;i<N;++i){
            st=new StringTokenizer(br.readLine());
            str[i]=st.nextToken();
            String temp=st.nextToken();
            for(int j=0;j<M;++j){
                bit[i]<<=1;
                if(temp.charAt(j)=='Y') bit[i]+=1;
            }
        }
        long col[]=new long[N];
        func(0,col);
        if(minCount==0) System.out.println(-1);
        else System.out.println(minCount);
    }
}
