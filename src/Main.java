import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int cards[];
    static int binarySearch(int x){
        int start=0;
        int end =N-1;

        int numCount=0;
        while(start<=end){
            int mid = (start+end)/2;

            if(cards[mid]==x){
                ++numCount;
                int temp=mid-1;
                while(temp>=0 && cards[temp]==x){
                    ++numCount;
                    --temp;
                }
                temp=mid+1;
                while(temp<=N-1 && cards[temp]==x){
                    ++numCount;
                    ++temp;
                }
                break;
            }
            else{
                if(cards[mid]<x) start=mid+1;
                else end=mid-1;
            }
        }
        return numCount;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cards = new int[500001];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            ++cards[Integer.parseInt(st.nextToken())];
        }
        //Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i){
            int val = Integer.parseInt(st.nextToken());
            bw.write(cards[val]+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}