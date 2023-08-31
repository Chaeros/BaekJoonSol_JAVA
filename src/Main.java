import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String objective = br.readLine();

        long count=0;
        for(int i=0;i<objective.length();++i){
            if('a'<objective.charAt(i)){
                for(int k=1;N-i-k>0;++k){
                    count+=Math.pow(26,N-i-k)*(int)(objective.charAt(i)-'a');
                }
                count+=(int)(objective.charAt(i)-'a');
            }
            ++count;
        }

        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}