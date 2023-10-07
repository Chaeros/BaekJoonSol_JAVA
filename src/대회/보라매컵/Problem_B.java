package 대회.보라매컵;

import java.io.*;
import java.util.*;

public class Problem_B {

    static ArrayList<LinkedList<Integer>> list = new ArrayList<>();
    static int itemArea[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long P = Long.parseLong(st.nextToken());

        for(int i=0;i<N;++i) list.add(new LinkedList<>());
        itemArea = new int[N];
        int result=1;

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int val = Integer.parseInt(st.nextToken());
                if(val==-1) itemArea[i]++;
                else list.get(i).add(val);
            }
            Collections.sort(list.get(i));
        }

        outter : for(int i=0;i<N;++i){
            for(int x:list.get(i)){
                if(P>=x){
                    P+=x;
                }
                else{
                    if(itemArea[i]>0)
                    {
                        while(itemArea[i]>0){
                            itemArea[i]--;
                            P*=2;
                            if(P>=x){
                                P+=x;
                                break;
                            }

                            if(itemArea[i]==0){
                                result=0;
                                break outter;
                            }
                        }
                    }
                    else{
                        result=0;
                        break outter;
                    }
                }
            }
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
