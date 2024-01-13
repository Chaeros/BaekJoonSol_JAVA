// https://www.acmicpc.net/problem/1244
// 스위치 켜고 끄기, Silver4
// 2023년 1월 13일
// 통과

package Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1244 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        int switchNumber = Integer.parseInt(br.readLine());
        int switchState[] = new int[switchNumber+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= switchNumber ; ++i ){
            switchState[i]=Integer.parseInt(st.nextToken());
        }

        int tryNumber = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < tryNumber ; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int pressNumber = Integer.parseInt(st.nextToken());

            if( gender == 1 ){
                pressSwitchMan(switchState,pressNumber);
            }
            else if ( gender == 2 ){
                pressSwitchWoman(switchState,pressNumber);
            }
        }

        printSwitchState(switchState);
        bw.flush();
        bw.close();
    }

    static void pressSwitchMan(int[] switchState, int pressNumber){
        int number = pressNumber;
        int round=2;
        while( number < switchState.length ){
            switchState[number] = convertSwitchNumber(switchState,number);
            number = pressNumber * round++;
        }
    }

    static void pressSwitchWoman(int[] switchState, int pressNumber){
        int frontPressNumber = pressNumber-1;
        int rearPressNumber = pressNumber+1;
        switchState[pressNumber] = convertSwitchNumber(switchState,pressNumber);
        while( (frontPressNumber > 0) && (rearPressNumber < switchState.length) ){
            if( switchState[frontPressNumber] != switchState[rearPressNumber] ) break;
            switchState[frontPressNumber] = convertSwitchNumber(switchState,frontPressNumber);
            switchState[rearPressNumber] = convertSwitchNumber(switchState,rearPressNumber);
            frontPressNumber--;
            rearPressNumber++;
        }
    }

    static void printSwitchState(int[] switchState) throws IOException {
        for(int i=1 ; i < switchState.length ; ++i ){
            if( ( i != switchState.length-1 ) && ( i % 20 != 0 ) ){
                bw.write(switchState[i] + " ");
                continue;
            }
            bw.write(switchState[i] + "\n");
        }
    }

    static int convertSwitchNumber(int[] switchState, int pressNumber){
        int answer = -1;
        if( switchState[pressNumber] == 0 ){
            answer = 1;
        }
        else if( switchState[pressNumber] == 1 ){
            answer = 0;
        }
        return answer;
    }
}
