// https://www.acmicpc.net/problem/5373
// 큐빙, Platinum5
// 2023년 12월 18일
// 통과

package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ5373 {

    static char upSide[][] = {{'w','w','w'},{'w','w','w'},{'w','w','w'}};
    static char downSide[][] = {{'y','y','y'},{'y','y','y'},{'y','y','y'}};
    static char frontSide[][] = {{'r','r','r'},{'r','r','r'},{'r','r','r'}};
    static char backSide[][] = {{'o','o','o'},{'o','o','o'},{'o','o','o'}};
    static char leftSide[][] = {{'g','g','g'},{'g','g','g'},{'g','g','g'}};
    static char rightSide[][] = {{'b','b','b'},{'b','b','b'},{'b','b','b'}};

    static void resetCube(){
        upSide = new char[][]{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};
        downSide = new char[][]{{'y','y','y'},{'y','y','y'},{'y','y','y'}};
        frontSide = new char[][]{{'r','r','r'},{'r','r','r'},{'r','r','r'}};
        backSide = new char[][]{{'o','o','o'},{'o','o','o'},{'o','o','o'}};
        leftSide = new char[][]{{'g','g','g'},{'g','g','g'},{'g','g','g'}};
        rightSide = new char[][]{{'b','b','b'},{'b','b','b'},{'b','b','b'}};
    }
    static void rotate(char side, char direction){
        if(side=='U'){
            if(direction=='+'){
                char tempUpside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempUpside[i]=upSide[i].clone();
                }
                upSide[0][0]=tempUpside[2][0];
                upSide[0][1]=tempUpside[1][0];
                upSide[0][2]=tempUpside[0][0];

                upSide[1][0]=tempUpside[2][1];
                upSide[1][2]=tempUpside[0][1];

                upSide[2][0]=tempUpside[2][2];
                upSide[2][1]=tempUpside[1][2];
                upSide[2][2]=tempUpside[0][2];

                char tempFrontSide[] = frontSide[0].clone();
                char tempLeftSide[] = leftSide[0].clone();
                char tempBackSide[] = backSide[0].clone();
                char tempRightSide[] = rightSide[0].clone();
                frontSide[0]=tempRightSide;
                leftSide[0]=tempFrontSide;
                backSide[0]=tempLeftSide;
                rightSide[0]=tempBackSide;
            }
            else if(direction=='-'){
                char tempUpside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempUpside[i]=upSide[i].clone();
                }
                upSide[0][0]=tempUpside[0][2];
                upSide[0][1]=tempUpside[1][2];
                upSide[0][2]=tempUpside[2][2];

                upSide[1][0]=tempUpside[0][1];
                upSide[1][2]=tempUpside[2][1];

                upSide[2][0]=tempUpside[0][0];
                upSide[2][1]=tempUpside[1][0];
                upSide[2][2]=tempUpside[2][0];

                char tempFrontSide[] = frontSide[0].clone();
                char tempLeftSide[] = leftSide[0].clone();
                char tempBackSide[] = backSide[0].clone();
                char tempRightSide[] = rightSide[0].clone();
                frontSide[0]=tempLeftSide;
                leftSide[0]=tempBackSide;
                backSide[0]=tempRightSide;
                rightSide[0]=tempFrontSide;
            }
        }
        else if(side=='D'){
            if(direction=='+'){
                char tempDownside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempDownside[i]=downSide[i].clone();
                }
                downSide[0][0]=tempDownside[2][0];
                downSide[0][1]=tempDownside[1][0];
                downSide[0][2]=tempDownside[0][0];

                downSide[1][0]=tempDownside[2][1];
                downSide[1][2]=tempDownside[0][1];

                downSide[2][0]=tempDownside[2][2];
                downSide[2][1]=tempDownside[1][2];
                downSide[2][2]=tempDownside[0][2];

                char tempFrontSide[] = frontSide[2].clone();
                char tempLeftSide[] = leftSide[2].clone();
                char tempBackSide[] = backSide[2].clone();
                char tempRightSide[] = rightSide[2].clone();
                frontSide[2]=tempLeftSide;
                leftSide[2]=tempBackSide;
                backSide[2]=tempRightSide;
                rightSide[2]=tempFrontSide;
            }
            else if(direction=='-'){
                char tempDownside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempDownside[i]=downSide[i].clone();
                }
                downSide[0][0]=tempDownside[0][2];
                downSide[0][1]=tempDownside[1][2];
                downSide[0][2]=tempDownside[2][2];

                downSide[1][0]=tempDownside[0][1];
                downSide[1][2]=tempDownside[2][1];

                downSide[2][0]=tempDownside[0][0];
                downSide[2][1]=tempDownside[1][0];
                downSide[2][2]=tempDownside[2][0];

                char tempFrontSide[] = frontSide[2].clone();
                char tempLeftSide[] = leftSide[2].clone();
                char tempBackSide[] = backSide[2].clone();
                char tempRightSide[] = rightSide[2].clone();
                frontSide[2]=tempRightSide;
                leftSide[2]=tempFrontSide;
                backSide[2]=tempLeftSide;
                rightSide[2]=tempBackSide;
            }
        }
        else if(side=='F'){
            if(direction=='+'){
                char tempFrontside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempFrontside[i]=frontSide[i].clone();
                }
                frontSide[0][0]=tempFrontside[2][0];
                frontSide[0][1]=tempFrontside[1][0];
                frontSide[0][2]=tempFrontside[0][0];

                frontSide[1][0]=tempFrontside[2][1];
                frontSide[1][2]=tempFrontside[0][1];

                frontSide[2][0]=tempFrontside[2][2];
                frontSide[2][1]=tempFrontside[1][2];
                frontSide[2][2]=tempFrontside[0][2];

                char tempUpSide[] = upSide[2].clone();
                char tempLeftSide[] = {leftSide[2][2],leftSide[1][2],leftSide[0][2]};
                char tempDownSide[] = {downSide[0][2],downSide[0][1],downSide[0][0]};
                char tempRightSide[] = {rightSide[0][0],rightSide[1][0],rightSide[2][0]};

                upSide[2][0]=tempLeftSide[0];
                upSide[2][1]=tempLeftSide[1];
                upSide[2][2]=tempLeftSide[2];

                rightSide[0][0]=tempUpSide[0];
                rightSide[1][0]=tempUpSide[1];
                rightSide[2][0]=tempUpSide[2];

                downSide[0][2]=tempRightSide[0];
                downSide[0][1]=tempRightSide[1];
                downSide[0][0]=tempRightSide[2];

                leftSide[2][2]=tempDownSide[0];
                leftSide[1][2]=tempDownSide[1];
                leftSide[0][2]=tempDownSide[2];
            }
            else if(direction=='-'){
                char tempFrontside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempFrontside[i]=frontSide[i].clone();
                }
                frontSide[0][0]=tempFrontside[0][2];
                frontSide[0][1]=tempFrontside[1][2];
                frontSide[0][2]=tempFrontside[2][2];

                frontSide[1][0]=tempFrontside[0][1];
                frontSide[1][2]=tempFrontside[2][1];

                frontSide[2][0]=tempFrontside[0][0];
                frontSide[2][1]=tempFrontside[1][0];
                frontSide[2][2]=tempFrontside[2][0];

                char tempUpSide[] = upSide[2].clone();
                char tempLeftSide[] = {leftSide[2][2],leftSide[1][2],leftSide[0][2]};
                char tempDownSide[] = {downSide[0][2],downSide[0][1],downSide[0][0]};
                char tempRightSide[] = {rightSide[0][0],rightSide[1][0],rightSide[2][0]};

                upSide[2][0]=tempRightSide[0];
                upSide[2][1]=tempRightSide[1];
                upSide[2][2]=tempRightSide[2];

                rightSide[0][0]=tempDownSide[0];
                rightSide[1][0]=tempDownSide[1];
                rightSide[2][0]=tempDownSide[2];

                downSide[0][2]=tempLeftSide[0];
                downSide[0][1]=tempLeftSide[1];
                downSide[0][0]=tempLeftSide[2];

                leftSide[2][2]=tempUpSide[0];
                leftSide[1][2]=tempUpSide[1];
                leftSide[0][2]=tempUpSide[2];
            }
        }
        else if(side=='B'){
            if(direction=='+'){
                char tempBackside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempBackside[i]=backSide[i].clone();
                }
                backSide[0][0]=tempBackside[2][0];
                backSide[0][1]=tempBackside[1][0];
                backSide[0][2]=tempBackside[0][0];

                backSide[1][0]=tempBackside[2][1];
                backSide[1][2]=tempBackside[0][1];

                backSide[2][0]=tempBackside[2][2];
                backSide[2][1]=tempBackside[1][2];
                backSide[2][2]=tempBackside[0][2];

                char tempUpSide[] = {upSide[0][2],upSide[0][1],upSide[0][0]};
                char tempLeftSide[] = {leftSide[0][0],leftSide[1][0],leftSide[2][0]};
                char tempDownSide[] = {downSide[2][0],downSide[2][1],downSide[2][2]};
                char tempRightSide[] = {rightSide[2][2],rightSide[1][2],rightSide[0][2]};
                leftSide[0][0]=tempUpSide[0];
                leftSide[1][0]=tempUpSide[1];
                leftSide[2][0]=tempUpSide[2];

                downSide[2][0]=tempLeftSide[0];
                downSide[2][1]=tempLeftSide[1];
                downSide[2][2]=tempLeftSide[2];

                rightSide[2][2]=tempDownSide[0];
                rightSide[1][2]=tempDownSide[1];
                rightSide[0][2]=tempDownSide[2];

                upSide[0][2]=tempRightSide[0];
                upSide[0][1]=tempRightSide[1];
                upSide[0][0]=tempRightSide[2];
            }
            else if(direction=='-'){
                char tempBackside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempBackside[i]=backSide[i].clone();
                }
                backSide[0][0]=tempBackside[0][2];
                backSide[0][1]=tempBackside[1][2];
                backSide[0][2]=tempBackside[2][2];

                backSide[1][0]=tempBackside[0][1];
                backSide[1][2]=tempBackside[2][1];

                backSide[2][0]=tempBackside[0][0];
                backSide[2][1]=tempBackside[1][0];
                backSide[2][2]=tempBackside[2][0];

                char tempUpSide[] = {upSide[0][2],upSide[0][1],upSide[0][0]};
                char tempLeftSide[] = {leftSide[0][0],leftSide[1][0],leftSide[2][0]};
                char tempDownSide[] = {downSide[2][0],downSide[2][1],downSide[2][2]};
                char tempRightSide[] = {rightSide[2][2],rightSide[1][2],rightSide[0][2]};
                leftSide[0][0]=tempDownSide[0];
                leftSide[1][0]=tempDownSide[1];
                leftSide[2][0]=tempDownSide[2];

                downSide[2][0]=tempRightSide[0];
                downSide[2][1]=tempRightSide[1];
                downSide[2][2]=tempRightSide[2];

                rightSide[2][2]=tempUpSide[0];
                rightSide[1][2]=tempUpSide[1];
                rightSide[0][2]=tempUpSide[2];

                upSide[0][2]=tempLeftSide[0];
                upSide[0][1]=tempLeftSide[1];
                upSide[0][0]=tempLeftSide[2];
            }
        }
        else if(side=='L'){
            if(direction=='+'){
                char tempLeftside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempLeftside[i]=leftSide[i].clone();
                }
                leftSide[0][0]=tempLeftside[2][0];
                leftSide[0][1]=tempLeftside[1][0];
                leftSide[0][2]=tempLeftside[0][0];

                leftSide[1][0]=tempLeftside[2][1];
                leftSide[1][2]=tempLeftside[0][1];

                leftSide[2][0]=tempLeftside[2][2];
                leftSide[2][1]=tempLeftside[1][2];
                leftSide[2][2]=tempLeftside[0][2];

                char tempUpSide[] = {upSide[0][0],upSide[1][0],upSide[2][0]};
                char tempFrontSide[] = {frontSide[0][0],frontSide[1][0],frontSide[2][0]};
                char tempDownSide[] = {downSide[0][0],downSide[1][0],downSide[2][0]};
                char tempBackSide[] = {backSide[2][2],backSide[1][2],backSide[0][2]};

                upSide[0][0]=tempBackSide[0];
                upSide[1][0]=tempBackSide[1];
                upSide[2][0]=tempBackSide[2];

                frontSide[0][0]=tempUpSide[0];
                frontSide[1][0]=tempUpSide[1];
                frontSide[2][0]=tempUpSide[2];

                downSide[0][0]=tempFrontSide[0];
                downSide[1][0]=tempFrontSide[1];
                downSide[2][0]=tempFrontSide[2];

                backSide[2][2]=tempDownSide[0];
                backSide[1][2]=tempDownSide[1];
                backSide[0][2]=tempDownSide[2];
            }
            else if(direction=='-'){
                char tempLeftside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempLeftside[i]=leftSide[i].clone();
                }
                leftSide[0][0]=tempLeftside[0][2];
                leftSide[0][1]=tempLeftside[1][2];
                leftSide[0][2]=tempLeftside[2][2];

                leftSide[1][0]=tempLeftside[0][1];
                leftSide[1][2]=tempLeftside[2][1];

                leftSide[2][0]=tempLeftside[0][0];
                leftSide[2][1]=tempLeftside[1][0];
                leftSide[2][2]=tempLeftside[2][0];

                char tempUpSide[] = {upSide[0][0],upSide[1][0],upSide[2][0]};
                char tempFrontSide[] = {frontSide[0][0],frontSide[1][0],frontSide[2][0]};
                char tempDownSide[] = {downSide[0][0],downSide[1][0],downSide[2][0]};
                char tempBackSide[] = {backSide[2][2],backSide[1][2],backSide[0][2]};

                upSide[0][0]=tempFrontSide[0];
                upSide[1][0]=tempFrontSide[1];
                upSide[2][0]=tempFrontSide[2];

                frontSide[0][0]=tempDownSide[0];
                frontSide[1][0]=tempDownSide[1];
                frontSide[2][0]=tempDownSide[2];

                downSide[0][0]=tempBackSide[0];
                downSide[1][0]=tempBackSide[1];
                downSide[2][0]=tempBackSide[2];

                backSide[2][2]=tempUpSide[0];
                backSide[1][2]=tempUpSide[1];
                backSide[0][2]=tempUpSide[2];
            }
        }
        else if(side=='R'){
            if(direction=='+'){
                char tempRightside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempRightside[i]=rightSide[i].clone();
                }
                rightSide[0][0]=tempRightside[2][0];
                rightSide[0][1]=tempRightside[1][0];
                rightSide[0][2]=tempRightside[0][0];

                rightSide[1][0]=tempRightside[2][1];
                rightSide[1][2]=tempRightside[0][1];

                rightSide[2][0]=tempRightside[2][2];
                rightSide[2][1]=tempRightside[1][2];
                rightSide[2][2]=tempRightside[0][2];

                char tempUpSide[] = {upSide[2][2],upSide[1][2],upSide[0][2]};
                char tempFrontSide[] = {frontSide[2][2],frontSide[1][2],frontSide[0][2]};
                char tempDownSide[] = {downSide[2][2],downSide[1][2],downSide[0][2]};
                char tempBackSide[] = {backSide[0][0],backSide[1][0],backSide[2][0]};

                upSide[2][2]=tempFrontSide[0];
                upSide[1][2]=tempFrontSide[1];
                upSide[0][2]=tempFrontSide[2];

                backSide[0][0]=tempUpSide[0];
                backSide[1][0]=tempUpSide[1];
                backSide[2][0]=tempUpSide[2];

                downSide[2][2]=tempBackSide[0];
                downSide[1][2]=tempBackSide[1];
                downSide[0][2]=tempBackSide[2];

                frontSide[2][2]=tempDownSide[0];
                frontSide[1][2]=tempDownSide[1];
                frontSide[0][2]=tempDownSide[2];
            }
            else if(direction=='-'){
                char tempRightside[][] = new char[3][3];
                for(int i=0;i<3;++i){
                    tempRightside[i]=rightSide[i].clone();
                }
                rightSide[0][0]=tempRightside[0][2];
                rightSide[0][1]=tempRightside[1][2];
                rightSide[0][2]=tempRightside[2][2];

                rightSide[1][0]=tempRightside[0][1];
                rightSide[1][2]=tempRightside[2][1];

                rightSide[2][0]=tempRightside[0][0];
                rightSide[2][1]=tempRightside[1][0];
                rightSide[2][2]=tempRightside[2][0];

                char tempUpSide[] = {upSide[2][2],upSide[1][2],upSide[0][2]};
                char tempFrontSide[] = {frontSide[2][2],frontSide[1][2],frontSide[0][2]};
                char tempDownSide[] = {downSide[2][2],downSide[1][2],downSide[0][2]};
                char tempBackSide[] = {backSide[0][0],backSide[1][0],backSide[2][0]};

                upSide[2][2]=tempBackSide[0];
                upSide[1][2]=tempBackSide[1];
                upSide[0][2]=tempBackSide[2];

                backSide[0][0]=tempDownSide[0];
                backSide[1][0]=tempDownSide[1];
                backSide[2][0]=tempDownSide[2];

                downSide[2][2]=tempFrontSide[0];
                downSide[1][2]=tempFrontSide[1];
                downSide[0][2]=tempFrontSide[2];

                frontSide[2][2]=tempUpSide[0];
                frontSide[1][2]=tempUpSide[1];
                frontSide[0][2]=tempUpSide[2];
            }
        }
    }

    static void printUpSide(){
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                System.out.print(upSide[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;++i){
            resetCube();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String command = st.nextToken();
                rotate(command.charAt(0),command.charAt(1));
//                System.out.println("[0]="+command.charAt(0)+" [1]="+command.charAt(1));
//                printUpSide();
            }
//            System.out.println("===result===");
            printUpSide();
        }
    }
}
