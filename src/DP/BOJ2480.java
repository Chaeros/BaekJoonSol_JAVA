package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[7];
        int maxVal=0;
        int maxCount=0;
        for(int i=0;i<3;++i){
            int val = Integer.parseInt(st.nextToken());
            arr[val]++;
            if(maxCount<arr[val]){
                maxCount=arr[val];
                maxVal=val;
            }
            else if(maxCount==arr[val] && maxVal<val){
                maxVal=val;
            }
        }

        int result=0;
        if(arr[maxVal]==3){
            result=10000+maxVal*1000;
        }
        else if(arr[maxVal]==2){
            result=1000+100*maxVal;
        }
        else if(arr[maxVal]==1){
            result=100*maxVal;
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
