// https://www.acmicpc.net/problem/20057
// 마법사 상어와 토네이도, Gold3
// 2023년 10월 13일
// 통과

package SWEA;

import java.io.*;
import java.util.*;

public class BOJ20057 {
    static int N;
    static int map[][];

    static int tornadoX;
    static int tornadoY;

    static int dx[]= {0,1,0,-1};
    static int dy[]= {-1,0,1,0};

    static int leftDx[]= {-2,-1,-1,-1,0,1,1,1,2};
    static int leftDy[]= {0,-1,0,1,-2,-1,0,1,0};
    static int leftVal[]= {2,10,7,1,5,10,7,1,2};

    static int downDx[]= {-1,-1,0,0,0,0,1,1,2};
    static int downDy[]= {-1,1,-2,-1,1,2,-1,1,0};
    static int downVal[]= {1,1,2,7,7,2,10,10,5};

    static int rightDx[]= {-2,-1,-1,-1,0,1,1,1,2};
    static int rightDy[]= {0,-1,0,1,2,-1,0,1,0};
    static int rightVal[]= {2,1,7,10,5,1,7,10,2};

    static int upDx[]= {-2,-1,-1,0,0,0,0,1,1};
    static int upDy[]= {0,-1,1,-2,-1,1,2,-1,1};
    static int upVal[]= {5,10,10,2,7,7,2,1,1};

    static int outSendCount=0;

    static void flutter(int direction) {
        if(direction==0) { // 좌측
//			if(tornadoY-1<0) {
//				outSendCount+=map[tornadoX][tornadoY];
//				map[tornadoX][tornadoY]=0;
//			}
//			else {
            if(tornadoY-1>=0) map[tornadoX][tornadoY-1]+=map[tornadoX][tornadoY];
            int sum=0;
            for(int i=0;i<leftDx.length;++i) {
                sum+=(map[tornadoX][tornadoY]*(leftVal[i]/(double)100));

                if(tornadoX+leftDx[i]<0 || tornadoX+leftDx[i]>=N ||
                        tornadoY+leftDy[i]<0 || tornadoY+leftDy[i]>=N) {
                    outSendCount+=map[tornadoX][tornadoY]*(leftVal[i]/(double)100);
                    continue;
                }

                map[tornadoX+leftDx[i]][tornadoY+leftDy[i]]
                        +=map[tornadoX][tornadoY]*(leftVal[i]/(double)100);
            }

            if(tornadoY-1>=0) map[tornadoX][tornadoY-1]-=sum;
            map[tornadoX][tornadoY]=0;
//			}
        }
        else if(direction==1) { // 하단
//			if(tornadoX+1>=N) {
//				outSendCount+=map[tornadoX][tornadoY];
//				map[tornadoX][tornadoY]=0;
//			}
//			else {
            if(tornadoX+1<N) map[tornadoX+1][tornadoY]+=map[tornadoX][tornadoY];
            int sum=0;
            for(int i=0;i<downDx.length;++i) {
                sum+=map[tornadoX][tornadoY]*(downVal[i]/(double)100);

                if(tornadoX+downDx[i]<0 || tornadoX+downDx[i]>=N ||
                        tornadoY+downDy[i]<0 || tornadoY+downDy[i]>=N) {
                    outSendCount+=map[tornadoX][tornadoY]*(downVal[i]/(double)100);
                    continue;
                }

                map[tornadoX+downDx[i]][tornadoY+downDy[i]]
                        +=map[tornadoX][tornadoY]*(downVal[i]/(double)100);

            }
            if(tornadoX+1<N) map[tornadoX+1][tornadoY]-=sum;
            map[tornadoX][tornadoY]=0;
//			}

        }
        else if(direction==2) { // 우측
//			if(tornadoY+1>=N) {
//				outSendCount+=map[tornadoX][tornadoY];
//				map[tornadoX][tornadoY]=0;
//			}
//			else {
            if(tornadoY+1<N) map[tornadoX][tornadoY+1]+=map[tornadoX][tornadoY];
            int sum=0;
            for(int i=0;i<rightDx.length;++i) {
                sum+=map[tornadoX][tornadoY]*(rightVal[i]/(double)100);

                if(tornadoX+rightDx[i]<0 || tornadoX+rightDx[i]>=N ||
                        tornadoY+rightDy[i]<0 || tornadoY+rightDy[i]>=N) {
                    outSendCount+=map[tornadoX][tornadoY]*(rightVal[i]/(double)100);
                    continue;
                }

                map[tornadoX+rightDx[i]][tornadoY+rightDy[i]]
                        +=map[tornadoX][tornadoY]*(rightVal[i]/(double)100);
            }
            if(tornadoY+1<N) map[tornadoX][tornadoY+1]-=sum;
            map[tornadoX][tornadoY]=0;
//			}
        }
        else if(direction==3) { // 상단
//			if(tornadoX-1<0) {
//				outSendCount+=map[tornadoX][tornadoY];
//				map[tornadoX][tornadoY]=0;
//			}
//			else {
            if(tornadoX-1>=0) map[tornadoX-1][tornadoY]+=map[tornadoX][tornadoY];
            int sum=0;
            for(int i=0;i<upDx.length;++i) {
                sum+=map[tornadoX][tornadoY]*(upVal[i]/(double)100);

                if(tornadoX+upDx[i]<0 || tornadoX+upDx[i]>=N ||
                        tornadoY+upDy[i]<0 || tornadoY+upDy[i]>=N) {
                    outSendCount+=map[tornadoX][tornadoY]*(upVal[i]/(double)100);
                    continue;
                }

                map[tornadoX+upDx[i]][tornadoY+upDy[i]]
                        +=map[tornadoX][tornadoY]*(upVal[i]/(double)100);
            }
            if(tornadoX-1>=0) map[tornadoX-1][tornadoY]-=sum;
            map[tornadoX][tornadoY]=0;
//			}
        }
    }

    static int countSend() {
        int sum=0;
        for(int i=0;i<N;++i) {
            for(int j=0;j<N;++j) {
                sum+=map[i][j];
            }
        }
        return sum;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0;i<N;++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        tornadoX = tornadoY = N/2;

        int originCount=countSend();

        int direction=-1;
        int round=1;
        outter: while(!(tornadoX==0 && tornadoY==0)) {
            for(int i=0;i<2;++i) {
                direction=(direction+1)%4;
                for(int j=0;j<round;++j) {
                    tornadoX+=dx[direction];
                    tornadoY+=dy[direction];
                    flutter(direction);
                    if(tornadoX==0 && tornadoY==0) break outter;
                }
            }
            round++;
        }

        int afterCount=countSend();

        bw.write(originCount-afterCount+"\n");
        bw.flush();
        bw.close();

    }

}
