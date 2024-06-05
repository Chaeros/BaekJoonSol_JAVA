package 삼성B형.단어가등장하는횟수;

import java.io.*;

public class Solution {

    static String B,S;

    // 충돌이 발생하지 않기 위해서 지수로 소수를 사용해야한다..
    static int EXPONENT1 = 31;
    static int EXPONENT2 = 37;
    static int EXPONENT3 = 41;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for ( int t = 1 ; t <= testCase ; ++t ){
            B = br.readLine();
            S = br.readLine();
            bw.write("#"+t+" "+getCount(B,S)+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int getCount(String string, String pattern){
        int stringLength = string.length();
        int patternLength = pattern.length();

        int stringHash1=0;
        int stringHash2=0;
        int stringHash3=0;

        int patternHash1=0;
        int patternHash2=0;
        int patternHash3=0;

        int power1=1;
        int power2=1;
        int power3=1;

        int count = 0;

        for ( int i = 0 ; i <= stringLength-patternLength ; ++i ){
            if ( i == 0 ){
                for ( int j = 0 ; j < patternLength ; ++j ){
                    stringHash1 += hash(string.charAt(patternLength-1-j),power1);
                    patternHash1 += hash(pattern.charAt(patternLength-1-j),power1);

                    stringHash2 += hash(string.charAt(patternLength-1-j),power2);
                    patternHash2 += hash(pattern.charAt(patternLength-1-j),power2);

                    stringHash3 += hash(string.charAt(patternLength-1-j),power3);
                    patternHash3 += hash(pattern.charAt(patternLength-1-j),power3);

                    if ( j < patternLength-1 ){
                        power1*=EXPONENT1;
                        power2*=EXPONENT2;
                        power3*=EXPONENT3;
                    }
                }
            }

            // 1. stringHash1 - hash(string.charAt(i - 1), power1)
            // 이전 해시 값에서 첫 문자 제거: 현재 해시 값에서 윈도우의 첫 문자의 해시 값을 빼줍니다.
            // 2. EXPONENT1 * (stringHash1 - hash(string.charAt(i - 1), power1))
            // 해시 값 위치 이동: 나머지 문자열의 해시 값에 상수를 곱해 위치를 한 칸 이동시킵니다.
            // 3. + string.charAt(patternLength - 1 + i)
            // 새로운 문자 추가: 새로운 문자의 해시 값을 더해줍니다.
            else{
                stringHash1 = EXPONENT1*(stringHash1-hash(string.charAt(i-1),power1))+string.charAt(patternLength-1+i);
                stringHash2 = EXPONENT2*(stringHash2-hash(string.charAt(i-1),power2))+string.charAt(patternLength-1+i);
                stringHash3 = EXPONENT3*(stringHash3-hash(string.charAt(i-1),power3))+string.charAt(patternLength-1+i);
            }
            if ( stringHash1 == patternHash1 && stringHash2 == patternHash2 && stringHash3 == patternHash3 ){
                ++count;
            }
        }
        return count;
    }

    public static int hash(char value, int hashValue){
        return value*hashValue;
    }
}
