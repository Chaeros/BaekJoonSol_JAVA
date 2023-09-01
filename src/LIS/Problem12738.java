// https://www.acmicpc.net/problem/12738
// 가장 긴 증가하는 부분 수열3, Gold2
// 2023년 9월 1일
// 통과

package LIS;

import java.io.*;
import java.util.StringTokenizer;

public class Problem12738{
    static int N;
    static int list[];
    static int result[];
    static void binarySearch(int start,int end,int x){

        while(start<=end){
            int mid=(start+end)/2;
            if(result[mid]==x){
                return;
            }
            else if(result[mid]<x){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        result[start]=x;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new int[N];
        result = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            list[i]=Integer.parseInt(st.nextToken());
        }

        result[0]=list[0];
        int length=0;
        for(int i=1;i<N;++i){
            if(result[length]>=list[i]){
                binarySearch(0,length,list[i]);
            }
            else{
                result[++length]=list[i];
            }
//            for(int j=0;j<N;++j){
//                System.out.print(result[j]+" ");
//            }
//            System.out.println();
        }
//        for(int i=0;i<N;++i){
//            System.out.print(result[i]+" ");
//        }
//        System.out.println();

        bw.write(length+1+"\n");
        bw.flush();
        bw.close();
    }
}