package 삼성B형.끝말잇기2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

class UserSolution {

    int participantNumber; // 참가자수
    boolean isEliminated[]; // 탈락여부
    Set<Integer> survivor;
    Set<String> usedString;
    Set<String> reverseString;
    Map<Character,PriorityQueue<String>> map;

    public void init(int N, int M, char[][] mWords)
    {
        participantNumber = N;
        isEliminated = new boolean[N+1];
        usedString = new HashSet<>();
        reverseString = new TreeSet<>();
        survivor = new HashSet<>();
        map = new HashMap<>();

        for ( char c = 'a'; c <= 'z' ; ++c ) {
            map.put(c, new PriorityQueue<>());
        }

        for ( int n = 1 ; n <= N ; ++n ) {
            survivor.add(n);
        }

        for ( int m = 0 ; m < M ; ++m ) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < mWords[m].length; j++) {
                if (mWords[m][j] == '\0') break;
                sb.append(mWords[m][j]);
            }

            char firstCharacter = mWords[m][0];
            map.get(firstCharacter).add(sb.toString());
            usedString.add(sb.toString());
        }
    }

    public int playRound(int mID, char mCh)
    {
        reverseString = new TreeSet<>();
        while(isContinue(mCh)) {
            String str = map.get(mCh).poll();
            StringBuffer strBuffer = new StringBuffer(str);
            String reverseStr = strBuffer.reverse().toString();
            if (!usedString.contains(reverseStr)) {
                usedString.add(reverseStr);
                reverseString.add(reverseStr);
            }
            mCh = str.charAt(str.length()-1);
            while(survivor.size()>0) {
                int tempMID=(mID+1)%(participantNumber+1);
                if(tempMID==0) tempMID=1;
                mID=tempMID;
                if(survivor.contains(mID)) {
                    break;
                }
            }
        }
        survivor.remove(mID);
        for(String reverse : reverseString) {
            char firstCharacter = reverse.charAt(0);
            map.get(firstCharacter).add(String.valueOf(reverse));
        }
        return mID;
    }

    boolean isContinue(char startCh) {
        if ( map.get(startCh).isEmpty() ) {
            return false;
        }
        return true;
    }
}