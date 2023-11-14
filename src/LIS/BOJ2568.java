// https://www.acmicpc.net/problem/2568
// 전깃줄 - 2, Platinum5
// 2023년 11월 13일
// 통과

package LIS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2568 {

    static int N;
    static ArrayList<Node> d = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();

    static int binarySearch(int start,int end,int target){

        while(start<=end){
            int mid = (start+end)/2;

            if(result.get(mid)==target){
                return mid;
            }
            else if(result.get(mid)<target){
                start=mid+1;
            }
            else if(result.get(mid)>target){
                end=mid-1;
            }
        }
        return start;
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if(this.start<o.start) return -1;
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            d.add(new Node(a,b));
        }
        Collections.sort(d);

        ArrayList<Integer> indexBox = new ArrayList<>();
        result.add(d.get(0).end);
        indexBox.add(0);
        for(int i=1;i<N;++i){
            int index = binarySearch(0,result.size()-1,d.get(i).end);
            if(result.size()==index) result.add(d.get(i).end);
            else result.set(index,d.get(i).end);
            indexBox.add(index);
        }

        bw.write(N-result.size()+"\n");

        ArrayList<Integer> resultList = new ArrayList<>();
        int currentIndex=result.size()-1;
        for(int i=indexBox.size()-1;i>=0;--i){
            if(indexBox.get(i)==currentIndex){
                resultList.add(i);
                currentIndex--;
                if(currentIndex==-1) break;
            }
        }
        Collections.reverse(resultList);

        outter: for(Node node:d){
            for(int x:resultList){
                if(node.start==d.get(x).start) continue outter;
            }
            bw.write(node.start+"\n");
        }
        bw.flush();
        bw.close();
    }
}
