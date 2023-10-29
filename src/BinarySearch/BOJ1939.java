package BinarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1939 {
    static int N,M;
    static ArrayList<LinkedList<Node>> list = new ArrayList<>();


    static int binarySearch(int a,int b,int c){
        int result=-1;
        int start=0;
        int end=list.get(a).size();

        while(start<=end){
            int mid = (start+end)/2;

            if(list.get(a).get(mid).objective==b){
                if(list.get(a).get(mid).weight<c){
                    list.get(a).set(mid,new Node(list.get(a).get(mid).objective,c));
                    result = mid;
                    break;
                }
            }

            if(list.get(a).get(mid).objective<b){
                start = mid+1;
                result = start;
            }
            else if(list.get(a).get(mid).objective>b){
                end = mid-1;
                result = start;
            }
        }
        return result;
    }

    static class Node implements Comparable<Node>{
        int objective;
        int weight;

        public Node(int objective, int weight) {
            this.objective = objective;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if(this.objective<o.objective) return -1;
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<=M;++i){
            list.add(new LinkedList<>());
        }

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(binarySearch(a,b,c)==-1){
                list.get(a).add(new Node(b,c));
                list.get(b).add(new Node(a,c));
            }
            else{

            }
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bw.write(list.get(a).get(b).weight+"\n");
        bw.flush();
        bw.close();
    }
}