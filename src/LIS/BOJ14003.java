// https://www.acmicpc.net/problem/14003
// 가장 긴 증가하는 부분 수열5, Platinum5
// 2023년 9월 24일
// 통과

package LIS;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14003{

    static int N;
    static int arr[];
    static int lis[];
    static int index[];
    static int binarySearch(int start,int end, int target){
        int mid=0;
        while(start<=end){
            mid=(start+end)/2;

            if(lis[mid]==target) return mid;

            if(lis[mid]<target){
                start=mid+1;
            }
            else if(lis[mid]>target){
                end=mid-1;
            }
        }
        return start;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        lis = new int[N];
        index = new int[N];

        // 입력
        for(int i=0;i<N;++i){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        // lis 길이
        int length=1;
        lis[0]=arr[0];
        for(int i=1;i<N;++i){
            if(lis[length-1]<arr[i]){
                lis[length]=arr[i];
                index[i]=length;
                ++length;
            }
            else{
                int changeIndex=binarySearch(0,length-1,arr[i]);
                lis[changeIndex]=arr[i];
                index[i]=changeIndex;
            }
        }

        bw.write(length+"\n");

        // lis 배열
        int result[] = new int[length];
        int lastNum=N-1;
        for(int i=length-1;i>=0;--i){
            for(int j=lastNum;j>=0;--j){
                if(i==index[j]){
                    result[i]=arr[j];
                    lastNum=j;
                    break;
                }
            }
        }

        for(int i=0;i<length;++i){
            sb.append(result[i]+" ");
        }
        sb.append("\n");
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}