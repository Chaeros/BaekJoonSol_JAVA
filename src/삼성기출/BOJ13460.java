// https://www.acmicpc.net/problem/13460
// 구슬 탈출, Gold1
// 2023년 12월 19일
// 통과

package 삼성기출;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13460 {
    static int N,M;
    static char map[][];
    static char originMap[][];
    static int maxCount=0;
    static boolean isSuccess=false;
    static int direction[] = new int[10];
    static int dx[]={-1,0,1,0}; // 상우하좌
    static int dy[]={0,1,0,-1};
    static int originRedBallPosition[] = new int[2]; // [0] -> x, [1] -> y
    static int originBlueBallPosition[] = new int[2];
    static int redBallPosition[] = new int[2]; // [0] -> x, [1] -> y
    static int blueBallPosition[] = new int[2];
    static int goal[] = new int[2];

    static boolean incline(){
        boolean result=false;
        for(int i=0;i<maxCount;++i){
            if(direction[i]==0){ // 상
                if(redBallPosition[0]<blueBallPosition[0]){
                    while(true){
                        int redMx = redBallPosition[0]+dx[0];
                        int blueMx = blueBallPosition[0]+dx[0];

                        if(!(map[redMx][redBallPosition[1]]=='.' || map[redMx][redBallPosition[1]]=='O'
                        || map[blueMx][blueBallPosition[1]]=='.' || map[blueMx][blueBallPosition[1]]=='O')){
                            break;
                        }

                        if(redMx>=1 && map[redMx][redBallPosition[1]]!='#'){
                            map[redBallPosition[0]][redBallPosition[1]]='.';
                            redBallPosition[0]=redMx;
                            map[redBallPosition[0]][redBallPosition[1]]='R';
                        }

                        if(blueMx>=1 && map[blueMx][blueBallPosition[1]]!='#'){
                            map[blueBallPosition[0]][blueBallPosition[1]]='.';
                            blueBallPosition[0]=blueMx;
                            map[blueBallPosition[0]][blueBallPosition[1]]='B';
                        }

                        if(redBallPosition[0]==goal[0] && redBallPosition[1]==goal[1]){
                            map[goal[0]][goal[1]]='O';
                            result=true;
                        }

                        if(blueBallPosition[0]==goal[0] && blueBallPosition[1]==goal[1]){
                            return false;
                        }
                    }
                    if(result) return true;
                }
                else{
                    while(true){
                        int redMx = redBallPosition[0]+dx[0];
                        int blueMx = blueBallPosition[0]+dx[0];

                        if(!(map[redMx][redBallPosition[1]]=='.' || map[redMx][redBallPosition[1]]=='O'
                                || map[blueMx][blueBallPosition[1]]=='.' || map[blueMx][blueBallPosition[1]]=='O')){
                            break;
                        }

                        if(blueMx>=1 && map[blueMx][blueBallPosition[1]]!='#'){
                            map[blueBallPosition[0]][blueBallPosition[1]]='.';
                            blueBallPosition[0]=blueMx;
                            map[blueBallPosition[0]][blueBallPosition[1]]='B';
                        }

                        if(redMx>=1 && map[redMx][redBallPosition[1]]!='#'){
                            map[redBallPosition[0]][redBallPosition[1]]='.';
                            redBallPosition[0]=redMx;
                            map[redBallPosition[0]][redBallPosition[1]]='R';
                        }

                        if(redBallPosition[0]==goal[0] && redBallPosition[1]==goal[1]){
                            map[goal[0]][goal[1]]='O';
                            result=true;
                        }

                        if(blueBallPosition[0]==goal[0] && blueBallPosition[1]==goal[1]){
                            return false;
                        }
                    }
                    if(result) return true;
                }
            }
            else if(direction[i]==1){ // 우
                if(redBallPosition[1]>blueBallPosition[1]){
                    while(true){
                        int redMy = redBallPosition[1]+dy[1];
                        int blueMy = blueBallPosition[1]+dy[1];

                        if(!(map[redBallPosition[0]][redMy]=='.' || map[redBallPosition[0]][redMy]=='O'
                                || map[blueBallPosition[0]][blueMy]=='.' || map[blueBallPosition[0]][blueMy]=='O')){
                            break;
                        }

                        if(redMy<M-1 && map[redBallPosition[0]][redMy]!='#'){
                            map[redBallPosition[0]][redBallPosition[1]]='.';
                            redBallPosition[1]=redMy;
                            map[redBallPosition[0]][redBallPosition[1]]='R';
                        }

                        if(blueMy<M-1 && map[blueBallPosition[0]][blueMy]!='#'){
                            map[blueBallPosition[0]][blueBallPosition[1]]='.';
                            blueBallPosition[1]=blueMy;
                            map[blueBallPosition[0]][blueBallPosition[1]]='B';
                        }

                        if(redBallPosition[0]==goal[0] && redBallPosition[1]==goal[1]){
                            map[goal[0]][goal[1]]='O';
                            result=true;
                        }

                        if(blueBallPosition[0]==goal[0] && blueBallPosition[1]==goal[1]){
                            return false;
                        }
                    }
                    if(result) return true;
                }
                else{
                    while(true){
                        int redMy = redBallPosition[1]+dy[1];
                        int blueMy = blueBallPosition[1]+dy[1];

//                        System.out.println(redBallPosition[0]+" "+redBallPosition[1]);
//                        System.out.println(blueBallPosition[0]+" "+blueBallPosition[1]);
//                        System.out.println("========================");
//                        System.out.println(redBallPosition[0]+" "+redMy);
//                        System.out.println(blueBallPosition[0]+" "+blueMy);
//                        System.out.println(redMy+" "+blueMy);

                        if(!(map[redBallPosition[0]][redMy]=='.' || map[redBallPosition[0]][redMy]=='O'
                                || map[blueBallPosition[0]][blueMy]=='.' || map[blueBallPosition[0]][blueMy]=='O')){
                            break;
                        }

                        if(blueMy<M-1 && map[blueBallPosition[0]][blueMy]!='#'){
                            map[blueBallPosition[0]][blueBallPosition[1]]='.';
                            blueBallPosition[1]=blueMy;
                            map[blueBallPosition[0]][blueBallPosition[1]]='B';
                        }

                        if(redMy<M-1 && map[redBallPosition[0]][redMy]!='#'){
                            map[redBallPosition[0]][redBallPosition[1]]='.';
                            redBallPosition[1]=redMy;
                            map[redBallPosition[0]][redBallPosition[1]]='R';
                        }

                        if(redBallPosition[0]==goal[0] && redBallPosition[1]==goal[1]){
                            map[goal[0]][goal[1]]='O';
                            result=true;
                        }

                        if(blueBallPosition[0]==goal[0] && blueBallPosition[1]==goal[1]){
                            return false;
                        }
                    }
                    if(result) return true;
                }

            }
            else if(direction[i]==2){ // 하
                if(redBallPosition[0]>blueBallPosition[0]){
                    while(true){
                        int redMx = redBallPosition[0]+dx[2];
                        int blueMx = blueBallPosition[0]+dx[2];

                        if(!(map[redMx][redBallPosition[1]]=='.' || map[redMx][redBallPosition[1]]=='O'
                                || map[blueMx][blueBallPosition[1]]=='.' || map[blueMx][blueBallPosition[1]]=='O')){
                            break;
                        }

                        if(redMx<N-1 && map[redMx][redBallPosition[1]]!='#'){
                            map[redBallPosition[0]][redBallPosition[1]]='.';
                            redBallPosition[0]=redMx;
                            map[redBallPosition[0]][redBallPosition[1]]='R';
                        }

                        if(blueMx<N-1 && map[blueMx][blueBallPosition[1]]!='#'){
                            map[blueBallPosition[0]][blueBallPosition[1]]='.';
                            blueBallPosition[0]=blueMx;
                            map[blueBallPosition[0]][blueBallPosition[1]]='B';
                        }

                        if(redBallPosition[0]==goal[0] && redBallPosition[1]==goal[1]){
                            map[goal[0]][goal[1]]='O';
                            result=true;
                        }

                        if(blueBallPosition[0]==goal[0] && blueBallPosition[1]==goal[1]){
                            return false;
                        }
                    }
                    if(result) return true;
                }
                else{
                    while(true){
                        int redMx = redBallPosition[0]+dx[2];
                        int blueMx = blueBallPosition[0]+dx[2];

                        if(!(map[redMx][redBallPosition[1]]=='.' || map[redMx][redBallPosition[1]]=='O'
                                || map[blueMx][blueBallPosition[1]]=='.' || map[blueMx][blueBallPosition[1]]=='O')){
                            break;
                        }

                        if(blueMx<N-1 && map[blueMx][blueBallPosition[1]]!='#'){
                            map[blueBallPosition[0]][blueBallPosition[1]]='.';
                            blueBallPosition[0]=blueMx;
                            map[blueBallPosition[0]][blueBallPosition[1]]='B';
                        }

                        if(redMx<N-1 && map[redMx][redBallPosition[1]]!='#'){
                            map[redBallPosition[0]][redBallPosition[1]]='.';
                            redBallPosition[0]=redMx;
                            map[redBallPosition[0]][redBallPosition[1]]='R';
                        }

                        if(redBallPosition[0]==goal[0] && redBallPosition[1]==goal[1]){
                            map[goal[0]][goal[1]]='O';
                            result=true;
                        }

                        if(blueBallPosition[0]==goal[0] && blueBallPosition[1]==goal[1]){
                            return false;
                        }
                    }
                    if(result) return true;
                }
            }
            else if(direction[i]==3){ // 좌
                if(redBallPosition[1]<blueBallPosition[1]){
                    while(true){
                        int redMy = redBallPosition[1]+dy[3];
                        int blueMy = blueBallPosition[1]+dy[3];

                        if(!(map[redBallPosition[0]][redMy]=='.' || map[redBallPosition[0]][redMy]=='O'
                                || map[blueBallPosition[0]][blueMy]=='.' || map[blueBallPosition[0]][blueMy]=='O')){
                            break;
                        }

                        if(redMy>=1 && map[redBallPosition[0]][redMy]!='#'){
                            map[redBallPosition[0]][redBallPosition[1]]='.';
                            redBallPosition[1]=redMy;
                            map[redBallPosition[0]][redBallPosition[1]]='R';
                        }

                        if(blueMy>=1 && map[blueBallPosition[0]][blueMy]!='#'){
                            map[blueBallPosition[0]][blueBallPosition[1]]='.';
                            blueBallPosition[1]=blueMy;
                            map[blueBallPosition[0]][blueBallPosition[1]]='B';
                        }

                        if(redBallPosition[0]==goal[0] && redBallPosition[1]==goal[1]){
                            map[goal[0]][goal[1]]='O';
                            result=true;
                        }

                        if(blueBallPosition[0]==goal[0] && blueBallPosition[1]==goal[1]){
                            return false;
                        }
//                        printMap();
                    }
                    if(result) return true;
                }
                else{
                    while(true){
                        int redMy = redBallPosition[1]+dy[3];
                        int blueMy = blueBallPosition[1]+dy[3];

                        if(!(map[redBallPosition[0]][redMy]=='.' || map[redBallPosition[0]][redMy]=='O'
                                || map[blueBallPosition[0]][blueMy]=='.' || map[blueBallPosition[0]][blueMy]=='O')){
                            break;
                        }

                        if(blueMy>=1 && map[blueBallPosition[0]][blueMy]!='#'){
                            map[blueBallPosition[0]][blueBallPosition[1]]='.';
                            blueBallPosition[1]=blueMy;
                            map[blueBallPosition[0]][blueBallPosition[1]]='B';
                        }

                        if(redMy>=1 && map[redBallPosition[0]][redMy]!='#'){
                            map[redBallPosition[0]][redBallPosition[1]]='.';
                            redBallPosition[1]=redMy;
                            map[redBallPosition[0]][redBallPosition[1]]='R';
                        }

                        if(redBallPosition[0]==goal[0] && redBallPosition[1]==goal[1]){
                            map[goal[0]][goal[1]]='O';
                            result=true;
                        }

                        if(blueBallPosition[0]==goal[0] && blueBallPosition[1]==goal[1]){
                            return false;
                        }
                    }
                    if(result) return true;
                }
            }
//            printMap();
        }
        return result;
    }

    static void printDirection(){
        for(int i=0;i<maxCount;++i){
            System.out.print(direction[i]+" ");
        }
        System.out.println();
    }

    static void printMap(){
        System.out.println("=======================");
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }

    static void dfs(int depth){
        if(depth==maxCount){
            init();
            if(incline()){
                isSuccess=true;
            }
            return;
        }

        for(int i=0;i<4;++i){
            direction[depth]=i;
            dfs(depth+1);
        }
    }

    static void init(){
        for(int i=0;i<N;++i){
            map[i]=originMap[i].clone();
        }

        redBallPosition[0]=originRedBallPosition[0];
        redBallPosition[1]=originRedBallPosition[1];
        blueBallPosition[0]=originBlueBallPosition[0];
        blueBallPosition[1]=originBlueBallPosition[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        originMap = new char[N][M];

        for(int i=0;i<N;++i){
            String tempMap = br.readLine();
            for(int j=0;j<M;++j){
                originMap[i][j]=tempMap.charAt(j);
                if(originMap[i][j]=='R'){
                    originRedBallPosition[0]=i;
                    originRedBallPosition[1]=j;
                }
                else if(originMap[i][j]=='B'){
                    originBlueBallPosition[0]=i;
                    originBlueBallPosition[1]=j;
                }
                else if(originMap[i][j]=='O'){
                    goal[0]=i;
                    goal[1]=j;
                }
            }
        }

        for(int i=1;i<=10;++i){
            maxCount=i;
            init();
            dfs(0);
            if(isSuccess){
                bw.write(maxCount+"\n");
                bw.flush();
                bw.close();
                return;
            }
        }
        bw.write("-1\n");
        bw.flush();
        bw.close();
    }
}
