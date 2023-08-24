// https://www.acmicpc.net/problem/2230
// 수 고르기, Gold5
// 2023년 8월 24일
// 통과

package BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2230 {
    static int N,M;
    static int A[];
    static int minVal = (int)1e11;
    static void binarySearch(int x){
        int start=x;
        int end=N-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]-A[x]>=M && minVal>A[mid]-A[x]){
                minVal=A[mid]-A[x];
            }

            if(A[mid]-A[x]==M) break;
            else if(A[mid]-A[x]>M){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];


        for(int i=0;i<N;++i){
            A[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        for(int i=0;i<N;++i){
            binarySearch(i);
        }
        bw.write(minVal+"\n");
        bw.flush();
        bw.close();
    }
}
