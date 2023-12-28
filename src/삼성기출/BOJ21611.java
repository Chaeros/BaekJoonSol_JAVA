// https://www.acmicpc.net/problem/21611
// 마법사 상어와 블리자드, Gold1
// 2023년 10월 14일
// 통과

package 삼성기출;

import java.io.BufferedReader;

import java.io.*;
import java.util.*;

public class BOJ21611 {

    static int N,M;
    static int map[][];
    static int sharkX,sharkY;

    static int magic_dx[]= {-1,1,0,0};
    static int magic_dy[]= {0,0,-1,1};

    static void print() {
        for(int i=0;i<N;++i) {
            for(int j=0;j<N;++j) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===============");
    }

    static void blizard(int direction, int length) {

        int mx = sharkX;
        int my = sharkY;
        for(int i=0;i<length;++i) {
            mx+=magic_dx[direction];
            my+=magic_dy[direction];
            if(mx<0 || mx>=N || my<0 || my>=N) break;
            map[mx][my]=-1;
        }
    }

    static int pulldx[]= {0,1,0,-1};
    static int pulldy[]= {-1,0,1,0};
    static void pull() {

        int round=1;
        int direction=0;
        int mx=sharkX;
        int my=sharkY;
        int preX=sharkX,preY=sharkY;
        boolean out = false;
        boolean isMagig = false;
        int currentNum=0;
        int rejectNum=isEmpty();
        while(true) {

            for(int i=0;i<2;++i) {
                for(int j=0;j<round;++j) {
                    mx+=pulldx[direction];
                    my+=pulldy[direction];

                    if((mx<0 || my<0)) {
                        map[0][0]=0;
                        out=true;
                        break;
                    }

                    if(isMagig) {
                        map[preX][preY]=map[mx][my];
                    }

                    if(map[mx][my]==-1) {
                        isMagig=true;
                    }

                    preX=mx;
                    preY=my;
                    ++currentNum;
                }
                if(out) break;
                direction = (direction+1)%4;
            }
            ++round;

            if(out) {
                if(isEmpty()==0) {
                    break;
                }
                else {
                    round=1;
                    direction=0;
                    mx=sharkX;
                    my=sharkY;
                    preX=sharkX;preY=sharkY;
                    out = false;
                    isMagig = false;
                }
            }
        }
    }

    static int isEmpty() {
        int sum=0;
        for(int i=0;i<N;++i) {
            for(int j=0;j<N;++j) {
                if(map[i][j]==-1) sum++;
            }
        }

        return sum;
    }

    static int bombBeads[] = new int[3];

    static boolean bomb() {

        boolean result=false;
        int round=1;
        int direction=0;
        int mx=sharkX;
        int my=sharkY;

        int preX=sharkX,preY=sharkY;
        int count=0;
        Queue<int[]> path= new LinkedList<>(); // 임시 경로 저장


        outter : while(true) {
            for(int i=0;i<2;++i) {
                for(int j=0;j<round;++j) {
                    mx+=pulldx[direction];
                    my+=pulldy[direction];

                    if((mx<0 || my<0) || map[mx][my]==0) {
                        break outter;
                    }

                    if(map[preX][preY]==map[mx][my]) {
                        ++count;
                        path.offer(new int[] {mx,my});
                    }
                    else {
                        if(count>=4) {
                            bombBeads[map[preX][preY]-1]+=count;
                            for(int[] x:path) {
                                map[x[0]][x[1]]=-1;
                            }
                            result=true;
                        }
                        path.clear();
                        path.offer(new int[] {mx,my});
                        count=1;
                    }

                    preX=mx;preY=my;
                }
                direction=(direction+1)%4;
            }
            ++round;
        }

        if(count>=4) {
            bombBeads[map[preX][preY]-1]+=count;
            for(int[] x:path) {
                map[x[0]][x[1]]=-1;
            }
            result=true;
        }

        return result;
    }

    static Queue<Integer> resultList; // 임시 경로 저장
    static void changeMap() {

        boolean result=false;
        int round=1;
        int direction=0;
        int mx=sharkX;
        int my=sharkY;

        int preX=sharkX,preY=sharkY-1;
        int count=0;
        resultList= new LinkedList<>();

        outter : while(true) {
            for(int i=0;i<2;++i) {
                for(int j=0;j<round;++j) {
                    mx+=pulldx[direction];
                    my+=pulldy[direction];

                    if((mx==0 && my==0) || map[mx][my]==0) {
                        if(resultList.size()+2<=N*N-1) {
                            resultList.offer(count);
                            resultList.offer(map[preX][preY]);
                        }
                        break outter;
                    }

                    if(map[preX][preY]==map[mx][my]) {
                        ++count;
                    }
                    else {
                        if(resultList.size()+2<=N*N-1) {
                            resultList.offer(count);
                            resultList.offer(map[preX][preY]);
                        }
                        count=1;
                    }

                    preX=mx;preY=my;
                }
                direction=(direction+1)%4;
            }
            ++round;
        }

//		for(int x:resultList) {
//			System.out.print(x+" ");
//		}
//		System.out.println("===============");

        copyMap();
    }

    static void copyMap() {
        int round=1;
        int direction=0;
        int mx=sharkX;
        int my=sharkY;

        int preX=sharkX,preY=sharkY;
        int count=0;

        map=new int[N][N];

        outter : while(true) {
            for(int i=0;i<2;++i) {
                for(int j=0;j<round;++j) {
                    mx+=pulldx[direction];
                    my+=pulldy[direction];

                    if((mx<0 || my<0)) {
                        break outter;
                    }

                    if(!resultList.isEmpty()) {
                        int x = resultList.poll();
                        map[mx][my]=x;
                    }
                    else break outter;

                }
                direction=(direction+1)%4;
            }
            ++round;
        }
    }


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        sharkX = sharkY = N/2;

        for(int i=0;i<N;++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        map[sharkX][sharkY]=-2;

        for(int m=0;m<M;++m) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken())-1;
            int length = Integer.parseInt(st.nextToken());

            // 블리자드
            blizard(direction,length);
//			print();

            // 당기기
            pull();
//			print();

            // 폴파
            while(bomb()) {
//				print();
                pull();
//				print();
            }


            // 맵 변환
            changeMap();
//			print();

        }

        bw.write(bombBeads[0]+2*bombBeads[1]+3*bombBeads[2]+"\n");
        bw.flush();
        bw.close();

    }
}
