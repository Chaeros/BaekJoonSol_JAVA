package 대회.보라매컵;

import java.io.*;
import java.util.StringTokenizer;

public class A번_방형구탐색 {
    static int N;
    static int arr[];
    static int getFlowerNumber(int start, int end, int flowerNumber){
        int answer=0;

        for(int i=start;i<=end;++i){
            if(arr[i]==flowerNumber){
                ++answer;
            }
        }

        return answer;
    }

    static void removeFlower(int start,int end){

        for(int i=start;i<=end;++i){
            arr[i]=0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;++i){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int flowerNumber;
            if(command==1){
                flowerNumber = Integer.parseInt(st.nextToken());
                bw.write(getFlowerNumber(start,end,flowerNumber)+"\n");
            }
            else {
                removeFlower(start, end);
            }
        }
        bw.flush();
        bw.close();
    }
}
