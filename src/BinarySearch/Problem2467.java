// https://www.acmicpc.net/problem/2467
// 용액, Gold5
// 2023년 8월 22일
// 통과

package BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2467 {

    static int list[];
    static int minDiff = 2000000001;
    static int firstVal=0;
    static int secondVal=0;
    static void binarySearch(int start,int end){
        while(start<end){
            int absSum=Math.abs(list[start]+list[end]);
            if(absSum<minDiff){
                firstVal=list[start];
                secondVal=list[end];
                minDiff=absSum;
            }

            if(list[start]+list[end]==0) break;
            else if(list[start]+list[end]>0){
                --end;
            }
            else ++start;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        list = new int[N];
        for(int i=0;i<N;++i){
            list[i]=Integer.parseInt(st.nextToken());
        }

        binarySearch(0,N-1);

        bw.write(firstVal+" "+secondVal+"\n");
        bw.flush();
        bw.close();
    }
}