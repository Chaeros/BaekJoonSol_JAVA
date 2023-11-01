package BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {

    static int N,M;
    static int arr[];
    public static int binarySearch(int x){
        int start = 0;
        int end = N-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]==x) return 1;

            if(arr[mid]<x) start = mid+1;
            else end=mid-1;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i){
            int val = Integer.parseInt(st.nextToken());
            bw.write(binarySearch(val)+" ");
        }
        bw.flush();
        bw.close();
    }
}
