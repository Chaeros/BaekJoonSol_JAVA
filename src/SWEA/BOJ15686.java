// https://www.acmicpc.net/problem/15686
// 치킨 배달, Gold5
// 2023년 10월 1일
//통과

package SWEA;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
    static int N,M;
    static int map[][];
    static int visited[][];
    static int tempMap[][];
    static List<ChickenStore> chickenStores = new ArrayList<>();
    static List<ChickenStore> subSetChickenStores = new LinkedList<>();
    static int resultMinVal=Integer.MAX_VALUE;
    static class ChickenStore{
        int row;
        int col;

        public ChickenStore(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static void dfs(int current, int depth){
        if(depth==M){
            // 해당 치킨집만을 남겨두고 도시의 치킨 거리를 구함
            calculateDistance();
            return;
        }

        // 조합(치킨 집들 중 M개의 치킨집이 있을 때 연산을 하도록 함)
        for(int i=current;i<chickenStores.size();++i){
            subSetChickenStores.add(chickenStores.get(i));
            dfs(i+1,depth+1);
            subSetChickenStores.remove(depth);
        }
    }

    static void calculateDistance(){
        int sum=0;
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                if(map[i][j]==1){
                    int minVal=Integer.MAX_VALUE;
                    for(ChickenStore store:subSetChickenStores){
                        minVal=Math.min(minVal,Math.abs(i-store.row)+Math.abs(j-store.col));
                    }
                    sum+=minVal;
                }
            }
        }
        resultMinVal=Math.min(resultMinVal,sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                int val = Integer.parseInt(st.nextToken());
                if(val==1){
                    map[i][j]=val;
                }
                else if(val==2){
                    chickenStores.add(new ChickenStore(i,j));
                }
            }
        }

        dfs(0,0);

        bw.write(resultMinVal+"\n");
        bw.flush();
        bw.close();
    }
}
