package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();

        String tempStr = "";
        String resultStr = "";
        boolean isTag = false;
        for ( int i = 0 ; i < str.length() ; ++i ) {
            if ( str.charAt(i) == '<' ) {
                st = new StringTokenizer(tempStr);
                while ( st.hasMoreElements() ) {
                    StringBuffer sb = new StringBuffer(st.nextToken());
                    resultStr += sb.reverse().toString();
                    if ( st.hasMoreElements() ) resultStr += " ";
                }
                tempStr = "";
                isTag = true;
                resultStr += '<';
                continue;
            }
            else if ( str.charAt(i) == '>' ) {
                isTag = false;
                resultStr += '>';
                continue;
            }

            if ( isTag ) {
                resultStr += str.charAt(i);
            }
            else {
                tempStr += str.charAt(i);
            }
        }
        st = new StringTokenizer(tempStr);
        while ( st.hasMoreElements() ) {
            StringBuffer sb = new StringBuffer(st.nextToken());
            resultStr += sb.reverse().toString();
            if ( st.hasMoreElements() ) resultStr += " ";
        }

        bw.write(resultStr);
        bw.flush();
        bw.close();
    }
}
