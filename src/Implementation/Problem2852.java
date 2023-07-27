// https://www.acmicpc.net/problem/2852
// NBA 농구, Silver3
// 2023년 7월 27일, 미제출

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Problem2852 {
    public static void main(String args[]) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

        int score[] = new int[3];
        long pTimeMil[] = new long[3];
        long sumTimeMil[] = new long[3];
        boolean maintainWin[] = new boolean[3];

        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i){
            st=new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            Date date = sdf.parse(st.nextToken());
            //Date를 MiliSecond로
            long cTimeMil=date.getTime()+32400000;

            ++score[team];
            // 1번팀이 앞질렀을 경우
            if(score[1]>score[2] && team==1 && maintainWin[1]==false){
                pTimeMil[2]=cTimeMil;
                maintainWin[1]=true;
                maintainWin[2]=false;
            }
            // 2번팀이 앞질렀을 경우
            else if(score[1]<score[2] && team==2 && maintainWin[2]==false){
                pTimeMil[1]=cTimeMil;
                maintainWin[2]=true;
                maintainWin[1]=false;
            }
            // 동점이 된 경우
            else if(score[1]==score[2]){
                if(team==1){ // 1번 팀이 득점해서 동점이된 경우
                    sumTimeMil[2]+=(cTimeMil-pTimeMil[1]);
                }
                else{ // 2번 팀이 득점해서 동점이된 경우
                    sumTimeMil[1]+=(cTimeMil-pTimeMil[2]);
                }
                maintainWin[1]=false;
                maintainWin[2]=false;
            }
        }
        //경기 끝났을 때 이기고 있는 팀 시간 추가
        Date date = sdf.parse("48:00");
        long cTimeMil=date.getTime()+32400000;
        if(score[1]>score[2]){
            sumTimeMil[1]+=(cTimeMil-pTimeMil[2]);
        }
        else if(score[1]<score[2]){
            sumTimeMil[2]+=(cTimeMil-pTimeMil[1]);
        }

        //Milisecond를 date로
        Date timeInDate = new Date(sumTimeMil[1]);
        System.out.println(sdf.format(timeInDate));
        Date timeInDate2 = new Date(sumTimeMil[2]);
        System.out.println(sdf.format(timeInDate2));
    }
}
