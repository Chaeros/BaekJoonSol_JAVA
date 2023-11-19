package 대회.보라매컵;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution2 {

    public int result[];
    public Set<ArrayList<Integer>> set = new HashSet<>();
    public ArrayList<Integer> resultList = new ArrayList<>();
    public int unusedNSize;
    public int unusedMSize;
    public int count=0;

    public void dfs(int depth,int n,int m){
        if(depth==n+m){
            if(!set.contains(resultList)){
                set.add(resultList);
                count++;
            }
            return;
        }

        for(int i=1;i<=2;++i){
            if(i==1 && unusedNSize>0){
                resultList.add(1);
                unusedNSize--;
                dfs(depth+1,n,m);
                resultList.remove(depth);
                unusedNSize++;
            }
            else if(i==2 && unusedMSize>0){
                resultList.add(2);
                unusedMSize--;
                dfs(depth+1,n,m);
                resultList.remove(depth);
                unusedMSize++;
            }
        }
    }

    public int solution(int n, int m) {
        int answer = 0;
        result = new int[n+m];
        unusedNSize = n;
        unusedMSize = m;

        count=0;
        dfs(0,n,m);
        answer = count;
        return answer;
    }
}