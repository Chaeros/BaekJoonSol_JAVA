// https://www.acmicpc.net/problem/10816
// 숫자 카드2, Silver4
// 2023년 8월 23일
// 미제출

package BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10816 {

    static int N;
    static int cards[];

    static int lowerBound(int key){
        int start=0;
        int end = N;

        while(start<end){
            int mid=(start+end)/2;

            if(key<=cards[mid]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }

    static int upperBound(int key){
        int start=0;
        int end = N;

        while(start<end){
            int mid=(start+end)/2;

            if(key<cards[mid]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            cards[i]=Integer.parseInt(st.nextToken());
        };
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i){
            int val = Integer.parseInt(st.nextToken());
            bw.write(upperBound(val)-lowerBound(val)+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
