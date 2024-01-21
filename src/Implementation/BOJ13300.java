package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int student[][] = new int[6][2];

        for ( int i = 0 ; i < N ; ++i ) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken())-1;
            student[grade][gender]++;
        }

        int roomCount = 0;
        for ( int i = 0 ; i < 6 ; ++i ) {
            while ( student[i][0] > 0 ) {
                student[i][0] -= K;
                roomCount++;
            }

            while ( student[i][1] > 0 ) {
                student[i][1] -= K;
                roomCount++;
            }
        }
        bw.write(roomCount+"\n");
        bw.flush();
        bw.close();
    }
}
