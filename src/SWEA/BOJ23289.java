// https://www.acmicpc.net/problem/23289
// 온풍기 안녕!, Platinum5
// 2023년 10월 15일
// 통과

package SWEA;

import java.io.*;
import java.util.*;

public class BOJ23289 {

    static int R,C,K,W;
    static int map[][];

    // 오른쪽, 왼쪽, 위, 아래
    static int dx[]= {0,0,-1,1};
    static int dy[]= {1,-1,0,0};

    static List<Hitter> hitters = new ArrayList<>();
    static List<Location> targets = new ArrayList<>();
//	static List<Wall> walls = new ArrayList<>();

    static boolean walls[][][][]=new boolean[20][20][20][20];

    static int eatingChocolateCount=0;

    static class Hitter{
        int x;
        int y;
        int direction;

        Hitter(int x, int y, int direction){
            this.x=x;
            this.y=y;
            this.direction=direction;
        }
    }

    static class Location{
        int x;
        int y;

        Location(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static class Wall{
        int cx;
        int cy;
        int nx;
        int ny;

        Wall(int cx,int cy,int nx,int ny){
            this.cx=cx;
            this.cy=cy;
            this.nx=nx;
            this.ny=ny;
        }
    }

    // 목표로 하는 좌표의 온도가 모두 K 이상이 되었는지 검사해주는 메서드
    static boolean isClear() {
        boolean clear = true;

        for(Location loc:targets) {
            if(map[loc.x][loc.y]<K) {
                clear=false;
                break;
            }
        }

        return clear;
    }

    static void upDfs(int x, int y, int depth,int direction) {

        if(direction==0 || direction==1) { // 오른쪽, 왼쪽
            int mx=x-1;
            int my=y;

            if(mx<0 || mx>=R || my<0 || my>=C) return;
            if(walls[x][y][mx][my]) return;
//			for(Wall wall:walls) {
//				if(x==wall.cx && y==wall.cy && mx==wall.nx && my==wall.ny) return;
//			}

            dfs(x-1,y,depth,direction);
        }
        else if(direction==2 || direction==3) { // 위, 아래
            int mx=x;
            int my=y-1;

            if(mx<0 || mx>=R || my<0 || my>=C) return;
            if(walls[x][y][mx][my]) return;
//			for(Wall wall:walls) {
//				if(x==wall.cx && y==wall.cy && mx==wall.nx && my==wall.ny) return;
//			}

            dfs(x,y-1,depth,direction);
        }
    }

    static void downDfs(int x, int y, int depth,int direction) {
        if(direction==0 || direction==1) { // 오른쪽, 왼쪽
            int mx=x+1;
            int my=y;

            if(mx<0 || mx>=R || my<0 || my>=C) return;
            if(walls[x][y][mx][my]) return;
//			for(Wall wall:walls) {
//				if(x==wall.cx && y==wall.cy && mx==wall.nx && my==wall.ny) return;
//			}

            dfs(x+1,y,depth,direction);
        }
        else if(direction==2 || direction==3) { // 위, 아래
            int mx=x;
            int my=y+1;

            if(mx<0 || mx>=R || my<0 || my>=C) return;
            if(walls[x][y][mx][my]) return;
//			for(Wall wall:walls) {
//				if(x==wall.cx && y==wall.cy && mx==wall.nx && my==wall.ny) return;
//			}

            dfs(x,y+1,depth,direction);
        }
    }

    static boolean visited[][];
    static void dfs(int x, int y, int depth,int direction) {
        if(depth==5) {
            return;
        }

        int mx=x+dx[direction];
        int my=y+dy[direction];

        if(mx<0 || mx>=R || my<0 || my>=C) return;
        if(visited[mx][my]) return;

        if(walls[x][y][mx][my]) return;
//		for(Wall wall:walls) {
//			if(x==wall.cx && y==wall.cy && mx==wall.nx && my==wall.ny) return;
//		}

        map[mx][my]+=5-depth;
        visited[mx][my]=true;


        if(direction==0) { // 오른쪽
            upDfs(x,y+1,depth+1,direction);
            dfs(x,y+1,depth+1,direction);
            downDfs(x,y+1,depth+1,direction);
        }
        else if(direction==1) { // 왼쪽
            upDfs(x,y-1,depth+1,direction);
            dfs(x,y-1,depth+1,direction);
            downDfs(x,y-1,depth+1,direction);
        }
        else if(direction==2) { // 위
            upDfs(x-1,y,depth+1,direction);
            dfs(x-1,y,depth+1,direction);
            downDfs(x-1,y,depth+1,direction);
        }
        else if(direction==3) { // 아래
            upDfs(x+1,y,depth+1,direction);
            dfs(x+1,y,depth+1,direction);
            downDfs(x+1,y,depth+1,direction);
        }
    }

    static void hitterOn() {

        for(Hitter hitter:hitters) {
            int cx = hitter.x;
            int cy = hitter.y;
            int direction = hitter.direction;
            visited = new boolean[R][C];

            dfs(cx,cy,0,direction);
        }
    }


    static int outermostDecline(int luX,int luY,int rdX,int rdY) {

        int layer=0;
        outter : while(luX<rdX && luY<rdY) {

            // 위
            for(int i=luY+1;i<=rdY-1;++i) {
                if(map[luX][i]!=0) {
                    break outter;
                }
            }

            // 아래
            for(int i=luY+1;i<=rdY-1;++i) {
                if(map[rdX][i]!=0) {
                    break outter;
                }
            }

            // 왼쪽
            for(int i=luX;i<=rdX;++i) {
                if(map[i][luY]!=0) {
                    break outter;
                }
            }

            // 오른쪽
            for(int i=luX;i<=rdX;++i) {
                if(map[i][rdY]!=0) {
                    break outter;
                }
            }

            layer++;
            luX+=1;
            luY+=1;
            rdX-=1;
            rdY-=1;
        }

        return layer;
    }

    static void decline(int layer) {

        int luX=0+layer;
        int luY=0+layer;
        int rdX=R-1-layer;
        int rdY=C-1-layer;

        // 위, 아래
        for(int i=luY+1;i<=rdY-1;++i) {
            if(map[luX][i]>0) map[luX][i]-=1;
            if(map[rdX][i]>0) map[rdX][i]-=1;
        }

        // 왼쪽, 오른쪽
        for(int i=luX;i<=rdX;++i) {
            if(map[i][luY]>0) map[i][luY]-=1;
            if(map[i][rdY]>0) map[i][rdY]-=1;
        }
    }

    static boolean temperControlVisited[][];
    static void temperControl() {
        temperControlVisited = new boolean[R][C];
        int tempMap[][] = new int[R][C];
        for(int r=0;r<R;++r) {
            tempMap[r]=map[r].clone();
        }

        for(int r=0;r<R;++r) {
            for(int c=0;c<C;++c) {
                temperControlVisited[r][c]=true;
                outter : for(int i=0;i<4;++i) {
                    int mx = r+dx[i];
                    int my = c+dy[i];

                    if(mx<0 || mx>=R || my<0 || my>=C) continue;
                    if(walls[r][c][mx][my]) continue outter;
                    if(temperControlVisited[mx][my]) continue;

                    if(map[r][c]>map[mx][my]) {
                        int diff = (map[r][c]-map[mx][my])/4;
                        tempMap[r][c]-=diff;
                        tempMap[mx][my]+=diff;

                    }
                    else {
                        int diff = (map[mx][my]-map[r][c])/4;
                        tempMap[r][c]+=diff;
                        tempMap[mx][my]-=diff;
                    }
                }
            }
        }
        map=tempMap;
    }

    static void print() {
        for(int r=0;r<R;++r) {
            for(int c=0;c<C;++c) {
                System.out.print(map[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println("================");
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int r=0;r<R;++r) {
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;++c) {
                int val = Integer.parseInt(st.nextToken());
                if(val==5) targets.add(new Location(r,c));
                else if(val!=0) hitters.add(new Hitter(r,c,val-1));
            }
        }

        W = Integer.parseInt(br.readLine());
        for(int w=0;w<W;++w) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());

            if(t==0) {
//				walls.add(new Wall(x,y,x-1,y));
//				walls.add(new Wall(x-1,y,x,y));
                walls[x][y][x-1][y]=true;
                walls[x-1][y][x][y]=true;
            }
            else if(t==1) {
//				walls.add(new Wall(x,y,x,y+1));
//				walls.add(new Wall(x,y+1,x,y));
                walls[x][y][x][y+1]=true;
                walls[x][y+1][x][y]=true;
            }
        }

        boolean overEat=false;
        while(!isClear()) {

            if(eatingChocolateCount>=100) {
                overEat=true;
                break;
            }

            // 히터 작동
            hitterOn();

            // 온도 조절
            temperControl();

            // 최외각 온도 1 감소
            int layer = outermostDecline(0,0,R-1,C-1);
            decline(layer);

            // 초콜릿 섭취
            eatingChocolateCount++;
        }

        if(overEat) {
            bw.write("101\n");
        }
        else {
            bw.write(eatingChocolateCount+"\n");
        }
        bw.flush();
        bw.close();
    }
}
