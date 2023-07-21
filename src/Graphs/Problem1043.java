package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem1043 {

    static ArrayList<ArrayList<Integer>> list= new ArrayList<>();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;++i) list.add(new ArrayList<>());
        HashSet set = new HashSet();

        st=new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        for(int i=0;i<temp;++i){
            set.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<M;++i){
            st=new StringTokenizer(br.readLine());
            temp = Integer.parseInt(st.nextToken());
            //System.out.println(temp);
            for(int j=0;j<temp;++j){
                list.get(j).add(Integer.parseInt(st.nextToken()));
            }
        }

        int result=0;
        for(int i=0;i<M;++i){
            boolean isPossible=true;
            for(int j=0;j<list.get(i).size();++j){
                if(set.contains(list.get(i).get(j)))
                {
                    isPossible=false;
                    break;
                }
            }
            if(isPossible) ++result;
        }
        System.out.println(result);
    }
}
