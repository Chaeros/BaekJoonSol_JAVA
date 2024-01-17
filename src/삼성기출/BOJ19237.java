package 삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ19237 {

    public static int N,M,k;
    public static ArrayList<ArrayList<ArrayList<Shark>>> sharkMap = new ArrayList<>();
    public static ArrayList<ArrayList<ArrayList<Smell>>> smellMap = new ArrayList<>();
    public static ArrayList<Shark> sharks = new ArrayList<>();

    public static int directions[][][];

    public static int dx[] = { -1, 1, 0, 0 };
    public static int dy[] = { 0, 0, -1, 1 };

    public static class Shark implements Comparable<Shark> {
        int id;
        int direction;

        public Shark( int id, int direction ) {
            this.id = id;
            this.direction = direction;
        }

        @Override
        public int compareTo(Shark o) {
            if( this.id < o.id ) return -1;
            return 0;
        }
    }

    public static class Smell {
        int id;
        int score;

        public Smell( int id, int score ) {
            this.id = id;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for ( int i = 0 ; i < N ; ++i ) {
            sharkMap.add(new ArrayList<>());
            smellMap.add(new ArrayList<>());

            for( int j = 0; j < N ; ++j ) {
                sharkMap.get(i).add(new ArrayList<>());
                smellMap.get(i).add(new ArrayList<>());
            }
        }

        directions = new int[M][4][4];

        for ( int i = 0 ; i < N ; ++i ) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0 ; j < N ; ++j ) {
                int id = Integer.parseInt(st.nextToken());
                if( id != 0 ) {
                    Shark shark = new Shark(id-1,0);
                    sharks.add(shark);
                    sharkMap.get(i).get(j).add(shark);
                    smellMap.get(i).get(j).add(new Smell(shark.id,k));
                }
            }
        }

        Collections.sort(sharks);
        st = new StringTokenizer(br.readLine());
        for ( int i = 0 ; i < M ; ++i ) {
            sharks.get(i).direction = Integer.parseInt(st.nextToken())-1;
        }

        for ( int i = 0 ; i < M ; ++i ){
            for ( int j = 0 ; j < 4 ; ++j ){
                st = new StringTokenizer(br.readLine());
                for( int k = 0 ; k < 4 ; ++k ){
                    directions[i][j][k] = Integer.parseInt(st.nextToken())-1;
                }
            }
        }

        int funcCount = 0;
        while( funcCount <= 1000 ){
            if ( isEnd() ) break;

            moveShark();
            rejectSmell();
            rejectShark();
            leaveSmell();
            funcCount++;
//            printMap();
//            printSmellMap();
        }
        if( funcCount > 1000 ) bw.write("-1\n");
        else bw.write(funcCount+"\n");
        bw.flush();
        bw.close();
    }

    public static void printMap(){
        System.out.println("==========================");
        for ( int i = 0 ; i < N ; ++i ){
            for ( int j = 0 ; j < N ; ++j){
                if(sharkMap.get(i).get(j).size()!=0){
                    System.out.print((sharkMap.get(i).get(j).get(0).id+1)+" ");
                }
                else if(sharkMap.get(i).get(j).size()==0){
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void printSmellMap(){
        System.out.println("smell==========================");
        for ( int i = 0 ; i < N ; ++i ){
            for ( int j = 0 ; j < N ; ++j){
                if(smellMap.get(i).get(j).size()!=0){
                    System.out.print((smellMap.get(i).get(j).get(0).score)+" ");
                }
                else if(smellMap.get(i).get(j).size()==0){
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static boolean isEnd(){
        int sharkCount = 0;
        for ( int i = 0 ; i < N ; ++i ){
            for ( int j = 0 ; j < N ; ++j){
                if(sharkMap.get(i).get(j).size() > 0 ){
                    sharkCount++;
                    if(sharkCount>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void rejectSmell(){
        for ( int i = 0 ; i < N ; ++i ){
            for ( int j = 0 ; j < N ; ++j ){
                if ( smellMap.get(i).get(j).size() > 0 ){
                    --smellMap.get(i).get(j).get(0).score;
                    if ( smellMap.get(i).get(j).get(0).score == 0 ){
                        smellMap.get(i).get(j).clear();
                    }
                }
            }
        }
    }

    public static void rejectShark(){
        for ( int i = 0 ; i < N ; ++i ){
            for ( int j = 0 ; j < N ; ++j ){
                if ( sharkMap.get(i).get(j).size() > 1 ){
                    Collections.sort(sharkMap.get(i).get(j));
                    Shark shark = sharkMap.get(i).get(j).get(0);
                    sharkMap.get(i).get(j).clear();
                    sharkMap.get(i).get(j).add(shark);
                }
            }
        }
    }

    public static void leaveSmell(){
        for ( int i = 0 ; i < N ; ++i ){
            for ( int j = 0 ; j < N ; ++j ){
                if(sharkMap.get(i).get(j).size() > 0 ){
                    smellMap.get(i).get(j).clear();
                    smellMap.get(i).get(j).add(new Smell(sharkMap.get(i).get(j).get(0).id,k));
                }
            }
        }
    }

    public static void moveShark(){
        ArrayList<ArrayList<ArrayList<Shark>>> tempSharkMap = new ArrayList<>();
        for ( int i = 0 ; i < N ; ++i ) {
            tempSharkMap.add(new ArrayList<>());
            for( int j = 0; j < N ; ++j ) {
                tempSharkMap.get(i).add(new ArrayList<>());
            }
        }

        for ( int i = 0 ; i < N ; ++i ){
            for ( int j = 0 ; j < N ; ++j ){
                if ( sharkMap.get(i).get(j).size() != 0 ){
                    Shark shark = sharkMap.get(i).get(j).get(0);
                    int originDirection = shark.direction;
                    int preDirection = -1;
                    for ( int t = 0 ; t < 5 ; ++t ){

                        if ( t == 4 ){
                            if ( preDirection != -1 ){
                                tempSharkMap.get( i + dx[preDirection] ).get( j + dy[preDirection] ).add(shark);
                                shark.direction = preDirection;
//                                if( tempSharkMap.get(i).get(j).size() == 0 ){
//                                    smellMap.get(i).get(j).clear();
//                                    smellMap.get(i).get(j).add(new Smell(shark.id,k));
//                                }
                            }
                            else{
                                tempSharkMap.get(i).get(j).add(shark);
                                shark.direction = originDirection;  // ?
//                                smellMap.get(i).get(j).clear();
                            }
                            break;
                        }

                        int mx = i + dx[directions[shark.id][shark.direction][t]];
                        int my = j + dy[directions[shark.id][shark.direction][t]];

                        if ( mx < 0 || mx >= N || my < 0 || my >= N ){
                            continue;
                        }
                        if ( smellMap.get(mx).get(my).size() > 0 ){
                            if( smellMap.get(mx).get(my).get(0).id == shark.id
                                    && preDirection == -1 ){
                                preDirection = directions[shark.id][shark.direction][t];
                            }
                            continue;
                        }

                        tempSharkMap.get(mx).get(my).add(shark);
                        shark.direction = directions[shark.id][shark.direction][t];

//                        if( tempSharkMap.get(i).get(j).size() == 0 ){
//                            smellMap.get(i).get(j).clear();
//                            smellMap.get(i).get(j).add(new Smell(shark.id,k));
//                        }
                        break;
                    }
                }
            }
        }
        sharkMap = tempSharkMap;
    }
}