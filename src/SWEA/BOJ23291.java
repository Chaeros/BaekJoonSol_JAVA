// https://www.acmicpc.net/problem/23291
// 어항 정리, Platinum5
// 2023년 10월 11일
// 통과

package SWEA;

import java.io.*;
import java.util.*;

public class BOJ23291 {

    static int N,K;
    static LinkedList<LinkedList<Integer>> fishbowl = new LinkedList<>();
    static int minVal = Integer.MAX_VALUE;
    static int maxVal = Integer.MIN_VALUE;

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    static void printBowl(LinkedList<LinkedList<Integer>> tempBowl) {
        for(int i=0;i<tempBowl.size();++i) {
            for(int j=0;j<tempBowl.get(i).size();++j) {
                System.out.print(tempBowl.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println("================================");
    }

    static void bfs() {
        LinkedList<LinkedList<Integer>> tempbowl = new LinkedList<>();
        for(int i=0;i<fishbowl.size();++i) {
            tempbowl.add(new LinkedList<>());
            tempbowl.get(i).addAll(fishbowl.get(i));
        }
        boolean visited[][] = new boolean[fishbowl.size()][];
        for(int i=0;i<fishbowl.size();++i) {
            visited[i]=new boolean[fishbowl.get(i).size()];
        }

        for(int r=0;r<fishbowl.size();++r) {
            for(int c=0;c<fishbowl.get(r).size();++c) {
                visited[r][c]=true;
                for(int i=0;i<4;++i) {
                    int mx = r+dx[i];
                    int my = c+dy[i];

                    if(mx<0 || mx>=fishbowl.size() || my<0 || my>=fishbowl.get(mx).size()) continue;
                    if(visited[mx][my]) continue;
                    if(fishbowl.get(mx).get(my)>fishbowl.get(r).get(c)) {
                        int moveValue = (fishbowl.get(mx).get(my)-fishbowl.get(r).get(c))/5;
                        tempbowl.get(r).set(c, tempbowl.get(r).get(c)+moveValue);
                        tempbowl.get(mx).set(my, tempbowl.get(mx).get(my)-moveValue);
                    }
                    else{
                        int moveValue = (fishbowl.get(r).get(c)-fishbowl.get(mx).get(my))/5;
                        tempbowl.get(r).set(c, tempbowl.get(r).get(c)-moveValue);
                        tempbowl.get(mx).set(my, tempbowl.get(mx).get(my)+moveValue);
                    }
                }
            }
        }
        fishbowl = tempbowl;
    }

    static void oneLineSort() {
        LinkedList<LinkedList<Integer>> tempbowl = new LinkedList<>();
        tempbowl.add(new LinkedList<>());
        int size = fishbowl.get(1).size();
        for(int i=0;i<size;++i) {
            for(int j=0;j<fishbowl.size();++j) {
                tempbowl.get(0).add(fishbowl.get(j).get(i));
            }
        }
        for(int i=size;i<fishbowl.get(0).size();++i) {
            tempbowl.get(0).add(fishbowl.get(0).get(i));
        }
        fishbowl=tempbowl;
    }

    static void slice() {
        LinkedList<Integer> tempbowlL = new LinkedList<>();
        LinkedList<Integer> tempbowlR = new LinkedList<>();

        int middle = fishbowl.get(0).size()/2;

        for(int i=0;i<middle;++i) {
            tempbowlL.add(fishbowl.get(0).get(i));
            tempbowlR.add(fishbowl.get(0).get(i+middle));
        }

        Collections.reverse(tempbowlL);

        LinkedList<LinkedList<Integer>> tempbowl = new LinkedList<>();
        tempbowl.add(tempbowlR); // 1층
        tempbowl.add(tempbowlL); // 2층

        fishbowl=tempbowl;

        LinkedList<Integer> tempbowl1 = new LinkedList<>();
        LinkedList<Integer> tempbowl2 = new LinkedList<>();
        LinkedList<Integer> tempbowl3 = new LinkedList<>();
        LinkedList<Integer> tempbowl4 = new LinkedList<>();

        middle = fishbowl.get(0).size()/2;

        for(int i=0;i<middle;++i) {
            tempbowl1.add(fishbowl.get(0).get(i));  // 좌측 하단
            tempbowl2.add(fishbowl.get(1).get(i));  // 좌측 상단
            tempbowl3.add(fishbowl.get(0).get(i+middle));  // 우측 하단
            tempbowl4.add(fishbowl.get(1).get(i+middle));  // 우측 상단
        }

        Collections.reverse(tempbowl1);
        Collections.reverse(tempbowl2);

        LinkedList<LinkedList<Integer>> tempbowlLast = new LinkedList<>();
        tempbowlLast.add(tempbowl3);
        tempbowlLast.add(tempbowl4);
        tempbowlLast.add(tempbowl2);
        tempbowlLast.add(tempbowl1);

        fishbowl=tempbowlLast;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fishbowl.add(new LinkedList<>());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i) {
            fishbowl.get(0).add(Integer.parseInt(st.nextToken()));
        }

        minVal = Collections.min(fishbowl.get(0));
        maxVal = Collections.max(fishbowl.get(0));

        int roundCount=0;
        while(maxVal-minVal>K){
            ++roundCount;
            for(int i=0;i<N;++i) {
                if(fishbowl.get(0).get(i)==minVal) {
                    fishbowl.get(0).set(i, minVal+1);
                }
            }
            int row = fishbowl.size();
            int col=0;

            if(row==1) { // 1열일 경우
                int val = fishbowl.get(row-1).remove(0);
                fishbowl.add(new LinkedList<>());
                fishbowl.get(1).add(val);
            }

            while(fishbowl.size()<=fishbowl.get(0).size()-fishbowl.get(1).size()) {
                row = fishbowl.size();
                col = fishbowl.get(1).size();
                LinkedList<LinkedList<Integer>> tempbowl = new LinkedList<>();
                for(int i=0;i<col;++i) {
                    tempbowl.add(new LinkedList<>());
                    for(int j=0;j<row;++j) {
                        tempbowl.get(i).add(fishbowl.get(j).get(i));
                    }
                }

                // 맨 아래 행 제외 모든 어항 행 삭제
                for(int i=0;i<row-1;++i) {
                    fishbowl.remove(1);
                }
                // 맨 아래 행에서 위에 쌓이기 위해 이도할 어항 삭제
                for(int i=0;i<col;++i) {
                    fishbowl.get(0).remove(0);
                }

                // 어항 쌓기
                for(int i=col-1;i>=0;--i) {
                    fishbowl.add(tempbowl.get(i));
                }
            }

            bfs();

            oneLineSort();

            slice();

            bfs();

            oneLineSort();

            minVal = Collections.min(fishbowl.get(0));
            maxVal = Collections.max(fishbowl.get(0));
        }

        bw.write(roundCount+"\n");
        bw.flush();
        bw.close();
    }
}
