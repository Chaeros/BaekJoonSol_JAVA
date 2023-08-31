// https://www.acmicpc.net/problem/12015
// 가장 긴 증가하는 부분 수열2, Gold2
// 2023년 8월 29일
// 통과

package LIS;

import java.io.*;
import java.util.StringTokenizer;

public class Problem12015{
    static int subSet[];

    static int binarySearch(int start,int end,int val){
        while(start<end){
            int mid = (start+end)/2;

            if(val==subSet[mid]){
                return mid;
            }
            else if(val>subSet[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        if(val>subSet[start]) return start+1;
        else return start;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        subSet = new int[N];
        int ans=0;

        st = new StringTokenizer(br.readLine());

        subSet[0]=Integer.parseInt(st.nextToken());
        ++ans;
        while(st.hasMoreTokens()){
            int inputNum=Integer.parseInt(st.nextToken());
            if(subSet[ans-1]>=inputNum){
                int diffIndex=binarySearch(0,ans-1,inputNum);
                subSet[diffIndex]=inputNum;
            }
            else subSet[ans++]=inputNum;

//            for(int i=0;i<N;++i){
//                System.out.print(subSet[i]+" ");
//            }
//            System.out.println();
        }

//        for(int i=0;i<N;++i){
//            System.out.print(subSet[i]+" ");
//        }
//        System.out.println();

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
}