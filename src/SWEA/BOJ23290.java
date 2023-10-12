// https://www.acmicpc.net/problem/23290
// 마법사 상어와 복제, Gold1
// 2023년 10월 12일
// 통과

package SWEA;

import java.util.*;
import java.io.*;

public class BOJ23290 {

    static final int MAX_SIZE=4;

    static int M,S;
    static int visited[][];
    static ArrayList<ArrayList<ArrayList<Fish>>> map = new ArrayList<>();
    static ArrayList<ArrayList<ArrayList<Fish>>> copyMap;

    static class Fish{
        int row;
        int col;
        int direction;

        Fish(int row,int col,int direction){
            this.row=row;
            this.col=col;
            this.direction=direction;
        }
    }

    static int dx[]= {0,-1,-1,-1,0,1,1,1};
    static int dy[]= {-1,-1,0,1,1,1,0,-1};

    static int sharkDx[]= {-1,0,1,0};
    static int sharkDy[]= {0,-1,0,1};

    static int sharkPosition[]=new int[2]; // 상어 좌표

    static void mapCopy(ArrayList<ArrayList<ArrayList<Fish>>> map,
                        ArrayList<ArrayList<ArrayList<Fish>>> copyMap) {
        for(int i=0;i<MAX_SIZE;++i) {
            copyMap.add(new ArrayList<>());
            for(int j=0;j<MAX_SIZE;++j) {
                copyMap.get(i).add(new ArrayList<>());
                copyMap.get(i).get(j).addAll(map.get(i).get(j));
            }
        }

    }

    static void moveFish() {
        ArrayList<ArrayList<ArrayList<Fish>>> tempMap = new ArrayList<>();;
        for(int i=0;i<MAX_SIZE;++i) {
            tempMap.add(new ArrayList<>());
            for(int j=0;j<MAX_SIZE;++j) {
                tempMap.get(i).add(new ArrayList<>());
            }
        }

        for(int i=0;i<MAX_SIZE;++i) {
            for(int j=0;j<MAX_SIZE;++j) {
                for(int k=0;k<map.get(i).get(j).size();++k) {
                    int direction = map.get(i).get(j).get(k).direction;
                    boolean check=false;
                    for(int d=direction+8;d>direction;--d) {
                        int mx= map.get(i).get(j).get(k).row+dx[d%8];
                        int my= map.get(i).get(j).get(k).col+dy[d%8];

                        if(mx<0 || mx>=MAX_SIZE || my<0 || my>=MAX_SIZE) continue;
                        if(mx==sharkPosition[0] && my==sharkPosition[1]) continue;
                        if(visited[mx][my]!=0) continue;

                        tempMap.get(mx).get(my).add(new Fish(mx,my,d%8));
                        check=true;
                        break;
                    }

                    if(!check) tempMap.get(i).get(j).add(new Fish(i,j,direction%8));
                }
            }
        }
        map = tempMap;
    }

    static int sharkMoveList[] = new int[3];
    static void sharkSelectMove(int depth) {
        if(depth==3) {
            sharkMove();
            return;
        }

        for(int i=0;i<4;++i) {
            sharkMoveList[depth]=i;
            sharkSelectMove(depth+1);
        }
    }

    static int maxValSum =0;
    static int sharkRealMoveList[] = new int[3];
    static int firstMx;
    static int firstMy;
    static boolean check=false;
    static void sharkMove() {

        int mx = sharkPosition[0];
        int my = sharkPosition[1];
        int eatFishCount=0;
        int cMx=0;
        int cMy=0;
        boolean simpleCheck=false;
        ArrayList<ArrayList<ArrayList<Fish>>> tempMap = new ArrayList<>();;
        for(int i=0;i<MAX_SIZE;++i) {
            tempMap.add(new ArrayList<>());
            for(int j=0;j<MAX_SIZE;++j) {
                tempMap.get(i).add(new ArrayList<>());
            }
        }
        mapCopy(map,tempMap);
        for(int i=0;i<3;++i) {
            int direction = sharkMoveList[i];
            mx += sharkDx[direction];
            my += sharkDy[direction];

            if(mx<0 || mx>=MAX_SIZE || my<0 || my>=MAX_SIZE) return;

            eatFishCount+=tempMap.get(mx).get(my).size();
            tempMap.get(mx).get(my).clear();

            if(!check && i==2 && eatFishCount==0) {
                check=true;
                firstMx=mx;
                firstMy=my;
            }
            else if(i==2) {
                simpleCheck=true;
            }
        }

        if(simpleCheck && maxValSum<eatFishCount) {
            maxValSum=eatFishCount;
            sharkRealMoveList=sharkMoveList.clone();
        }
    }

    static void realSharkMove() {
        int mx = sharkPosition[0];
        int my = sharkPosition[1];

        if(maxValSum==0) {
            sharkPosition[0]=firstMx;
            sharkPosition[1]=firstMy;
            return;
        }

        for(int i=0;i<3;++i) {
            int direction = sharkRealMoveList[i];
            mx += sharkDx[direction];
            my += sharkDy[direction];

            if(map.get(mx).get(my).size()>0) {
                map.get(mx).get(my).clear();
                visited[mx][my]=3;
            }
        }
        sharkPosition[0]=mx;
        sharkPosition[1]=my;
    }

    static void removeSmell() {
        for(int i=0;i<MAX_SIZE;++i) {
            for(int j=0;j<MAX_SIZE;++j) {
                if(visited[i][j]!=0) --visited[i][j];
            }
        }
    }

    static void realMapCopy(ArrayList<ArrayList<ArrayList<Fish>>> map,
                            ArrayList<ArrayList<ArrayList<Fish>>> copyMap) {
        for(int i=0;i<MAX_SIZE;++i) {
            for(int j=0;j<MAX_SIZE;++j) {
                map.get(i).get(j).addAll(copyMap.get(i).get(j));
            }
        }
    }

    static int calFishCount() {
        int sum=0;
        for(int i=0;i<MAX_SIZE;++i) {
            for(int j=0;j<MAX_SIZE;++j) {
                sum+=map.get(i).get(j).size();
            }
        }
        return sum;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        visited = new int[MAX_SIZE][MAX_SIZE];

        for(int i=0;i<MAX_SIZE;++i) {
            map.add(new ArrayList<>());
            for(int j=0;j<MAX_SIZE;++j) {
                map.get(i).add(new ArrayList<>());
            }
        }

        for(int i=0;i<M;++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int direction = Integer.parseInt(st.nextToken())-1;
            map.get(x).get(y).add(new Fish(x,y,direction));
        }

        st = new StringTokenizer(br.readLine());
        sharkPosition[0] = Integer.parseInt(st.nextToken())-1;
        sharkPosition[1] = Integer.parseInt(st.nextToken())-1;

        for(int i=0;i<S;++i) {
            // 1. 물고기 복사
            copyMap = new ArrayList<>();
            mapCopy(map,copyMap);

            // 2. 물고기 이동
            moveFish();

            // 3. 상어 이동
            maxValSum =0;
            check=false;
            sharkSelectMove(0);
            realSharkMove();

            // 4. 물고기 냄새 제거
            removeSmell();

            // 5. 물고기 복사 적용
            realMapCopy(map,copyMap);

        }

        bw.write(calFishCount()+"\n");
        bw.flush();
        bw.close();

    }
}