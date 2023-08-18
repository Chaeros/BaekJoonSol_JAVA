// https://www.acmicpc.net/problem/7662
// 이중 우선순위 큐, Gold4
// 2023년 8월 16일
// 통과

package DataStructure;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem7662{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;++t){
            TreeMap<Integer,Integer> map = new TreeMap<>();
            int qSize=0;
            int K = Integer.parseInt(br.readLine());
            for(int i=0;i<K;++i){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("I")){
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num,map.getOrDefault(num,0)+1);
                    ++qSize;
                }
                else if(command.equals("D")){
                    int num = Integer.parseInt(st.nextToken());
                    if(num ==-1 && qSize>0){
                        int originNum = map.put(map.firstKey(),map.get(map.firstKey())-1);
                        if(originNum==1) map.remove(map.firstKey());
                        --qSize;
                    }
                    else if(num ==1 && qSize>0){
                        int originNum = map.put(map.lastKey(),map.get(map.lastKey())-1);
                        if(originNum==1) map.remove(map.lastKey());
                        --qSize;
                    }
                }
            }

            if(qSize==0){
                bw.write("EMPTY\n");
            }
            else{
                bw.write(map.lastKey()+" "+map.firstKey()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}