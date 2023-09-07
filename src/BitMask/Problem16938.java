// https://www.acmicpc.net/problem/16938
// 캠프준비, Gold5
// 2023년 9월 6일
// 통과

package BitMask;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16938{
    static int problem[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        problem = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            problem[i]=Integer.parseInt(st.nextToken());
        }

        int allNumberOfCases=(int)Math.pow(2,N);

        int count=0;
        for(int i=1;i<allNumberOfCases;++i){
            int sum=0;
            int minVal=Integer.MAX_VALUE;
            int maxVal=Integer.MIN_VALUE;
            int roundCount=0;

            for(int j=0;j<N;++j){
                if((i & (int)Math.pow(2,j))==(int)Math.pow(2,j)){
                    sum+=problem[j];
                    minVal=Math.min(minVal,problem[j]);
                    maxVal=Math.max(maxVal,problem[j]);
                    ++roundCount;
                }
            }

            int diff = maxVal-minVal;
            if(sum>=L && sum<=R && diff>=X && roundCount>=2){
                ++count;
            }
        }

        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}