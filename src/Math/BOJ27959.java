package Math;

import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ27959 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(a*100<b?"No":"Yes");
    }
}