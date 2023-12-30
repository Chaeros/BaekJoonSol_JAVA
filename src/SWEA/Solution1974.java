package SWEA;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution1974
{
    static int map[][];

    static boolean isDuplicateRow(){
        Set<Integer> set;
        for(int i=0;i<9;++i){
            set = new HashSet<>();
            for(int j=0;j<9;++j){
                if(set.contains(map[i][j])){
                    return true;
                }
                set.add(map[i][j]);
            }
        }
        return false;
    }

    static boolean isDuplicateColumn(){
        Set<Integer> set;
        for(int i=0;i<9;++i){
            set = new HashSet<>();
            for(int j=0;j<9;++j){
                if(set.contains(map[j][i])){
                    return true;
                }
                set.add(map[j][i]);
            }
        }
        return false;
    }

    static boolean isDuplicateBox(){
        Set<Integer> set;
        for(int t=0;t<9;++t){
            set = new HashSet<>();
            int row = t/3;
            int col = t%3;
            for(int r=row*3;r<row*3+3;++r){
                for(int c=col*3;c<col*3+3;++c){
                    if(set.contains(map[r][c])){
                        return true;
                    }
                    set.add(map[r][c]);
                }
            }
        }
        return false;
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            map = new int[9][9];
            for(int i=0;i<9;++i){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<9;++j){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            if(isDuplicateRow()) bw.write("#"+test_case+" "+"0\n");
            else if(isDuplicateColumn()) bw.write("#"+test_case+" "+"0\n");
            else if(isDuplicateBox()) bw.write("#"+test_case+" "+"0\n");
            else bw.write("#"+test_case+" "+"1\n");
        }
        bw.flush();
        bw.close();
    }
}