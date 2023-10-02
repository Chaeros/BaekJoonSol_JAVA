// https://www.acmicpc.net/problem/20055
// 컨베이어 벨트 위의 로봇, Gold5
// 2023년 10월 1일
// 통과

package SWEA;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20055 {
    static int N,K;
    static List<Node> list = new LinkedList<>();
    static int outOfDurability;

    static class Node{
        int durability;
        boolean located;
        public Node(int durability, boolean located){
            this.durability = durability;
            this.located = located;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        outOfDurability =0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*N;++i){
            list.add(new Node(Integer.parseInt(st.nextToken()),false));
        }

        int resultVal=0;
        while(outOfDurability<K){
            ++resultVal;
            Node node = list.get(2*N-1);
            list.remove(2*N-1);
            list.add(0,node);

            if(list.get(N-1).located) list.get(N-1).located=false;

            for(int j=N-1;j>0;--j){
                if(!list.get(j).located && list.get(j).durability>0){
                    if(list.get(j-1).located){
                        list.get(j).located=true;
                        --list.get(j).durability;
                        list.get(j-1).located=false;
                        if(list.get(j).durability==0){
                            ++outOfDurability;
                        }
                    }
                }
            }

            if(list.get(N-1).located) list.get(N-1).located=false;

            if(list.get(0).durability>0){
                list.get(0).located=true;
                --list.get(0).durability;
                if(list.get(0).durability==0){
                    ++outOfDurability;
                }
            }
        }

        bw.write(resultVal+"\n");
        bw.flush();
        bw.close();
    }
}
