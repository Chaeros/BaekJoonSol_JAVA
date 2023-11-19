package 대회.보라매컵;


import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Solution3 {
    TreeSet<Integer> set = new TreeSet<>();
    List<Integer> list = new LinkedList<>();



    public int solution(int n,int[] orders){
        int answer=0;

        for(int x:orders){
            if(!set.contains(x)){
                set.add(x);
                list.add(x);
                list.add(x);
            }
        }

        for(int x:orders){
            for(int i=0;i<list.size();++i){
                if(x==list.get(i)){
                    answer+=i;
                    list.remove(i);
                    break;
                }
            }
        }

        return answer;
    }
}