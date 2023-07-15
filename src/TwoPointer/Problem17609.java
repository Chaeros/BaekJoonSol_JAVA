//https://www.acmicpc.net/problem/17609
//회문 Gold5
//2023년 7월 15일

package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem17609 {

    static int start, end;

    static boolean compare(String str){
        boolean check;
        if(check=(str.charAt(start)==str.charAt(end))){
            ++start;
            --end;
        }
        return check;
    }


    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;++i){
            String str=br.readLine();
            int count=0;
            start=0;
            end=str.length()-1;
            while(start<end){
                if(!compare(str)){
                    ++count;
                    break;
                }
            }
            int tempStart=start;
            int tempEnd=end;

            boolean check=false;
            if(count==1){
                ++start;
                while(start<end){
                    if(!compare(str)){
                        check=true;
                        break;
                    }
                }

                if(check==true){
                    start=tempStart;
                    end=tempEnd-1;
                    while(start<end){
                        if(!compare(str)){
                            ++count;
                            break;
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }
}
