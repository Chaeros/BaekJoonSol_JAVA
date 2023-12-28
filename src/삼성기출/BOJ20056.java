// https://www.acmicpc.net/problem/20056
// 마법사 상어와 파이어볼
// 2023년 11월 2일
// 통과

package 삼성기출;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ20056 {

    static ArrayList<ArrayList<ArrayList<Fireball>>> map = new ArrayList<>();
    static int N,M,K;
    static int dx[] = {-1,-1,0,1,1,1,0,-1};
    static int dy[] = {0,1,1,1,0,-1,-1,-1};
    static int sameDirection[] = {0,2,4,6};
    static int otherDirection[] = {1,3,5,7};
    static class Fireball{
        int row;
        int column;
        int mass;
        int speed;
        int direction;

        public Fireball(int row, int column, int mass, int speed, int direction) {
            this.row = row;
            this.column = column;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;++i){
            map.add(new ArrayList<>());
            for(int j=0;j<N;++j){
                map.get(i).add(new ArrayList<>());
            }
        }

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1;
            int column = Integer.parseInt(st.nextToken())-1;
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            Fireball fireball = new Fireball(row,column,mass,speed,direction);
            map.get(row).get(column).add(fireball);
        }

        for(int k=0;k<K;++k){
            moveFireball();
            unionFireball();
        }

        bw.write(calculateSumResult()+"\n");
        bw.flush();
        bw.close();
    }

    static void moveFireball(){
        ArrayList<ArrayList<ArrayList<Fireball>>> tempMap = new ArrayList<>();
        for(int i=0;i<N;++i){
            tempMap.add(new ArrayList<>());
            for(int j=0;j<N;++j){
                tempMap.get(i).add(new ArrayList<>());
            }
        }

        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                for(Fireball fireball:map.get(i).get(j)){
                    int mx = fireball.row + dx[fireball.direction]* (fireball.speed%N);
                    int my = fireball.column + dy[fireball.direction]* (fireball.speed%N);

                    if(mx<0) mx+=N;
                    if(my<0) my+=N;
                    mx%=N;
                    my%=N;

                    tempMap.get(mx).get(my).add(new Fireball(mx,my, fireball.mass, fireball.speed, fireball.direction));
                }
            }
        }
        map=tempMap;
    }

    static void unionFireball(){
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                if(map.get(i).get(j).size()>=2){
                    int mass=0;
                    int speed=0;
                    int size = map.get(i).get(j).size();
                    boolean isAllOddOrEven= true;
                    int divideValue = map.get(i).get(j).get(0).direction%2;
                    for(Fireball fireball:map.get(i).get(j)){
                        mass+= fireball.mass;
                        speed+= fireball.speed;
                        if(fireball.direction%2!=divideValue) isAllOddOrEven=false;
                    }

                    map.get(i).get(j).clear();
                    if(mass/5!=0){
                        for(int k=0;k<4;++k){
                            if(isAllOddOrEven){
                                map.get(i).get(j).add(new Fireball(i,j,mass/5,speed/size,sameDirection[k]));
                            }
                            else{
                                map.get(i).get(j).add(new Fireball(i,j,mass/5,speed/size,otherDirection[k]));
                            }
                        }
                    }
                }
            }
        }
    }

    static int calculateSumResult(){
        int sum=0;
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                for(Fireball fireball:map.get(i).get(j)){
//                    System.out.println("row="+i+",col="+j+",mass="+fireball.mass);
                    sum+= fireball.mass;
                }
            }
        }
        return sum;
    }
}
