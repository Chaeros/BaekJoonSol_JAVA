// https://www.acmicpc.net/problem/13711
// LCS4, Platinum5
// 2023년 11월 11일
// 통과

package LCS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13711 {

    static int N;

    static ArrayList<Integer> result;
    static int binarySearch(int start,int end,int target){
        while(start<=end){
            int mid = (start+end)/2;

            if(result.get(mid)==target) return mid;
            if(result.get(mid)<target){
                start=mid+1;
            }
            else if(result.get(mid)>target){
                end=mid-1;
            }
        }

        return start;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int arr1[] = new int[N];
        int arr2[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            int x = Integer.parseInt(st.nextToken());
            arr2[x-1] = i;
        }

        int arr3[] = new int[N];
        for(int i=0;i<N;++i){
            arr3[i]=arr2[arr1[i]-1];
        }

//        for(int i=0;i<N;++i){
//            System.out.print(arr3[i]+" ");
//        }
//        System.out.println();

        result = new ArrayList<>();
        result.add(arr3[0]);
        for(int i=1;i<N;++i){
            int index = binarySearch(0,result.size()-1,arr3[i]);
            if(result.size()==index) result.add(arr3[i]);
            else result.set(index,arr3[i]);
        }

//        for(int i=0;i<result.size();++i){
//            System.out.print(result.get(i)+" ");
//        }
//        System.out.println();

        bw.write(result.size()+"\n");
        bw.flush();
        bw.close();
    }
}
