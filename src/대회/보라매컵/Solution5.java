package 대회.보라매컵;

import java.io.*;
import java.util.StringTokenizer;

// 7번
public class Solution5 {

    static int n;
    static int maxVal[];
    static int currentVal[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        maxVal = new int[n];
        for(int i=0;i<n;++i){
            maxVal[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        currentVal = new int[n];
        for(int i=0;i<n;++i){
            currentVal[i] = Integer.parseInt(st.nextToken());
        }

        int pushCount = Integer.parseInt(br.readLine());

        if(!validateIsCorrectInputNumber()){
            System.out.print(-1);
        }
        else{
            while(pushCount>0){
                pushCount--;
                currentVal[n-1]++;
                for(int i=n-1;i>0;--i){
                    if(currentVal[i]>maxVal[i]){
                        currentVal[i]=0;
                        if(i!=0) currentVal[i-1]++;
                    }
                    else{
                        break;
                    }
                }
            }

            String result="";
            for(int i=0;i<n;++i){
                result+=currentVal[i];
            }
            System.out.print(result);
        }

    }

    static boolean validateIsCorrectInputNumber(){
        for(int i=n-1;i>0;--i){
            if(currentVal[i]>maxVal[i]){
                return false;
            }
        }
        return true;
    }
}
