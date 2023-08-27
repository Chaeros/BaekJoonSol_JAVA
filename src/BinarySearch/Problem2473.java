// https://www.acmicpc.net/problem/2473
// 세 용액, Gold3
// 2023년 8월 27일
// 통과

package BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2473{
    static long list[];
    static long minVal = (long)2e12;

    static long smallVal;
    static long middleVal;
    static long bigVal;

    static void binarySearch(int start, int end){
        int front=start+1;
        int rear=end-1;
        while(front<=rear){
            int mid = (front+rear)/2;

            if(Math.abs(list[start]+list[end]+list[mid])<minVal){
                minVal=Math.abs(list[start]+list[end]+list[mid]);
                smallVal=list[start];
                middleVal=list[mid];
                bigVal=list[end];
            }

            if(list[start]+list[end]+list[mid]==0) break;
            else if(list[start]+list[end]+list[mid]<0) front=mid+1;
            else rear=mid-1;
        }
    }

    static void func(int start, int end){
        for(int i=start;i<end-1;++i){
            for(int j=end;j>i+1;--j){
                binarySearch(i,j);
            }
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        list = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            list[i]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(list);

        func(0,N-1);

        bw.write(smallVal+" "+middleVal+" "+bigVal);
        bw.flush();
        bw.close();
    }
}