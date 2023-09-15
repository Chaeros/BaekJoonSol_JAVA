// https://www.acmicpc.net/problem/2143
// 두 배열의 합, Gold3
// 2023년 9월 12일
// 통과

package Prefix_Sum;

import java.io.*;
import java.util.*;

public class BOJ2143{

    static int T;
    static ArrayList<Node> allPrefixSumB;
    static long resultCount=0;

    static class Node implements Comparable<Node>{
        int prefixSum;
        int count;

        public Node(int prefixSum, int count) {
            this.prefixSum = prefixSum;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if(this.prefixSum<o.prefixSum) return -1;
            else if(this.prefixSum>o.prefixSum) return 1;
            else return 0;
        }

        public int getPrefixSum() {
            return prefixSum;
        }

        public int getCount() {
            return count;
        }
    }
    static void binarySearch(int start, int end, int val){
        while(start<=end){
            int mid=(start+end)/2;

            if(allPrefixSumB.get(mid).getPrefixSum()+val==T){
                resultCount+=allPrefixSumB.get(mid).getCount();
                break;
            }
            else if(allPrefixSumB.get(mid).getPrefixSum()+val<T) start=mid+1;
            else end=mid-1;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // A 배열을 입력받고 prefix_sum을 구함
        T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int A[] = new int[n];
        int prefixSumA[] = new int[n];
        st = new StringTokenizer(br.readLine());
        A[0]=Integer.parseInt(st.nextToken());
        prefixSumA[0]=A[0];
        for(int i=1;i<n;++i){
            A[i]=Integer.parseInt(st.nextToken());
            prefixSumA[i]=prefixSumA[i-1]+A[i];
        }

        // B 배열을 입력받고 prefix_sum을 구함
        int m = Integer.parseInt(br.readLine());
        int B[] = new int[m];
        int prefixSumB[] = new int[m];
        st = new StringTokenizer(br.readLine());
        B[0]=Integer.parseInt(st.nextToken());
        prefixSumB[0]=B[0];
        for(int i=1;i<m;++i){
            B[i]=Integer.parseInt(st.nextToken());
            prefixSumB[i]=prefixSumB[i-1]+B[i];
        }

        // A 배열에서 나올 수 있는 모든 누적합의 경우를 구하여 저장함
        ArrayList<Integer> allPrefixSumA = new ArrayList<>();
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(j+i>=n) break;
                if(i==0) allPrefixSumA.add(prefixSumA[j]);
                else allPrefixSumA.add(prefixSumA[j+i]-prefixSumA[j]);
            }
        }

        // B 배열에서 나올 수 있는 모든 누적합의 경우를 구하여 맵에 저장함
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<m;++i){
            for(int j=0;j<m;++j){
                if(j+i>=m) break;
                if(i==0){
                    int num = map.getOrDefault(prefixSumB[j], 0);
                    map.put(prefixSumB[j],num+1);
                }
                else{
                    int num = map.getOrDefault(prefixSumB[j+i]-prefixSumB[j], 0);
                    map.put(prefixSumB[j+i]-prefixSumB[j],num+1);
                }
            }
        }

        // 맵에 저장해두었던 B 배열의 연속되는 누적합을 이분탐색을 위해 ArrayList로 옮김
        allPrefixSumB = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            allPrefixSumB.add(new Node(entry.getKey(),entry.getValue()));
        }
        // 누적합 크기에 따라 ArrayList를 오름차순으로 정렬
        Collections.sort(allPrefixSumB);

        // A 배열에서 구한 연속되는 누적합이 B 배열에서의 연속 누적합과 합했을 경우 T의 값이 나오는 수를 구함
        for(int i=0;i<allPrefixSumA.size();++i){
            binarySearch(0,allPrefixSumB.size()-1,allPrefixSumA.get(i));
        }

        bw.write(resultCount+"\n");
        bw.flush();
        bw.close();
    }
}