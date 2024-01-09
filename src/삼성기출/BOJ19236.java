package 삼성기출;

import java.io.*;
import java.util.*;

public class BOJ19236 {
    static class Shark{
        int x;
        int y;
        int direction;
        int eatingSum;
        public Shark(int x,int y,int direction,int eatingSum){
            this.x=x;
            this.y=y;
            this.direction=direction;
            this.eatingSum=eatingSum;
        }
    }

    static class Fish{
        int x;
        int y;
        int number;
        int direction;
        boolean isAlive;
        public Fish(int x,int y,int number,int direction,boolean isAlive){
            this.x=x;
            this.y=y;
            this.number=number;
            this.direction=direction;
            this.isAlive=isAlive;
        }
    }

    static int maxSum=0;
    static int dx[]={-1,-1,0,1,1,1,0,-1};
    static int dy[]={0,-1,-1,-1,0,1,1,1};

    static ArrayList<Fish> copyFishes(ArrayList<Fish> fishes){
        ArrayList<Fish> tempFishes = new ArrayList<>();
        fishes.forEach(e->tempFishes.add(new Fish(e.x,e.y,e.number,e.direction,e.isAlive)));
        return tempFishes;
    }

    static int[][] copyMap(int[][] map){
        int tempMap[][] = new int[4][4];
        for(int i=0;i<4;++i){
            System.arraycopy(map[i],0,tempMap[i],0,map[i].length);
        }
        return tempMap;
    }

    static void printMap(int[][] map){
        System.out.println("================");
        for(int i=0;i<4;++i){
            for(int j=0;j<4;++j){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("================");
    }

    static void dfs(Shark shark,int map[][],ArrayList<Fish> fishes){
        if(maxSum<shark.eatingSum){
            maxSum=shark.eatingSum;
            System.out.println("[x="+shark.x+" y="+shark.y+"] maxSum="+maxSum);
        }

        for(int i=1;i<=3;++i){
            System.out.println("new==========");
            ArrayList<Fish> tempFishes = copyFishes(fishes);
            int[][] tempMap = copyMap(map);
            tempFishes = moveFishes(tempFishes,tempMap);
            Shark tempShark = new Shark(shark.x,shark.y,shark.direction,shark.eatingSum);

            int mx = tempShark.x+dx[tempShark.direction]*i;
            int my = tempShark.y+dy[tempShark.direction]*i;

            if(mx>=0 && mx<4 && my>=0 && my<4 && tempMap[mx][my]>0){
                tempMap[tempShark.x][tempShark.y]=0;
                tempShark.eatingSum+=tempMap[mx][my];
                Fish fish = tempFishes.get(tempMap[mx][my]-1);
                fish.isAlive=false;
                tempMap[mx][my]=-1;
                tempShark.x=mx;
                tempShark.y=my;
                tempShark.direction=fish.direction;

//                printMap(tempMap);
                dfs(tempShark,tempMap,tempFishes);
            }
        }
    }

    static ArrayList<Fish> moveFishes(ArrayList<Fish> fishes, int[][] map){
        ArrayList<Fish> tempFishes = copyFishes(fishes);
        for(int i=0;i<16;++i){
            Fish fish = tempFishes.get(i);

            if(!tempFishes.get(i).isAlive) continue;

            for(int j=0;j<8;++j){
//                System.out.println("rotate="+(fish.direction+j)%8);
                int mx = fish.x+dx[(fish.direction+j)%8];
                int my = fish.y+dy[(fish.direction+j)%8];

                if(mx>=0 && mx<4 && my>=0 && my<4 && map[mx][my]!=-1) {
                    if(map[mx][my]==0){
                        map[fish.x][fish.y]=0;
                        map[mx][my]=fish.number;
                        fish.x=mx;
                        fish.y=my;
                    }
                    else if(map[mx][my]>0){
                        Fish fish2 = tempFishes.get(map[mx][my]-1);
                        fish2.x=fish.x;
                        fish2.y=fish.y;
                        map[mx][my]=fish.number;
                        map[fish.x][fish.y]=fish2.number;
                        fish.x=mx;
                        fish.y=my;
                    }
                    break;
                }
            }
            printMap(map);
        }
        return tempFishes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<Fish> fishes = new ArrayList<>();
        int map[][]=new int[4][4];

        for(int i=0;i<4;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;++j){
                int number = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken())-1;
                fishes.add(new Fish(i,j,number,direction,true));
                map[i][j]=number;
            }
        }

        Collections.sort(fishes, new Comparator<Fish>(){
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.number-o2.number;
            }
        });

        System.out.println("originMap>>");
        printMap(map);

        Fish fish = fishes.get(map[0][0]-1);
        Shark shark = new Shark(0,0,fish.direction,fish.number);
        map[0][0]=-1;
        fish.isAlive=false;

        dfs(shark,map,fishes);
        bw.write(maxSum+"\n");
        bw.flush();
        bw.close();
    }
}
