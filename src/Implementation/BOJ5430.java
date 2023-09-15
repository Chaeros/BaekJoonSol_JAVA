// https://www.acmicpc.net/problem/5430
// AC, Gold5
// 2023년 9월 11일
// 통과

package Implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class BOJ5430{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;++t){
            String command = br.readLine();
            int arrCnt = Integer.parseInt(br.readLine());
            String arrStrInput = br.readLine();

            arrStrInput=arrStrInput.substring(1,arrStrInput.length()-1);
            String arrStr[] = arrStrInput.split(",");

            LinkedList<String> list = new LinkedList<>();
            for(int i=0;i<arrCnt;++i){
                list.add(arrStr[i]);
            }

            boolean isError = false;
            boolean isReverse = false;
            for(int i=0;i<command.length();++i){
                if(command.charAt(i)=='R'){
                    isReverse=(!isReverse);
                }
                else if(command.charAt(i)=='D'){
                    if(!list.isEmpty()){
                        if(isReverse) list.remove(list.size()-1);
                        else list.remove(0);
                    }
                    else{
                        isError=true;
                        break;
                    }
                }
            }
            ArrayList<String> arrayList = new ArrayList<>(list);

            if(isError) sb.append("error\n");
            else{
                sb.append("[");
                if(isReverse){
                    for(int i=arrayList.size()-1;i>=0;--i){
                        sb.append(arrayList.get(i));
                        if(i>0) sb.append(",");
                    }
                }
                else{
                    for(int i=0;i<arrayList.size();++i){
                        sb.append(arrayList.get(i));
                        if(i<arrayList.size()-1) sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}