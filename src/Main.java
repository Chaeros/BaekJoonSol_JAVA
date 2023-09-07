import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N,K;
    static String voca[];
    static int resultCount=0;

    static int searchCount(int val){
        int count=0;
        for(int i=0;i<26;++i){
            if((val>>i & 1) == 1) ++count;
        }
        return count;
    }
//    static void backTracking(int index,int val,int count){
//        if(searchCount(val)>K) return;
//
//        resultCount=Math.max(resultCount,count);
//
//        for(int i=index;i<N;++i){
//            int tempVal =val;
//            tempVal|=boca[i];
//            backTracking(i+1,tempVal,count+1);
//        }
//    }

    static void dfs(int depth,int val){
        if(depth==K-5){
            for(int i=0;i<N;++i){
                boolean pass=true;
                for(int j=0;j<voca[i].length();++j){
                    if((val & 1<<(122-voca[i].charAt(j)))!=(1<<(122-voca[i].charAt(j)))){
                        System.out.println(i+" "+j+" "+val + " "+ voca[i].charAt(j));
                        pass=false;
                        break;
                    }
                }
                if(pass) ++resultCount;
            }
        }
        else{
            for(int i=depth;i<26;++i){
                if((val & 1<<25-i)==0){
                    int tempVal=val|(1<<25-i);
                    dfs(depth+1,tempVal);
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int defualtVal=(1<<(122-'a'))+(1<<(122-'n'))+(1<<(122-'t'))+(1<<(122-'i'))+(1<<(122-'c'));
        //System.out.println("defualtVal="+defualtVal);

        voca = new String[N];

        Arrays.fill(voca,"");

        for(int i=0;i<N;++i){
            System.out.println(voca[i]);
        }

        for(int i=0;i<N;++i){
            String str = br.readLine();
            for(int j=4;j<str.length()-4;++j){
                voca[i]+=str.charAt(j);
                System.out.println(voca[i]);
                //voca[i]|=1<<(122-str.charAt(j));
            }
        }

        if(K==26){
            bw.write(N+"\n");
            bw.flush();
            bw.close();
            return;
        }
        else if(K<5){
            bw.write(0+"\n");
            bw.flush();
            bw.close();
            return;
        }

        for(int i=0;i<N;++i){
            System.out.println(voca[i]);
        }

        dfs(0,defualtVal);
        bw.write(resultCount+"\n");
        bw.flush();
        bw.close();
    }
}