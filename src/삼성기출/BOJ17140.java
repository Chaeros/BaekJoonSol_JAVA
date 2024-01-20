package 삼성기출;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ17140 {

    public static int r,c,k;

    public static int map[][] = new int[101][101];

    public static int row_len = 3;
    public static int col_len = 3;

    public static class Node implements Comparable<Node>{

        int number;
        int count;

        public Node(int number, int count) {
            super();
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if ( this.count == o.count ) {
                if ( this.number < o.number ) {
                    return -1;
                }
            }
            else if ( this.count < o.count ) {
                return -1;
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());

        for ( int i = 0 ; i < 3 ; ++ i ) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while ( map[r][c] != k ){
            if ( row_len >= col_len ) {
                rCalculate();
            }
            else if ( row_len < col_len ){
                cCalculate();
            }
            time++;
            if ( time > 100 ) break;
        }

        if ( time > 100 ) {
            bw.write("-1\n");
        }
        else bw.write(time + " \n");;
        bw.flush();
        bw.close();
    }

    public static void rCalculate(){
        int tempMap[][] = new int[101][101];
        for ( int  i = 0 ; i < row_len ; ++i ){
            Map<Integer,Integer> hashMap = new HashMap<>();
            for ( int j = 0 ; j < col_len ; ++j ){
                if ( map[i][j] != 0 ) {
                    if ( !hashMap.containsKey(map[i][j]) ){
                        hashMap.put(map[i][j],1);
                    }
                    else{
                        hashMap.put(map[i][j],hashMap.get(map[i][j])+1);
                    }
                }
            }

            List<Node> list = new ArrayList<>();
            for( Map.Entry<Integer,Integer> entry : hashMap.entrySet() ){
                list.add(new Node(entry.getKey(),entry.getValue()));
            }
            Collections.sort(list);

            int size = list.size();
            if ( size > 50 ) size = 50;

            for ( int k = 0 ; k < size ; ++k ) {
                tempMap[i][k*2] = list.get(k).number;
                tempMap[i][k*2+1] = list.get(k).count;
            }
            col_len = Math.max( col_len, list.size()*2 );
        }
        map = tempMap;
    }

    public static void cCalculate(){
        int tempMap[][] = new int[101][101];
        for ( int  i = 0 ; i < col_len ; ++i ){
            Map<Integer,Integer> hashMap = new HashMap<>();
            for ( int j = 0 ; j < row_len ; ++j ){
                if ( map[j][i] != 0 ) {
                    if ( !hashMap.containsKey(map[j][i]) ){
                        hashMap.put(map[j][i],1);
                    }
                    else{
                        hashMap.put(map[j][i],hashMap.get(map[j][i])+1);
                    }
                }
            }

            List<Node> list = new ArrayList<>();
            for( Map.Entry<Integer,Integer> entry : hashMap.entrySet() ){
                list.add(new Node(entry.getKey(),entry.getValue()));
            }
            Collections.sort(list);

            int size = list.size();
            if ( size > 50 ) size = 50;

            for ( int k = 0 ; k < size ; ++k ) {
                tempMap[k*2][i] = list.get(k).number;
                tempMap[k*2+1][i] = list.get(k).count;
            }
            row_len = Math.max( row_len, list.size()*2 );
        }
        map = tempMap;
    }
}
