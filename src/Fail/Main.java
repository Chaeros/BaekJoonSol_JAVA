package Fail;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;++i){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            Map<Integer,Integer> map = new HashMap<>();
            boolean proceeding = true;
            int maxNum = 0;
            long armyNum =0;
            for(int j=0;j<t;++j){
                int x = Integer.parseInt(st.nextToken());
                int num = map.getOrDefault(x, 0);
                map.put(x,num+1);
                if(num+1>maxNum){
                    maxNum=num+1;
                    armyNum=x;
                }
            }
            if(maxNum>t/2) bw.write(armyNum + "\n");
            else if(proceeding) bw.write("SYJKGW\n");
        }
        bw.flush();
        bw.close();
    }
}