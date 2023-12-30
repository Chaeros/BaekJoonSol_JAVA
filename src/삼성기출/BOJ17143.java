// https://www.acmicpc.net/problem/17143
// 낚시왕, Gold1
// 2023년 12월 30일
// 통과, 걸린 시간 : 40분

package 삼성기출;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17143 {

    static int R,C,M;
    static ArrayList<ArrayList<ArrayList<Shark>>> map = new ArrayList<>();

    static class Shark{
        int speed;
        int direction;
        int size;

        public Shark(int speed,int direction,int size){
            this.speed=speed;
            this.direction=direction;
            this.size=size;
        }
    }

    static int fishing(int position){
        int sharkSize=0;
        for(int r=0;r<R;++r){
            if(!map.get(r).get(position).isEmpty()){
                sharkSize=map.get(r).get(position).get(0).size;
                map.get(r).get(position).clear();
                return sharkSize;
            }
        }
        return sharkSize;
    }

    static int dx[] = {-1,1,0,0}; // 상하우좌
    static int dy[] = {0,0,1,-1};
    static void moveShark(){
        ArrayList<ArrayList<ArrayList<Shark>>> tempMap = new ArrayList<>();
        for(int r=0;r<R;++r){
            tempMap.add(new ArrayList<>());
            for(int c=0;c<C;++c){
                tempMap.get(r).add(new ArrayList<>());
            }
        }
        for(int r=0;r<R;++r){
            for(int c=0;c<C;++c){
                if(!map.get(r).get(c).isEmpty()){
                    Shark shark = map.get(r).get(c).get(0);
                    int x = r;
                    int y = c;
                    for(int s=0;s<shark.speed;++s){
                        int mx = x+dx[shark.direction];
                        int my = y+dy[shark.direction];

                        if(mx<0 || mx>=R || my<0 || my>=C){
                            if(shark.direction==0) shark.direction=1;
                            else if(shark.direction==1) shark.direction=0;
                            else if(shark.direction==2) shark.direction=3;
                            else if(shark.direction==3) shark.direction=2;
                            --s;
                            continue;
                        }

                        x=mx;
                        y=my;
                    }
                    tempMap.get(x).get(y).add(new Shark(shark.speed,shark.direction,shark.size));
                    map.get(r).get(c).clear();
                }
            }
        }
        map=tempMap;
    }

    static void eating(){
        for(int r=0;r<R;++r){
            for(int c=0;c<C;++c){
                if(map.get(r).get(c).size()>1){
                    int speed=0;
                    int direction=0;
                    int size=0;
                    for(Shark shark:map.get(r).get(c)){
                        if(size<shark.size){
                            speed=shark.speed;
                            direction=shark.direction;
                            size=shark.size;
                        }
                    }
                    map.get(r).get(c).clear();
                    map.get(r).get(c).add(new Shark(speed,direction,size));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int r=0;r<R;++r){
            map.add(new ArrayList<>());
            for(int c=0;c<C;++c){
                map.get(r).add(new ArrayList<>());
            }
        }

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            map.get(r).get(c).add(new Shark(s,d,z));
        }

        int resultSum=0;
        for(int fisherPosition=0;fisherPosition<C;++fisherPosition){
            resultSum+=fishing(fisherPosition);
            moveShark();
            eating();
        }
        bw.write(resultSum+"\n");
        bw.flush();
        bw.close();
    }
}
