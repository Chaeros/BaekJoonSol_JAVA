package 삼성기출;

import java.io.IOException;

public class BOJ19237{

    public static int N,M,K;
    public static int dx[] = { -1, 1, 0, 0};
    public static int dy[] = { 0, 0, -1, 1};
    public static int priority[][][];

    public class Shark{
        int id;
        int x;
        int y;
        int direction;
        boolean isAlive;


    }
    public static void main(String[] args) throws IOException {

    }
}


//import java.io.BufferedWriter;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.StringTokenizer;
//
//public class BOJ19237 {
//
//    public static int N,M,k;
//    public static ArrayList<ArrayList<ArrayList<Shark>>> sharkMap = new ArrayList<>();
//    public static ArrayList<ArrayList<ArrayList<Smell>>> smellMap = new ArrayList<>();
//    public static ArrayList<Shark> sharks = new ArrayList<>();
//
//    public static int directions[][][];
//
//    public static int dx[] = { -1, 1, 0, 0 };
//    public static int dy[] = { 0, 0, -1, 1 };
//
//    public static class Shark implements Comparable<Shark> {
//        int id;
//        int direction;
//
//        public Shark( int id, int direction ) {
//            this.id = id;
//            this.direction = direction;
//        }
//
//        @Override
//        public int compareTo(Shark o) {
//            if( this.id < o.id ) return -1;
//            return 0;
//        }
//    }
//
//    public static class Smell {
//        int id;
//        int score;
//
//        public Smell( int id, int score ) {
//            this.id = id;
//            this.score = score;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
//
//        for ( int i = 0 ; i < N ; ++i ) {
//            sharkMap.add(new ArrayList<>());
//            smellMap.add(new ArrayList<>());
//
//            for( int j = 0; j < N ; ++j ) {
//                sharkMap.get(i).add(new ArrayList<>());
//                smellMap.get(i).add(new ArrayList<>());
//            }
//        }
//
//        directions = new int[M][4][4];
//
//        for ( int i = 0 ; i < N ; ++i ) {
//            st = new StringTokenizer(br.readLine());
//            for( int j = 0 ; j < N ; ++j ) {
//                int id = Integer.parseInt(st.nextToken());
//                if( id != 0 ) {
//                    Shark shark = new Shark(id-1,0);
//                    sharks.add(shark);
//                    sharkMap.get(i).get(j).add(shark);
//                    smellMap.get(i).get(j).add(new Smell(shark.id,k));
//                }
//            }
//        }
//
//        Collections.sort(sharks);
//        st = new StringTokenizer(br.readLine());
//        for ( int i = 0 ; i < M ; ++i ) {
//            sharks.get(i).direction = Integer.parseInt(st.nextToken())-1;
//        }
//
//        for ( int i = 0 ; i < M ; ++i ){
//            for ( int j = 0 ; j < 4 ; ++j ){
//                st = new StringTokenizer(br.readLine());
//                for( int k = 0 ; k < 4 ; ++k ){
//                    directions[i][j][k] = Integer.parseInt(st.nextToken())-1;
//                }
//            }
//        }
//
//        int funcCount = 0;
//        while( true ){
//            if ( isEnd() ) break;
//
//            moveShark();
//            rejectSmell();
//            rejectShark();
//            leaveSmell();
//            funcCount++;
////            System.out.println("round:"+ funcCount);
////            countShark();
////            printMap();
//            if( funcCount > 1000 ) break;
////            printSmellMap();
//        }
//        if( funcCount > 1000 ) bw.write("-1\n");
//        else bw.write(funcCount+"\n");
//        bw.flush();
//        bw.close();
//    }
//
//    public static int countShark(){
//        int sharkCount=0;
//        for ( int i = 0 ; i < N ; ++i ){
//            for ( int j = 0 ; j < N ; ++j){
//                if( sharkMap.get(i).get(j).size() > 0 ){
//                    sharkCount++;
//                }
//            }
//        }
//        System.out.println("sharkCount="+sharkCount);
//        return sharkCount;
//    }
//
//    public static void printMap(){
//        System.out.println("==========================");
//        for ( int i = 0 ; i < N ; ++i ){
//            for ( int j = 0 ; j < N ; ++j){
//                if(sharkMap.get(i).get(j).size()!=0){
//                    System.out.print((sharkMap.get(i).get(j).get(0).id+1)+" ");
//                }
//                else if(sharkMap.get(i).get(j).size()==0){
//                    System.out.print("0 ");
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    public static void printSmellMap(){
//        System.out.println("smell==========================");
//        for ( int i = 0 ; i < N ; ++i ){
//            for ( int j = 0 ; j < N ; ++j){
//                if(smellMap.get(i).get(j).size()!=0){
//                    System.out.print((smellMap.get(i).get(j).get(0).score)+" ");
//                }
//                else if(smellMap.get(i).get(j).size()==0){
//                    System.out.print("0 ");
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    public static boolean isEnd(){
//        int sharkCount = 0;
//        for ( int i = 0 ; i < N ; ++i ){
//            for ( int j = 0 ; j < N ; ++j){
//                if(sharkMap.get(i).get(j).size() > 0 ){
//                    sharkCount++;
//                    if(sharkCount>1){
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    public static void rejectSmell(){
//        for ( int i = 0 ; i < N ; ++i ){
//            for ( int j = 0 ; j < N ; ++j ){
//                if ( smellMap.get(i).get(j).size() > 0 ){
//                    --smellMap.get(i).get(j).get(0).score;
//                    if ( smellMap.get(i).get(j).get(0).score == 0 ){
//                        smellMap.get(i).get(j).clear();
//                    }
//                }
//            }
//        }
//    }
//
//    public static void rejectShark(){
//        for ( int i = 0 ; i < N ; ++i ){
//            for ( int j = 0 ; j < N ; ++j ){
//                if ( sharkMap.get(i).get(j).size() > 1 ){
//                    Collections.sort(sharkMap.get(i).get(j));
//                    Shark shark = sharkMap.get(i).get(j).get(0);
//                    sharkMap.get(i).get(j).clear();
//                    sharkMap.get(i).get(j).add(shark);
//                }
//            }
//        }
//    }
//
//    public static void leaveSmell(){
//        for ( int i = 0 ; i < N ; ++i ){
//            for ( int j = 0 ; j < N ; ++j ){
//                if(sharkMap.get(i).get(j).size() > 0 ){
//                    smellMap.get(i).get(j).clear();
//                    smellMap.get(i).get(j).add(new Smell(sharkMap.get(i).get(j).get(0).id,k));
//                }
//            }
//        }
//    }
//
//    public static void moveShark(){
//        ArrayList<ArrayList<ArrayList<Shark>>> tempSharkMap = new ArrayList<>();
//        for ( int i = 0 ; i < N ; ++i ) {
//            tempSharkMap.add(new ArrayList<>());
//            for( int j = 0; j < N ; ++j ) {
//                tempSharkMap.get(i).add(new ArrayList<>());
//            }
//        }
//
//        for ( int i = 0 ; i < N ; ++i ){
//            for ( int j = 0 ; j < N ; ++j ){
//                if ( sharkMap.get(i).get(j).size() != 0 ){
//                    Shark shark = sharkMap.get(i).get(j).get(0);
//                    boolean isPossibleMove = false;
//                    for ( int t = 0 ; t < 4 ; ++t ){
//                        int mx = i + dx[directions[shark.id][shark.direction][t]];
//                        int my = j + dy[directions[shark.id][shark.direction][t]];
//
//                        if ( mx < 0 || mx >= N || my < 0 || my >= N ) continue;
//                        if ( smellMap.get(mx).get(my).size() > 0 ) continue;
//
//                        tempSharkMap.get(mx).get(my).add(shark);
//                        shark.direction = directions[shark.id][shark.direction][t];
//                        isPossibleMove = true;
//                        break;
//                    }
//
//                    if ( !isPossibleMove ){
//                        boolean isPossibleMove2 = false;
//                        for ( int t = 0 ; t < 4 ; ++t ){
//                            int mx = i + dx[directions[shark.id][shark.direction][t]];
//                            int my = j + dy[directions[shark.id][shark.direction][t]];
//
//                            if ( mx < 0 || mx >= N || my < 0 || my >= N ) continue;
//                            if ( smellMap.get(mx).get(my).get(0).id != shark.id ) continue;
//
//                            tempSharkMap.get(mx).get(my).add(shark);
//                            shark.direction = directions[shark.id][shark.direction][t];
//                            isPossibleMove2 = true;
//                            break;
//                        }
//
//                        if ( !isPossibleMove2 ){
//                            tempSharkMap.get(i).get(j).add(shark);
//                        }
//                    }
//                }
//            }
//        }
//        sharkMap = tempSharkMap;
//    }
//}